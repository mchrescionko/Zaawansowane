package projekt1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        PlayerPawn pionekGracza = new PlayerPawn(0, 0, "Jan");
        ComputerPawn computerPawn = new ComputerPawn(1, 0, "LaMarcus");
        ComputerPawn computerPawn2 = new ComputerPawn(1, 1, "Kevin");
        ComputerPawn computerPawn3 = new ComputerPawn(0, 1, "Marcus");

        List<Pawn> pawns = new ArrayList<>();

        pawns.add(pionekGracza);
        pawns.add(computerPawn);
        pawns.add(computerPawn2);
        pawns.add(computerPawn3);

        Game game = new Game(pawns);
        game.showBoard();
        game.start();
    }
}

