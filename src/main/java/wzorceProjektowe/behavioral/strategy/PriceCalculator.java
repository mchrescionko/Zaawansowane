package wzorceProjektowe.behavioral.strategy;

public class PriceCalculator {
    private PricingStrategy pricingStrategy;

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public void calculate(int price, boolean isSignedUpForNewsletter){
        pricingStrategy.calculatePrice(price,isSignedUpForNewsletter);
    }
}
