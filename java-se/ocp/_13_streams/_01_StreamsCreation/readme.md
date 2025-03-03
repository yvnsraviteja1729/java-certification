##  Java 8 Streams (Functional Programming)**
Java 8 introduced the **Stream API** to process collections and arrays in a functional way.

### **Creating Streams**
- **From Collections (`List`, `Set`, etc.)**
  ```java
  List<String> list = Arrays.asList("A", "B", "C");
  Stream<String> stream = list.stream();
  ```

- **From Arrays**
  ```java
  String[] arr = {"X", "Y", "Z"};
  Stream<String> stream = Arrays.stream(arr);
  ```

- **Using `Stream.of()`**
  ```java
  Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
  ```

- **Using `Stream.generate()` (Infinite Streams)**
  ```java
  Stream<Double> randomStream = Stream.generate(Math::random).limit(5);
  ```

- **Using `Stream.iterate()`**
  ```java
  Stream<Integer> evenNumbers = Stream.iterate(0, n -> n + 2).limit(10);
  ```
