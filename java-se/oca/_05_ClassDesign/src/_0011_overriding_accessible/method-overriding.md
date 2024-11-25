### **Method Overriding in Java**

**Method overriding** is a feature in Java where a subclass provides its own specific implementation of a method that is already defined in its **superclass**. When a method is overridden, the subclass method **replaces** or **modifies** the behavior of the inherited method, providing new functionality or behavior specific to the subclass.

Overriding is fundamental to Java's **polymorphism** feature, enabling dynamic method dispatch, which allows Java to call the correct method at runtime based on the object type (not the reference type).

### **Key Concepts of Method Overriding**

1. **Method Signature Must Be the Same**:
    - The method in the subclass must have the same method signature (name, parameters, and return type) as the method in the superclass. If the signature doesn't match, it's **not overriding** but overloading.

2. **Access Modifiers**:
    - The overriding method in the subclass must have an **equal or broader access level** than the method in the superclass. For example:
        - If the superclass method is `protected`, it can be overridden as `protected` or `public`, but **not** as `private`.
        - If the superclass method is `private`, it cannot be overridden because it's not visible to the subclass.

3. **Return Type**:
    - The return type of the overriding method must be **compatible** with the return type of the method in the superclass. In Java 5 and later, this can involve **covariant return types**, where the subclass can return a subtype of the return type of the superclass method.

4. **`@Override` Annotation**:
    - Although not required, it’s good practice to use the `@Override` annotation when overriding a method. This annotation helps the compiler detect errors when the method doesn't properly override the superclass method (e.g., due to a signature mismatch).

5. **Method Invocation**:
    - At runtime, the Java Virtual Machine (JVM) determines which method to call based on the object type (not the reference type). This is known as **dynamic method dispatch** or **runtime polymorphism**.

### **Example of Method Overriding**

Let’s illustrate method overriding with a simple example:

```java
class Animal {
    // Superclass method
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    // Subclass overriding the sound method
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

public class MainApp {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound();  // Output: Animal makes a sound
        
        Dog dog = new Dog();
        dog.sound();     // Output: Dog barks

        // Polymorphism in action
        Animal myDog = new Dog();  // Animal reference, Dog object
        myDog.sound();  // Output: Dog barks (overridden method is called)
    }
}
```

### **Explanation of the Code**:

1. **Superclass `Animal`**:
    - The `Animal` class has a method `sound()`, which prints `"Animal makes a sound"`.

2. **Subclass `Dog`**:
    - The `Dog` class extends `Animal` and overrides the `sound()` method. The overridden method prints `"Dog barks"` instead of `"Animal makes a sound"`.

3. **Method Call**:
    - When calling `sound()` on an instance of `Animal`, it prints `"Animal makes a sound"`.
    - When calling `sound()` on an instance of `Dog`, it prints `"Dog barks"`.

4. **Polymorphism**:
    - Even though the reference variable `myDog` is of type `Animal`, the object it refers to is of type `Dog`. Due to **dynamic method dispatch**, the overridden `sound()` method of `Dog` is called at runtime.

### **Access Modifier and Overriding**

As mentioned, the overriding method in the subclass cannot have a **more restrictive** access modifier than the method in the superclass.

#### **Valid Examples**:

```java
class Animal {
    protected void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
```

In this case, `sound()` is `protected` in the superclass `Animal`, and it is overridden as `public` in the subclass `Dog`. This is valid because `public` has a broader access than `protected`.

#### **Invalid Example**:

```java
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    private void sound() {  // Compiler error: Cannot reduce the visibility
        System.out.println("Dog barks");
    }
}
```

In this example, the `sound()` method is `public` in the superclass `Animal`, but it is overridden as `private` in the subclass `Dog`. This would result in a **compilation error** because the access modifier of the overriding method (`private`) is more restrictive than the original method (`public`).

### **Return Type in Overriding**

The return type of the overridden method should either be the **same** as the superclass method or a **covariant return type** (a subtype).

```java
class Animal {
    public Animal getAnimal() {
        return new Animal();
    }
}

class Dog extends Animal {
    @Override
    public Dog getAnimal() {  // Covariant return type
        return new Dog();
    }
}
```

In the above example, `Dog` is a subclass of `Animal`, and `Dog` overrides `getAnimal()` with a return type of `Dog`, which is allowed because `Dog` is a subclass of `Animal`. This is an example of **covariant return types**.

### **`@Override` Annotation**

While not mandatory, the `@Override` annotation is a good practice. It ensures that the method is actually overriding a method from the superclass. If the method signature does not match, the compiler will give an error.

```java
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {  // Ensures overriding of the superclass method
        System.out.println("Dog barks");
    }
}
```

If we mistakenly change the method signature in the subclass (e.g., incorrect parameter or return type), the compiler will generate an error with the `@Override` annotation.

### **When Does Overriding Happen?**

Overriding typically happens in the following scenarios:
1. When you want a subclass to modify or extend the behavior of a method defined in the superclass.
2. When you want to provide a specific implementation for an inherited method, like in the example with the `Dog` class overriding the `sound()` method of the `Animal` class.

### **Conclusion**

- **Method Overriding** is a core concept in Java and allows a subclass to provide its own specific implementation of a method that is already defined in its superclass.
- Overriding is essential for achieving **runtime polymorphism** in Java.
- When overriding methods, ensure the method signature matches, the access level is not more restrictive, and the return type is compatible.
