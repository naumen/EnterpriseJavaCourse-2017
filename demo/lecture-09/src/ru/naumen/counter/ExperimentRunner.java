package ru.naumen.counter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Запускает серию экспериментов над счетчиков вызовов
 * @author pzykov
 * @since 19 нояб. 2017 г.	
 */
public class ExperimentRunner
{
    private int threadsNumber;
    private int experimentsNumber;
    private int repeatsNumber;

    /**
     * @param threadsNumber количество потоков
     * @param experimentsNumber количество экспериментов
     * @param repeatsNumber количество вызовов метода increment у счетчика
     */
    public ExperimentRunner(int threadsNumber, int experimentsNumber, int repeatsNumber)
    {
        this.threadsNumber = threadsNumber;
        this.experimentsNumber = experimentsNumber;
        this.repeatsNumber = repeatsNumber;
    }

    /**
     * Запускает серию экспериментов над счетчиком вызовов
     * и выводит результаты каждого эксперимента и среднее время
     * @param counter счетчик вызовов
     */
    public void runExperiments(Counter counter)
    {
        long totalTime = 0;
        System.out.format("Counter '%s':\n", counter.getClass().getName());
        for (int i = 0; i < experimentsNumber; i++)
        {
            long startTime = System.currentTimeMillis();
            runExperiment(counter);
            long elapsed = (System.currentTimeMillis() - startTime);
            totalTime += elapsed;
            System.out.format(" Experiment [%d/%d]:\tvalue = %d time = %d ms\n", i + 1, experimentsNumber,
                    counter.get(), elapsed);
            counter.reset();
        }
        System.out.format(" Average time:\t%d ms\n", totalTime / experimentsNumber);
    }

    /**
     * Запускает эксперимент над счетчиком вызовов
     * @param counter счетчик вызовов
     */
    private void runExperiment(Counter counter)
    {
        Runnable experiment = () -> {
            for (int i = 0; i < (repeatsNumber / threadsNumber); i++)
            {
                counter.increment();
            }
        };

        List<Thread> threads = Stream.generate(() -> new Thread(experiment)).limit(threadsNumber)
                .collect(Collectors.toList());

        threads.forEach(t -> t.start());
        threads.forEach(t -> {
            try
            {
                t.join();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        });
    }
}
