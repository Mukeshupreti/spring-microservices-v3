#### solid Pattern are specification and Design patterns are its implementation.

## All the SOLID priciple are closly related to each other if you satisfied/voildate one other get satisfied

### Single Responsibility
motivation:
If class has too many resposibilty that It will have tight coupling.
to make class loose coupling each resposibilty shoudld be handeled by different system.
### open close (using abstraction/interfacesx) (stregtgy and template)
Minimise change to existing code while updating code for adding new feature 
as existing code is unit and integration tested
It is closely related to single resposibility priciple as if class is doing one
resposibility then it easier to extend it without changing it.
So if voilate SRP then it will also voilate open close.

How ; class should not extend another class . A common interface should be define.

### Liskov Subsitution Principal.(stregtgy and template)
Motivation: We create lot of drived class. If subclass object will is behaviour
wise same as superclass then it can be replaced easily without affecting stablity
of existing code.
if you break it that also mean you break SRP

### Interface Segrigate principal.
Fat interface should break into smaller interface by using
extend interface so that client are not forced all.

### Dependecy (inversion of control)
Holiwold principal. you dont call us we will call you.
So dependency are intject by outside to the application.


