package inherit;

/**
 * ��ֹ�̳У�
 * 		��������£�ֻҪĳ��classû��final���η�����ô�κ��඼���ԴӸ�class�̳�
 * ��Java15��ʼ������ʹ��sealed����class����ͨ��permits��ȷд��
 * �ܹ��Ӹ�class�̳е���������
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
		 * 		1. �Զ����ø���Ĺ��췽��
		 * 		2. �������������
		 * ���ۣ�
		 * 		�������û��Ĭ�ϵĹ��췽��������ͱ�����ʽ����super()
		 * 		�����������Ա��ñ�������λ�������һ�����ʵ���ʽ�Ĺ��췽��
		 * ���಻��̳��κθ���Ĺ��췽����
		 * �����Ĭ�Ϲ��췽�����ɱ������Զ����ɵģ������Ǽ̳еġ�
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