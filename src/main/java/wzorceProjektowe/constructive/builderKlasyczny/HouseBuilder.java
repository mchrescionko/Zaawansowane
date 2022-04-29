package wzorceProjektowe.constructive.builderKlasyczny;

public interface HouseBuilder {

    void buildWalls();
    void buildFloors();
    void buildRooms();
    void buildGarage();
    void buildRoof();
    void buildWindows();
    void buildDoors();

    House getHouse();


}
