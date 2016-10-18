package ru.innopolis.classloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.HelloWorld;

/**
 * Created by d.sapaev on 17.10.2016.
 */
public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) throws ClassNotFoundException {
        LoggableClassloader classloader = new LoggableClassloader(getClassLoader());
        Class test = classloader.loadClass("ru.innopolis.Stub");
    }

    private static ClassLoader getClassLoader() {
        return Main.class.getClassLoader();
    }
}
