/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines.model.board;

import mines.commons.NewBoardPack;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dawid
 */
public class BoardIT {
    
    public BoardIT() {
    }
      
 //---------------------------------------------------   
    
    @Test
    public void testNewBoard() {
        System.out.print("NewBoard");
        Board instance = new Board(new NewBoardPack(20, 10, 199, true, true));
        assertEquals(20, instance.getHeight());
        assertEquals(10, instance.getWidth());
        int mines = 0;
        for (int y = 0; y < 20; ++y){
            for (int x = 0; x < 10; ++x){
                if (instance.isFieldMined(y, x)) ++mines;
            }
        }
        assertEquals(instance.getNumOfMines(), mines);
        System.out.println(" passed");
    }
   
 //---------------------------------------------------   

    @Test
    public void testUncoverField() {
        System.out.print("uncoverField");
        // czy odkrywa nieodkryte pola i czy nie odkrywa oflagowanych
        for (int y = 0; y < 20; ++y){
            for (int x = 0; x < 10; ++x){
                Board instance = new Board(new NewBoardPack(20, 10, 0, true, true));
                assertEquals(true, instance.uncoverField(y, x));
                
                instance.markField(y, x);
                assertEquals(false, instance.uncoverField(y, x));
            }
        }
        //czy odkrywa wszystkie które może
        Board instance = new Board(new NewBoardPack(20, 10, 0, true, true));
        instance.uncoverField(0, 0);
        for (int y = 0; y < 20; ++y){
            for (int x = 0; x < 10; ++x){
                    assertEquals(false, instance.isFieldCovered(y, x));
            }
        }
        // czy nie odkrywa odkrytych
        instance = new Board(new NewBoardPack(20, 10, 30, true, true));
        for (int y = 0; y < 20; ++y){
            for (int x = 0; x < 10; ++x){
                if (instance.isFieldCovered(y, x)) {
                    assertEquals(true, instance.uncoverField(y, x));
                    assertEquals(false, instance.isFieldCovered(y, x));
                    assertEquals(false, instance.isFieldMarked(y, x));
                } else {
                    assertEquals(false, instance.uncoverField(y, x));
                }
            }
        }
        System.out.println(" passed");
    }

 //---------------------------------------------------   
    
    
    @Test
    public void testDefuseFieldRemoveMine() {
        System.out.print("defuseField-removeMine");
        Board instance = new Board(new NewBoardPack(20, 10, 179, true, true));
        for (int y = 0; y < 20; ++y){
            for (int x = 0; x < 10; ++x){
                instance.defuseField(y, x);
                assertEquals(false, instance.isFieldMined(y, x));
            }
        }
        System.out.println(" passed");
    }

 //---------------------------------------------------   
  
    
    @Test
    public void testDefuseFieldReduceDegrees() {
        System.out.print("defuseField-reduceDegrees");
        Board instance = new Board(new NewBoardPack(20, 10, 77, true, true));
        int mines[][] = new int[77][2];
        int count = 0;
        for (int y = 0; y < 20; ++y){
            for (int x = 0; x < 10; ++x){
                if (instance.isFieldMined(y, x)){
                    mines[count][0] = x;
                    mines[count++][1] = y;
                }
            }
        }
        assertEquals(77, count);
        for (int i = 0; i < count; ++i){
            int y = mines[i][1];
            int x = mines[i][0];
            int neighbours = 0;
            int degsum = 0;
            for (int k = y - 1; k <= y + 1; ++k) {
                for (int j = x - 1; j <= x + 1; ++j) {
                    if (k >= 0 && k < 20 && j >= 0 && j < 10) {
                        degsum += instance.getFieldDeg(y, x);
                        ++neighbours;
                    }
                }
            }
            instance.defuseField(y, x);
            int degsum2 = 0;
            for (int k = y - 1; k <= y + 1; ++k) {
                for (int j = x - 1; j <= x + 1; ++j) {
                    if (k >= 0 && k < 20 && j >= 0 && j < 10) {
                        degsum2 += instance.getFieldDeg(y, x);
                    }
                }
            }
            assertEquals(degsum2, degsum - neighbours);
        }
        
        
        System.out.println(" passed");
    }
    
 //---------------------------------------------------   
  
    
    @Test
    public void testDefuseFieldUncoverAndSetDegree() {
        System.out.print("defuseField-uncoverAndSetDegree");
        Board instance = new Board(new NewBoardPack(20, 10, 99, true, true));
        int mines[][] = new int[99][2];
        int count = 0;
        for (int y = 0; y < 20; ++y){
            for (int x = 0; x < 10; ++x){
                if (instance.isFieldMined(y, x)){
                    mines[count][0] = x;
                    mines[count++][1] = y;
                }
            }
        }
        assertEquals(99, count);
        for (int i = 0; i < count; ++i){
            int y = mines[i][1];
            int x = mines[i][0];
            
            instance.defuseField(y, x);
            assertEquals(false, instance.isFieldCovered(y, x));
            
            int nearmines = 0;
            for (int k = y - 1; k <= y + 1; ++k) {
                for (int j = x - 1; j <= x + 1; ++j) {
                    if (k >= 0 && k < 20 && j >= 0 && j < 10) {
                        if (instance.isFieldMined(k, j)) ++nearmines;
                    }
                }
            }
            assertEquals(nearmines, instance.getFieldDeg(y, x));
        }
        System.out.println(" passed");
    }
    
}
