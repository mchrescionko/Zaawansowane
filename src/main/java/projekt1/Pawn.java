package projekt1;

public abstract class Pawn {
    protected int x;
    protected int y;
    protected String name;

    public Pawn(int x, int y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public String toString(){
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void move ();

    public boolean isOnTheSamePosition(Pawn pawn){
        return y == pawn.y && x == pawn.x;
    }
}
