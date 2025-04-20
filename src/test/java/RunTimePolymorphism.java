
class Shape {
	String color;

	public void area() {
	System.out.println("This is a shape");
	}
	public void printColor() {
		System.out.println("Color: " + color);
	
	
}}
 class Triangle extends Shape {
		int base;
		int height;
		Triangle(int i,int j) {
			this.base =i;
			this.height = j;
		}
		public void area(int base, int height) {
			System.out.println(0.5*base*height);
		}}
class Circle extends Shape {
			int r;
			Circle(int r) {
				this.r = r;
			}
			public void area(int radius) {
				System.out.println(3.14*radius*radius);
			}
}
	public class RunTimePolymorphism {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape s = new Shape();
		s.color = "red";
		s.area();
		Circle c = new Circle(3);
		c.area(3);
		Triangle t = new Triangle(4,5);
		t.area(4,5);
		t.color = "blue";
		t.printColor();
		
}}

