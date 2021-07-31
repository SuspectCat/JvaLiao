package inherit;

/**
 * 阻止继承：
 * 		正常情况下，只要某个class没有final修饰符，那么任何类都可以从该class继承
 * 从Java15开始，允许使用sealed修饰class，并通过permits明确写出
 * 能够从该class继承的子类名称
 * @author 32848
 *
 */

public class SupperMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MuStudent s = new MuStudent("Xiao ming", 12, 89);
		System.out.println(s.name + " | " + s.age + " | " + s.score);
	}

}

class MuStudent extends Person {
	protected int score;
	
	public MuStudent(String name, int age, int score) {
		/*
		 * super() super(name, age);
		 * 		1. 自动调用父类的构造方法
		 * 		2. 必须放在最上面
		 * 结论：
		 * 		如果父类没有默认的构造方法，子类就必须显式调用super()
		 * 		并给出参数以便让编译器定位到父类的一个合适的显式的构造方法
		 * 子类不会继承任何父类的构造方法。
		 * 子类的默认构造方法是由编译器自动生成的，而不是继承的。
		 */
		// super();
		
		super(name, age);
		
		this.score = score;
		/*
		 * super.name = name; 
		 * super.age = age;
		 */
		// super(name, age);
	}
}