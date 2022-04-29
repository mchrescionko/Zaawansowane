package programowanieFunkcyjne;

public class WielowatkowoscDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i =0;i<10000;i++){
                    System.out.println("kod na osobnym watku" + i);
                }
            }
        });
        thread.start();
        Thread thread2 = new Thread( () -> {
                for (int i =0;i<1000;i++){
                    System.out.println("kod na osobnym watku2");
                }

            }
        );
        thread2.start();

    }
}
