
package mines.model.board;

/**
 * Klasa opisuje pojedyncze pole miny
 * @author wojciech
 */
public class Field {
    /** Czy na polu występuje mina */
    private boolean mined;
    /** Czy pole jest oflagowane */
    private boolean marked;
    /** Czy pole jest zasloniete */
    private boolean covered;
    /** Ilosc min wokol pola. Jezeli na polu jest mina to rownież w tej sumie */
    private int deg;

    public Field() {
        mined = false;
        marked = false;
        covered = true;
    }

    /**
     * 
     * @return true jezeli pole jest zaminowane
     */
    public boolean isMined() {
        return mined;
    }

    /**
     * Ustawia na polu mine
     * @param mine true jezeli na polu jest mina
     */
    public void setMine(final boolean mine) {
        mined = mine;
    }

    /**
     * 
     * @return true jezeli pole jest oflagowane
     */
    public boolean isMarked() {
        return marked;
    }

    /**
     * 
     * @param mark true jezeli flaga ma byc postawiaona na polu
     */
    public void setMark(final boolean mark) {
        marked = mark;
    }
    //setCover

    /**
     * 
     * @return true jeżeli pole jest zasłoniete
     */
    public boolean isCovered() {
        return covered;
    }

    /**
     * Odkrywa pole
     */
    public void uncover() {
        covered = false;
    }

    /**
     * Ustwia ile min jest wokol pola
     * @param d Ile min dookola
     */
    public void setDeg(final int d) {
        deg = d;
    }

    /**
     * 
     * @return zwraca ile min dookola
     */
    public int getDeg() {
        return deg;
    }
}
