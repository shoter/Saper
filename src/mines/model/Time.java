
package mines.model;

/**
 *
 * @author wojciech
 */
public class Time {

    private int second = 0;

    public void setTime(int second) {
        this.second = second;
    }

    public void incrementSecond() {
        second++;
    }

    public int getTime() {
        return second;
    }
}
