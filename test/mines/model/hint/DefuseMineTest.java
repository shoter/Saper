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
public class DefuseMineTest {
    
    public DefuseMineTest() {
    }

    @Test
    public void defuseMineTest() {
        System.out.print("defuseMineTest");
        DefuseMine obj = new DefuseMine(true);
        for(int i = 0;i < Constans.DEFUSE_MINE_NUMBER; ++i)
        {
            assertTrue(obj.canDefuse());
            obj.defuseMine();
        }
        assertFalse(obj.canDefuse());
        System.out.println(" passed");
    }
    
    @Test
    public void noDefuseTest() {
        System.out.print("noDefuseTest");
        DefuseMine obj = new DefuseMine(false);
        for(int i = 0;i < Constans.DEFUSE_MINE_NUMBER; ++i)
        {
            assertFalse(obj.canDefuse());
            obj.defuseMine();
        }
        assertFalse(obj.canDefuse());
        System.out.println(" passed");
    }
    
}
