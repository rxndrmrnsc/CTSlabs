package ro.ase.cts.g1098.clean.code.stage4;

//stage 4
// - use the received productType and not the generic enum symbol
// - remove the switch because all branches do the same stuff (except New)

public class DiscountStrategy {

	public final static int PREMIUM_ACCOUNT_MIN_AGE = 10;
	public final static float PREMIUM_DISCOUNT = 0.15f;

	public float getFinalPrice(ProductType productType, float productPrice, int accountAgeInYears) {

		float finalPrice = 0;
		float accountDiscount = 0;

		if (productType != ProductType.NEW) {
			accountDiscount = (accountAgeInYears > DiscountStrategy.PREMIUM_ACCOUNT_MIN_AGE)
					? DiscountStrategy.PREMIUM_DISCOUNT
					: (float) accountAgeInYears / 100;

		}

		finalPrice = (productPrice - (productType.getDiscount() * productPrice))
				- accountDiscount * (productPrice - (productType.getDiscount() * productPrice));

		return finalPrice;
	}
}
