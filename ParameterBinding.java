package liaoxuefeng;

public class ParameterBinding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person();
		int n = 15;
		p.setAge(n);
		
		System.out.println(p.getMyAge());
		
		n = 20;
		// p.setAge(n);
		
		System.out.println(p.getMyAge());
		
		System.out.println("---------------------");
		
		PersonA pA = new PersonA();
		pA.setName("Homer", "SimpSon");
		
		System.out.println(pA.getName());
		
		System.out.println("---------------------");
		
		String[] name = {
			"´óéÙéÙ", "°×ÊÖÌ×"	
		};
		
		pA.setStringName(name);
		
		System.out.println(pA.getName());
	}

}
