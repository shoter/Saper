
package mines.model.hint;

/**
 *
 * @author wojciech
 */
public class SafeCheck {
    /** Czy wskazowka zostala wykorzystana w rozgrywce*/
    private boolean hintEnable;

    public SafeCheck() {
        this.hintEnable = true;
    }
    
    /**
     * Uaktualnia stan wskazowki po jej wykorzystaniu.
     */
    public void useHint() {
        if (hintEnable == true) {
            hintEnable = false;
        }
    }
    
    /**
     * 
     * @return true jeżeli można użyć wskazówki
     */
    public boolean isHintEnable(){
        return hintEnable;
    }
}
