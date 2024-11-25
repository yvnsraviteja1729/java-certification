### **Method Overriding and Exceptions in Java**

In Java, when overriding a method, the subclass method can **throw exceptions**, but there are rules regarding which exceptions can be thrown. These rules are related to the **exception handling** in both the **superclass** and **subclass** methods.

#### **Key Points on Overriding and Exceptions:**

1. **Exception Subtypes**:
    - A subclass method can only throw **exceptions that are the same type or subclasses** of the exceptions declared in the superclass method. It can also **omit throwing an exception** if the superclass method declares one, as long as the exception is unchecked.

2. **Checked Exceptions**:
    - A **checked exception** (i.e., one that is a subclass of `Exception` but not a subclass of `RuntimeException`) is subject to stricter rules. The overriding method in the subclass can throw:
        - The same checked exceptions as the superclass method.
        - A subclass of the checked exception.
        - No checked exception at all (i.e., it can choose not to declare the exception).

3. **Unchecked Exceptions**:
    - Unchecked exceptions (i.e., instances of `RuntimeException` or its subclasses) can be **thrown freely** in the overriding method, even if they are not declared in the superclass method. They are not subject to the restrictions of checked exceptions.

4. **No New Checked Exceptions**:
    - If the superclass method does not declare any checked exceptions, the subclass method cannot **introduce new checked exceptions**.

### **Rules Summary for Overriding with Exceptions**:

1. **If the superclass method declares a checked exception:**
    - The subclass method can throw the same checked exception or a subclass of that exception.
    - The subclass method **cannot** throw a checked exception that is not declared in the superclass method.
    - The subclass method can choose not to throw the declared exception at all.

2. **If the superclass method does not declare any checked exception:**
    - The subclass method can throw any unchecked exceptions.
    - The subclass method cannot introduce any checked exceptions.

3. **Unchecked exceptions** (like `RuntimeException` and its subclasses) are **not subject to these restrictions**, so they can be thrown in any subclass method, regardless of what the superclass method throws.

### **Example 1: Overriding with Checked Exceptions**

```java
class Animal {
    public void makeSound() throws Exception {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() throws IOException {  // Valid: IOException is a subclass of Exception
        System.out.println("Dog barks");
    }
}
```

- In this example, the `Dog` class overrides the `makeSound` method of the `Animal` class, which throws a checked `Exception`. The overridden method in the subclass `Dog` can throw a **subclass of `Exception`** (such as `IOException`), which is perfectly valid.

### **Example 2: Overriding with the Same Exception Type**

```java
class Animal {
    public void makeSound() throws IOException {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() throws IOException {  // Valid: Same Exception type
        System.out.println("Dog barks");
    }
}
```

- In this case, the `Dog` class overrides the `makeSound` method and throws the same checked exception (`IOException`) as declared in the `Animal` class. This is **valid** because the exception type is the same.

### **Example 3: No Exception in the Subclass**

```java
class Animal {
    public void makeSound() throws IOException {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {  // Valid: No exception thrown
        System.out.println("Dog barks");
    }
}
```

- Here, the `Dog` class overrides the `makeSound` method and **does not throw any exception**. This is valid because the `Dog` method can choose not to throw any checked exceptions, even though the superclass method (`Animal`) does.

### **Example 4: Introducing a New Checked Exception (Invalid)**

```java
class Animal {
    public void makeSound() throws IOException {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() throws SQLException {  // Invalid: Cannot introduce a new checked exception
        System.out.println("Dog barks");
    }
}
```

- In this example, the `Dog` class attempts to throw a **new checked exception** (`SQLException`), which is **not** declared in the superclass method (`makeSound` in `Animal`). This will cause a **compilation error** because the subclass method cannot introduce a new checked exception that is not declared in the superclass method.

### **Example 5: Unchecked Exceptions (Valid)**

```java
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
        throw new RuntimeException("Unexpected Error");  // Valid: Unchecked exception
    }
}
```

- In this case, the `Dog` class overrides the `makeSound` method and throws an **unchecked exception** (`RuntimeException`). This is **valid** because unchecked exceptions are not restricted by the rules that govern checked exceptions.

### **Summary of Rules for Overriding Methods with Exceptions:**

- **Checked exceptions**: The overriding method can throw the same checked exceptions or any subclass of the exceptions thrown by the superclass method. The overriding method can also choose to **omit** throwing the exception.
- **Unchecked exceptions** (e.g., `RuntimeException` and its subclasses) can be thrown freely, regardless of what the superclass method declares.
- A subclass **cannot introduce a new checked exception** if the superclass method does not declare it.

### **Conclusion**:

When overriding methods in Java, it is essential to understand the relationship between exceptions in the superclass and subclass methods. The overriding method in the subclass can throw:
- The same checked exceptions or their subclasses.
- No checked exceptions, even if the superclass method throws one.
- Unchecked exceptions can always be thrown in the subclass method without restriction.