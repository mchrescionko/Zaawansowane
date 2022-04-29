package wzorceProjektowe.behavioral.strategy;

public class RegularPrice implements PricingStrategy{
    @Override
    public void calculatePrice(int price, boolean isSignedUpForNewsletter) {
        if(isSignedUpForNewsletter){
            System.out.println("cena to "+((double)(price)/2));
        }
        else{
            System.out.println("nowy uzytkownik nie zapisal sie do newslettera");
        }
    }
}
