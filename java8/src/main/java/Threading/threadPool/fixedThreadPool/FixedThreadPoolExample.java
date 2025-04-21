package Threading.threadPool.fixedThreadPool;

import java.util.concurrent.*;

public class FixedThreadPoolExample {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Future f=null;
        ExecutorService executor= Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++)
        {
            Task task = new Task("Task " + i);
            System.out.println("A new task has been added : " + task.getName());
            executor.execute(task);
           // System.out.println(" running status " + f.get());

        }
      //  System.out.println("Maximum threads inside pool " + executor);
        executor.shutdownNow();
        final long timeout = 5 ;
        try {
           boolean status= executor.awaitTermination(timeout, TimeUnit.SECONDS);
            System.out.println("status :" + status);
            System.out.println("is terminate :" + executor.isTerminated());
            System.out.println("is shutdown :" + executor.isShutdown());


            if(!status){

                executor.shutdownNow();
            }
        } catch (Exception e) {
            e.printStackTrace();
            executor.shutdownNow();
        }
    }


    }


    class Task implements Runnable
    {
        private String name;

        public Task(String name)
        {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public void run()
        {
            try
            {
                Long duration = (long) (Math.random() * 30);
                System.out.println("Doing a task during : " + name);
                TimeUnit.SECONDS.sleep(duration);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }


