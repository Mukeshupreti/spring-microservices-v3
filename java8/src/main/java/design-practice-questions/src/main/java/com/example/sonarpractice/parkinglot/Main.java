package com.example.sonarpractice.parkinglot;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot(2, 2); // 2 car spots, 2 bike spots per floor, single floor for simplicity
        Vehicle car = new Vehicle("CAR", VehicleType.CAR);
        Vehicle bike = new Vehicle("BIKE", VehicleType.BIKE);
        Ticket t1 = lot.park(car);
        Ticket t2 = lot.park(bike);
        System.out.println("Tickets issued:");
        System.out.println(t1);
        System.out.println(t2);
        // simulate leaving
        sleepSeconds(2);
        double fee = lot.unpark(t1.getId());
        System.out.println("Fee for t1: " + fee);
    }
    static void sleepSeconds(int s){ try{ Thread.sleep(s*1000L);}catch(Exception e){} }
}

enum VehicleType { CAR, BIKE, TRUCK }

class Vehicle {
    private final String id;
    private final VehicleType type;
    public Vehicle(String id, VehicleType type){ this.id=id; this.type=type;}
    public String getId(){ return id; }
    public VehicleType getType(){ return type; }
}

class Ticket {
    private final UUID id = UUID.randomUUID();
    private final LocalDateTime in;
    private LocalDateTime out;
    private final Vehicle vehicle;
    public Ticket(Vehicle v){ this.vehicle=v; this.in=LocalDateTime.now(); }
    public UUID getId(){ return id; }
    public void close(){ this.out=LocalDateTime.now(); }
    public Duration duration(){ return Duration.between(in, out==null?LocalDateTime.now():out); }
    public Vehicle getVehicle(){ return vehicle; }
    public String toString(){ return "Ticket{"+id+", vehicle="+vehicle.getId()+", type="+vehicle.getType()+" in="+in+"}"; }
}

class ParkingSpot {
    private final String id;
    private final VehicleType type;
    private Ticket ticket;
    public ParkingSpot(String id, VehicleType type){ this.id=id; this.type=type; }
    public boolean free(){ return ticket==null; }
    public boolean canFit(Vehicle v){ return v.getType()==type; }
    public void occupy(Ticket t){ this.ticket=t; }
    public Ticket vacate(){ Ticket t=this.ticket; this.ticket=null; return t; }
}

class ParkingLot {
    private final List<ParkingSpot> spots = new ArrayList<>();
    private final Map<UUID, ParkingSpot> active = new HashMap<>();
    private final PaymentService payment = new PaymentService();
    public ParkingLot(int carSpots, int bikeSpots){
        // single floor simple creation
        for(int i=0;i<carSpots;i++) spots.add(new ParkingSpot("C"+i, VehicleType.CAR));
        for(int i=0;i<bikeSpots;i++) spots.add(new ParkingSpot("B"+i, VehicleType.BIKE));
    }
    public synchronized Ticket park(Vehicle v){
        for(ParkingSpot s: spots){
            if(s.free() && s.canFit(v)){
                Ticket t = new Ticket(v);
                s.occupy(t);
                active.put(t.getId(), s);
                return t;
            }
        }
        throw new IllegalStateException("No spot available for " + v.getType());
    }
    public synchronized double unpark(UUID ticketId){
        ParkingSpot s = active.remove(ticketId);
        if(s==null) throw new IllegalArgumentException("Invalid ticket");
        Ticket t = s.vacate();
        t.close();
        double fee = payment.calculate(t);
        return fee;
    }
}

class PaymentService {
    // simple pricing: per second rate
    public double calculate(Ticket t){
        long secs = t.duration().getSeconds();
        double rate = 0.01; // 0.01 EUR per second (~0.6EUR/min)
        return Math.round(secs * rate * 100.0)/100.0;
    }
}
