
package mines.model.hint;

import mines.commons.Constans;

/**
 * Obsługa stanu wskazowki odkrywania miejsca min
 * @author wojciech
 */
public class HintControl {
    /** Ile razy wskazowka zostala wykorzystana */
    private int numberOfHints = 0;
    /** Czy wskazowka zostala uaktywniona w rozgrywce*/
    final private boolean hintEnable;

    public HintControl(final boolean hintEnable) {
        this.hintEnable = hintEnable;
    }

    /**
     * Uaktualnia stan wskazowki po jej wykorzystaniu.
     */
    public void useHint() {
        if (numberOfHints < Constans.NUMBER_OF_HINTS && hintEnable == true) {
            numberOfHints++;
        }
    }

    /**
     * 
     * @return true jeżeli można użyć wskazówki
     */
    public boolean isHintEnable() {
        return numberOfHints < Constans.NUMBER_OF_HINTS && hintEnable == true;
    }
}
