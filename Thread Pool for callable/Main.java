import java.util.concurrent.*;

public class Main {
    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Future<Integer> task1 = executor.submit(()->{
            System.out.println("Task 1 is submitted");
            Thread.sleep(2000);
            return 42;
        } );

        Future<Integer> task2 = executor.submit(()->{
            System.out.println("Task 2 is submitted");
            Thread.sleep(5000);
            return 45;
        } );

        // executor.submit(task1);
        // executor.submit(task2);
         executor.shutdown();
        System.out.println("All tasks are submitted");
        try{
        int res1 = task1.get();
        int res2 = task2.get();
        System.err.println(res1+" "+res2);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        
       
    }
}
