package ru.naumen.jobqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pzykov
 * @since 29 нояб. 2017 г.	
 */
public class SyncJobQueue implements JobQueue
{
    List<Runnable> jobs = new ArrayList<>();

    public synchronized Runnable getJob() throws InterruptedException
    {
        while (jobs.size() == 0)
        {
            this.wait();
        }
        return jobs.remove(0);
    }

    public synchronized void put(Runnable job)
    {
        jobs.add(job);
        this.notifyAll();
    }
}
