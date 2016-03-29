
package mines.model.board;

import java.util.Random;

/**
 *
 * @author wojciech
 */
public class BoardGenerator {

    private final Field[][] fields;
    private final int mines;

    public BoardGenerator(final Field[][] fields, final int mines) {
        this.fields = fields;
        this.mines = mines;
    }

    /**
     * Mechanizm moreMines działa w ten sposob że gdy jest wiecej min niż połowa
     * to łatwiej jest losować gdzie min nie ma
     *
     * @param seed
     */
    public void setMines(final long seed) {
        Random rand = new Random(seed);
        boolean moreMines = (mines > fields.length * fields[0].length / 2);
        int t_h, t_w, t_m = (moreMines) ? (fields.length * fields[0].length - mines) : (mines);
        if (moreMines) {
            setAllMines();
        }
        for (int i = 0; i < t_m; i++) {
            do {
                t_h = rand.nextInt(fields.length);
                t_w = rand.nextInt(fields[0].length);
            } while (fields[t_h][t_w].isMined() == !moreMines);
            fields[t_h][t_w].setMine(!moreMines);
        }
        setFieldDeg();
    }

    /**
     * Ustawia degree czyli ile min jest wokoł danego pola.
     */
    private void setFieldDeg() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[0].length; j++) {
                int n = 0;
                for (int i2 = i - 1; i2 <= i + 1; i2++) {
                    for (int j2 = j - 1; j2 <= j + 1; j2++) {
                        if (i2 >= 0 && i2 < fields.length && j2 >= 0 && j2 < fields[0].length) {
                            n += (fields[i2][j2].isMined() ? 1 : 0);
                        }
                    }
                }
                fields[i][j].setDeg(n);
            }
        }
    }

    /**
     * Ustawia na wszystkich polach miny.
     */
    private void setAllMines() {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fields[i][j].setMine(true);
            }
        }
    }
}
