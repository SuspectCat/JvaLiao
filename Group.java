package liaoxuefeng;

public class Group {

	private String[] names;
	
	/*
	 * public void setNames(String... names) { this.names = names; }
	 * ��ȫ���Ը�Ϊ������ʽ
	 * 		���ǶԷ����� ��Ҫ�Լ��ȹ��� String[]
	 * 		���÷����Դ��� null
	 */
	public void setNames(String[] names) {
		this.names = names;
	}
	
	public void showNames() {
		for(String name : names) {
			System.out.print(name + " ");
		}
		
		System.out.println();
	}
}
