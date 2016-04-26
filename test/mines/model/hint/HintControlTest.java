/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines.model.hint;

import mines.commons.Constans;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Damian
 */
public class HintControlTest {
    
    public HintControlTest() {
    }

    @Test
    public void useHintTest() {
        System.out.print("useHintTest");
        HintControl obj = new HintControl(true);
        for(int i = 0;i < Constans.NUMBER_OF_HINTS; ++i)
        {
            assertTrue(obj.isHintEnable());
            obj.useHint();
        }
        assertFalse(obj.isHintEnable());
        System.out.println(" passed");
    }
    
    @Test
    public void noHintTest() {
        System.out.print("noHintTest");
        HintControl obj = new HintControl(false);
        for(int i = 0;i < Constans.NUMBER_OF_HINTS; ++i)
        {
            assertFalse(obj.isHintEnable());
            obj.useHint();
        }
        assertFalse(obj.isHintEnable());
        System.out.println(" passed");
    }
    
}
