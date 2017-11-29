package ru.naumen.jobqueue;

/**
 * @author pzykov
 * @since 29 нояб. 2017 г.	
 */
public interface JobQueue
{

    Runnable getJob() throws InterruptedException;

    void put(Runnable job);
}