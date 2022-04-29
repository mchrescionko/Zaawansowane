package wzorceProjektowe.constructive.factory.abstractFactory;

public class Main {
    public static void main(String[] args) {
        Factory blueFactory = new BlueFactory();
        Factory redfacto = new RefFactory();

        MechanizedUnit redTank = redfacto.createMEchanizedUnit(UnitType.TANK);
        InfantryUnit redInfantry = redfacto.createInfantryUnit(UnitType.RIFFLEMAN);

        MechanizedUnit blueTank = blueFactory.createMEchanizedUnit(UnitType.TANK);
        InfantryUnit blueInfantry = blueFactory.createInfantryUnit(UnitType.RIFFLEMAN);

    }
}
