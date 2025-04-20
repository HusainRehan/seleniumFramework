
public class Polymorphism {

	String name;
	int age;
	int standard;
	
	public void printInfo(String name) {
		System.out.println("Name: " + name);
	}
	public void printInfo(int age) {
		System.out.println("Age: " + age);
	}
	public void printInfo(int age, String name) {
		System.out.println(age + " " + name);
	}
	
	public static void main(String[] args) {
		// method overloading
		Polymorphism compileTime = new Polymorphism();
		compileTime.name = "Rehan";
		compileTime.age = 25;
		compileTime.standard = 12;
		compileTime.printInfo(compileTime.name);
		compileTime.printInfo(compileTime.age);
		compileTime.printInfo(compileTime.age, compileTime.name);
		

	}

}
