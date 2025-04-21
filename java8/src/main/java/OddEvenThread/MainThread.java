package OddEvenThread;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        MainThread m= new MainThread();
        Counter counter= new Counter(0);
        Thread t2= new Thread(new OddThread(m,counter));
        Thread t1= new Thread(new EvenThread(m,counter));

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Main finished");

    }
}
