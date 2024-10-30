Initializer blocks in Java are used to initialize instance variables or to execute certain code when an object is created. There are two types of initializer blocks: **instance initializer blocks** and **static initializer blocks**.

### 1. Instance Initializer Block

An instance initializer block is executed when an instance of the class is created. It runs before the constructor and can be useful for common initialization code that should run for all constructors.

**Syntax:**
```java
class MyClass {
    // Instance variable
    int x;

    // Instance initializer block
    {
        x = 5; // Initializing x
        System.out.println("Instance initializer block executed");
    }

    // Constructor
    MyClass() {
        System.out.println("Constructor executed");
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        // Output:
        // Instance initializer block executed
        // Constructor executed
    }
}
```

### 2. Static Initializer Block

A static initializer block is executed when the class is loaded into memory, which is typically when the class is first referenced. This is useful for initializing static variables or performing one-time setup for the class.

**Syntax:**
```java
class MyClass {
    static int y;

    // Static initializer block
    static {
        y = 10; // Initializing y
        System.out.println("Static initializer block executed");
    }

    // Constructor
    MyClass() {
        System.out.println("Constructor executed");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(MyClass.y); // Accessing static variable
        MyClass obj = new MyClass();
        // Output:
        // Static initializer block executed
        // 10
        // Constructor executed
    }
}
```

### Key Points

- **Execution Order**:
    - For instance initializers: They execute before any constructor.
    - For static initializers: They execute once when the class is loaded, before any instance is created.

- **Use Cases**:
    - Instance initializer blocks are used when you want to run the same code for multiple constructors.
    - Static initializer blocks are useful for complex static variable initialization or performing setup that only needs to happen once.

Initializer blocks can help organize code and reduce redundancy, especially when multiple constructors share common initialization logic.