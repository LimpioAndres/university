package com.solvd.tasks.reflection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Notify hello = new Notify();

        Field[] fields = hello.getClass().getDeclaredFields();
        Constructor[] constructors = hello.getClass().getConstructors();
        Method[] methods = hello.getClass().getMethods();

        Arrays.stream(fields).forEach((iterator)->{
            LOGGER.info("Name of variable: " + iterator.getName());
        });
        Arrays.stream(fields).forEach(LOGGER::info);
        Arrays.stream(constructors).forEach((LOGGER::info));
        Arrays.stream(methods).forEach((LOGGER::info));

        try{
            Method setMessage = hello.getClass().getMethod("setMessage", String.class);
            Method getMessage = hello.getClass().getMethod("getMessage");

            setMessage.invoke(hello, "HELLO");
            LOGGER.info(getMessage.invoke(hello));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
            LOGGER.error(e.getMessage());
        }
    }
}
