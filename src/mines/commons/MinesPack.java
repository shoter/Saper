
package mines.commons;

/**
 * Paczka przenosi dane pomiędzy Modelem a Widokiem. 0 : pole puste. 1-8 :
 * wartości liczbowe. 9 : pole nieodkryte 10 : flaga 11 : mina 12 : zakryte pole
 * pauzy
 *
 * @author wojciech
 */
public class MinesPack {
    /**
     * Paczka z danymi
     */
    public final byte[][] tab;
    /**
     * Ilosc flag zaznaczonych
     */
    final public int fieldsMarked;
    /**
     * Ilość wszystkich min
     */
    final public int numbOfMines;

    /**
     * Tworzy paczkę danych do wyswitlenia w widoku.
     *
     * @param tab
     * @param fieldsMarked
     * @param numbOfMines
     */
    public MinesPack(final byte[][] tab, int fieldsMarked, int numbOfMines) {
    
        this.tab = tab;
        this.fieldsMarked = fieldsMarked;
        this.numbOfMines = numbOfMines;
    }
}
