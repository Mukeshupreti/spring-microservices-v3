Gang of Four (GoF) Design Patterns
The Gang of Four refers to the four authors — Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides — who wrote the seminal book Design Patterns: Elements of Reusable Object-Oriented Software. They defined 23 classic design patterns, categorized into three groups:


 ## 1.Creational Patterns
Help instantiate objects in a flexible and reusable way.

### Singleton
Ensures a class has only one instance and provides a global point of access to it.
Example: Logger class.

### Factory Method
Defines an interface for creating an object but lets subclasses decide which class to instantiate.
Example: Dialog box creates different types of buttons.

###  Abstract Factory
Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
Example: UI toolkit supporting multiple themes.

###  Builder
Separates the construction of a complex object from its representation.
Example: Building a complex House object step by step.

###  Prototype
Creates new objects by copying an existing object (clone).
Example: Copying configuration objects.

 ## 2.Structural Patterns
Help compose classes or objects to form larger structures.

### Adapter
Converts the interface of a class into another interface clients expect.
Example: Wrapping a legacy API to work with a new system.

### Bridge
Decouples an abstraction from its implementation so both can vary independently.
Example: Separating an interface from platform-specific implementations.

### Composite
Composes objects into tree structures to represent part-whole hierarchies.
Example: UI components like panels and buttons.

### Decorator
Adds behavior to objects dynamically without altering the original class.
Example: Adding scrollbars to a window.

### Facade
Provides a simplified interface to a complex subsystem.
Example: Simplified API for a complicated library.

### Flyweight
Uses sharing to support large numbers of fine-grained objects efficiently.
Example: Reusing characters in a text editor.

### Proxy
Provides a surrogate or placeholder for another object to control access.
Example: Lazy loading or access control.

## 3.  Behavioral Patterns
Deal with communication between objects.

### Chain of Responsibility
Passes a request along a chain until an object handles it.
Example: Event bubbling.

### Command
Encapsulates a request as an object, allowing parameterization and queuing.
Example: Undo/Redo functionality.

### Interpreter
Implements a specialized language or grammar interpreter.
Example: SQL parser.

### Iterator
Provides a way to access elements of a collection sequentially without exposing its representation.
Example: Traversing a list.

### Mediator
Defines an object that encapsulates how a set of objects interact.
Example: Chat room message routing.

### Memento
Captures and externalizes an object's internal state without violating encapsulation.
Example: Undo state saving.

### Observer
Defines a one-to-many dependency so that when one object changes state, all dependents are notified.
Example: Event listeners.

### State
Allows an object to alter its behavior when its internal state changes.
Example: TCP connection states.

### Strategy
Defines a family of algorithms, encapsulates each one, and makes them interchangeable.
Example: Sorting algorithms.

### Template Method
Defines the skeleton of an algorithm, deferring some steps to subclasses.
Example: Game loop structure.

### Visitor
Separates an algorithm from the object structure it operates on.
Example: Operations on complex data structures like ASTs.