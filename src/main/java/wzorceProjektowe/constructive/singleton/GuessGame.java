package wzorceProjektowe.constructive.singleton;

import java.io.Serializable;
import java.util.Scanner;

public class GuessGame implements Serializable {

    static GuessGame guessGame;
    private int score;


    private GuessGame() {
    }

    //synchronized - synchronizuje całą metodę (w nagłówku)
    public static GuessGame getInstance() {
        if (guessGame == null) {
            synchronized (GuessGame.class) {
                if (guessGame == null) {
                    guessGame = new GuessGame();
                }
            }
        }
        return guessGame;
    }

    public int getScore() {
        return score;
    }

    public void play(){
        Scanner scanner = new Scanner(System.in);

        for(int i=0;i<10;i++){
            System.out.println("Podaj liczbe");
            if((int)(Math.random()*10)==scanner.nextInt()){
                score++;
                System.out.println("zgadles");
            }else {
                System.out.println("nie zgadles");
            }
        }
        System.out.println("koniec gry");
    }


}
