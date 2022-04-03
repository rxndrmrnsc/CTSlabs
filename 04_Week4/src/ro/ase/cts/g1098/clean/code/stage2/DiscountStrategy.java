package ro.ase.cts.g1098.clean.code.stage2;

//stage 2
// - remove statics and use enums instead

public class DiscountStrategy {

	public final static int PREMIUM_ACCOUNT_MIN_AGE = 10;
	public final static float PREMIUM_DISCOUNT = 0.15f;

	public float getFinalPrice(ProductType productType, float productPrice, int accountAgeInYears) {

//		final float new_product_discount = 0.1f;

		float finalPrice = 0;
		float accountDiscount = (accountAgeInYears > DiscountStrategy.PREMIUM_ACCOUNT_MIN_AGE)
				? DiscountStrategy.PREMIUM_DISCOUNT
				: (float) accountAgeInYears / 100;
		if (productType == ProductType.NEW) {
			finalPrice = productPrice;
		} else if (productType == ProductType.NORMAL) {
			finalPrice = (productPrice - (productType.getDiscount() * productPrice))
					- accountDiscount * (productPrice - (productType.getDiscount() * productPrice));
		} else if (productType == ProductType.ON_SALE) {
			finalPrice = (productPrice - (productType.getDiscount() * productPrice))
					- accountDiscount * (productPrice - (productType.getDiscount() * productPrice));
		} else if (productType == ProductType.FINAL_SALE) {
			finalPrice = (productPrice - (productType.getDiscount() * productPrice))
					- accountDiscount * (productPrice - (productType.getDiscount() * productPrice));
		}
		return finalPrice;
	}
}
