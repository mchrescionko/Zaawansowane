package wzorceProjektowe.structural.dekorator;

public class Swamp extends TerrainDecorator{
    public Swamp(Terrain terrain) {
        super(terrain);
    }



    @Override
    public int fuelCost() {
        return terrain.fuelCost()+15;
    }
}
