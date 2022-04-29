package wzorceProjektowe.structural.flyweight.flyweightInside;

public class DestroyerStats {
    private String name;
    private int hp;
    private int armour;
    private int damageDealt;
    private int speed;
    private int resourceCost;

    public DestroyerStats(String name, int hp, int armour, int damageDealt, int speed, int resourceCost) {
        this.name = name;
        this.hp = hp;
        this.armour = armour;
        this.damageDealt = damageDealt;
        this.speed = speed;
        this.resourceCost = resourceCost;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getArmour() {
        return armour;
    }

    public int getDamageDealt() {
        return damageDealt;
    }

    public int getSpeed() {
        return speed;
    }

    public int getResourceCost() {
        return resourceCost;
    }
}
