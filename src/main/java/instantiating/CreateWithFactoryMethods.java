package instantiating;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CreateWithFactoryMethods {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        // do something with ExecutorService
        executorService.shutdown();
    }
}