package ro.ase.csie.cts.gr1098.homework;

public class Account {
	private Loan loan;
	private int daysActive;
	private AccountType accountType;
	
	public Account(double loanValue, double rate, AccountType accountType) throws Exception {
		loan = new Loan(loanValue, rate);
		this.accountType = accountType;
	}
	
	public double getLoanValue() {
		return this.loan.getLoanValue();
	}

	public double getRate() {
		return this.loan.getRate();
	}

	public double getMonthlyRate() {
		return this.loan.getMonthlyRate();
	}

	public void setLoanValue(double loanValue) throws InvalidArgumentException {
		loan.setLoanValue(loanValue);
	}


	public double getYearsActive() {
		return DateConversion.getYears(daysActive);
	}
	
	public double getInterestPrincipal() {
		return Math.pow(this.loan.getRate(), this.getYearsActive());
	}
	
	public double getFullInterestPrincipal() {
		return this.loan.getLoanValue() * (this.getInterestPrincipal() - 1);
	}
	
	public double getFee() {
		if (this.accountType == AccountType.PREMIUM || this.accountType == AccountType.SUPER_PREMIUM) {
			return Broker.BROKERS_FEE * this.getFullInterestPrincipal();			
		}
		return 0.0;
	}
	
	public static double getTotalFee(Account[] accounts) {
		double totalFee = 0.0;
		for (int i = 0; i < accounts.length; i++) {
			totalFee += accounts[i].getFee();
		}
		return totalFee;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Loan=");
		builder.append(loan);
		builder.append("; DaysActive=");
		builder.append(daysActive);
		builder.append("; AccountType=");
		builder.append(accountType);
		builder.append(";");
		return builder.toString();
	}

	
}
