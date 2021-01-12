import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * @Author ex_lianggang
 * @Date 2020/12/5 15:48
 * @Version 1.0
 */
public class Future {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //jdk1.8之前的实现方式
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("task started!");
                try {
                    //模拟耗时操作
                    System.out.println("进行1秒");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "task finished!";
            }
        }, executor);

        //采用lambada的实现方式
        future.thenAccept(e -> System.out.println(e + " ok"));
        executor.shutdown();
        System.out.println("main thread is running");
    }
}
