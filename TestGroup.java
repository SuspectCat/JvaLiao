package liaoxuefeng;

public class TestGroup {
	
	public static void main(String[] args) {
		Group g = new Group();
		/*
		 * g.setNames("xiao ming", "xiao hong", "xiao jun"); g.showNames();
		 * 
		 * g.setNames("Xiao Ming", "Xiao Hong"); g.showNames();
		 * 
		 * g.setNames("ะกร๛"); g.showNames();
		 * 
		 * g.setNames(); g.showNames();
		 */
		
		String[] names = new String[] {
			"Xiao ming", "Xiao hong", "Xiao jun"	
		};
		
		g.setNames(names);
		g.showNames();
	}
}
