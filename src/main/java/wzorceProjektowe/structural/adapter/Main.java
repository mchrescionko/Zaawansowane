package wzorceProjektowe.structural.adapter;


import wzorceProjektowe.structural.adapter.inside.*;

public class Main {
    public static void main(String[] args) {
        ContinentalDevice radio = new ContinentalDevice() {
            @Override
            public void on() {
                System.out.println("gra muzyka");
            }
        };
        ContinentalSocket continentalSocket = new ContinentalSocket();

        continentalSocket.plugIn(radio);

        UKDevice ukRadio = new UKDevice() {
            @Override
            public void powerOn() {
                System.out.println("Londyn płonie");
            }
        };


        UKSocket ukSocket = new UKSocket();

        ukSocket.plugIn(ukRadio);

        UKtoContinentalAdapter uKtoContinentalAdapter = new UKtoContinentalAdapter(ukRadio);

        continentalSocket.plugIn(uKtoContinentalAdapter);


    }
}
