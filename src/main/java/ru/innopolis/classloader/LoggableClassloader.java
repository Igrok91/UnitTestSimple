package ru.innopolis.classloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.HelloWorld;

/**
 * Created by d.sapaev on 17.10.2016.
 */
public class LoggableClassloader extends ClassLoader{
    private static Logger logger = LoggerFactory.getLogger(LoggableClassloader.class);

    LoggableClassloader(ClassLoader parent){
        super(parent);
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        logger.info("findClass with name " + name);
        return null;
        /*
        * 1. Найти сам файл
        * 2. Подгрузить
        * */
    }
}
