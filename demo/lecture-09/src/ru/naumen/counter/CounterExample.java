package ru.naumen.counter;

import java.util.Arrays;
import java.util.List;

import ru.naumen.counter.impls.AtomicCounter;
import ru.naumen.counter.impls.RWLockCounter;
import ru.naumen.counter.impls.ReentrantLockCounter;
import ru.naumen.counter.impls.ReentrantLockCounterWithTryLock;
import ru.naumen.counter.impls.StampedLockCounter;
import ru.naumen.counter.impls.SynchronizedCounter;
import ru.naumen.counter.impls.UnsafeCounter;

/**
 * Запускает для всех реализаций счетчиков с ерию из 5 экспериментов,
 * в каждом эксперименте 4 потока будут вызывать у счетчика 
 * метод increment 100 млн. раз
 * @author pzykov
 * @since 19 нояб. 2017 г.	
 */
public class CounterExample
{

    public static void main(String[] args)
    {
        List<Counter> counters = Arrays.asList(new UnsafeCounter(), new SynchronizedCounter(), new AtomicCounter(),
                new RWLockCounter(false), new ReentrantLockCounter(false), new ReentrantLockCounterWithTryLock(false),
                new StampedLockCounter());

        ExperimentRunner runner = new ExperimentRunner(4, 5, 100_000_000);

        counters.forEach(c -> runner.runExperiments(c));
    }

}
