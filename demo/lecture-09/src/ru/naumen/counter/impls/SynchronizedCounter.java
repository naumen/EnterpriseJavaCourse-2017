package ru.naumen.counter.impls;

import ru.naumen.counter.Counter;

/**
 * Счетчик вызовов с синхронизированными методами
 * @author pzykov
 * @since 19 нояб. 2017 г.	
 */
public class SynchronizedCounter implements Counter
{
    private int counter = 0;

    @Override
    public synchronized int get()
    {
        return counter;
    }

    @Override
    public synchronized void increment()
    {
        counter++;
    }

    @Override
    public synchronized void reset()
    {
        counter = 0;
    }
}
