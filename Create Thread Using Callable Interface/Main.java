import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class SMSCallable implements Callable<Void>{
    public Void call(){
        try{
           Thread.sleep(2000);
           System.out.println("SMS is sent");
        }catch(Exception e){
              System.out.println("Error generated in SMS thread "+e.getMessage() );
        }
        return null;
        

    }
}

class EmailCallable implements Callable<Void>{
    public Void call(){
        try{
           Thread.sleep(3000);
           System.out.println("Email is sent");
        }catch(Exception e){
              System.out.println("Error generated in Email thread "+e.getMessage());
        }
         return null;
    }
}

class ETACalculator implements Callable<String>{
    public String call(){
        try{
           Thread.sleep(5000);
           System.out.println("ETA has calculated");
        }catch(Exception e){
              System.out.println("Error generated in ETA thread "+e.getMessage());
        }
         return "Estimated time : 25 minutes";
    }
}

class Main{
    public static void main(String[] args){
      FutureTask<Void> smsRunnable = new FutureTask<>(new SMSCallable()); 
      FutureTask<Void> emailRunnable = new FutureTask<>(new EmailCallable());
      FutureTask<String> etaRunnable = new FutureTask<>(new ETACalculator());
      Thread smsThread = new Thread(smsRunnable);
      Thread emailThread = new Thread(emailRunnable);
      Thread etaThread = new Thread(etaRunnable);

      smsThread.start();
      System.out.println("Task 1 has started");
      emailThread.start();
      System.out.println("Task 2 has started");
      etaThread.start();
      System.out.println("Task 3 has started");

      try{
        smsRunnable.get();
        emailRunnable.get();
        String time = etaRunnable.get();
        System.err.println(time);
        System.out.println("All tasks have end");
      }catch(Exception e){
         
      }
    }
}