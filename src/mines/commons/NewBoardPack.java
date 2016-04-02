package mines.commons;

/**
 * Paczka przenosi informacje na temat rozmiarów i trybów gry wybranych przez
 * gracza. Służy do tworzenia nowej rozgrywki w oparciu o nie.
 *
 * @author wojciech
 */
public class NewBoardPack {

    /** Szerokosc nowej planszy */
    public final int width;
    /** Wysokość nowej planszy */
    public final int height;
    /** Ilość min na planszy */
    public final int mines;
    /** Czy można korzystać z wskazówki pokazującej miny */
    public final boolean showMineEnable;
    /** Czy można rozbrajać miny */
    public final boolean defuseMineEnable;

    /** Stand. plansze rozgrywki*/
    public final static NewBoardPack BEGINNER_PACK = new NewBoardPack(Constans.BEGINNER_H, Constans.BEGINNER_W, Constans.BEGINNER_M, true, true);
    public final static NewBoardPack MEDIUM_PACK = new NewBoardPack(Constans.MEDIUM_H, Constans.MEDIUM_W, Constans.MEDIUM_M, false, false);
    public final static NewBoardPack EXPERT_PACK = new NewBoardPack(Constans.EXPERT_H, Constans.EXPERT_W, Constans.EXPERT_M, false, false);

    /** Kontruktor tworzy paczkę
     * @param height Wysokść planszy
     * @param width Szerokosc planszy
     * @param mines Ilość min na planszy
     * @param showMineEnable Czy wskazowka pokazywania min jest dostępna.
     * @param defuseMineEnable Czy wskazówka rozbrajania min jest dostępna.
     */
    public NewBoardPack(int height, int width, int mines, boolean showMineEnable, boolean defuseMineEnable) {
        this.height = height;
        this.mines = mines;
        this.width = width;
        this.defuseMineEnable = defuseMineEnable;
        this.showMineEnable = showMineEnable;
    }
}
