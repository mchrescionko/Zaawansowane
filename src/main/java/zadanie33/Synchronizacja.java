package zadanie33;

public class Synchronizacja implements Runnable {
    private int x = 0;


    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
//            increment();
            synchronized (this){
                x++;
            }
//            int y = x;
//            int newValue = y + 1;
//            x = newValue;

        }
    }

    public synchronized void increment() {
        x++;
    }

    public int getX() {
        return x;
    }
}
