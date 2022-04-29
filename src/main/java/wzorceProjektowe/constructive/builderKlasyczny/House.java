package wzorceProjektowe.constructive.builderKlasyczny;


import javax.net.ssl.HostnameVerifier;



public class House {
    private String walls;
    private String floors;
    private String rooms;
    private String roof;
    private String windows;
    private String doors;
    private String garage;

    public House() {

    }

    private House(HouseBuilder houseBuilder){
        this.walls = houseBuilder.walls;
        this.floors = houseBuilder.floors;
        this.doors = houseBuilder.doors;
        this.roof = houseBuilder.roof;
        this.garage = houseBuilder.garage;
        this.windows = houseBuilder.windows;
        this.rooms = houseBuilder.rooms;

    }

    public void setWalls(String walls) {
        this.walls = walls;
    }

    public void setFloors(String floors) {
        this.floors = floors;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setWindows(String windows) {
        this.windows = windows;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public void setGarage(String garage) {
        this.garage = garage;
    }

    public String getWalls() {
        return walls;
    }

    public String getFloors() {
        return floors;
    }

    public String getRooms() {
        return rooms;
    }

    public String getRoof() {
        return roof;
    }

    public String getWindows() {
        return windows;
    }

    public String getDoors() {
        return doors;
    }

    public String getGarage() {
        return garage;
    }

    @Override
    public String toString() {
        return "House{" +
                "walls='" + walls + '\'' +
                ", floors='" + floors + '\'' +
                ", rooms='" + rooms + '\'' +
                ", roof='" + roof + '\'' +
                ", windows='" + windows + '\'' +
                ", doors='" + doors + '\'' +
                ", garage='" + garage + '\'' +
                '}';
    }

    public static class HouseBuilder{
        private String walls;
        private String floors;
        private String rooms;
        private String roof;
        private String windows;
        private String doors;
        private String garage;

        public HouseBuilder buildWalls(String walls){
            this.walls = walls;
            return this;
        }

        public HouseBuilder buildFloors(String floors){
            this.floors = floors;
            return this;
        }

        public HouseBuilder buildRoof(String roof){
            this.roof = roof;
            return this;
        }

        public HouseBuilder buildWindows(String windows){
            this.windows = windows;
            return this;
        }

        public HouseBuilder buildRooms(String rooms){
            this.rooms = rooms;
            return this;
        }

        public HouseBuilder buildDoors(String doors){
            this.doors = doors;
            return this;
        }

        public HouseBuilder buildGarage(String garage){
            this.garage = garage;
            return this;
        }


        public House build(){
            return new House(this);
        }

    }
}
