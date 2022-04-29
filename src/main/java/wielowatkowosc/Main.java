package wielowatkowosc;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("O czym mowa?");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.next();
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("skonczyl sie czas");
                    return;
                }
                if(answer.equals("tak")){
                    System.out.println("udalo sie");

                }else{
                    System.out.println("bledna odpowiedz");

                }


            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                    thread2.interrupt();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread2.start();



    }
}
