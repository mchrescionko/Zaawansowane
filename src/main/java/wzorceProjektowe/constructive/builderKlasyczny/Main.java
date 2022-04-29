package wzorceProjektowe.constructive.builderKlasyczny;

import jdk.jshell.Snippet;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        SmallHouseBuilder smallHouseBuilder = new SmallHouseBuilder();
        BIgHouseBilder bigHouseBuilder = new BIgHouseBilder();

        HouseDirector smallHouseDirector = new HouseDirector(smallHouseBuilder);
        smallHouseDirector.buildHouse();

        HouseDirector bigHouseDirector = new HouseDirector(bigHouseBuilder);
        bigHouseDirector.buildHouse();

        House smallHouse = smallHouseBuilder.getHouse();
        House bigHouse = bigHouseBuilder.getHouse();

        System.out.println(smallHouse);
        System.out.println(bigHouse);

    }
}
