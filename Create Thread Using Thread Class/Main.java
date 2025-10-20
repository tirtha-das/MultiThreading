class SMSThread extends Thread{
    public void run(){
        try{
           Thread.sleep(2000);
           System.out.println("SMS is sent");
        }catch(Exception e){
              System.out.println("Error generated in SMS thread "+e.getMessage() );
        }
        

    }
}

class EmailThread extends Thread{
    public void run(){
        try{
           Thread.sleep(3000);
           System.out.println("Email is sent");
        }catch(Exception e){
              System.out.println("Error generated in Email thread "+e.getMessage());
        }
    }
}

class Main{
    public static void main(String[] args){
      Thread smsThread = new SMSThread();
      Thread emailThread = new EmailThread();

      smsThread.start();
      System.out.println("Task 1 has started");
      emailThread.start();
      System.out.println("Task 2 has started");

      try{
        smsThread.join();
        emailThread.join();
        System.out.println("All tasks have end");
      }catch(Exception e){
         
      }
    }
}