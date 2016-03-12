/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saper01.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import saper01.commons.Constans;
import saper01.commons.Pack;
import java.util.Random;

/**
 *
 * @author wojciech
 */
public class Model {

    private final Time time;
    private Board board;
    private boolean gameStart=false;
    private boolean gameEnd=false;
    private boolean gameWin=false;
    private boolean gamePause=false;
    private boolean gameRestart=false;
    final Random rand=new Random(); 

    public Model() {
        time = new Time();
        board = new Board(Constans.BEGINNER_H,Constans.BEGINNER_W,Constans.BEGINNER_M);
    }
    
    public void checkField(final int y,final int x) throws Exception{
        if(y<0||y>=board.getHeight()||x<0||x>=board.getWidth())
            throw new Exception("Model.checkField : Błedne argumenty y="+y+" x="+x+" h="+board.getHeight()+" w="+board.getWidth());
        if(gameEnd==true)
            throw new Exception("Model.checkField : koniec gry");
        if(gameStart==false){
            if(gameRestart==false)
                board.setMines(y, x,rand.nextLong());
            gameStart=true;
            gameRestart=false;
        }else if(board.isFieldMined(y, x)==true){
            gameEnd=true;
            gameWin=false;
        }
        board.uncoverField(y, x);
        if(board.getFieldsUncovered()==board.getNumOfMines()){
            gameEnd=true;
            gameWin=true;
        }
    }
    
    public void markField(final int y,final int x) throws Exception{
        if(y<0||y>=board.getHeight()||x<0||x>=board.getWidth())
            throw new Exception("Model.markField : Błedne argumenty y="+y+" x="+x+" h="+board.getHeight()+" w="+board.getWidth());
        if(gameEnd==true)
            throw new Exception("Model.checkField : koniec gry");
        if(gameStart==false){
            if(gameRestart==false)
                board.setMines(y, x,rand.nextLong());
            gameStart=true;
            gameRestart=false;
        }
        if(board.isFieldCovered(y, x)==true)
            board.markField(y, x);
        
    }
    
    public void startNewGame(final int h,final int w,final int m) throws Exception {
        if(h<4||h>30||w<4||w>60||m<1||m>h*w-2)
            throw new Exception("Model.startNewGame : błędne argumenty");
        gameStart=false;
        gameEnd=false;
        gameWin=false;
        board=new Board(h,w,m);
        
        time.setTime(0);
    }
    
    public void restartGame(){
        gameStart=false;
        gameEnd=false;
        gameWin=false;
        gameRestart=true;
        board.restartGame();
        time.setTime(0);
    }
    
    public Pack getPack() {
        byte[][] tab = new byte[board.getHeight()][board.getWidth()];//Zapewniam dobre rozmiary.
        System.out.println("P:\n"+board);
        try{
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if(board.isFieldCovered(i, j)==true){
                    if(board.isFieldMarked(i, j)==true)
                        tab[i][j]=10;
                    else
                        tab[i][j]=9;
                }else if(board.isFieldMined(i, j)==true){
                    tab[i][j]=11;
                }else{
                    tab[i][j]=(byte)board.getFieldDeg(i, j);
                }
            }
        }
        }catch(Exception ex){
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Pack(tab);
    }

    public String getTime() {
        return time.toString();
    }

    public String getMarkedStr(){
        return (board.getFieldsMarked())+"/"+(board.getNumOfMines())+" Marked";
    }
    
    public void incrementTime() {
        time.incrementSecond();
    }

    
    public int getBoardHeight(){
        return board.getHeight();
    }

    public int getBoardWidth(){
        return board.getWidth();
    }
    
    public int getBoardNumOfMines(){
        return board.getNumOfMines();
    }
    
    public boolean gameStarted(){
        return gameStart;
    }
    
    public boolean gameEnd(){
        return gameEnd;
    }
    
    public boolean gameWin(){
        return gameWin;
    }
    
    public int getNumOfMarked(){
        return board.getFieldsMarked();
    }
    
    public void setGamePause(boolean pause){
        gamePause=pause;
    }
    
    public boolean gamePaused(){
        return gamePause;
    }
}
