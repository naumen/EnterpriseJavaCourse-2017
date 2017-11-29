package ru.naumen.counter.impls;

import java.util.concurrent.locks.ReentrantLock;

import ru.naumen.counter.Counter;

/**
 * Счетчик вызовов на ReentrantLock c tryLock
 * @author pzykov
 * @since 19 нояб. 2017 г.	
 */
public class ReentrantLockCounterWithTryLock implements Counter
{
    ReentrantLock lock;
    private int counter = 0;

    public ReentrantLockCounterWithTryLock(boolean fair)
    {
        lock = new ReentrantLock(fair);
    }

    @Override
    public int get()
    {
        boolean locked = false;
        while (!locked)
        {
            locked = lock.tryLock();
        }
        int value = counter;
        lock.unlock();
        return value;
    }

    @Override
    public void increment()
    {
        lock.lock();
        counter++;
        lock.unlock();
    }

    @Override
    public void reset()
    {
        lock.lock();
        counter = 0;
        lock.unlock();
    }
}
