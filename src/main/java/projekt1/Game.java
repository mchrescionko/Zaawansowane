package projekt1;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Pawn> pawns;


    public Game(List<Pawn> pawns) {
        this.pawns = pawns;
    }


    public void start() {
        while (isNotOver(pawns.get(0))) {
            List<Pawn> extraList = new ArrayList<>(pawns);
            for (Pawn pawn : extraList) {
                if (pawns.contains(pawn)) {
                    move(pawn);
                    showBoard();
                }
            }
        }
    }

    public boolean isNotOver(Pawn pawn) {
        if (pawns.size() == 1 && pawns.contains(pawn)) {
            System.out.println("Brawo, wygrałeś!");
            return false;
        } else if (!pawns.contains(pawn)) {
            System.out.println("Przegrałeś!");
            return false;
        }
        return true;
    }

    public void move(Pawn pawn) {
        pawn.move();
        killing(pawn);
    }

    public void showBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + field(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public String field(int x, int y) {
        for (Pawn pawn : pawns) {
            if (pawn.getX() == x && pawn.getY() == y) {
                return pawn.toString().charAt(0) + "";
            }
        }
        return "o";
    }


    public void killing(Pawn killingPawn) {
        List<Pawn> restOfPawns = new ArrayList<>(pawns);
        restOfPawns.remove(killingPawn);
        for (Pawn killedPawn : restOfPawns) {
            if (killingPawn.isOnTheSamePosition(killedPawn)) {
                System.out.println("Pionek gracza " + killedPawn.toString() + " został zabity przez pionek gracza " + killingPawn.toString());
                pawns.remove(killedPawn);
            }
        }
    }





}
