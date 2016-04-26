/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines.model;

import mines.commons.NewBoardPack;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Damian
 */
public class ModelTest {
    
    public ModelTest() {
    }

    @Test
    public void wrongStartTest() {
        System.out.print("wrongStartTest");
        boolean passed = false;
        try
        {
        NewBoardPack pack = new NewBoardPack(-123, -123, -123, false, false);
        Model gameModel = new Model();
        gameModel.startNewGame(pack);
        }
        catch(Exception e)
        {
            System.out.println(" passed");
            passed = true;
        }
        finally
        {
            assertTrue(passed);
        }
    }
    
}
