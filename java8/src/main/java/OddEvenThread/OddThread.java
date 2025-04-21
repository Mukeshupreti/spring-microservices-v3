package OddEvenThread;

public class OddThread implements  Runnable{
   final MainThread m;
    Counter counter;
    public OddThread(MainThread m, Counter counter) {
        this.m=m;
        this.counter=counter;
    }

    @Override
    public void run() {

            synchronized (m) {
                while (counter.getValue()<50) {
                if(counter.getValue()%2!=0) {
                    System.out.println(counter.getValue() + " Odd Thread");
                    counter.setValue(counter.getValue()+1);

                    try {
                        m.notify(); // it dont
                        m.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
        }
        System.out.println("exiting odd");

    }
}
