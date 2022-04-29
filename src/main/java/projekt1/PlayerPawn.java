package projekt1;

public class PlayerPawn extends Pawn {

    public PlayerPawn(int x, int y, String name) {
        super(x, y, name);
    }

    @Override
    public void move() {

        System.out.println("Twój ruch " + toString());
        int move;
        String message = "";
        Controler controler = new Controler();
        do {

            System.out.println(message);
            message = "wyszedles poza plansze! sprobuj jeszcze raz";
            move = controler.move("Ruch prawo lewo");

        } while (!(x + move > -1 && x + move < 10));
        x = x + move;

        message = "";
        do {
            System.out.println(message);
            message = "wyszedles poza plansze! sprobuj jeszcze raz";
            move = controler.move("ruch góra dół");
        } while (!(y + move > -1 && y + move < 10));
        y = y + move;
    }


}
