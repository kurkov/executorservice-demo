package shutting_down;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ShutdownNow {
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

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        System.out.println("Total tasks: " + callableTasks.size());
        try {
            executorService.invokeAny(callableTasks);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        List<Runnable> notExecutedTasks = executorService.shutdownNow();
        System.out.println("shutdownNow()");
        System.out.println(notExecutedTasks.size() + " tasks were not completed");
    }
}
