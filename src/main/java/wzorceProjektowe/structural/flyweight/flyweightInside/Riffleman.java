package wzorceProjektowe.structural.flyweight.flyweightInside;

public class Riffleman {
    private String name;
    private int hp;
    private int armour;
    private int damageDealt;
    private int speed;
    private int x;
    private int y;
    private int hpleft;
    private int resourceCost;

    public Riffleman(String name, int hp, int armour, int damageDealt, int speed, int x, int y, int resourceCost) {
        this.name = name;
        this.hp = hp;
        this.armour = armour;
        this.damageDealt = damageDealt;
        this.speed = speed;
        this.x = x;
        this.y = y;
        this.resourceCost = resourceCost;
        this.hpleft = hp;
    }
}
