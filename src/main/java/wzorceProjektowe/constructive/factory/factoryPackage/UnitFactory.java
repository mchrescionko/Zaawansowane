package wzorceProjektowe.constructive.factory.factoryPackage;

public class UnitFactory extends Factory{

    @Override
    public Unit createUnit(UnitType unitType) {
        switch(unitType){
            case TANK:
                Unit tank = new Tank(100,10,20);
                return tank;
            case RIFFLEMAN:
                Unit riffleman = new Riffleman(200,5,30);
                return riffleman;
            default:
                throw new UnsupportedOperationException("no such type");
        }
    }
}
