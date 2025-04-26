package algorithms.Threads;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * lock for monitor
 * limit - number for iternation
 * Atomic variable based on that thread will wait of run to swich controll between thread.
 */


public class OddEvenThread {

    public static void main(String[] args) {
        // All should be final as you are using in lambda
        //function
        final Object lock = new Object();
        final int limit = 100;
        final AtomicBoolean  flag=new AtomicBoolean(true);
        Runnable odd = () ->{

            for (int i = 1; i < limit;i=i+2 ) {
                synchronized (lock) {

                    while(flag.get()){  // use always while loop while waiting
                        try {
                            lock.wait();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    if(!flag.get()){
                        System.out.println("odd :" + i);
                        flag.set(true);
                        lock.notify(); // no thread is waiting even you call notify it is no harm
                    }
                }


            }
        };

        Runnable even = () -> {

            for (int i = 0; i < limit;i=i+2 ) {
                synchronized (lock) {

                    while(!flag.get()){
                        try {
                            lock.wait();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }

                    if(flag.get()){
                        System.out.println("even :" + i);
                        flag.set(false);
                        lock.notify();
                    }


                }

                }


        };

        Thread o = new Thread(odd);
        Thread e = new Thread(even);
        e.start();
        o.start();
    }
}
