package inherit;

import liaoxuefeng.Person;

public class UpWardAndDownWard {
	
	public static void main(String[] args) {
		Student s = new Student();
		
		/*
		 * 向上转型
		 * Student 属于 Person 的子类对象
		 * 它拥有 Person 的全部功能
		 */
		Person p = new Student();
		
		System.out.println(p.equals(s));
		
		System.out.println("---------------------");
		
		/* 向下转型
		 * 为了避免向下转型出错
		 * Java提供了instanceof操作符，可以先判断一个实例究竟是不是某种类型
		 */
		Person pA = new Person();
		System.out.println(pA instanceof Person);
		System.out.println(pA instanceof Student);
		
		Student sA = new Student();
		System.out.println(sA instanceof Person);
		System.out.println(sA instanceof Student);
	}
}
