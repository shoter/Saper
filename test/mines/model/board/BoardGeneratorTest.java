/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines.model.board;

import mines.commons.NewBoardPack;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Damian
 */
public class BoardGeneratorTest {
    
    public BoardGeneratorTest() {
    }

    @Test
    public void boundsTest() {
        System.out.print("boundsTest");
        NewBoardPack nbp = new NewBoardPack(30, 20, 0, true, true);
        Field[][] fields = BoardGenerator.getBoard(nbp);
        
        assertEquals(30, fields.length);
        
        assertEquals(20, fields[0].length);
        System.out.println(" passed");
    }
    
    @Test
    public void minesCountTest() {
        System.out.print("minesCountTest");
        NewBoardPack nbp = new NewBoardPack(30, 30, 666, true, true);
        Field[][] fields = BoardGenerator.getBoard(nbp);
        
        int mineCount = 0;
        
        for(int y = 0;y < 30;++y)
            for(int x = 0; x < 30;++x)
            {
                Field field = fields[x][y];
                if(field.isMined())
                    mineCount++;
            }
        
        assertEquals(666, mineCount);
        System.out.println(" passed");
    }
    
    @Test
    public void tooMuchMinesTest() {
        System.out.print("tooMuchMinesTest");
        NewBoardPack nbp = new NewBoardPack(30, 30, 9999, true, true);
        Field[][] fields = BoardGenerator.getBoard(nbp);
        
        int mineCount = 0;
        
        for(int y = 0;y < 30;++y)
            for(int x = 0; x < 30;++x)
            {
                Field field = fields[x][y];
                if(field.isMined())
                    mineCount++;
            }
        
        assertEquals(30 * 30, mineCount);
        System.out.println(" passed");
    }
    
}
