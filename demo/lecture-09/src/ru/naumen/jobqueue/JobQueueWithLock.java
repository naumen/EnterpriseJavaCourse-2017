package ru.naumen.jobqueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pzykov
 * @since 29 нояб. 2017 г.	
 */
public class JobQueueWithLock implements JobQueue
{
    List<Runnable> jobs = new ArrayList<>();
    Lock lock = new ReentrantLock();
    Condition cond = lock.newCondition();

    @Override
    public Runnable getJob() throws InterruptedException
    {
        lock.lock();
        try
        {
            while (jobs.size() == 0)
            {
                cond.await();
            }
            return jobs.remove(0);
        }
        finally
        {
            lock.unlock();
        }
    }

    @Override
    public void put(Runnable job)
    {
        lock.lock();
        try
        {
            jobs.add(job);
            cond.signalAll();
        }
        finally
        {
            lock.unlock();
        }
    }
}
