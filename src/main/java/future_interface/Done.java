package future_interface;

import java.util.concurrent.*;

public class Done {
    public static void main(String[] args) {
        Callable<String> callableTask = () -> {
            System.out.println("<Callable task's execution 300ms>");
            TimeUnit.MILLISECONDS.sleep(300);
            return "Callable task's result";
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(callableTask);
        String result = null;
        try {
            System.out.println("future is done: " + future.isDone());
            System.out.println("future.get()");
            result = future.get();
            System.out.println("future is done: " + future.isDone());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result);

        executorService.shutdown();
    }
}
