## **Enums in Java**
### **Definition**
An **enum (short for enumeration)** in Java is a **special class** that represents a fixed set of constant values. Enums help define a group of named constants that can be used in a type-safe way.

Enums were introduced in **Java 5** and provide a better alternative to using `static final` constants.

---

## **Declaring an Enum**
Enums are declared using the `enum` keyword:
```java
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}
```
Here, `Day` is an enum type that contains **seven constants**.

---

## **Using Enums**
```java
public class TestEnum {
    public static void main(String[] args) {
        Day today = Day.SATURDAY;
        
        System.out.println("Today is: " + today);  // Output: Today is: SATURDAY
    }
}
```
### **Key Points**
- `today` is a variable of type `Day`, and it can only store one of the values defined in `Day`.
- It prevents invalid values (e.g., `"Holiday"` is not a valid `Day`).

---

## **Enum with `switch` Statement**
Enums work well with `switch` statements:
```java
enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

public class EnumSwitchExample {
    public static void main(String[] args) {
        Day today = Day.SATURDAY;

        switch (today) {
            case MONDAY:
                System.out.println("Start of the work week!");
                break;
            case FRIDAY:
                System.out.println("Weekend is near!");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("It's the weekend!");
                break;
            default:
                System.out.println("A regular weekday.");
        }
    }
}
```
### **Output**
```
It's the weekend!
```
---
## **Enum with Methods and Fields**
Enums can have **constructors, fields, and methods**, making them more powerful.

### **Example: Enum with Methods**
```java
enum Size {
    SMALL(30), MEDIUM(40), LARGE(50), XLARGE(60);

    private int sizeValue;  // Instance variable

    Size(int sizeValue) {  // Constructor
        this.sizeValue = sizeValue;
    }

    public int getSizeValue() {  // Getter method
        return sizeValue;
    }
}

public class EnumExample {
    public static void main(String[] args) {
        Size tshirtSize = Size.LARGE;

        System.out.println("Selected Size: " + tshirtSize);
        System.out.println("Size Value: " + tshirtSize.getSizeValue());
    }
}
```
### **Output**
```
Selected Size: LARGE
Size Value: 50
```
### **Explanation**
- Each enum constant (`SMALL`, `MEDIUM`, etc.) **stores a value** (e.g., `30, 40, 50`).
- The constructor initializes the value.
- The method `getSizeValue()` returns the stored value.

---

## **Enum Methods**
### **1. `values()` – Get All Constants**
Returns an array of all enum constants.
```java
for (Size s : Size.values()) {
    System.out.println(s);
}
```
### **Output**
```
SMALL
MEDIUM
LARGE
XLARGE
```

### **2. `ordinal()` – Get Index of Enum**
Returns the **index** of an enum constant (starting from `0`).
```java
System.out.println(Size.SMALL.ordinal());   // Output: 0
System.out.println(Size.LARGE.ordinal());   // Output: 2
```

### **3. `valueOf()` – Convert String to Enum**
```java
Size s = Size.valueOf("MEDIUM");
System.out.println(s);  // Output: MEDIUM
```
If the string does not match any enum constant, it throws an **`IllegalArgumentException`**.

---

## **When to Use Enums?**
- **When you have a fixed set of constants** (like days of the week, colors, directions).
- **To improve code readability** instead of using integer constants.
- **To prevent invalid values** in a variable.

---

## **Key Takeaways**
✅ Enums are **type-safe** (only predefined constants are allowed).  
✅ Enums **cannot be instantiated** using `new`.  
✅ Enums can have **constructors, fields, and methods**.  
✅ Enums are **implicitly final** and **cannot be extended**.  
✅ Enums **can implement interfaces** but **cannot extend a class**.  

Would you like a real-world example? 😊