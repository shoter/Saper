/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines.model.board;

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
public class FieldTest {
    @Test
    public void setMineTest() {
        System.out.print("setMine");
        Field instance = new Field();
        
        instance.setMine(true);
        assertEquals(true, instance.isMined());
        
        instance.setMine(false);
        assertEquals(false, instance.isMined());
        
        System.out.println(" passed");
    }

    @Test
    public void setMarkTest() {
        System.out.print("setMark");
        Field instance = new Field();
        
        instance.setMark(true);
        assertEquals(true, instance.isMarked());
        
        instance.setMark(false);
        assertEquals(false, instance.isMarked());
        
        System.out.println(" passed");
    }

    @Test
    public void setCoverTest() {
        System.out.print("setCover");
        Field instance = new Field();
        
        instance.setCover(true);
        assertEquals(true, instance.isCovered());
        
        instance.setCover(false);
        assertEquals(false, instance.isCovered());
        
        System.out.println(" passed");
    }

    @Test
    public void setDegTest() {
        System.out.print("setDeg");
        Field instance = new Field();
        for(int i = 0;i <= 9;++i)
        {
            instance.setDeg(i);
            assertEquals(i, instance.getDeg());
        }
        
        System.out.println(" passed");
    }
    
}