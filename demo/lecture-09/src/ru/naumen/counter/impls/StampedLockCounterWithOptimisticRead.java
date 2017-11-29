package ru.naumen.counter.impls;

import java.util.concurrent.locks.StampedLock;

import ru.naumen.counter.Counter;

/**
 * Счетчик вызовов на StampedLock
 * @author pzykov
 * @since 19 нояб. 2017 г.	
 */
public class StampedLockCounterWithOptimisticRead implements Counter
{
    StampedLock lock;
    private int counter = 0;

    public StampedLockCounterWithOptimisticRead()
    {
        lock = new StampedLock();
    }

    @Override
    public int get()
    {
        long stamp = lock.tryOptimisticRead();
        int value = counter;
        if (!lock.validate(stamp))
        {
            stamp = lock.readLock();
            value = counter;
            lock.unlockRead(stamp);
        }
        return value;
    }

    @Override
    public void increment()
    {
        long stamp = lock.writeLock();
        counter++;
        lock.unlockWrite(stamp);
    }

    @Override
    public void reset()
    {
        long stamp = lock.writeLock();
        counter = 0;
        lock.unlockWrite(stamp);
    }
}
