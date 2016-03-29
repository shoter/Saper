
package mines.model.board;

/**
 * Klasa opisuje pojedyncze pole miny
 * @author wojciech
 */
public class Field {

    private boolean mined;
    private boolean marked;
    private boolean covered;
    private int deg;

    public Field() {
        mined = false;
        marked = false;
        covered = true;
    }

    public boolean isMined() {
        return mined;
    }

    public void setMine(final boolean mine) {
        mined = mine;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMark(final boolean mark) {
        marked = mark;
    }

    public void setCover(final boolean cov) {
        covered = cov;
    }

    public boolean isCovered() {
        return covered;
    }

    public void uncover() {
        covered = false;
    }

    public void setDeg(final int d) {
        deg = d;
    }

    public int getDeg() {
        return deg;
    }
}
