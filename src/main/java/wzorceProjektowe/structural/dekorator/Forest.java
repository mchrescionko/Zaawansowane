package wzorceProjektowe.structural.dekorator;

public class Forest extends TerrainDecorator{


    public Forest (Terrain terrain){
        super(terrain);
    }

    @Override
    public int fuelCost(){
        return terrain.fuelCost() +5;
    }
}
