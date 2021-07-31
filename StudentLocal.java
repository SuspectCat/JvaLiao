package inherit;

public class StudentLocal extends Person {
	public String hello() {
		return "hello" + name;
	}
	
	public String supperHello() {
		return "supper " + super.name; 
	}
}
