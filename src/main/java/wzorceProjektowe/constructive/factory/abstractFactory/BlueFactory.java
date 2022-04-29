package wzorceProjektowe.constructive.factory.abstractFactory;

public class BlueFactory extends Factory{
    @Override
    public InfantryUnit createInfantryUnit(UnitType type) {
        switch(type){
            case RIFFLEMAN:
                return new Riffleman(25,0,5);
            default:
                throw new UnsupportedOperationException("Nieznany typ");
        }
    }

    @Override
    public MechanizedUnit createMEchanizedUnit(UnitType type) {
        switch(type){
            case TANK:
                return new Tank(100,0,25);
            default:
                throw new UnsupportedOperationException("Nieznany typ");
        }
    }
}
