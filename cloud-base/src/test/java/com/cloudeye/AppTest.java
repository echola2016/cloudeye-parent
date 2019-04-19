package com.cloudeye;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void wrapperEquals(){
        Integer a = 100;
        Integer b =100;
        Integer c = new Integer(100);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a==b);
        System.out.println(a==c);
    }

    @Test
    public void mapCapacityExpansion(){
        Map<Integer,Integer> a = new HashMap<>();
        Map<Integer,Integer> b = new HashMap<>(10240);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("a");
        for(int i=0;i<10240;i++){
            a.put(i,i);
        }
        stopWatch.stop();
        stopWatch.start("b");
        for(int i=0;i<10240;i++){
            b.put(i,i);
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
