package ro.ase.cts.g1098.clean.code.stage1;

//stage 1
// - refactor it by using a proper naming convention
// - remove "magic" numbers (hardcoded numbers)

public class DiscountStrategy {

	public final static int PREMIUM_ACCOUNT_MIN_AGE = 10;
	public final static float PREMIUM_DISCOUNT = 0.15f;
	
	public final static int NEW_PRODUCT_TYPE = 1;
	public final static int NORMAL_PRODUCT_TYPE = 2;
	public final static int ON_SALE_PRODUCT_TYPE = 3;
	public final static int ON_FINAL_SALE_PRODUCT_TYPE = 4;

	public final static float NEW_PRODUCT_DISCOUNT = 0f;
	public final static float NORMAL_PRODUCT_DISCOUNT = 0.1f;
	public final static float ON_SALE_PRODUCT_DISCOUNT = 0.25f;
	public final static float ON_FINAL_SALE_PRODUCT_DISCOUNT = 0.35f;

	
	public float getFinalPrice(int productType, float productPrice, int accountAgeInYears) {

//		final float new_product_discount = 0.1f;

		
		float finalPrice = 0;
		float accountDiscount = 
				(accountAgeInYears > DiscountStrategy.PREMIUM_ACCOUNT_MIN_AGE) ? DiscountStrategy.PREMIUM_DISCOUNT : (float) accountAgeInYears / 100;
		if (productType == DiscountStrategy.NEW_PRODUCT_TYPE) {
			finalPrice = productPrice;
		} else if (productType == DiscountStrategy.NORMAL_PRODUCT_TYPE) {
			finalPrice = (productPrice - (DiscountStrategy.NORMAL_PRODUCT_DISCOUNT * productPrice)) - accountDiscount * (productPrice - (DiscountStrategy.NORMAL_PRODUCT_DISCOUNT * productPrice));
		} else if (productType == DiscountStrategy.ON_SALE_PRODUCT_TYPE) {
			finalPrice = (productPrice - (DiscountStrategy.ON_SALE_PRODUCT_DISCOUNT * productPrice)) - accountDiscount * (productPrice - (DiscountStrategy.ON_SALE_PRODUCT_DISCOUNT * productPrice));
		} else if (productType == DiscountStrategy.ON_FINAL_SALE_PRODUCT_TYPE) {
			finalPrice = (productPrice - (DiscountStrategy.ON_FINAL_SALE_PRODUCT_DISCOUNT * productPrice)) - accountDiscount * (productPrice - (DiscountStrategy.ON_FINAL_SALE_PRODUCT_DISCOUNT * productPrice));
		}
		return finalPrice;
	}
}
