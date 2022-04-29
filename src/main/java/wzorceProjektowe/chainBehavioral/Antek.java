package wzorceProjektowe.chainBehavioral;

public class Antek extends Child{
    public Antek(Shelf shelf) {
        super(shelf);
    }

    @Override
    public void processRequest(MotherRequest motherRequest) {
        if(motherRequest.getShelf().equals(getShelf())){
            System.out.println("antek wziel sloik z polki!");
        }
        else{
            getTallerChild().processRequest(motherRequest);
        }
    }
}