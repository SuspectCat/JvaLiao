package construct;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("Xiao ming", 15);
		
		// 调用无参构造方法
		// Person p1 = new Person();
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}

}

class Person {
	
	private String name;
	private int age;
	
	/*
	 * 如果你既要使用有参的构造方法，
	 * 又想保留无参的构造方法
	 * 		那么，只能把两个构造方法都定义出来
	 */
	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
}