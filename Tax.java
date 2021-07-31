package polymorphism;

public class Tax {
	
	public static void main(String[] args) {
		Income[] incomes = new Income[] {
			new Income(3000),
			new Sarlary(7500),
			new StateCouncilSpecialAllowance(15000)
		};
		
		System.out.println(totalTax(incomes));
	}
	
	public static double totalTax(Income[] incomes) {
		double total = 0;
		
		for (Income income : incomes) 
			total += income.getTax();
		
		return total;
	}
}

class Income {
	protected double income;
	
	public Income(double income) {
		this.income = income;
	}
	
	public double getTax() {
		return income * 0.1;
	}
}

class Sarlary extends Income {
	public Sarlary(double income) {
		super(income);
	}
	
	@Override
	public double getTax() {
		if (income <= 5000)
			return 0;
		return (income - 5000) * 0.2;
	}
}

class StateCouncilSpecialAllowance extends Income {
	public StateCouncilSpecialAllowance(double income) {
		super(income);
	}
	
	@Override
	public double getTax() {
		return 0;
	}
}