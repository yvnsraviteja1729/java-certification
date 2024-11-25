In Java, **`int`** and **`Integer`** are related but fundamentally different types. The key difference lies in their nature: `int` is a **primitive type**, while `Integer` is a **wrapper class**. Below is a detailed comparison of both:

### 1. **`int` (Primitive Type):**
- **Nature:** It is a **primitive data type** in Java.
- **Size:** `int` occupies 4 bytes (32 bits) in memory.
- **Default Value:** The default value of an `int` is `0`.
- **Performance:** Primitive types like `int` are generally faster because they are directly stored in memory and don’t involve object creation.
- **Usage:** `int` is used when you need to store simple numeric values in variables and don’t require the additional overhead associated with objects.

### 2. **`Integer` (Wrapper Class):**
- **Nature:** `Integer` is a **class** in the `java.lang` package that wraps an `int` value into an object.
- **Size:** Being an object, `Integer` occupies more memory than an `int`. It includes the memory required for the object itself in addition to the actual `int` value.
- **Default Value:** The default value of an `Integer` is `null` (because it’s an object).
- **Performance:** `Integer` is slower compared to `int` because it involves object creation and the associated overhead.
- **Usage:** `Integer` is used when you need to store `int` values in contexts that require objects, such as in collections like `ArrayList<Integer>` (which cannot store primitive types).

### **Key Differences:**

| **Feature**             | **`int` (Primitive)**                 | **`Integer` (Wrapper Class)**        |
|-------------------------|---------------------------------------|--------------------------------------|
| **Type**                | Primitive type                       | Object (Wrapper class for `int`)     |
| **Size in Memory**      | 4 bytes                               | 16 bytes (depending on JVM and platform) |
| **Default Value**       | `0`                                   | `null`                               |
| **Nullability**         | Cannot be `null`                      | Can be `null`                        |
| **Performance**         | Faster (due to no object overhead)    | Slower (due to object creation)      |
| **Used For**            | Simple numeric values                | When an `int` is needed as an object |
| **Storage in Collections** | Cannot store in collections directly (e.g., `ArrayList<int>`) | Can be used in collections (e.g., `ArrayList<Integer>`) |

### **When to Use `int` vs. `Integer`:**

1. **Use `int` when:**
    - You need a simple, fast, and memory-efficient way to store integer values.
    - You are performing arithmetic operations frequently, where performance is a concern.
    - You don’t need to store the value in a collection like `ArrayList`, which only accepts objects.
    - You don't need to represent `null` values for the variable (since `int` cannot be `null`).

   Example:
   ```java
   int a = 5;
   int b = 10;
   int sum = a + b;  // Simple arithmetic operation
   ```

2. **Use `Integer` when:**
    - You need to store integer values in collections like `ArrayList`, `HashMap`, etc. (which cannot directly store primitive types).
    - You need to represent `null` as a valid value, i.e., when an integer may not have been assigned yet or is missing.
    - You are working with generic types or APIs that require objects.
    - You need to use utility methods available in the `Integer` class (such as `parseInt()`, `valueOf()`, `toString()`, etc.).

   Example:
   ```java
   // Using Integer in a collection
   ArrayList<Integer> list = new ArrayList<>();
   list.add(5);  // Autoboxing converts int to Integer
   list.add(10);
   ```

   Example of `Integer` utility methods:
   ```java
   String numberStr = "123";
   int number = Integer.parseInt(numberStr);  // Converts String to int
   Integer integerObj = Integer.valueOf(10);  // Converts int to Integer
   ```

### **Autoboxing and Unboxing:**
Java automatically converts between `int` and `Integer` in many situations through **autoboxing** and **unboxing**:
- **Autoboxing:** Automatically converts a primitive `int` to an `Integer` object.
- **Unboxing:** Automatically converts an `Integer` object to a primitive `int`.

```java
public class AutoboxingExample {
    public static void main(String[] args) {
        // Autoboxing: converting int to Integer automatically
        Integer integerObj = 5;  // This is equivalent to Integer.valueOf(5)
        
        // Unboxing: converting Integer to int automatically
        int num = integerObj;  // This is equivalent to integerObj.intValue()
        
        System.out.println("Integer: " + integerObj); // Output: 5
        System.out.println("Primitive int: " + num);   // Output: 5
    }
}
```

### **Summary:**
- **`int`** is used when you need a simple, fast, and memory-efficient way to store integer values, especially for arithmetic operations or when working with large amounts of data.
- **`Integer`** is used when you need an object to store integer values, such as in collections, or when you need to represent `null` or use utility methods provided by the `Integer` class.

In general, prefer using **`int`** for most use cases, as it is more efficient, and use **`Integer`** when you need to work with objects or store the values in collections.