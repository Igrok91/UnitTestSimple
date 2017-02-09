package ru.innopolis;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.innopolis.streams.Mock;
import ru.innopolis.streams.StreamReader;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * Created by Igor Ryabtsev on 11.11.2016.
 */
public class MockTest {

    private Mock mock;

    @Before
    public void resetFields(){
        this.mock = new Mock();
        //first case
        /*this.mock.setStreamReader(new StreamReader() {
            @Override
            public String read(long id) {
                if(id == 16)
                    return "Tatarstan";
                throw new RuntimeException();
            }
        });*/
        //second case
       /* this.mock.setStreamReader((StreamReader) Proxy.newProxyInstance(this.mock.getClass().getClassLoader(),
                new Class[]{StreamReader.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if((long)args[0] == 16)
                            return "Tatarstan";
                        throw new RuntimeException();
                    }
                }));*/
       //third case
        StreamReader streamReader = mock(StreamReader.class);
        when(streamReader.read(16)).thenReturn("Tatarstan");
        this.mock.setStreamReader(streamReader);
    }

    @Test
    public void testCalculate(){

        String result = this.mock.calculate(16l);
        assertEquals(result, "calculated Tatarstan");
    }
}
