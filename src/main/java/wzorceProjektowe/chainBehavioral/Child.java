package wzorceProjektowe.chainBehavioral;

abstract public class Child {
    private Child tallerChild;
    private Shelf shelf;

    public Child(Shelf shelf) {
        this.shelf = shelf;
    }

    public void setTallerChild(Child tallerChild) {
        this.tallerChild = tallerChild;
    }

    public Child getTallerChild() {
        return tallerChild;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public void processRequest(MotherRequest motherRequest){
        ;
    }
}
