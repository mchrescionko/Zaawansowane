package wzorceProjektowe.constructive.factory.abstractFactory;

abstract public class InfantryUnit {
    private int HP;
    private int exp;
    private int hit;

    protected InfantryUnit(int HP, int exp, int hit) {
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
