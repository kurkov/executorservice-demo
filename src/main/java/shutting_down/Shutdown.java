package shutting_down;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Shutdown {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        /* The shutdown() method doesn't cause immediate destruction of the ExecutorService.
        It will make the ExecutorService stop accepting new tasks and shut down after all running threads
        finish their current work.*/
        executorService.shutdown();
    }
}