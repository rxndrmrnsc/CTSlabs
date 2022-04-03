package ro.ase.cts.g1098.clean.code.stage6.models.main;

import ro.ase.cts.g1098.clean.code.stage6.interfaces.MarketingStrategyInterface;
import ro.ase.cts.g1098.clean.code.stage6.models.marketing.AccountMarketingStrategy;
import ro.ase.cts.g1098.clean.code.stage6.models.marketing.SummerAccountMarketingStrategy;
import ro.ase.cts.g1098.clean.code.stage6.models.product.Product;
import ro.ase.cts.g1098.clean.code.stage6.models.product.ProductType;

public class Main {

	public static void main(String[] args) {

		Product product = new Product();
		MarketingStrategyInterface marketingStrategy = new AccountMarketingStrategy();
		
		product.setAccountDiscountStrategy(marketingStrategy);
		
		float finalPrice = product.getFinalPrice(ProductType.ON_SALE, 1000, 10);
		System.out.println("The final price is " + finalPrice);
		
		product.setAccountDiscountStrategy(new SummerAccountMarketingStrategy());
		
		finalPrice = product.getFinalPrice(ProductType.ON_SALE, 1000, 10);
		System.out.println("The final Summer price is " + finalPrice);
		
	}

}
