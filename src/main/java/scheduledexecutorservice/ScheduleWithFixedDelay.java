package scheduledexecutorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleWithFixedDelay {
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

        /* If it is necessary to have a fixed length delay between iterations of the task, scheduleWithFixedDelay()
         * should be used. For example, the following code will guarantee a 150-millisecond pause between the end
         * of the current execution and the start of another one. */
        Future<?> resultFuture = executorService
                .scheduleWithFixedDelay(runnableTask, 100, 150, TimeUnit.MILLISECONDS);


        TimeUnit.SECONDS.sleep(3);
        executorService.shutdown();
    }
}
