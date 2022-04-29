package wzorceProjektowe.structural.fasada;

public class DeliveryBoxSystem {

    void sendNOtification(){
        System.out.println("Text message send to the client");
    }

    boolean isPaymentSecured(){
        System.out.println("Payment has been secured");
        return true;
    }

    boolean isUserDataValidated(){
        System.out.println("User data has been validated");
        return true;
    }

    void scheduleDelivery(){
        System.out.println("Delivery has been scheduled");
    }


}
