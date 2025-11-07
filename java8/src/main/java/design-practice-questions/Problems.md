# Sonar Interview Design Questions & Answers

A curated list of **common design, OOD, and system design questions** for Sonar/SonarQube interviews with concise answers and guidance.

---

## **1️⃣ Design a Parking Lot System**

**Question:** Design a parking lot with multiple floors, vehicle types, ticketing, and payment.

**Answer / Approach:**

* **Classes:** `ParkingLot`, `Floor`, `ParkingSpot`, `Vehicle`, `Ticket`, `Payment`
* **Relationships:** `ParkingLot` contains multiple `Floor`s; `Floor` contains multiple `ParkingSpot`s; `ParkingSpot` can hold `Vehicle`s.
* **Design Patterns:**

    * **Factory:** to create different vehicle types.
    * **Strategy:** different pricing strategies for vehicles.
* **Considerations:**

    * Track occupied/free spots.
    * Handle different vehicle sizes.
    * Payment logic separated from parking logic.

---

## **2️⃣ Design a Library Management System**

**Question:** Design a system for managing books, issues/returns, and fines.

**Answer / Approach:**

* **Classes:** `Library`, `Book`, `Member`, `Loan`, `Fine`
* **Relationships:** `Library` has `Book`s; `Member` can have multiple `Loan`s.
* **Design Patterns:** Singleton for Library instance.
* **Considerations:**

    * Search functionality (by author, title).
    * Track loan history and calculate fines.
    * Ensure low coupling between classes.

---

## **3️⃣ Design a Vending Machine**

**Question:** Design a vending machine that handles multiple products and payment.

**Answer / Approach:**

* **Classes:** `VendingMachine`, `Product`, `Inventory`, `PaymentProcessor`
* **Design Patterns:**

    * **State Pattern:** machine can be in `Idle`, `Selection`, `Payment`, or `Dispensing` states.
    * **Strategy Pattern:** handle different payment types.
* **Considerations:**

    * Stock management
    * Change calculation
    * Error handling for invalid selections or insufficient payment

---

## **4️⃣ Design an Elevator System**

**Question:** Multiple elevators, requests, scheduling.

**Answer / Approach:**

* **Classes:** `ElevatorSystem`, `Elevator`, `Request`
* **Relationships:** `ElevatorSystem` manages multiple `Elevator`s.
* **Design Patterns:**

    * **Observer:** floor buttons notify elevators.
    * **Strategy:** different scheduling algorithms (nearest elevator, load balancing).
* **Considerations:**

    * Handle concurrent requests.
    * Optimize wait times.

---

## **5️⃣ Design a URL Shortener**

**Question:** Design a system like bit.ly.

**Answer / Approach:**

* **Components:** URL generator, database, API layer
* **Classes:** `URLShortenerService`, `URLMapping`
* **Design Patterns:**

    * **Singleton:** single instance of URL generator.
    * **Hashing:** generate unique short codes.
* **Considerations:**

    * Handle collisions
    * Store mappings in DB
    * Scalable read/write

---

## **6️⃣ Design a Logging System**

**Question:** Log levels, persistence, rotation.

**Answer / Approach:**

* **Classes:** `Logger`, `LogMessage`, `Appender`, `Formatter`
* **Design Patterns:**

    * **Strategy:** different appenders (file, console, database)
    * **Decorator:** format log messages
* **Considerations:**

    * Thread-safe logging
    * Configurable log levels
    * Rotation and archival of old logs

---

## **7️⃣ Design a Notification Service**

**Question:** Send notifications via email, SMS, push.

**Answer / Approach:**

* **Classes:** `NotificationService`, `Notification`, `Notifier` (interface)
* **Design Patterns:**

    * **Strategy:** different notifier implementations (`EmailNotifier`, `SMSNotifier`)
* **Considerations:**

    * Retry failed notifications
    * Async processing with queues
    * Extensible for new channels

---

## **8️⃣ Explain SOLID Principles**

**Answer / Approach:**

* **S**ingle Responsibility: a class should have one reason to change.
* **O**pen/Closed: open for extension, closed for modification.
* **L**iskov Substitution: subclasses should replace base class without breaking behavior.
* **I**nterface Segregation: small, client-specific interfaces.
* **D**ependency Inversion: depend on abstractions, not concrete classes.
* **Tip:** Give real examples from your experience.

---

## **9️⃣ Extend Payment System without Changing Existing Code**

**Answer / Approach:**

* Use **Strategy Pattern** or **Factory Pattern** to add new payment methods.
* Existing code depends on `PaymentMethod` interface, not concrete classes.
* New payment type added by implementing interface, no change to existing code.

---

## **🔟 Refactor Legacy Module Violating SRP**

**Answer / Approach:**

* Identify responsibilities mixed in one class.
* Split class into multiple classes, each with **single responsibility**.
* Use **interfaces** to abstract common behavior.
* Ensure existing functionality works (tests recommended).

---

## **Tips for Sonar Interview Design Questions**

* Focus on **clean code and maintainability** — Sonar values quality.
* Explain **trade-offs** in design.
* Mention **design patterns** and why you use them.
* Keep **low coupling, high cohesion** in mind.
* Use **diagrams** if possible to explain architecture.

---

This document provides **10+ practical design questions with answers** to simulate a Sonar interview.

You can use it to **practice whiteboard explanations and code snippets**.
