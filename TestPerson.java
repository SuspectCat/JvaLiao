package liaoxuefeng;

public class TestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person ming = new Person();
		// ming.name 无法正常访问
		
		/* 
		 * 使用方法来修改参数值
		 * 间接修改 
		 */
		ming.setName("Xiao Ming");
		ming.setAge(12);
		
		System.out.println("name: " + ming.getName() + " age: " + ming.getMyAge());
		
		ming.setBirth(2008);
		System.out.println(ming.getAge());
	}

}
