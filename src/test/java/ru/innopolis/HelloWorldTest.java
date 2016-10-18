package ru.innopolis;


import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.streams.StreamWriter;

import java.io.Externalizable;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

/**
 * Created by d.sapaev on 11.10.2016.
 */

public class HelloWorldTest {

    private static Logger log = LoggerFactory.getLogger(HelloWorldTest.class);

    private HelloWorld helloWorld;
    private Mockery context;

    @BeforeClass
    public static void beforeTest(){
        log.info("This is @BeforeClass method");
    }

    @Before
    public void before(){
        log.info("This is @Before method");
        this.helloWorld = new HelloWorld();
        this.context = new JUnit4Mockery();
    }

    @Test
    public void testHandle(){
        log.info("This is testHandle method");

        final StreamWriter streamWriter= context.mock(StreamWriter.class);

        context.checking(new Expectations() {{
            oneOf(streamWriter).write("Tatarstan");
            will(returnValue(new Long(16)));
        }});

        helloWorld.setStreamWriter(streamWriter);
        assertEquals(new Long(16), helloWorld.handle("Tatarstan"));

    }

    @After
    public void after(){
        log.info("This is @After method");
    }

    @AfterClass
    public static void afterTest(){
        log.info("This is @AfterClass method");
    }
}
