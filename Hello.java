package reload;

public class Hello {
	
	/*
	 * 这些方法名相同但是参数不同的方法
	 * 		我们称之为重载
	 */
	
	public void hello() {
		System.out.println("Hello world");
	}
	
	public void hello(String name) {
		System.out.println("Hello " + name + " !");
	}
	
	public void hello(String name, int age) {
		if (age < 18) {
			System.out.println("Hi " + name + " !");
		} else {
			System.out.println("Hello, " + name + " !");
		}
	}
}
