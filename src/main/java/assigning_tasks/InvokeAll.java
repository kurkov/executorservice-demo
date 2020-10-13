package assigning_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAll {
    public static void main(String[] args) {
        Callable<String> callableTask = () -> {
            System.out.println("Callable task's execution");
            TimeUnit.MILLISECONDS.sleep(300);
            return "Callable task's result";
        };

        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Future<String>> futures = null;
        try {
            futures = executorService.invokeAll(callableTasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (futures != null) {
            for (Future<String> stringFuture : futures) {
                try {
                    System.out.println(stringFuture.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }

        executorService.shutdown();
    }
}
