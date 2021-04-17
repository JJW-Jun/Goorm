import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DelayedTaskExample {
    public static void main(String args []){
        ScheduledExecutorService exeService = Executors.newSingleThreadScheduledExecutor();

        exeService.schedule(()-> System.out.println("First"), 10, TimeUnit.SECONDS);
        exeService.schedule(()-> System.out.println("Second"), 10, TimeUnit.SECONDS);
        exeService.schedule(()-> System.out.println("Third"), 10, TimeUnit.SECONDS);

    }
}
