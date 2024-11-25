package _0025_reference_types;

public class MainApp {

	// Method 1: Takes a String as an argument
	public void fly(String s) {
		System.out.println("string ");
	}

	// Method 2: Takes an Object as an argument
	public void fly(Object o) {
		System.out.println("object ");
	}

	public static void main(String[] args) {
		// Create an instance of MainApp
		MainApp obj = new MainApp();

		// Calling the fly method with a String argument
		obj.fly("test");

		// Calling the fly method with an Integer argument (56 is an int, which will be autoboxed to an Integer)
		obj.fly(56);
	}
}
