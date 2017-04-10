# Class Hierarchies

A hierarchy of classes

## Abstract classes
Contain header of methods to be initialized in an implementation class. Persistent data structures in scala, means that when you change a node in a tree, the previous tree does not disappear.

When you use abstract classes, an implementation conforms to that abstract class so you can use it wherever the one or the other is required. **Base classes** are the superclasses of a class. 

You have to explicitly override base methods of an abstract class which are defined.

## Objects vs Classes
Classes are blueprints and need instantiation via the new method. There can also be different instance of a clas in program. However an object exists as only one instance, so you do not need to use the new keyword to instantiate a new object. Simply write the name of the object, so `new MyObject` just becomes `MyObject`.
