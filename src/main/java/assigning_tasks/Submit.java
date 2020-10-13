package assigning_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Submit {
    public static void main(String[] args) {
        Runnable runnableTask = () -> {
            try {
                System.out.println("Runnable task's execution");
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Callable task's execution";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<?> futureOfRunnableTask = executorService.submit(runnableTask);
        Object futureResultOfRunnableTask = null;
        try {
            futureResultOfRunnableTask = futureOfRunnableTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(futureResultOfRunnableTask + "\n");

        Future<String> futureOfCallableTask = executorService.submit(callableTask);
        String futureResultOfCallableTask = null;
        try {
            futureResultOfCallableTask = futureOfCallableTask.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(futureResultOfCallableTask);

        // executorService.submit(callableTasks); // collection not supported

        executorService.shutdown();
    }
}
