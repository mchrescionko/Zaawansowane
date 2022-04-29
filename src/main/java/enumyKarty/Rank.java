package enumyKarty;

public enum Rank {

    Jeden(1), Dwa(2), Trzy(3), Cztery(4), Piec(5), Szesc(6), Siedem(7), Osiem(8), Dziewiec(9), Dziesiec(10), Jopek(11), Dama(12), Krol(13), As(14);
    private final int rankStrength;

    Rank(int rankStrength) {
        this.rankStrength = rankStrength;
    }

    public int getRankStrength() {
        return rankStrength;
    }
}
