/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Damian
 */
public class TimeTest {
    
    private static final int SecondsInDay = 86400;
    private Time time;
    
    public TimeTest() {
    }
    
    @Before
    public void init()
    {
        time = new Time();
    }
    
    /**
     * Sprawdza czy możemy przypisać czas od 0 do 86400 (1d). 
     * nikt nie powinien grać dłuzej niż 86400 sekund w taką gre.
     */
    @Test
    public void setTimeTest() {
        System.out.print("setTime");
        for(int i = 0;i < SecondsInDay; ++i)
        {
            time.setTime(i);
            assertEquals(i, time.getTime());
        }
        System.out.println(" passed");
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void incrementTest()
    {
        System.out.print("incrementSecond");
        for(int i = 0;i < SecondsInDay; ++i)
        {
            assertEquals(i, time.getTime());
            time.incrementSecond();
        }
        System.out.println(" passed");
    }
    
}
