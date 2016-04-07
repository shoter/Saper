
package mines.model.hint;

import mines.commons.Constans;

/**
 * Obsługa stanu wskazowki rozbrajania min
 * @author wojciech
 */
public class DefuseMine {
    /** Ile razy wskazowka zostala wykorzystana */
    private int numberOfDefuse = 0;
    /** Czy wskazowka zostala uaktywniona w rozgrywce*/
    private final boolean defuseEnable;

    public DefuseMine(final boolean defuseEnable) {
        this.defuseEnable = defuseEnable;
    }

    /**
     * Wykonuje rozbrojenie zmienia stan wskazowki.
     */
    public void defuseMine() {

        if (numberOfDefuse < Constans.DEFUSE_MINE_NUMBER && defuseEnable == true) {
            numberOfDefuse++;
        }
    }

    /**
     * Czy rozbtrojenie się udało
     * @return 
     */
    public boolean getDefuseDecision() {
        return Math.random() < Constans.PROB_OF_DEFUSE;
    }

    /**
     * Czy istnieje możliwość rozbrojenia miny
     * @return 
     */
    public boolean canDefuse() {
        return (numberOfDefuse < Constans.DEFUSE_MINE_NUMBER && defuseEnable == true);
    }
}
