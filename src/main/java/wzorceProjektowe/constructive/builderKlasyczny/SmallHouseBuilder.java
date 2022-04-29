package wzorceProjektowe.constructive.builderKlasyczny;

public class SmallHouseBuilder implements HouseBuilder {

    private House house;

    public SmallHouseBuilder() {
        this.house = new House();
    }


    @Override
    public void buildWalls() {
        this.house.setDoors("doors");
    }

    @Override
    public void buildFloors() {
        this.house.setFloors("floors");
    }

    @Override
    public void buildRooms() {
        this.house.setRooms("rooms");
    }

    @Override
    public void buildGarage() {
        this.house.setGarage("garage");
    }

    @Override
    public void buildRoof() {
        this.house.setRoof("roof");
    }

    @Override
    public void buildWindows() {
        this.house.setWindows("windows");
    }

    @Override
    public void buildDoors() {
        this.house.setDoors("doors");
    }

    @Override
    public House getHouse() {
        return house;
    }
}
