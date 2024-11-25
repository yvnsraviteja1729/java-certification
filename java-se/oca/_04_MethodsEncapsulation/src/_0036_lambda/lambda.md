### **Lambdas in Java**

In Java, **lambda expressions** provide a clear and concise way to represent **functional interfaces** (interfaces with a single abstract method) using an expression. They were introduced in **Java 8** as part of the **functional programming** features added to the language. Lambda expressions enable developers to write more expressive, compact, and readable code, especially when working with collections and APIs like **Streams**.

### **Syntax of Lambda Expressions**

The syntax of a lambda expression consists of the following parts:

1. **Parameter List:** A comma-separated list of parameters for the method defined by the functional interface.
2. **Arrow Token (`->`)**: Separates the parameter list from the body of the lambda expression.
3. **Body:** Contains the expression or block of code to be executed. The body can either be a single expression or a block of statements.

```java
(parameters) -> expression or { statements }
```

### **Example:**

#### **Lambda Expression Example:**
```java
// Traditional anonymous class implementation
Runnable r1 = new Runnable() {
    public void run() {
        System.out.println("Hello, World!");
    }
};

// Lambda expression equivalent
Runnable r2 = () -> System.out.println("Hello, World!");

r1.run();  // Output: Hello, World!
r2.run();  // Output: Hello, World!
```

In the above example:
- The **traditional approach** uses an anonymous class to implement the `Runnable` interface.
- The **lambda expression** simplifies this by directly defining the implementation of the `run` method.

### **Lambda Expression Components:**

1. **Parameter List:**
    - The parameters of the lambda expression are defined in parentheses `()` just like method parameters. You can omit parentheses if there is only one parameter and its type can be inferred.
    - Example with multiple parameters: `(int x, int y) -> x + y`
    - Example with a single parameter: `x -> x * x`

2. **Arrow Token (`->`):**
    - The arrow (`->`) separates the parameter list from the body of the lambda expression. It indicates that what follows is the body that defines the implementation of the abstract method.

3. **Body:**
    - The body can be:
        - A **single expression** (which is implicitly returned).
        - A **block of code** enclosed in `{}` that can contain multiple statements, where a return statement may be needed.

   **Single expression:**
   ```java
   (a, b) -> a + b
   ```
   **Block of code:**
   ```java
   (a, b) -> { 
       int sum = a + b; 
       return sum;
   }
   ```

### **Types of Functional Interfaces:**
Lambda expressions can be used only where there is a **functional interface**, which is an interface with **exactly one abstract method**. Java provides several built-in functional interfaces in the `java.util.function` package.

1. **`Predicate<T>`**: Represents a function that takes one argument and returns a `boolean`.
   ```java
   Predicate<Integer> isEven = x -> x % 2 == 0;
   System.out.println(isEven.test(4));  // Output: true
   ```

2. **`Function<T, R>`**: Represents a function that takes one argument and returns a result.
   ```java
   Function<Integer, Integer> square = x -> x * x;
   System.out.println(square.apply(4));  // Output: 16
   ```

3. **`Consumer<T>`**: Represents a function that takes one argument and returns no result (i.e., it performs an operation).
   ```java
   Consumer<String> printMessage = message -> System.out.println(message);
   printMessage.accept("Hello, Lambda!");  // Output: Hello, Lambda!
   ```

4. **`Supplier<T>`**: Represents a function that takes no arguments and returns a result.
   ```java
   Supplier<Double> randomValue = () -> Math.random();
   System.out.println(randomValue.get());  // Output: Random value between 0.0 and 1.0
   ```

5. **`BinaryOperator<T>`**: Represents a function that takes two arguments of the same type and returns a result of the same type.
   ```java
   BinaryOperator<Integer> add = (a, b) -> a + b;
   System.out.println(add.apply(2, 3));  // Output: 5
   ```

### **Advantages of Lambda Expressions:**

1. **Conciseness**: Lambda expressions provide a more concise way to express methods (often replacing anonymous classes).
2. **Readability**: Lambdas can make code more readable, especially when dealing with **functional-style operations** on collections or streams.
3. **Enables Functional Programming**: Lambdas enable functional programming techniques like **map**, **filter**, **reduce**, and more in Java, making it easier to work with **streams** and **collections**.

### **Example: Using Lambdas with Streams:**

Java's **Stream API** makes heavy use of lambdas for various operations like filtering, mapping, and reducing data.

```java
import java.util.*;
import java.util.stream.*;

public class LambdaStreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill");

        // Example: Filter names starting with 'J' and convert to uppercase
        List<String> result = names.stream()
                                   .filter(name -> name.startsWith("J"))
                                   .map(name -> name.toUpperCase())
                                   .collect(Collectors.toList());

        result.forEach(System.out::println);  // Output: JOHN, JANE, JACK, JILL
    }
}
```

In this example:
- The **`filter`** operation uses a lambda to test each element of the stream (`name -> name.startsWith("J")`).
- The **`map`** operation uses a lambda to transform each element (`name -> name.toUpperCase()`).
- The **`collect`** method gathers the results into a list.

### **Lambda Expression and Scope:**

- **Final or Effectively Final Variables**: Lambda expressions can **capture** variables from their surrounding environment, but the captured variables must be **final** or **effectively final** (i.e., the variable is not modified after initialization).

  Example:
  ```java
  int value = 10;
  Runnable r = () -> System.out.println(value);  // Works fine because value is effectively final
  r.run();  // Output: 10
  ```

### **Restrictions of Lambda Expressions:**

1. **Cannot access non-final local variables that are modified**:
    - Variables used inside a lambda must be either **final** or **effectively final**. You can't modify a local variable after it's used in a lambda expression.

2. **No method overloading or inheritance for lambda**:
    - Lambdas are tied to the specific signature of the functional interface they are implementing. This means you cannot overload methods using lambdas, and they can't inherit from a class.

### **Lambda Expression vs Anonymous Class:**

- **Lambda Expression**:
    - Concise and easy to read.
    - Can be passed around as arguments and returned as values.

- **Anonymous Class**:
    - Verbose and requires defining a class each time.
    - Involves boilerplate code for method implementation.

#### **Example Comparison**:
Anonymous class implementation:
```java
Runnable r = new Runnable() {
    public void run() {
        System.out.println("Running...");
    }
};
```
Lambda expression:
```java
Runnable r = () -> System.out.println("Running...");
```

### **Conclusion:**

Lambda expressions in Java provide a more concise, expressive, and functional way to handle behavior that would normally require anonymous classes. They are particularly useful when working with APIs that rely on functional interfaces, such as the **Stream API** or **java.util.function** package. By using lambdas, you can reduce boilerplate code, improve readability, and adopt a functional programming style within Java.