package inherit;

import liaoxuefeng.Person;

public class UpWardAndDownWard {
	
	public static void main(String[] args) {
		Student s = new Student();
		
		/*
		 * ����ת��
		 * Student ���� Person ���������
		 * ��ӵ�� Person ��ȫ������
		 */
		Person p = new Student();
		
		System.out.println(p.equals(s));
		
		System.out.println("---------------------");
		
		/* ����ת��
		 * Ϊ�˱�������ת�ͳ���
		 * Java�ṩ��instanceof���������������ж�һ��ʵ�������ǲ���ĳ������
		 */
		Person pA = new Person();
		System.out.println(pA instanceof Person);
		System.out.println(pA instanceof Student);
		
		Student sA = new Student();
		System.out.println(sA instanceof Person);
		System.out.println(sA instanceof Student);
	}
}
