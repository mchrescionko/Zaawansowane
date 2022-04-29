package Executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        //ThreadPoolExecutor - you can use it to manage threads, specify number of it etc, handle runnable and callable tasks

        ExecutorService executorService = new ThreadPoolExecutor(
                1,
                1,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());

        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
                System.out.println("zadanie zrobione");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable runnableTask2 = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                    System.out.println("zadanie zrobione2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(3000);
            System.out.println("raz.raz");
            TimeUnit.MILLISECONDS.sleep(3000);
            System.out.println("raz.dwa");
            return "Task's execution one";
        };
        Callable<String> callableTask2 = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println("dwa");
            return "Task's execution two";
        };
        Callable<String> callableTask3 = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            System.out.println("trzy");
            return "Task's execution three";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask2);
        callableTasks.add(callableTask3);

        //execute - invoke task, but doesn't give any results
        executorService.execute(runnableTask);

        //submit - invoke task and return result in Future object
        Future<String> future = executorService.submit(callableTask);
        String result = "";
        try {
            //invokeAny - invoke one task and returns the result of him
            result = executorService.invokeAny(callableTasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        List<Future<String>> futures = null;
        try {
            //invokeAll - invoke all tasks and returns results from all of them
             futures = executorService.invokeAll(callableTasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //future.get - return result of the task (if thread is running, get will wait till the task stops)
        System.out.println(futures.get(0).toString());
        executorService.shutdown();

        Future<String> future2 = executorService.submit(callableTask);
        String result2 = "";
        try {
            result2 = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("result: "+result2);
        //shutdow - end thread, doesn't cause immediate end of all tasks, it stops ececuteService starting new tasks
        // and shuts down all running tasks when they finish their work
        executorService.shutdown();
        System.out.println("result: "+result2);
//       The shutdownNow() method tries to destroy the ExecutorService immediately,
//       but it doesn't guarantee that all the running threads will be stopped at the same time.

//       The shutdownNow() method tries to destroy the ExecutorService immediately,
//       but it doesn't guarantee that all the running threads will be stopped at the same time:



    }
}
