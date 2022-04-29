package wzorceProjektowe.chainBehavioral;

public class Ania extends Child{
    public Ania(Shelf shelf) {
        super(shelf);
    }

    @Override
    public void processRequest(MotherRequest motherRequest) {
        if(motherRequest.getShelf().equals(getShelf())){
            System.out.println("ania wziela sloik z polki!");
        }
        else {
            getTallerChild().processRequest(motherRequest);
        }


    }
}
