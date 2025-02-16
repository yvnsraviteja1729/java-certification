The `instanceof` keyword in Java is used to **check whether an object is an instance of a specific class or subclass**. It returns `true` if the object is an instance of the specified class (or a subclass), otherwise it returns `false`.

### **Syntax**

```java
object instanceof ClassName
```

- `object` → The reference variable to check.
- `ClassName` → The class or interface being checked.

---

## **Example 1: Checking Instance of a Class**

```java
class Animal { }
class Dog extends Animal { }

public class Test {
    public static void main(String[] args) {
        Dog d = new Dog();
        System.out.println(d instanceof Dog);    // true
        System.out.println(d instanceof Animal); // true (since Dog extends Animal)
    }
}
```

### **Explanation:**

- `d instanceof Dog` → `true` because `d` is an instance of `Dog`.
- `d instanceof Animal` → `true` because `Dog` is a subclass of `Animal`.

---

## **Example 2: Checking `null` with `instanceof`**

If the object is `null`, `instanceof` always returns `false`.

```java
class Cat { }

public class Test {
    public static void main(String[] args) {
        Cat c = null;
        System.out.println(c instanceof Cat); // false
    }
}
```

---

## **Example 3: Using `instanceof` with Interfaces**

The `instanceof` operator can also check if an object implements an interface.

```java
interface Animal { }
class Dog implements Animal { }

public class Test {
    public static void main(String[] args) {
        Dog d = new Dog();
        System.out.println(d instanceof Animal); // true
    }
}
```

### **Explanation:**

- Since `Dog` implements `Animal`, `d instanceof Animal` returns `true`.

---

## **Example 4: Using `instanceof` for Type Checking**

```java
class Animal { }
class Dog extends Animal { }
class Cat extends Animal { }

public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();

        if (a instanceof Dog) {
            System.out.println("a is a Dog");
        } else if (a instanceof Cat) {
            System.out.println("a is a Cat");
        } else {
            System.out.println("Unknown type");
        }
    }
}
```

### **Output:**

```
a is a Dog
```

- `a instanceof Dog` → `true` because `a` is a `Dog` object.

---

## **Key Points**

1. `instanceof` checks if an object belongs to a specific class or subclass.
2. It works with both **classes** and **interfaces**.
3. If the reference variable is `null`, `instanceof` **always returns `false`**.
4. Useful for **type checking** before performing type casting.

Would you like a real-world example? 😊
