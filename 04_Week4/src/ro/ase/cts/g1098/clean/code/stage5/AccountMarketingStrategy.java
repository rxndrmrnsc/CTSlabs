package ro.ase.cts.g1098.clean.code.stage5;

public class AccountMarketingStrategy {

	public final static int PREMIUM_ACCOUNT_MIN_AGE = 10;
	public final static float PREMIUM_DISCOUNT = 0.15f;
	
	public float getAccountDiscount(int accountAgeInYears) {
		
		return  (accountAgeInYears > PREMIUM_ACCOUNT_MIN_AGE)
				? PREMIUM_DISCOUNT
				: (float) accountAgeInYears / 100;
	}
	
}
