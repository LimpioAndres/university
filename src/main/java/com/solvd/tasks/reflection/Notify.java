package com.solvd.tasks.reflection;

import java.util.Objects;

public class Notify {

    private String message;

    public Notify() {
    }

    public Notify(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notify greeting = (Notify) o;
        return Objects.equals(message, greeting.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return "com.solvd.reflectionExample.Greeting{" +
                "message='" + message + '\'' +
                '}';
    }
}
