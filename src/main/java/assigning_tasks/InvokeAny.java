package assigning_tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAny {
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

        /*
         * InvokeAny() cancels remaining tasks after one was completed. But that does not mean it will
         * submit/start the next task only after the current task is finished, that's the whole point
         * of concurrency, it does not wait for the previous task to complete. Submit the tasks one by one,
         * don't wait for them to complete, meanwhile, check if any task is completed, if completed,
         * cancel all currently running tasks, don't submit the remaining tasks and just return the completed task.
         *
         * Now, before cancelling the running tasks finally, its possible they have done their job or they may not,
         * in this case the print statement, depending on the time slice each thread gets, this is based
         * on various JVM and System factors.
         * */
        String result = null;
        try {
            result = executorService.invokeAny(callableTasks);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        executorService.shutdown();
    }
}
