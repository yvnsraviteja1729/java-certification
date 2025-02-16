# **🔹 Java Method References (Method Referencing) Explained in Detail**

## **📌 What is Method Referencing in Java?**
**Method referencing (`::`)** is a **shorthand way** of writing **lambda expressions** when you are calling an existing method. Instead of writing out a full lambda expression, you can simply reference a method by its name.

### **💡 Example: Without Method Reference**
```java
list.forEach(name -> System.out.println(name)); // Lambda expression
```
### **✅ With Method Reference (`::`)**
```java
list.forEach(System.out::println);  // Method reference
```

**✔️ Benefits of Method Referencing:**
- **Reduces boilerplate code**
- **Increases readability**
- **Uses existing methods without rewriting them in lambdas**

---

## **📌 Types of Method References in Java**
There are **four types** of method references in Java:

| **Method Reference Type** | **Syntax** | **Example** |
|---------------------------|------------|------------|
| **1️⃣ Static Method Reference** | `ClassName::staticMethod` | `Math::sqrt` |
| **2️⃣ Instance Method of an Object** | `instance::method` | `System.out::println` |
| **3️⃣ Instance Method of a Class** | `ClassName::method` | `String::toUpperCase` |
| **4️⃣ Constructor Reference** | `ClassName::new` | `ArrayList::new` |

---

# **🔹 1️⃣ Static Method Reference (`ClassName::staticMethod`)**
A static method reference is used when you want to call a **static method** from a class.

### **Example: Without Method Reference (Using Lambda Expression)**
```java
Function<Double, Double> squareRoot = x -> Math.sqrt(x);
System.out.println(squareRoot.apply(25.0)); // Output: 5.0
```

### **✅ With Method Reference**
```java
Function<Double, Double> squareRoot = Math::sqrt;
System.out.println(squareRoot.apply(25.0)); // Output: 5.0
```

✔️ **Why Use Method Reference?**
- **Avoids repeating method logic** (`Math.sqrt(x)`)
- **More concise and readable**

---

# **🔹 2️⃣ Instance Method Reference (`instance::method`)**
Used when you want to call a method on a **specific object**.

### **Example: Without Method Reference (Using Lambda Expression)**
```java
Consumer<String> printMsg = msg -> System.out.println(msg);
printMsg.accept("Hello, World!");
```

### **✅ With Method Reference**
```java
Consumer<String> printMsg = System.out::println;
printMsg.accept("Hello, World!");
```

✔️ **Why Use Method Reference?**
- `System.out.println(msg)` is **already an existing method**
- Method reference **simplifies it**

---

# **🔹 3️⃣ Instance Method of a Class (`ClassName::method`)**
Used when you want to call an **instance method** on a **class object** that will be supplied later.

### **Example: Without Method Reference**
```java
Function<String, String> upperCase = str -> str.toUpperCase();
System.out.println(upperCase.apply("hello")); // Output: HELLO
```

### **✅ With Method Reference**
```java
Function<String, String> upperCase = String::toUpperCase;
System.out.println(upperCase.apply("hello")); // Output: HELLO
```

✔️ **Why Use Method Reference?**
- It **avoids redundant lambda expressions**

---

# **🔹 4️⃣ Constructor Reference (`ClassName::new`)**
Used when you want to call a **constructor** to create a new object.

### **Example: Without Method Reference**
```java
Supplier<List<String>> listSupplier = () -> new ArrayList<>();
List<String> myList = listSupplier.get();
```

### **✅ With Method Reference**
```java
Supplier<List<String>> listSupplier = ArrayList::new;
List<String> myList = listSupplier.get();
```

✔️ **Why Use Method Reference?**
- **Cleaner and more intuitive** than using `() -> new ClassName()`

---

# **🔹 Full Example of All Method References**
```java
import java.util.*;
import java.util.function.*;

public class MethodReferenceExample {
    public static void main(String[] args) {
        // 1️⃣ Static Method Reference
        Function<Double, Double> squareRoot = Math::sqrt;
        System.out.println("Square Root of 16: " + squareRoot.apply(16.0));

        // 2️⃣ Instance Method Reference (on a specific object)
        Consumer<String> printMsg = System.out::println;
        printMsg.accept("Hello, Java!");

        // 3️⃣ Instance Method Reference (on a class)
        Function<String, String> upperCase = String::toUpperCase;
        System.out.println(upperCase.apply("hello world"));

        // 4️⃣ Constructor Reference
        Supplier<List<String>> listSupplier = ArrayList::new;
        List<String> myList = listSupplier.get();
        myList.add("Item 1");
        myList.add("Item 2");
        System.out.println("My List: " + myList);
    }
}
```
### **✅ Output**
```
Square Root of 16: 4.0
Hello, Java!
HELLO WORLD
My List: [Item 1, Item 2]
```

---

# **🔹 When to Use Method References?**
| **Scenario** | **Use Lambda** | **Use Method Reference** |
|--------------|---------------|--------------------------|
| **Short and simple method calls** | ✅ Yes | ✅ Yes |
| **More complex operations inside lambda** | ✅ Yes | ❌ No |
| **Existing method is already doing the job** | ❌ No | ✅ Yes |

---

# **🔹 FAQs**
### **1️⃣ Can method references be used for methods with parameters?**
Yes! If the method you are referencing has parameters, Java automatically matches them.

Example:
```java
BiFunction<String, String, Boolean> equalsCheck = String::equals;
System.out.println(equalsCheck.apply("abc", "abc")); // true
```

---

### **2️⃣ Can method references be used for static methods with multiple arguments?**
Yes! If the static method has multiple parameters, they will be passed automatically.

Example:
```java
BiFunction<Integer, Integer, Integer> maxFunction = Math::max;
System.out.println(maxFunction.apply(5, 10)); // 10
```

---

### **3️⃣ Can method references be used with custom classes?**
Yes! You can reference methods in your own classes.

Example:
```java
class Utility {
    public static int multiply(int a, int b) {
        return a * b;
    }
}

BiFunction<Integer, Integer, Integer> multiplyFunc = Utility::multiply;
System.out.println(multiplyFunc.apply(3, 4)); // 12
```

---

### **4️⃣ What happens if the method reference doesn't match the functional interface?**
It will cause a **compilation error**. Java needs an exact match between the referenced method and the functional interface.

Incorrect Example:
```java
Function<Integer, Double> func = Math::sqrt;  // ❌ Compilation Error! sqrt() expects double, not int.
```
✅ **Fix:**
```java
Function<Double, Double> func = Math::sqrt;
```

---

# **📌 Final Summary**
| **Concept** | **Description** |
|-------------|----------------|
| **What is method referencing?** | A shorthand way to refer to existing methods using `::`. |
| **Why use it?** | Improves readability, removes redundant lambdas, and enhances code reusability. |
| **Types of Method References** | Static Method, Instance Method, Class Method, Constructor Reference. |
| **Best Practice** | Use it when an existing method already does the job required by the lambda. |

---
### **🚀 Method referencing makes Java functional programming easier and more elegant!**
Let me know if you need further clarifications! 🎯