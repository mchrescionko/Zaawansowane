package wzorceProjektowe.constructive.factory.factoryPackage;

abstract public class Unit {
    private int HP;
    private int exp;
    private int hit;

    protected Unit(int HP, int exp, int hit) {
        this.HP = HP;
        this.exp = exp;
        this.hit = hit;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getHP() {
        return HP;
    }

    public int getExp() {
        return exp;
    }

    public int getHit() {
        return hit;
    }
}
