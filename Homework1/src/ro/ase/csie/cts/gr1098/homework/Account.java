package ro.ase.csie.cts.gr1098.homework;

public class Account {
	public double loanValue;
	public double rate;
	public int daysActive;
	public AccountType accountType;
	
	public Account(double loanValue, double rate, AccountType accountType) throws Exception {
		setLoanValue(loanValue);
		this.rate = rate;
		this.accountType = accountType;
	}
	
	public double getLoanValue() {
		return this.loanValue;
	}

	public double getRate() {
		return this.rate;
	}

	public double getMonthlyRate() {
		return this.loanValue * this.rate;
	}

	public void setLoanValue(double loanValue) throws Exception {
		if (loanValue < 0) {
			throw new Exception();
		}
		this.loanValue = loanValue;
	}


	public double getYearsActive() {
		return DateConversion.getYears(daysActive);
	}
	
	public double getInterestPrincipal() {
		return Math.pow(this.rate, this.getYearsActive());
	}
	
	public double getFullInterestPrincipal() {
		return this.loanValue * (this.getInterestPrincipal() - 1);
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
		return "Loan: " + this.loanValue 
				+ "; Rate: " + this.rate 
				+ "; Days Active:" + this.daysActive 
				+ "; Account Type: " + this.accountType.toString() 
				+ ";";
	}
}
