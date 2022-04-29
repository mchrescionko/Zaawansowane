package wzorceProjektowe.constructive.factory.factoryMethod;

public class TankRight extends Tank {
    public TankRight() {

        barrel = new BarrelLeft();
    }

    @Override
    public Barrel createBarrel() {
        return null;
    }

}
