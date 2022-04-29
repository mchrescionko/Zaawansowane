package wzorceProjektowe.constructive.factory.factoryMethod;

//czołg wytawarza działo
//nie uzywamy tutaj klas BarrelLeft i BarrelRight
abstract public class Tank {
    protected Barrel barrel;

    public Tank(){
        barrel = createBarrel();
    }

    public abstract Barrel createBarrel();

    public void shoot(){
        barrel.shoot();
    }
}
