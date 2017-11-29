package ru.naumen.counter.impls;

import ru.naumen.counter.Counter;

/**
 * Потоконебезопасный счетчик вызовов
 * @author pzykov
 * @since 19 нояб. 2017 г.	
 */
public class UnsafeCounter implements Counter
{
    private int counter = 0;

    @Override
    public int get()
    {
        return counter;
    }

    @Override
    public void increment()
    {
        counter++;
    }

    @Override
    public void reset()
    {
        counter = 0;
    }

}
