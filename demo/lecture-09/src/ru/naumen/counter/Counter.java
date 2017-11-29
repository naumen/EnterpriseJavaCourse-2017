package ru.naumen.counter;

/**
 * Счетчик времени
 * @author pzykov
 * @since 19 нояб. 2017 г.	
 */
public interface Counter
{
    int get();

    void increment();

    void reset();
}
