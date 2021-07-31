package polymorphism;

public class PersonA {

	protected String name;
	
	@Override
	public String toString() {
		return "Person:name = " + name;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof PersonA) {
			PersonA p = (PersonA)o;
			
			return this.name.equals(p.name);
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
}
