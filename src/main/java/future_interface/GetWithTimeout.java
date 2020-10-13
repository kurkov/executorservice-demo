package future_interface;

import java.util.concurrent.*;

public class GetWithTimeout {
    public static void main(String[] args) {
        Callable<String> callableTask = () -> {
            System.out.println("<Callable task's execution 300ms>");
            TimeUnit.MILLISECONDS.sleep(300);
            return "Callable task's result";
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future1 = executorService.submit(callableTask);
        String result1 = null;
        try {
            System.out.println("future.get(500, TimeUnit.MILLISECONDS)");
            result1 = future1.get(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("Timeout exception!");
        }
        System.out.println("result = " + result1 + "\n");

        Future<String> future2 = executorService.submit(callableTask);
        String result2 = null;
        try {
            System.out.println("future.get(200, TimeUnit.MILLISECONDS)");
            result2 = future2.get(200, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("Timeout exception!");
        }
        System.out.println("result = " + result2);

        executorService.shutdown();
    }
}
