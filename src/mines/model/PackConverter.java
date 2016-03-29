/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines.model;

import mines.commons.MinesPack;
import mines.model.board.Board;

/**
 *
 * @author wojciech
 */
public class PackConverter {
    
    private final Board board;
    private final Time time;

    public PackConverter(Board board, Time time) {
        this.board = board;
        this.time = time;
    }

    /**
     * Paczka standardowa
     *
     * @param status
     * @return
     */
    public MinesPack getMinesPack(Status status) {
        byte[][] tab = new byte[board.getHeight()][board.getWidth()];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (board.isFieldCovered(i, j) == true) {
                    if (board.isFieldMarked(i, j) == true) {
                        tab[i][j] = 10;
                    } else {
                        tab[i][j] = 9;
                    }
                } else if (board.isFieldMined(i, j) == true) {
                    tab[i][j] = 11;
                } else {
                    tab[i][j] = (byte) board.getFieldDeg(i, j);
                }
            }
        }
        return new MinesPack(tab, board.getFieldsMarked(), board.getNumOfMines());
    }

    /**
     * Paczka wygrana - wszystkie nieodkryte pola sa zaznaczone flagami
     *
     * @param status
     * @return
     */
    public MinesPack getWinMinesPack(Status status) {
        byte[][] tab = new byte[board.getHeight()][board.getWidth()];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (board.isFieldMined(i, j) == true) {
                    tab[i][j] = 10;
                } else {
                    tab[i][j] = (byte) board.getFieldDeg(i, j);
                }
            }
        }
        return new MinesPack(tab, board.getFieldsMarked(), board.getNumOfMines());
    }

    /**
     * Paczka przegranego lub pauzy pokazuje wszystkie miny. Pola zasłoniete
     * pozostaja nimi
     *
     * @param status
     * @return
     */
    public MinesPack getLoseMinesPack(Status status) {
        byte[][] tab = new byte[board.getHeight()][board.getWidth()];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (board.isFieldMined(i, j) == true) {
                    tab[i][j] = 11;
                } else if (board.isFieldCovered(i, j) == true) {
                    if (board.isFieldMarked(i, j) == true) {
                        tab[i][j] = 10;
                    } else {
                        tab[i][j] = 9;
                    }
                } else {
                    tab[i][j] = (byte) board.getFieldDeg(i, j);
                }
            }
        }
        return new MinesPack(tab,board.getFieldsMarked(), board.getNumOfMines() );
    }

    /**
     * Paczka pauzy zaslania wszystkie pola
     *
     * @param status
     * @return
     */
    public MinesPack getPauseMinesPack(Status status) {
        byte[][] tab = new byte[board.getHeight()][board.getWidth()];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                tab[i][j] = 12;
            }
        }

        return new MinesPack(tab, board.getFieldsMarked(), board.getNumOfMines());
    }
}
