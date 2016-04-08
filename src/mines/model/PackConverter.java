package mines.model;

import mines.commons.MinesPack;
import mines.model.board.Board;

/**
 * Klasa obsługuje konwersje Board do formy zapewniającej wyświetlanie w module
 * widoku.
 *
 * @author wojciech
 */
public class PackConverter {

    private final Board board;

    public PackConverter(Board board) {
        this.board = board;
    }

    /**
     * Paczka standardowa.
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
        return new MinesPack(tab, board.getFieldsMarked(), board.getNumOfMines());
    }

    /**
     * Paczka pauzy zaslania wszystkie pola
     *
     * @param status
     * @return
     */
    public MinesPack getPauseMinesPack(Status status) {
        byte[][] tab = new byte[board.getHeight()][board.getWidth()];
        for (byte[] tab1 : tab) {
            for (int j = 0; j < tab[0].length; j++) {
                tab1[j] = 12;
            }
        }

        return new MinesPack(tab, board.getFieldsMarked(), board.getNumOfMines());
    }
}
