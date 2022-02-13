import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDrive {
    public static void main(String[] args) {

    }


    // The Java ExecutorService's execute() method takes in a runnable object and performs its task asynchronously. 
    // After making the call to execute method, we call the shutdown method, which blocks any other task to queue up in the executorService.
    public void firstExample() {
        ExecutorService eService = Executors.newFixedThreadPool(10);
        eService.execute(new Runnable() {
            public void run() {
                System.out.println("Executor service");
            }
        });


        eService.shutdown();
    }


    // The submit() method takes in a runnable object and returns a Future object. 
    // This object is later on used to check the status of Runnable whether it has completed execution or not.
    public void secondExample() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();  
        executorService.submit(new Runnable() {  
              
            @Override  
            public void run() {  
                System.out.println("ExecutorService");  
                  
            }  
        });  
    }
}
