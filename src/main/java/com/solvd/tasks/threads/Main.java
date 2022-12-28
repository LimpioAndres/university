package com.solvd.tasks.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

    }
}
