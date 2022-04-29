package wzorceProjektowe.structural.dekorator;

abstract public class Terrain {
    private String description;
    private int feulCost;

    public String getDescription() {
        return description;
    }

    public Terrain(String description, int feulCost) {
        this.description = description;
        this.feulCost = feulCost;
    }

    public int fuelCost(){
        return feulCost;
    }
}
