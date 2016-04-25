
package mines.model.board;

import java.util.Random;
import mines.commons.NewBoardPack;

/**
 * Klasa obsługuje generacje min na planszy.
 * @author wojciech
 */
public class BoardGenerator {
    
    private BoardGenerator(){}

    public static Field[][] getBoard(NewBoardPack nbp){
        Field[][] fields=initBoard(nbp.height,nbp.width);
        setMines(fields,nbp.mines);
        return fields;
    }
    
    private static Field[][] initBoard(int height,int width){
        Field[][] fields = new Field[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                fields[i][j] = new Field();
            }
        }
        return fields;
    }
    
    private static void setMines(Field[][] fields,int mines) {
        Random rand = new Random();
        boolean moreMines = (mines > fields.length * fields[0].length / 2);
        int t_h, t_w, t_m = (moreMines) ? (fields.length * fields[0].length - mines) : (mines);
        if (moreMines) {
            setAllMines(fields);
        }
        for (int i = 0; i < t_m; i++) {
            do {
                t_h = rand.nextInt(fields.length);
                t_w = rand.nextInt(fields[0].length);
            } while (fields[t_h][t_w].isMined() == !moreMines);
            fields[t_h][t_w].setMine(!moreMines);
        }
        setFieldDeg(fields);
    }

    /**
     * Ustawia degree czyli ile min jest wokoł danego pola.
     */
    private static void setFieldDeg(Field[][] fields) {
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
    private static void setAllMines(Field[][] fields) {
        for (Field[] field : fields) {
            for (Field field1 : field) {
                field1.setMine(true);
            }
        }
    }
}
