# **Inner Classes in Java**
### **Definition**
An **inner class** is a class **defined within another class**. Inner classes help **logically group** code, increase **encapsulation**, and improve **readability**. They also allow access to the **private members** of the outer class.

---

## **Types of Inner Classes in Java**
Java provides four types of inner classes:
1. **Member Inner Class** (Non-static)
2. **Static Nested Class**
3. **Local Inner Class**
4. **Anonymous Inner Class**

---

## **1. Member Inner Class (Non-static)**
### **Definition**
- A **normal inner class** defined inside another class.
- Can access **all members of the outer class (even private)**.
- Requires an **instance of the outer class** to be instantiated.

### **Example**
```java
class Outer {
    private String message = "Hello from Outer class";

    class Inner {
        void display() {
            System.out.println(message);  // Accessing private member of Outer class
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();  // Create Outer class object
        Outer.Inner inner = outer.new Inner();  // Create Inner class object
        inner.display();  // Output: Hello from Outer class
    }
}
```

### **When to Use?**
✔ When the inner class **needs access to private members** of the outer class.  
✔ When the inner class is **logically tied** to the outer class.  

---

## **2. Static Nested Class**
### **Definition**
- **Declared using `static` keyword**.
- **Cannot access non-static members** of the outer class.
- Can be instantiated **without** creating an instance of the outer class.

### **Example**
```java
class Outer {
    static String message = "Static Nested Class Example";

    static class StaticNested {
        void display() {
            System.out.println(message);  // Can access only static members of Outer
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Outer.StaticNested nested = new Outer.StaticNested();  // No need for Outer instance
        nested.display();  // Output: Static Nested Class Example
    }
}
```

### **When to Use?**
✔ When the nested class **does NOT need access** to instance variables of the outer class.  
✔ When grouping **related utility methods or constants** inside a class.  

---

## **3. Local Inner Class**
### **Definition**
- Defined **inside a method**.
- Can access local variables **only if they are `final` or effectively final**.
- Cannot have **static members**.

### **Example**
```java
class Outer {
    void outerMethod() {
        class LocalInner {  // Local inner class inside a method
            void display() {
                System.out.println("Hello from Local Inner Class");
            }
        }

        LocalInner local = new LocalInner();  // Instantiate within the method
        local.display();
    }
}

public class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.outerMethod();  // Output: Hello from Local Inner Class
    }
}
```

### **When to Use?**
✔ When the inner class is **only needed within a single method**.  
✔ When you want to **encapsulate logic within a method**.  

---

## **4. Anonymous Inner Class**
### **Definition**
- A **class without a name**, defined using `new ClassName() {}`.
- Used when **extending a class or implementing an interface on the spot**.
- Can **override methods**.

### **Example: Extending a Class**
```java
abstract class Animal {
    abstract void makeSound();
}

public class Test {
    public static void main(String[] args) {
        Animal myAnimal = new Animal() {  // Anonymous inner class
            void makeSound() {
                System.out.println("Roar!");
            }
        };
        
        myAnimal.makeSound();  // Output: Roar!
    }
}
```

### **Example: Implementing an Interface**
```java
interface Greeting {
    void sayHello();
}

public class Test {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {  // Anonymous inner class
            public void sayHello() {
                System.out.println("Hello, World!");
            }
        };
        
        greeting.sayHello();  // Output: Hello, World!
    }
}
```

### **When to Use?**
✔ When you need a **one-time-use** class.  
✔ When creating an instance of an **abstract class or interface** without defining a separate subclass.  

---

## **Comparison of Inner Class Types**
| Type | Access to Outer Class Members | Static? | Use Case |
|------|------------------------------|---------|----------|
| **Member Inner Class** | ✅ Yes | ❌ No | When the inner class needs to access private members of the outer class. |
| **Static Nested Class** | ❌ No | ✅ Yes | When the inner class should be independent of the outer instance. |
| **Local Inner Class** | ✅ Yes (final or effectively final) | ❌ No | When the class is only used within a specific method. |
| **Anonymous Inner Class** | ✅ Yes | ❌ No | When a short-lived class needs to override a method or implement an interface. |

---

## **Conclusion**
- Inner classes help in **organizing** and **encapsulating** code.
- **Use member inner classes** when an inner class needs access to the outer class.
- **Use static nested classes** when an inner class should not depend on an outer class instance.
- **Use local inner classes** when the class is only needed inside a method.
- **Use anonymous inner classes** when you need a **quick, one-time class implementation**.

Would you like a real-world example of inner classes? 😊