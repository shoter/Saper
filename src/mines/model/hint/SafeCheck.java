
package mines.model.hint;

/**
 *
 * @author wojciech
 */
public class SafeCheck {
    private boolean hintEnable;

    public SafeCheck() {
        this.hintEnable = true;
    }

    public void useHint() {
        if (hintEnable == true) {
            hintEnable = false;
        }
    }
    
    public boolean isHintEnable(){
        return hintEnable;
    }
}
