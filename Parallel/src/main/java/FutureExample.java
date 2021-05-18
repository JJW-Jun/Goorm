import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {
    public Callable<Long> calSquare(long value) {
        Callable<Long> callable = new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                Long returnValue = value * value;
                TimeUnit.SECONDS.sleep(1);
                System.out.println(value + "의 제곱근은 " + returnValue);
                return returnValue;
            }
        };
        return callable;
    }

    public void executeTest() {
        List<Long> sampleDataList = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
        List<Future<Long>> futureList = new ArrayList<>();

        ExecutorService servicePool = Executors.newFixedThreadPool(4);

        for (Long sampleValue : sampleDataList) {
            Future<Long> future = servicePool.submit(calSquare(sampleValue));
            futureList.add(future);
        }

        Long sumValue = 0L;

        for (Future<Long> future : futureList) {
            try {
                sumValue += future.get();
            } catch (ExecutionException | InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        System.out.println("최종합계= " + sumValue);
        servicePool.shutdown();
    }

    public static void main(String args[]) {
        FutureExample futureExample = new FutureExample();
        futureExample.executeTest();

    }
}
