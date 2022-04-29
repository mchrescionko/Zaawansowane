package wzorceProjektowe.structural.fasada;

public class DeliveryBoxFacade {


    private DeliveryBoxSystem deliveryBoxSystem;
    private DeliveryBox deliveryBox;

    public DeliveryBoxFacade() {
        this.deliveryBoxSystem = new DeliveryBoxSystem();
        this.deliveryBox = new DeliveryBox();
    }

    public void pickUpPackage(){

        deliveryBox.getUserData();
        if(deliveryBoxSystem.isUserDataValidated()&&deliveryBoxSystem.isPaymentSecured()){
            deliveryBox.openBox();
        }

    }
}
