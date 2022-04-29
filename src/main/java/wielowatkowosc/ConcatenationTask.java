package wielowatkowosc;

import javax.swing.plaf.TableHeaderUI;

public class ConcatenationTask implements Runnable {

    private int x;
    private String message;
    private String result ="";
    private boolean running = true;


    public ConcatenationTask(int x, String message) {
        this.x = x;
        this.message = message;
    }

    @Override
    public void run() {
        for(int i=0;i<x;i++){
            result += message;

            if(!running){
                break;
            }

        }
        System.out.println(result.length());
    }

    public String getResult() {
        return result;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    //    public void startTask(){
//        Thread thread1 =  new Thread(this);
//
//    }
}
