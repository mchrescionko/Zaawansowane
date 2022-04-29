package zadanie33;

import java.util.ArrayList;
import java.util.List;

public class Letters {
    private String napis;
    private List<Thread> threads = new ArrayList<>();
    private boolean result = true;

    public Letters(String napis) {
        this.napis = napis;
        char[] array = napis.toCharArray();
        for (char c : array) {
            threads.add(new Thread(new Task(c), "Thread-" + c));
        }
    }

    public void setResult(boolean result) {
        this.result = result;
    }


    public List<Thread> getThreads() {
        return threads;
    }


    class Task implements Runnable {
        private char letter;

        public Task(char letter) {
            this.letter = letter;
        }

        @Override
        public void run() {
            try {
                while (result) {
                    Thread.sleep(1000);
                    System.out.print(letter);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


