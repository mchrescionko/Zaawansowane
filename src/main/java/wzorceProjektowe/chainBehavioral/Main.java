package wzorceProjektowe.chainBehavioral;

public class Main {
    public static void main(String[] args) {
        Child ania  = new Ania(Shelf.MEDIUM);
        Child antek = new Antek(Shelf.HIGH);
        Child tomek = new Tomek(Shelf.LOW);

        ania.setTallerChild(antek);
        tomek.setTallerChild(ania);

        MotherRequest motherRequest = new MotherRequest(Shelf.MEDIUM);
        MotherRequest motherRequest2 = new MotherRequest(Shelf.HIGH);

        tomek.processRequest(motherRequest);
        tomek.processRequest(motherRequest2);

    }
}
