package com.solvd.tasks.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.SecureRandom;

public class ThreadThread extends Thread{

    private static final Logger LOGGER = LogManager.getLogger(ThreadThread.class);

    private static final SecureRandom generator = new SecureRandom();
    private final int sleepTime;
    private final String nameTask;

    public ThreadThread(String nameTask){
        this.nameTask = nameTask;
        sleepTime = generator.nextInt(3000);
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
