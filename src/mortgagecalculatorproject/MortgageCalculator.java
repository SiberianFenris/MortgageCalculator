package mortgagecalculatorproject;

public class MortgageCalculator {
	final static byte MONTHS_IN_YEAR = 12;
	final static byte PERCENT = 100;

	private int principal;
	private float annualInterest;
	private byte years;
	
	public MortgageCalculator(int principal, float annualInterest, byte years) {
		super();
		this.principal = principal;
		this.annualInterest = annualInterest;
		this.years = years;
	}

	public double calculateMortgage() {
		float numberOfPayments = getNumberOfPayments();
		float monthlyInterest = getMonthlyInterest();
		
		double mortgage = principal
				* (monthlyInterest * Math.pow(1+ monthlyInterest, numberOfPayments)
				/ (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
		
		return mortgage;
	}

	public double calculateBalance(short numberOfPaymentsMade) {
		float numberOfPayments = getNumberOfPayments();
		float monthlyInterest = getMonthlyInterest();
		double balance = principal
				* (Math.pow(1 + monthlyInterest, numberOfPayments)
				- Math.pow(1 + monthlyInterest, numberOfPaymentsMade))
				/ (Math.pow(1 + monthlyInterest, numberOfPayments) -1);
		
		return balance;
	}
		
	private int getNumberOfPayments() {
		return years * MONTHS_IN_YEAR;
	}

	private float getMonthlyInterest() {
		return annualInterest / PERCENT / MONTHS_IN_YEAR;
	}
}
