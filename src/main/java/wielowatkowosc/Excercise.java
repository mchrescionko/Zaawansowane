package wielowatkowosc;

public class Excercise implements Runnable {
    private Thread t;
    private String threadName;

    public Excercise(String threadName) {
        this.threadName = threadName;
    }

    public Excercise(Thread t, String threadName) {
        this.t = t;
        this.threadName = threadName;
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

class TestThread {

    public static void main(String args[]) {
        Excercise R1 = new Excercise("Thread-1");
        R1.start();

        Excercise R2 = new Excercise("Thread-2");
        R2.start();

        Excercise R3 = new Excercise("Thread-3") {
            @Override
            public void sayHello() {
                System.out.println("Hi");
            }
        };
        R2.sayHello();
        R3.sayHello();
    }
}
