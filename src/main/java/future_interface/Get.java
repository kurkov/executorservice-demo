package future_interface;

import java.util.concurrent.*;

public class Get {
    public static void main(String[] args) {
        Callable<String> callableTask = () -> {
            System.out.println("Callable task's execution");
            TimeUnit.MILLISECONDS.sleep(3000);
            return "Callable task's result";
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(callableTask);
        String result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        executorService.shutdown();
    }
}
