package algorithms.Threads;

public class Application {

    public static void main(String[] args) {
        Object lock = new Object();
        int limit = 100;
        Runnable odd = () -> {

            for (int i = 1; i < limit; i = i + 2) {
                synchronized (lock) {
                    if (i % 2 != 0) {
                        try {

                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("odd :" + i);
                        lock.notify();
                    }
                }
            }
        };

        Runnable even = () -> {

            for (int i = 0; i < limit; i = i + 2) {
                synchronized (lock) {
                    if (i % 2 == 0) {
                        try {

                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("even :" + i);
                        lock.notify();
                    }
                }

            }
        };

        Thread o = new Thread(odd);
        Thread e = new Thread(even);
        o.start();
        e.start();
    }
}
