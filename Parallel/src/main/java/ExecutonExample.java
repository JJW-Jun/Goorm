import java.util.concurrent.Executor;

public class ExecutonExample implements Executor {
    @Override
    public void execute(Runnable task) {
        task.run();
    }

    public static void main(String args []){
        Executor executor = new ExecutonExample();
        executor.execute(()-> System.out.println("Executor"));

    }
}


