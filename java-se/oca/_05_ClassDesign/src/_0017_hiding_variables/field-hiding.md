**Fields:**
Field hiding occurs when a subclass declares a field with the same name as a field in the superclass. The field in the subclass hides the field in the superclass.
Accessing a field depends on the reference type, not the actual object type. Therefore, field hiding can lead to unexpected results if the field names are the same in both the superclass and subclass.

**Methods:**
Method overriding occurs when a subclass provides its own implementation for a method that is already defined in the superclass.
Methods are polymorphic, meaning that the method that is called is determined at runtime based on the actual object type (not the reference type). This is why method overriding behaves differently from field hiding.
