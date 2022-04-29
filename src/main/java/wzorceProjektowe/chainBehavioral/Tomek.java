package wzorceProjektowe.chainBehavioral;

public class Tomek extends Child{
    public Tomek(Shelf shelf) {
        super(shelf);
    }

    @Override
    public void processRequest(MotherRequest motherRequest) {
        if(motherRequest.getShelf().equals(getShelf())){
            System.out.println("Tomek wzial sloik z polki!");
        }
        else{
            getTallerChild().processRequest(motherRequest);
        }
    }
}