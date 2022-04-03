package ro.ase.csie.cts.gr1098.homework;

public class Account {
	public double loanValue;
	public double rate;
	public int daysActive;
	public AccountType accountType;

	public Account(double loanValue, double rate, AccountType accountType) throws Exception {
		if (loanValue < 0) {			
			throw new Exception();
		}
		this.loanValue = loanValue;
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

	@Override
	public String toString() {
		return "Loan: " + this.loanValue 
				+ "; Rate: " + this.rate 
				+ "; Days Active:" + this.daysActive 
				+ "; Account Type: " + this.accountType.toString() 
				+ ";";
	}

	public static double getTotalFee(Account[] accounts) {
		double totalFee = 0.0;
		Account account;
		int daysInYear = 365;
		for (int i = 0; i < accounts.length; i++) {
			account = accounts[i];
			if (account.accountType == AccountType.PREMIUM || account.accountType == AccountType.SUPER_PREMIUM)
				totalFee += .0125 * // 1.25% broker's fee
						(account.loanValue * 
						Math.pow(account.rate, (account.daysActive / daysInYear)) 
						- account.loanValue); // interest-principal
		}
		return totalFee;
	}

}
