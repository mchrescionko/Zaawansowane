package wielowatkowosc;

import javax.swing.plaf.TableHeaderUI;
import java.lang.management.RuntimeMXBean;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        ConcatenationTask concatenationTask = new ConcatenationTask(555555,"D");
        Thread thread = new Thread(concatenationTask);
        thread.start();

        ConcatenationTask concatenationTask2 = new ConcatenationTask(5, "E");
//        Thread thread2 = new Thread(concatenationTask2);
//        thread2.start();
//        System.out.println(concatenationTask2.getResult());
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(7000);
                    concatenationTask.setRunning(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();
    }
}
