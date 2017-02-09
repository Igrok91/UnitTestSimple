package ru.innopolis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

/**
 * Created by Igor Ryabtsev on 10.11.2016.
 */
public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
         login("user", "user");
    }

    static void login(String userName, String password){
        try {
            MDC.put("userName", userName);
            MDC.put("password", password);
            doSome();
        }finally {
            MDC.clear();
        }
    }

    static void doSome(){
        logger.warn("Warning happened");
    }
}
