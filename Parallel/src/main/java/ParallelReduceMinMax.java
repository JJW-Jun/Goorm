import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ParallelReduceMinMax {
    public static void main(String args[]) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        integerList.parallelStream().forEach(v -> {
            String threadName = Thread.currentThread().getName();

            LocalDateTime currentTime = LocalDateTime.now();
            System.out.printf(currentTime.format(formatter) + "->Thread Name : %s, Stream value: %s\n", threadName, v);
            ;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {

            }
        });
    }

}
