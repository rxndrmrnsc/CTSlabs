package ro.ase.csie.cts.gr1098.homework;

public class Account {
	public double loanValue;
	public double rate;
	public int daysActive;
	public int accountType;
	public static final int STANDARD = 0;
	public static final int BUDGET = 1;
	public static final int PREMIUM = 2;
	public static final int SUPER_PREMIUM = 3;

	public Account(double loanValue, double rate, int accountType) throws Exception {
		if (loanValue < 0) {			
			throw new Exception();
		}
		this.loanValue = loanValue;
		this.rate = rate;
		this.accountType = accountType;
	}
	
	public double getLoanValue() {
		System.out.println("The loan value is " + this.loanValue);
		return this.loanValue;
	}

	public double getRate() {
		System.out.println("The rate is " + this.rate);
		return this.rate;
	}

	// must have method - the lead has requested it in all classes
	public double getMonthlyRate() {
		return this.loanValue * this.rate;
	}

	public void setLoanValue(double loanValue) throws Exception {
		if (loanValue < 0) {
			throw new Exception();
		}
		this.loanValue = loanValue;
	}

	public String toString() {
		return "Loan: " + this.loanValue 
				+ "; Rate: " + this.rate 
				+ "; Days Active:" + this.daysActive 
				+ "; Account Type: " + this.accountType 
				+ ";";
	}

	public void printClassName() {
		int variable = 10;
		System.out.println("This is an account");
	}

	public static double getTotalFee(Account[] accounts) {
		double totalFee = 0.0;
		Account account;
		int daysInYear = 365;
		for (int i = 0; i < accounts.length; i++) {
			account = accounts[i];
			if (account.accountType == Account.PREMIUM || account.accountType == Account.SUPER_PREMIUM)
				totalFee += .0125 * // 1.25% broker's fee
						(account.loanValue * 
						Math.pow(account.rate, (account.daysActive / 365)) 
						- account.loanValue); // interest-principal
		}
		return totalFee;
	}

}
