package construct;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("Xiao ming", 15);
		
		// �����޲ι��췽��
		// Person p1 = new Person();
		
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}

}

class Person {
	
	private String name;
	private int age;
	
	/*
	 * ������Ҫʹ���вεĹ��췽����
	 * ���뱣���޲εĹ��췽��
	 * 		��ô��ֻ�ܰ��������췽�����������
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