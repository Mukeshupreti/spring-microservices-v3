package com.example.sonarpractice.elevator;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        ElevatorSystem sys = new ElevatorSystem(3); // 3 elevators
        sys.request(0, Direction.UP);
        sys.request(5, Direction.DOWN);
        Thread.sleep(1000);
        sys.shutdown();
    }
}

enum Direction { UP, DOWN, IDLE }

class Elevator {
    private final int id;
    private final AtomicInteger floor = new AtomicInteger(0);
    private volatile Direction dir = Direction.IDLE;
    public Elevator(int id){ this.id=id; }
    public int getId(){ return id; }
    public int getFloor(){ return floor.get(); }
    public void moveTo(int target){
        System.out.println("Elevator " + id + " moving from " + floor.get() + " to " + target);
        floor.set(target);
    }
}

class ElevatorSystem {
    private final List<Elevator> elevators = new ArrayList<>();
    private final ExecutorService exec = Executors.newSingleThreadExecutor();
    public ElevatorSystem(int count){
        for(int i=0;i<count;i++) elevators.add(new Elevator(i));
    }
    public void request(int floor, Direction dir){
        exec.submit(() -> handleRequest(floor, dir));
    }
    private void handleRequest(int floor, Direction dir){
        Elevator chosen = chooseElevator(floor);
        System.out.println("Dispatching elevator " + chosen.getId() + " to floor " + floor);
        chosen.moveTo(floor);
    }
    private Elevator chooseElevator(int floor){
        // naive: choose nearest
        Elevator best = null; int bestDist = Integer.MAX_VALUE;
        for(Elevator e: elevators){
            int d = Math.abs(e.getFloor() - floor);
            if(d < bestDist){ best = e; bestDist = d; }
        }
        return best;
    }
    public void shutdown(){ exec.shutdown(); }
}
