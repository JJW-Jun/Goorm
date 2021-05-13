import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
    public static void main(String args[]) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new MyTask("First"));
        executorService.execute(new MyTask("Second"));
        executorService.execute(new MyTask("Third"));
        executorService.shutdown();

    }

}

class MyTask implements Runnable {
    private String id;

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Task Id= " + id + ", running ... " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public MyTask(String id) {
        this.id = id;
    }
}
