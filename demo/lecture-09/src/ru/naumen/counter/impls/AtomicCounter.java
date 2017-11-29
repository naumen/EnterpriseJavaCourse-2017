package ru.naumen.counter.impls;

import java.util.concurrent.atomic.AtomicInteger;

import ru.naumen.counter.Counter;

/**
 * Счетчик вызовов с атомарными операциями
 * @author pzykov
 * @since 19 нояб. 2017 г.	
 */
public class AtomicCounter implements Counter
{
    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public int get()
    {
        return counter.intValue();
    }

    @Override
    public void increment()
    {
        counter.incrementAndGet();
    }

    @Override
    public void reset()
    {
        counter.set(0);
    }
}
