package wzorceProjektowe.constructive.factory.abstractFactory;

public class RefFactory extends Factory{
    @Override
    public InfantryUnit createInfantryUnit(UnitType type) {
        switch(type){
            case RIFFLEMAN:
                return new Riffleman(55,0,15);
            default:
                throw new UnsupportedOperationException("Nieznany typ");
        }
    }

    @Override
    public MechanizedUnit createMEchanizedUnit(UnitType type) {
        switch(type){
            case TANK:
                return new Tank(80,0,15);
            default:
                throw new UnsupportedOperationException("Nieznany typ");
        }
    }
}
