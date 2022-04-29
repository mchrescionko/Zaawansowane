package wzorceProjektowe.structural.flyweight.flyweightInside;

public class UnitStatsRepository {

    private static DestroyerStats destroyerStats = new DestroyerStats("destroyer", 10, 10, 10, 10, 10);

    private UnitStatsRepository(){};

    public static DestroyerStats getDestroyerStats(){
        return destroyerStats;
    }
}
