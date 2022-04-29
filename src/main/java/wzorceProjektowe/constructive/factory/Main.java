package wzorceProjektowe.constructive.factory;


import wzorceProjektowe.constructive.factory.factoryPackage.Unit;
import wzorceProjektowe.constructive.factory.factoryPackage.UnitFactory;
import wzorceProjektowe.constructive.factory.factoryPackage.UnitType;

public class Main {
    public static void main(String[] args) {
        UnitFactory unitFactory = new UnitFactory();

        Unit tank = unitFactory.createUnit(UnitType.TANK);
        Unit riffleman = unitFactory.createUnit(UnitType.RIFFLEMAN);
    }



}
