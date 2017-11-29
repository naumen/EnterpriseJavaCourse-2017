package ru.naumen.counter.impls;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import ru.naumen.counter.Counter;

/**
 * Счетчик вызовов на ReentrantReadWriteLock
 * @author pzykov
 * @since 19 нояб. 2017 г.	
 */
public class RWLockCounter implements Counter
{
    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private int counter = 0;

    public RWLockCounter(boolean fair)
    {
        lock = new ReentrantReadWriteLock(fair);
    }

    @Override
    public int get()
    {
        lock.readLock().lock();
        int value = counter;
        lock.readLock().unlock();
        return value;
    }

    @Override
    public void increment()
    {
        lock.writeLock().lock();
        counter++;
        lock.writeLock().unlock();
    }

    @Override
    public void reset()
    {
        lock.writeLock().lock();
        counter = 0;
        lock.writeLock().unlock();
    }
}
