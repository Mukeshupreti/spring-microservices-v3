# Parking Lot Design – Step by Step Guide

## 1. Clarify Requirements
Before designing, ask questions:

- Capacity — total slots? multiple floors?
- Vehicle types — car, bike, truck, EV?
- Parking rules — nearest spot, VIP, handicap?
- Payment — hourly, prepaid?
- Ticketing — automated machine or manual?
- Real-time status — free spots display?

> **Tip:** Clarifying assumptions shows interviewers your thought process.

---

## 2. Identify Core Entities / Objects
Think of nouns in the system:

- ParkingLot
- ParkingFloor
- ParkingSpot
- Vehicle
- Ticket
- Payment
- EntryGate / ExitGate
- DisplayBoard

---

## 3. Define Relationships
Ask: which entities contain others?

- `ParkingLot` → has multiple `ParkingFloor`s
- `ParkingFloor` → has multiple `ParkingSpot`s
- `ParkingSpot` → assigned to exactly **one Vehicle** (or empty)
- `Ticket` → linked to `Vehicle` + `ParkingSpot`

---

## 4. Identify Behaviors / Methods
Think in verbs:

- `parkVehicle()`
- `unparkVehicle()`
- `findSpot()`
- `calculateFee()`
- `printTicket()`

---

## 5. Handle Constraints & Extensions

- Handle full parking lot gracefully
- Priority parking for handicap
- Assign nearest available spot
- Real-time spot availability updates
- Handle lost ticket
- Variable pricing by vehicle type

---

## 6. Consider Design Patterns

- **Strategy Pattern** → different pricing strategies
- **Factory Pattern** → create spot based on vehicle type
- **Observer Pattern** → update display board when spot changes
- **Singleton Pattern** → single instance of ParkingLot

---

## 7. Core Class Design (Java Example)

```java
class ParkingLot {
    List<ParkingFloor> floors;
    
    ParkingSpot findSpot(Vehicle vehicle) { /* ... */ }
    Ticket park(Vehicle vehicle) { /* ... */ }
    Receipt unpark(Ticket ticket) { /* ... */ }
}

class ParkingFloor {
    List<ParkingSpot> spots;
}

abstract class ParkingSpot {
    int spotId;
    boolean isFree;
    Vehicle vehicle;
    abstract SpotType getType();
}

class Vehicle {
    String plateNumber;
    VehicleType type;
}

class Ticket {
    Date entryTime;
    ParkingSpot spot;
    Vehicle vehicle;
}

class PaymentService {
    double calculate(Ticket ticket) { /* ... */ }
}
