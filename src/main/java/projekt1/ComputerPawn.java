package projekt1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPawn extends Pawn {

    public ComputerPawn(int x, int y, String name) {
        super(x, y, name);
    }

    @Override
    public void move() {
        System.out.println("Ruch gracza " + toString());
        List<Integer> givenList = new ArrayList();
        Random rand = new Random();
        givenList.add(1);
        givenList.add(-1);
        int randomIndexX;
        int randomIndexY;
        int newPositionX;
        int newPositionY;
        do {
            randomIndexX = rand.nextInt(givenList.size());
            newPositionX = y + givenList.get(randomIndexX);
            randomIndexY = rand.nextInt(givenList.size());
            newPositionY = x + givenList.get(randomIndexY);
        } while (!(newPositionX > -1 && newPositionX < 11 && newPositionY > -1 && newPositionY < 11));

        y= y + givenList.get(randomIndexX);
        x=x + givenList.get(randomIndexY);

    }
}

