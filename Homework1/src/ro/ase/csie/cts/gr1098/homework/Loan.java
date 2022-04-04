package ro.ase.csie.cts.gr1098.homework;

public class Loan {
	private double loanValue;
	private double rate;

	public Loan(double loanValue, double rate) throws InvalidArgumentException {
		super();
		this.setLoanValue(loanValue);
		this.setRate(rate);
	}

	public double getLoanValue() {
		return loanValue;
	}

	public void setLoanValue(double loanValue) throws InvalidArgumentException {
		if (loanValue < 0) {
			throw new InvalidArgumentException();
		}
		this.loanValue = loanValue;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) throws InvalidArgumentException {
		if (rate < 0) {
			throw new InvalidArgumentException();

		}
		this.rate = rate;
	}

	public double getMonthlyRate() {
		return this.loanValue * this.rate;
	}

}
