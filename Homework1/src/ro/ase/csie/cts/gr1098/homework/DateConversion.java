package ro.ase.csie.cts.gr1098.homework;

public abstract class DateConversion {

	public static final int DAYS_IN_YEAR = 365;
	
	public static final double getYears(int nrOfDays) {
		return nrOfDays / DateConversion.DAYS_IN_YEAR;
	}
}
