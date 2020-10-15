package scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleAtFixedRate {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnableTask = () -> {
            try {
                System.out.println("<Runnable task's execution 300ms>");
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        /* The ScheduledExecutorService runs tasks after some predefined delay and/or periodically.
         * The best way to instantiate a ScheduledExecutorService is to use the factory methods of the Executors class. */
        ScheduledExecutorService executorService = Executors
                .newSingleThreadScheduledExecutor();

        /* The scheduleAtFixedRate() method lets execute a task periodically after a fixed delay.
         *
         * The following block of code will execute a task after an initial delay of 100 milliseconds, and after that,
         * it will execute the same task every 450 milliseconds. If the processor needs more time to execute an assigned
         * task than the period parameter of the scheduleAtFixedRate() method, the ScheduledExecutorService will wait
         * until the current task is completed before starting the next */
        Future<?> resultFuture = executorService
                .scheduleAtFixedRate(runnableTask, 100, 450, TimeUnit.MILLISECONDS);

        TimeUnit.SECONDS.sleep(3);
        executorService.shutdown();
    }
}
