package ru.innopolis;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import ru.innopolis.streams.StreamWriter;
import ru.innopolis.streams.WSStreamWrite;

/**
 * Created by Igor Ryabtsev on 10.10.2016.
 */
public class HelloWorld {
    private static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    public int summ(int arg1, int arg2){
        return arg1 + arg2;
    }

    public void doSome(int arg) throws Exception{
        if(arg == 5)
            throw new RuntimeException();
    }

    public static void main(String[] args) {
        logger.warn("HelloWorld! ");
    }
}
