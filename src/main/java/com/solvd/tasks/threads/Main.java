package com.solvd.tasks.threads;

import com.solvd.university.methods.RandomGenerate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(ThreadRun.class);

    public static void main(String[] args) {
        // Runnable and Threads
        ThreadRun run1 = new ThreadRun("Run 1");
        ThreadRun run2 = new ThreadRun("Run 2");
        ThreadThread th1 = new ThreadThread("Thread 1");
        ThreadThread th2 = new ThreadThread("Thread 2");

        LOGGER.info("Initializing the Runner");

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(run1);
        executorService.execute(run2);
        executorService.execute(th1);
        executorService.execute(th2);
        executorService.shutdown();
        LOGGER.info("Finishing task");

        //--------------------------------------- Connection Pool ------------------------------------------------

        ConnectionPool pool = new ConnectionPool();
        int i = 0;
        ExecutorService executor = Executors.newFixedThreadPool(7);

        while (i < 7) {
            pool.getConnection(executor)
                    .thenAccept(connection -> {
                        try {
                            LOGGER.info("Time to test this connection x" + i + " with random numbers");
                            RandomGenerate.generateNumberRandom(40594, 1000000);
                            try {
                                sleep(3000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            pool.returnConnection(connection);
                        } catch (InterruptedException e) {
                            LOGGER.info("Error in get connection");
                        }
                    });
        }

        // Shut down the thread pool
        executor.shutdown();
        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            LOGGER.info("Error in connection executor");
        }
    }

}
