package wzorceProjektowe.constructive.builder;

import javax.net.ssl.HostnameVerifier;

public class Main {
    public static void main(String[] args) {

        House house = House.createHouse()
                .buildWalls("walls")
                .buildFloors("floors")
                .buildWindows("windows").build();

        System.out.println(house);



    }
}
