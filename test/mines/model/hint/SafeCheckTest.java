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
public class SafeCheckTest {
    
    public SafeCheckTest() {
    }

       @Test
    public void useHintTest() {
        System.out.print("useHintTest");
        SafeCheck obj = new SafeCheck();
        
        assertTrue(obj.isHintEnable());
        obj.useHint();
        assertFalse(obj.isHintEnable());
        
        System.out.println(" passed");
    }
}
