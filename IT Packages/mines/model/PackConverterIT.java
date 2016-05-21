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
public class PackConverterIT {
    
    public PackConverterIT() {
    }

 //---------------------------------------------------   
    
    @Test
    public void testGetMinesPack() {
        System.out.print("getMinesPack");
        
        NewBoardPack nbp = new NewBoardPack(20, 10, 100, true, true);
        Board board = new Board(nbp);
        PackConverter instance = new PackConverter(board);
        MinesPack result = instance.getMinesPack(Status.BEGUN);
        byte[][] tab = new byte[20][10];
        for (int y = 0; y < 20; ++y){
            for (int x = 0; x < 10; ++x){
                tab[y][x] = 9;
            }
        }
        assertArrayEquals(tab, result.tab);
        
        System.out.println(" passed");
    }
 //---------------------------------------------------   
    
}
