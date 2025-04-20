class Human {
		String name;
		String gender;
		int age;
		
		public void printName() {
			System.out.println(this.name);
		}
		
		
		
	   public void eat() {
			System.out.println("Eating");
		}
		
	}
public class OOPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human Male1 = new Human();
		Male1.name = "Rehan";
		Male1.gender = "Male";
		Male1.age = 25;
		
		Human Male2 = new Human();
		Male2.name = "Shadab";
		
				
		Male1.eat();
		Male1.printName();
		Male2.printName();
		Male2.eat();

	}

}
