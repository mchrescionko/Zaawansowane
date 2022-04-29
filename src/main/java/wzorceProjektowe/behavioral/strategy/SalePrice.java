package wzorceProjektowe.behavioral.strategy;

public class SalePrice implements PricingStrategy{
    @Override
    public void calculatePrice(int price, boolean isSignedUpForNewsletter) {
        if(!isSignedUpForNewsletter){
            System.out.println("cena to "+price);
        }
        else{
            System.out.println("nowy uzytkownik zapisal sie do newslettera, a rabat nie zostal uwzgledniony");
        }
    }
}
