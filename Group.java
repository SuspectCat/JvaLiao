package liaoxuefeng;

public class Group {

	private String[] names;
	
	/*
	 * public void setNames(String... names) { this.names = names; }
	 * 完全可以改为以下形式
	 * 		但是对方调用 需要自己先构造 String[]
	 * 		调用方可以传入 null
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
