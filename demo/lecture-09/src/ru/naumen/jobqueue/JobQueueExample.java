package ru.naumen.jobqueue;

/**
 * @author pzykov
 * @since 29 нояб. 2017 г.	
 */
public class JobQueueExample
{
    public static void main(String[] args) throws InterruptedException
    {
        JobQueue queue = new JobQueueWithLock();

        Thread worker = new Thread(() -> {
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    Thread.sleep(1000 - (9 - i) * 100);
                }
                catch (InterruptedException e1)
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                final int idx = i;
                try
                {
                    System.out.format("Get task %d\n", idx);
                    queue.getJob().run();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

        });

        Thread client = new Thread(() -> {
            for (int i = 0; i < 10; i++)
            {
                try
                {
                    Thread.sleep(1000 - (i) * 100);
                }
                catch (InterruptedException e1)
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                final int idx = i;
                System.out.format("Push task %d\n", idx);
                queue.put(() -> System.out.format("Run task %d\n", idx));
            }

        });

        worker.start();
        client.start();
        client.join();
        worker.join();
    }
}
