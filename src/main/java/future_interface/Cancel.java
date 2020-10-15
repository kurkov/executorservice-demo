package future_interface;

import java.util.concurrent.*;

public class Cancel {
    public static void main(String[] args) {
        Callable<String> callableTask = () -> {
            System.out.println("<Callable task's execution 300ms>");
            TimeUnit.MILLISECONDS.sleep(300);
            return "Callable task's result";
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(callableTask);

        System.out.println("future is canceled: " + future.isCancelled());
        System.out.println("canceling future");
        future.cancel(true);
        System.out.println("future is canceled: " + future.isCancelled());

        executorService.shutdown();
    }
}
