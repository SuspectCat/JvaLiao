package liaoxuefeng;

public class TestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person ming = new Person();
		// ming.name �޷���������
		
		/* 
		 * ʹ�÷������޸Ĳ���ֵ
		 * ����޸� 
		 */
		ming.setName("Xiao Ming");
		ming.setAge(12);
		
		System.out.println("name: " + ming.getName() + " age: " + ming.getMyAge());
		
		ming.setBirth(2008);
		System.out.println(ming.getAge());
	}

}
