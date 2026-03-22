# 🎯 Java Design Practice Projects for Sonar Interview

A collection of **10 mini design projects** to strengthen object-oriented design, code quality, and architectural reasoning — great for **Sonar/SonarQube** interviews.

---

## 🚗 1️⃣ Parking Lot System

**Goal:** Build a console-based parking lot app.

### Features
- Support `Car`, `Bike`, `Truck`
- Allocate/free parking spots
- Issue and close tickets

### Classes
`ParkingLot`, `Floor`, `ParkingSpot`, `Vehicle`, `Ticket`, `PaymentService`

**Bonus:** Add pricing logic using a **Strategy pattern**.

---

## 📚 2️⃣ Library Management System

**Goal:** Simple book checkout and return system.

### Features
- Add/search books by author/title
- Issue and return books
- Calculate overdue fines

### Classes
`Library`, `Book`, `Member`, `Loan`, `FineCalculator`

**Bonus:** Persist data in memory using a `Map`.

---

## 🥤 3️⃣ Vending Machine

**Goal:** CLI vending machine simulator.

### Features
- Show items and prices
- Insert coins
- Dispense product and return change

### Patterns
**State + Strategy**

### Classes
`VendingMachine`, `Product`, `Inventory`, `State`, `PaymentProcessor`

---

## 🏢 4️⃣ Elevator System

**Goal:** Multi-elevator controller simulation.

### Features
- Handle up/down requests
- Assign nearest elevator
- Simulate movement

### Patterns
**Observer (button → controller)**, **Strategy (dispatch logic)**

### Classes
`ElevatorSystem`, `Elevator`, `Request`

---

## 🔗 5️⃣ URL Shortener

**Goal:** Build a mini bit.ly-like service.

### Features
- Shorten and expand URLs
- Store mappings in a map or small DB

### Classes
`URLShortenerService`, `URLMapping`

**Bonus:** Use hash + timestamp to avoid collisions.

---

## 🧾 6️⃣ Logging System

**Goal:** Design your own lightweight logger.

### Features
- Multiple log levels (`INFO`, `ERROR`, `DEBUG`)
- Write to console or file
- Configurable via properties file

### Patterns
**Strategy (Appender)**, **Singleton (Logger)**

---

## 📩 7️⃣ Notification Service

**Goal:** Unified notification framework.

### Features
- Send messages by email, SMS, or push
- Retry failures
- Queue support (simulate async)

### Classes
`NotificationService`, `Notifier` (interface), `EmailNotifier`, `SMSNotifier`

---

## 💳 8️⃣ Payment System Extension

**Goal:** Easily add new payment methods.

### Features
- Base interface `PaymentMethod`
- Concrete types: `CreditCardPayment`, `PayPalPayment`, `UPIPayment`

### Patterns
**Strategy or Factory**

**Demo:** Add new type without touching old code.

---

## 🧩 9️⃣ Refactor Legacy Module (SRP)

**Goal:** Demonstrate **Single Responsibility Principle (SRP)** refactoring.

### Steps
1. Start with one class doing DB, logging, and validation.
2. Split into: `Repository`, `Logger`, `Validator`.

**Outcome:** Cleaner, testable, maintainable code.

---

## 🔍 🔟 Code Quality Analyzer (Bonus: Sonar Concept)

**Goal:** Build a basic static analyzer.

### Features
- Read Java files
- Count lines of code, comments, methods
- Detect long methods (>20 lines)

**Output:** Simple quality report

**Purpose:** Practice metrics and clean-code logic like **Sonar** does.

---

💡 **Tip:**  
Start with 1–2 projects, keep classes small, apply **SOLID principles**, and document your design decisions. These are perfect for **SonarSource, backend, or architecture interviews**.
