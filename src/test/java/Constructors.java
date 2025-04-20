
public class Constructors {
	String name;
	int age;

	/*Constructors() {
         System.out.println("Default Constructor"); non-parameterized constructor
		}*/

	Constructors(String name, int age) {
		this.name = name; //this keyword is used to refer to the current object
		this.age= age;
	}
	//Parameterized constructor
	public void printDetails() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		//System.out.println("Parameterized Constructor");
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
           					//Constructors obj = new Constructors(); 
		Constructors obj1 = new Constructors("Rehan", 25); //parameterized constructor
           	obj1.printDetails();

           	
           	
        
	}

}
