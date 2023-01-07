package com.solvd.tasks.threads;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;


public class ConnectionPool {

    private BlockingQueue<Connection> availableConnections;

    private static final int POOL_SIZE = 5;

    private boolean initialized = false;

    private void initialize() {
        if (!initialized) {

            availableConnections = new ArrayBlockingQueue<>(POOL_SIZE);

            for (int i = 0; i < POOL_SIZE; i++) {
                availableConnections.offer(new Connection());
            }
            initialized = true;
        }
    }

    public CompletionStage<Connection> getConnection(Executor executor) {

        initialize();
        // Create a CompletableFuture to hold the result
        CompletableFuture<Connection> future = new CompletableFuture<>();

        executor.execute(() -> {
            try {

                Connection connection = availableConnections.take();
                future.complete(connection);

            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });
        return future;
    }

    public void returnConnection(Connection connection) throws InterruptedException {
        availableConnections.put(connection);
    }
}