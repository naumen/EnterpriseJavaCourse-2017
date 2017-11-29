package ru.naumen.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author pzykov
 * @since 26 нояб. 2017 г.	
 */
public class ClientWorkersExample
{
    public static void main(String[] args) throws InterruptedException
    {
        ExecutorService workers = Executors.newFixedThreadPool(5);
        ExecutorService clients = Executors.newFixedThreadPool(10);

        for (int i = 3; i < 20; i++)
        {
            Callable<Long> task;
            final int idx = i;
            if (i % 2 == 0)
            {
                task = () -> {
                    return Stream.iterate(new long[] { 1, 1 }, f -> new long[] { f[1], f[0] + f[1] }).limit(idx)
                            .skip(idx - 1).findFirst().get()[0];
                };
            }
            else
            {
                task = () -> {
                    return LongStream.rangeClosed(2, idx).reduce(1, (a, b) -> a * b);
                };
            }
            Future<Long> future = workers.submit(task);

            clients.execute(() -> {

                Long result;
                try
                {
                    result = future.get();
                    System.out.format("%s for %d = %d\n", idx % 2 == 0 ? "Fibonacci" : "Factorial", idx, result);
                }
                catch (InterruptedException | ExecutionException e)
                {
                    e.printStackTrace();
                }
            });
        }
        workers.shutdown();
        clients.shutdown();
    }
}
