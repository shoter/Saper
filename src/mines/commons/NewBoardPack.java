package mines.commons;

/**
 * Paczka przenosi informacje na temat rozmiarów i trybów gry wybranych przez
 * gracza. Służy do tworzenia nowej rozgrywki w oparciu o nie.
 *
 * @author wojciech
 */
public class NewBoardPack {

    public final int width;
    public final int height;
    public final int mines;
    public final boolean showMineEnable;
    public final boolean defuseMineEnable;

    /** Stand. plansze rozgrywki*/
    public final static NewBoardPack BEGINNER_PACK = new NewBoardPack(Constans.BEGINNER_H, Constans.BEGINNER_W, Constans.BEGINNER_M, true, true);
    public final static NewBoardPack MEDIUM_PACK = new NewBoardPack(Constans.MEDIUM_H, Constans.MEDIUM_W, Constans.MEDIUM_M, false, false);
    public final static NewBoardPack EXPERT_PACK = new NewBoardPack(Constans.EXPERT_H, Constans.EXPERT_W, Constans.EXPERT_M, false, false);

    public NewBoardPack(int height, int width, int mines, boolean showMineEnable, boolean defuseMineEnable) {
        this.height = height;
        this.mines = mines;
        this.width = width;
        this.defuseMineEnable = defuseMineEnable;
        this.showMineEnable = showMineEnable;
    }
}
