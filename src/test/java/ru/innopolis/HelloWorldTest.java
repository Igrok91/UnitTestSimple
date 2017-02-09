package ru.innopolis;


import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.streams.StreamWriter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

/**
 * Created by Igor Ryabtsev on 11.10.2016.
 */

public class HelloWorldTest {

    private static Logger log = LoggerFactory.getLogger(HelloWorldTest.class);

    private HelloWorld helloWorld;
    //private Mockery context;

    @BeforeClass
    public static void beforeTest(){
        log.info("This is @BeforeClass method");
    }

    @Before
    public void before(){
        log.info("This is @Before method");
        this.helloWorld = new HelloWorld();
        //this.context = new JUnit4Mockery();
    }

    @Test
    public void sumTest(){
        log.info("This is sumTest method");
        int sum = this.helloWorld.summ(2,2);
        assertTrue("Summ is incorrect", sum == 4);
    }


    @Test(expected = RuntimeException.class)
    public void testDoSome() throws Exception {
        log.info("This is testHandle method");
        this.helloWorld.doSome(5);
        /*final StreamWriter streamWriter= context.mock(StreamWriter.class);

        context.checking(new Expectations() {{
            oneOf(streamWriter).write("Tatarstan");
            will(returnValue(new Long(16)));
        }});

        helloWorld.setStreamWriter(streamWriter);
        assertEquals(new Long(16), helloWorld.handle("Tatarstan"));*/

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
