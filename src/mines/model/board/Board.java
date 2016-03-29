/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines.model.board;

import java.util.Random;

/**
 *
 * @author wojciech
 */
public class Board {

    final private Field[][] fields;
    final private int h;
    final private int w;
    final private int m;
    private int fieldsUncovered;
    private int fieldsMarked;
    final Random rand = new Random();
    final BoardGenerator boardGener;

    /**
     * Inicjalizacja wartosciami poczatkowymi
     *
     * @param h
     * @param w
     * @param m
     */
    public Board(final int h, final int w, final int m) {

        fields = new Field[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                fields[i][j] = new Field();
            }
        }
        this.h = h;
        this.m = m;
        this.w = w;
        fieldsUncovered = h * w;
        boardGener = new BoardGenerator(fields, m);
        boardGener.setMines(rand.nextLong());
    }

    /**
     * Metoda rekurencyja zapewnia odsloniecie wszystkich pol wokol odkrytego
     * zera.
     *
     * @param y
     * @param x
     * @return
     */
    public boolean uncoverField(final int y, final int x) {
        if (fields[y][x].isCovered() == false || fields[y][x].isMarked()) {
            return false;
        }
        fields[y][x].setMark(false);
        fields[y][x].uncover();
        fieldsUncovered--;
        if (fields[y][x].getDeg() != 0) {
            return true;
        }
        for (int i = y - 1; i <= y + 1; i++) {
            for (int j = x - 1; j <= x + 1; j++) {
                if (i >= 0 && i < h && j >= 0 && j < w) {
                    uncoverField(i, j);
                }
            }
        }
        return true;
    }

    /**
     * Stawia lub zabiera flage na polu
     *
     * @param y
     * @param x
     */
    public void markField(final int y, final int x) {
        if (fieldsMarked >= m && fields[y][x].isMarked() == false) {
            return;
        }
        fieldsMarked += (fields[y][x].isMarked() ? -1 : 1);
        fields[y][x].setMark(!fields[y][x].isMarked());
    }

    public boolean isFieldMined(final int y, final int x) {
        return fields[y][x].isMined();
    }

    public boolean isFieldCovered(final int y, final int x) {
        return fields[y][x].isCovered();
    }

    public boolean isFieldMarked(final int y, final int x) {
        return fields[y][x].isMarked();
    }

    public int getFieldDeg(final int y, final int x) {
        return fields[y][x].getDeg();
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    public int getFieldsUncovered() {
        return fieldsUncovered;
    }

    public int getFieldsMarked() {
        return fieldsMarked;
    }

    public int getNumOfMines() {
        return m;
    }
}
