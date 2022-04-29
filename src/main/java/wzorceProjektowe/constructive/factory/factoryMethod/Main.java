package wzorceProjektowe.constructive.factory.factoryMethod;

public class Main {
    public static void main(String[] args) {
        Tank tankleft = new TankLeft();
        Tank tankright = new TankRight();

        tankright.shoot();
        tankleft.shoot();
    }
}
