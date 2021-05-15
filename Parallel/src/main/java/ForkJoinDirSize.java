import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class ForkJoinDirSize extends RecursiveTask<Long> {
    private final Path path;

    public ForkJoinDirSize(Path path) {
        this.path = path;
    }

    @Override
    protected Long compute() {
        long fileSize = 0;

        if (Files.isDirectory(path)) {
            System.out.println("Files");
            try {
                var fileList = Files.list(path).collect(Collectors.toList());
                var subTaskList = new ArrayList<ForkJoinDirSize>();

                for (Path file : fileList) {
                    ForkJoinDirSize subtask = new ForkJoinDirSize(file);
                    subtask.fork();
                    subTaskList.add(subtask);
                }

                Long subSize = 0L;

                for (ForkJoinDirSize subTask : subTaskList) {
                    subSize += subTask.join();
                }
                return subSize;
            } catch (IOException e) {
                System.out.println("Error= " + path);
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        } else{
            try{
                fileSize = Files.size(path);
            }catch (IOException e){
                System.out.println("Error= " + path);
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return fileSize;
    }

    public static void main(String args []){
        Path rootPath = Paths.get("/Users/jungjunwoo/Jun");
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println("병렬처리 크기= "+pool.getParallelism());
        System.out.println("Total= "+pool.invoke(new ForkJoinDirSize(rootPath)));

    }
}
