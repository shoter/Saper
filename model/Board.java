/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saper01.model;

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
    }

    public void setMines(final int y, final int x, final long seed) {
        rand.setSeed(seed);
        boolean moreMines = (m > w * h / 2);
        int t_h, t_w, t_m = (moreMines) ? (w * h - m) : (m);
        if (moreMines) {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    fields[i][j].setMine(true);
                }
            }
        }
        fields[y][x].setMine(false);//To jest ten element że pierwsze klikniecie nie zabija;
        for (int i = 0; i < t_m; i++) {
            do {
                t_h = rand.nextInt(h);
                t_w = rand.nextInt(w);
            } while (fields[t_h][t_w].isMined() == !moreMines || (t_w == x && t_h == y));//O tutaj dokładnie to ||(t_w==x&&t_h==y)
            fields[t_h][t_w].setMine(!moreMines);
        }
        setFieldDeg();
    }

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

    public void restartGame() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                fields[i][j].setMark(false);
                fields[i][j].setCover(true);
            }
        }
        fieldsUncovered = h * w;
        fieldsMarked = 0;
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                temp += (fields[i][j].isMined() ? "M " : "O ");
            }
            temp += "\n";
        }
        temp += "\n";
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                temp += (fields[i][j].getDeg() + " ");
            }
            temp += "\n";
        }
        return temp + "\n";
    }

    private void setFieldDeg() {
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int n = 0;
                for (int i2 = i - 1; i2 <= i + 1; i2++) {
                    for (int j2 = j - 1; j2 <= j + 1; j2++) {
                        if (i2 >= 0 && i2 < h && j2 >= 0 && j2 < w) {
                            n += (fields[i2][j2].isMined() ? 1 : 0);
                        }
                    }
                }
                fields[i][j].setDeg(n);
            }
        }
    }

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
