package com.solvd.tasks.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.SecureRandom;

public class ThreadRun implements Runnable{

    private static final Logger LOGGER = LogManager.getLogger(ThreadRun.class);
    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime;
    private final String nameTask;

    public ThreadRun(String nameTask){
        this.nameTask = nameTask;
        sleepTime = generator.nextInt(5000);
    }

    @Override
    public void run(){
        try{
            LOGGER.info(this.nameTask +" gonna sleep for: " + sleepTime + " seconds.");
            Thread.sleep(sleepTime);
        }catch(InterruptedException exception){
            exception.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
