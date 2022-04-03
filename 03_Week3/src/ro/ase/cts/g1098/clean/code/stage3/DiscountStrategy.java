package ro.ase.cts.g1098.clean.code.stage3;

//stage 3
// - change if else to switch

public class DiscountStrategy {

	public final static int PREMIUM_ACCOUNT_MIN_AGE = 10;
	public final static float PREMIUM_DISCOUNT = 0.15f;

	public float getFinalPrice(ProductType productType, float productPrice, int accountAgeInYears) {

		float finalPrice = 0;
		float accountDiscount = (accountAgeInYears > DiscountStrategy.PREMIUM_ACCOUNT_MIN_AGE)
				? DiscountStrategy.PREMIUM_DISCOUNT
				: (float) accountAgeInYears / 100;

		switch (productType) {
		case NEW:
			finalPrice = productPrice;
			break;
		case NORMAL:
			finalPrice = (productPrice - (productType.getDiscount() * productPrice))
					- accountDiscount * (productPrice - (productType.getDiscount() * productPrice));
			break;
		case ON_SALE:
			finalPrice = (productPrice - (productType.getDiscount() * productPrice))
					- accountDiscount * (productPrice - (productType.getDiscount() * productPrice));
			break;
		case FINAL_SALE:
			finalPrice = (productPrice - (productType.getDiscount() * productPrice))
					- accountDiscount * (productPrice - (productType.getDiscount() * productPrice));
			break;
		default:
			throw new UnsupportedOperationException();
		}

		return finalPrice;
	}
}
