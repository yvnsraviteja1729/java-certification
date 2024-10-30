Access modifiers in Java are keywords that determine the visibility or accessibility of classes, methods, and variables. They control where these elements can be accessed from in the code. There are four main access modifiers in Java:

1. **Public**:
    - Accessible from any other class in any package.
    - Syntax: `public class MyClass { }`

2. **Protected**:
    - Accessible within its own package and by subclasses, even if they are in different packages.
    - Syntax: `protected void myMethod() { }`

3. **Default (Package-Private)**:
    - If no access modifier is specified, the default access level is applied. It is accessible only within its own package.
    - Syntax: `void myMethod() { }` (no modifier)

4. **Private**:
    - Accessible only within the class it is declared. It cannot be accessed from outside the class.
    - Syntax: `private int myVariable;`

### Summary

- **Public**: Accessible everywhere.
- **Protected**: Accessible in the same package and subclasses.
- **Default**: Accessible only within the same package.
- **Private**: Accessible only within the defining class.

Using these modifiers appropriately helps enforce encapsulation and maintainability in your Java programs.