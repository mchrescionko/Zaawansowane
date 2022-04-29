package wzorceProjektowe.structural.flyweight.flyweightInside;

public class Destroyer {


    private int x;
    private int y;
    private int hpleft;
    private DestroyerStats stats;


    public Destroyer( int x, int y) {
        stats = UnitStatsRepository.getDestroyerStats();
        this.x = x;
        this.y = y;
        this.hpleft = stats.getHp();;
    }
}
