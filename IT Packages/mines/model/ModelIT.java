/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines.model;

import mines.commons.MinesPack;
import mines.commons.NewBoardPack;
import mines.model.board.Board;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dawid
 */
public class ModelIT {
    
    public ModelIT() {
    }

 //---------------------------------------------------   
    
    @Test
    public void testCheckField() {
        System.out.print("checkField");
        NewBoardPack nbp = new NewBoardPack(20, 10, 200, false, true);
        Model instance = new Model();
        instance.startNewGame(nbp);
        instance.checkField(0, 0);
        assertEquals(true, instance.isLose());
        
        nbp = new NewBoardPack(20, 10, 0, false, false);
        instance.startNewGame(nbp);
        instance.checkField(0, 0);
        assertEquals(true, instance.isWin());
        
        System.out.println(" passed");
    }

 //---------------------------------------------------   
    
    @Test
    public void testSafeCheckField() {
        System.out.print("safeCheckField");
        NewBoardPack nbp = new NewBoardPack(20, 10, 200, true, true);
        Model instance = new Model();
        instance.startNewGame(nbp);
        
        try {
            Thread t = new Thread(() -> {
                instance.safeCheckField();
            });
            t.start();
            t.join(1000);
            //czy petla nieskonczona bo nie ma miejsca na bezpieczny ruch
            assertTrue(t.isAlive());
        }
        catch (Exception e) {}
        assertEquals(false, instance.isLose());

        System.out.println(" passed");
    }


 //---------------------------------------------------   
    
    @Test
    public void testDefuseField() {
        System.out.print("defuseField");
        NewBoardPack nbp = new NewBoardPack(20, 10, 200, false, true);
        Model instance = new Model();
        instance.startNewGame(nbp);
        instance.defuseField(0, 0);
        instance.checkField(0, 0);
        assertEquals(false, instance.isLose());
        
        System.out.println(" passed");
    }

 //---------------------------------------------------   
    
    @Test
    public void testMarkField() {
        System.out.print("markField");
        NewBoardPack nbp = new NewBoardPack(20, 10, 200, true, true);
        Model instance = new Model();
        instance.startNewGame(nbp);
        instance.markField(0, 0);
        instance.checkField(0, 0);
        assertEquals(false, instance.isLose());
        
        System.out.println(" passed");
    }

 //---------------------------------------------------   
    
    @Test
    public void testSetGamePause() {
        System.out.print("setGamePause");
        Model instance = new Model(); //beginner 8 8 10
        instance.setGamePause();
        assertEquals(false, instance.isPausa());
        
        instance.markField(4, 4);
        instance.setGamePause();
        assertEquals(true, instance.isPausa());
        instance.setGamePause();
        assertEquals(false, instance.isPausa());
        
        System.out.println(" passed");
    }


 //---------------------------------------------------   
    
    @Test
    public void testActivHint() {
        System.out.print("activHint");
        NewBoardPack nbp = new NewBoardPack(20, 10, 200, true, true);
        Model instance = new Model();
        instance.startNewGame(nbp);
        instance.activHint();
        MinesPack result = instance.getPack();
        
        byte[][] tab = new byte[20][10];
        for (int y = 0; y < 20; ++y){
            for (int x = 0; x < 10; ++x){
                tab[y][x] = 11;
            }
        }
        assertArrayEquals(tab, result.tab);
        
        System.out.println(" passed");
    }

}
