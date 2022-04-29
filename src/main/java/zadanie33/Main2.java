package zadanie33;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        Synchronizacja synchronizacja = new Synchronizacja();
        Thread thread = new Thread(synchronizacja);
        Thread thread2 = new Thread(synchronizacja);

        thread.start();
        thread2.start();


        thread.join();
        thread2.join();
        System.out.println(synchronizacja.getX());

    }
}
