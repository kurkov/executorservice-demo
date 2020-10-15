package scheduledexecutorservice;

import java.util.concurrent.*;

public class Schedule {
    public static void main(String[] args) {
        Runnable runnableTask = () -> {
            try {
                System.out.println("<Runnable task's execution 300ms>");
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTask = () -> {
            System.out.println("<Callable task's execution 300ms>");
            TimeUnit.MILLISECONDS.sleep(300);
            return "Callable task's result";
        };

        /* The ScheduledExecutorService runs tasks after some predefined delay and/or periodically.
        The best way to instantiate a ScheduledExecutorService is to use the factory methods of the Executors class. */
        ScheduledExecutorService executorService = Executors
                .newSingleThreadScheduledExecutor();

        /* To schedule a single task's execution after a fixed delay, use the scheduled() method of the ScheduledExecutorService.
        There are two scheduled() methods that allow you to execute Runnable or Callable tasks */
        Future<String> resultFutureOfCallableTask =
                executorService.schedule(callableTask, 1, TimeUnit.SECONDS);

        Future<?> resultFutureOfRunnableTask =
                executorService.schedule(runnableTask, 1, TimeUnit.SECONDS);

        executorService.shutdown();
    }
}
