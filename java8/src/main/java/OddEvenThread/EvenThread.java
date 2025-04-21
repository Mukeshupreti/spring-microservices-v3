package OddEvenThread;

public class EvenThread implements  Runnable{
    MainThread m;
    Counter counter;
    public EvenThread(MainThread m, Counter counter) {
        this.m=m;
        this.counter=counter;
    }

    @Override
    public void run() {

            synchronized (m) {
                while (counter.getValue()<50) {
                if(counter.getValue()%2==0) {
                    System.out.println(counter.getValue() + " Even Thread");
                    counter.setValue(counter.getValue()+1);
                    try {
                        m.notify();
                        m.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
                m.notifyAll();
            }

        System.out.println("Exiting Even");
        }


}
