
package mines.model.hint;

import mines.commons.Constans;

/**
 * Obsługa stanu wskazowki odkrywania miejsca min
 * @author wojciech
 */
public class HintControl {

    private int numberOfHints = 0;
    final private boolean hintEnable;

    public HintControl(final boolean hintEnable) {
        this.hintEnable = hintEnable;
    }

    public void useHint() {
        if (numberOfHints < Constans.NUMBER_OF_HINTS && hintEnable == true) {
            numberOfHints++;
        }
    }

    public boolean isHintEnable() {
        return numberOfHints < Constans.NUMBER_OF_HINTS && hintEnable == true;
    }
}
