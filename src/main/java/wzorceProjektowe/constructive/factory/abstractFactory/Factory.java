package wzorceProjektowe.constructive.factory.abstractFactory;

abstract class Factory {
    abstract public InfantryUnit createInfantryUnit(UnitType type);
    abstract public MechanizedUnit createMEchanizedUnit(UnitType type);
}
