
package mines.model.board;

import java.util.Random;

/**
 * Klasa przedstawia plansze rozgrywki. Metody do jej obsługi.
 * 
 * @author wojciech
 */
public class Board {
    /** Pola planszy*/
    final private Field[][] fields;
    /** Wyskosc planszy*/
    final private int h;
    /** Szerokość planszy*/
    final private int w;
    /** Ilosc min na planszy*/
    final private int m;
    /** Ilosc min nieodkrytych */
    private int fieldsUncovered;
    /** Ilosc min zaflagowanych*/
    private int fieldsMarked;
    /** Generator losowy*/
    final Random rand = new Random();
    /** Generator planszy */
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

    /**
     * 
     * @param y
     * @param x
     * @return true jeżeli mina jest na polu (x,y).
     */
    public boolean isFieldMined(final int y, final int x) {
        return fields[y][x].isMined();
    }

    /**
     * 
     * @param y
     * @param x
     * @return true jeżeli pole jest zasłonięte.
     */
    public boolean isFieldCovered(final int y, final int x) {
        return fields[y][x].isCovered();
    }

    /**
     * 
     * @param y
     * @param x
     * @return true jeżeli pole zostało oflagowane
     */
    public boolean isFieldMarked(final int y, final int x) {
        return fields[y][x].isMarked();
    }

    /**
     * 
     * @param y
     * @param x
     * @return ilość min wokół pola.
     */
    public int getFieldDeg(final int y, final int x) {
        return fields[y][x].getDeg();
    }

    /**
     * 
     * @return szerokosc planszy.
     */
    public int getWidth() {
        return w;
    }

    /**
     * 
     * @return wysokosc planszy.
     */
    public int getHeight() {
        return h;
    }

    /**
     * 
     * @return ilość pol nieodkrytych
     */
    public int getFieldsUncovered() {
        return fieldsUncovered;
    }

    /**
     * 
     * @return ilość pol oflagowanych
     */
    public int getFieldsMarked() {
        return fieldsMarked;
    }

    /**
     * 
     * @return ilość min na planszy.
     */
    public int getNumOfMines() {
        return m;
    }
}
