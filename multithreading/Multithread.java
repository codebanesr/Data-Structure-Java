package multithreading;
class MultithreadingDemo extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Thread ", this.currentThread() + " is running");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



public class Multithread {
    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            new MultithreadingDemo().start();
        }
    }
}