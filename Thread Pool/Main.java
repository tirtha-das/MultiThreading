import java.util.concurrent.*;



public class Main {
   private static final ExecutorService executor =  Executors.newFixedThreadPool(5);

     static void sendEmail(String recipient){
        executor.execute(()->{
            System.out.println("Sending email to "+recipient);
            try{
             Thread.sleep(1000);
            }catch(Exception e){
              e.printStackTrace();
             }
             System.out.println("Email sent to "+recipient);
        });
      }

      public static void main(String[] args){
        for(int i=1;i<=12;i++){
            sendEmail("user"+i+"@gmail.com");
        }
        executor.shutdown();
        System.out.println("all emails are submitted");

        try{
           if(!executor.awaitTermination(10, TimeUnit.SECONDS)){
            executor.shutdownNow();
           }
        }catch(Exception e){
          e.printStackTrace();
        }
        System.out.println("all emails are sent");
      }


}
