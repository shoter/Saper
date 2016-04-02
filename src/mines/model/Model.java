package mines.model;

import java.util.Random;
import mines.commons.MinesPack;
import mines.commons.NewBoardPack;
import mines.model.board.Board;
import mines.model.hint.DefuseMine;
import mines.model.hint.HintControl;
import mines.model.hint.SafeCheck;

/**
 * Model z Model-View-Controller jest pewną reprezentacją problemu bądź logiki
 * aplikacji. Obsługuje stan gry i wykonuje decyzje w oparciu o stan.
 *
 * @author wojciech
 */
public class Model {

    /** Moduł obsługuje stan czasu */
    private final Time time;
    /** Obsługuje funkcje planszy. */
    private Board board;
    /** Losowanie seed dla generatora seed */
    private final Random rand = new Random();
    /** Przechowuje aktualny stan gry */
    private Status status = Status.BEGUN;
    /** Generacja paczek dla View */
    private PackConverter packConverter;
    /** Wyswietlanie podpowiedzi */
    private HintControl hintControl;
    /** Rozbrajanie min*/
    private DefuseMine defuseMine;
    /** Stan czy był pierwszy bez ruch*/
    private SafeCheck safeCheck;
    /** Przechowuje informacje o ostatniej konfiguracji planszy*/
    private NewBoardPack lastGameConfig;

    /**
     * Kostruktor tworzy pierwsza rozgrywke wyswietlna. Oraz inicjalizuje
     * odliczanie czasu.
     */
    public Model() {
        time = new Time();
        startNewGame(NewBoardPack.BEGINNER_PACK);
    }

    /**
     * Tworzy nowa rozgrywke w oparciu o parametr planszy zawarte w boardPack,
     *
     * @param boardPack Parametry
     */
    public final void startNewGame(NewBoardPack boardPack) {
        status = Status.BEGUN;
        board = new Board(boardPack.height, boardPack.width, boardPack.mines);
        time.setTime(0);
        packConverter = new PackConverter(board);
        hintControl = new HintControl(boardPack.showMineEnable);
        defuseMine = new DefuseMine(boardPack.defuseMineEnable);
        safeCheck = new SafeCheck();
        lastGameConfig = boardPack;
    }

    /**
     * Powtarza parametry poprzedniej rozgrywki
     */
    public void restartGame() {
        startNewGame(lastGameConfig);
    }

    /**
     * W oparciu o status gry rostrzyga jak pole powinno się odsłonić
     *
     * @param y
     * @param x
     */
    public void checkField(final int y, final int x) {
        if (!(status == Status.PLAYING || status == Status.BEGUN)) {
            return;
        }
        if (status == Status.BEGUN) {
            status = Status.PLAYING;
        }
        if (board.isFieldMined(y, x) == true) {
            status = Status.LOSE;
        }
        board.uncoverField(y, x);
        if (board.getFieldsUncovered() == board.getNumOfMines()&&status!=Status.LOSE) {
            status = Status.WIN;
        }
    }

    /**
     * Wykonuje pierwszy bezpieczny ruch.
     */
    public void safeCheckField() {
        if (status != Status.BEGUN || safeCheck.isHintEnable() == false) {
            return;
        }
        int t_x, t_y;
        do {
            t_y = rand.nextInt(board.getHeight());
            t_x = rand.nextInt(board.getWidth());
        } while (board.isFieldMined(t_y, t_x) == true || board.getFieldDeg(t_y, t_x) == 0);
        checkField(t_y, t_x);
    }

    /**
     * W oparciu o status gry i stan wskazowki decyduje czy gracz może rozbroić
     * mine
     *
     * @param y
     * @param x
     * @return true jeżeli może rozbroić.
     */
    public boolean defuseField(final int y, final int x) {
        if (!(status == Status.PLAYING || status == Status.BEGUN)) {
            return false;
        }
        if (board.isFieldMined(y, x) == true) {

            if (defuseMine.canDefuse() == true) {
                defuseMine.defuseMine();
                return true;
            }
        }
        return false;
    }

    /**
     * Obsługa oznaczenia flagą pola
     *
     * @param y
     * @param x
     */
    public void markField(final int y, final int x) {
        if (!(status == Status.PLAYING || status == Status.BEGUN)) {
            return;
        }
        if (status == Status.BEGUN) {
            status = Status.PLAYING;
        }
        if (board.isFieldCovered(y, x) == true) {
            board.markField(y, x);
        }
    }

    /**
     * W oparciu o status gry wybiera który zestaw paczki wybrać do wyswietlenia
     * na panelu
     *
     * @return
     */
    public MinesPack getPack() {
        switch (status) {
            case LOSE:
            case HINT:
                return packConverter.getLoseMinesPack(status);
            case WIN:
                return packConverter.getWinMinesPack(status);
            case PAUSE:
                return packConverter.getPauseMinesPack(status);
            default:
        }
        return packConverter.getMinesPack(status);
    }

    /**
     * Ustawia status gry na pauze
     */
    public void setGamePause() {
        if (status == Status.PAUSE) {
            status = Status.PLAYING;
        } else if (status == Status.PLAYING) {
            status = Status.PAUSE;
        }
    }

    /**
     * Zwiększa czas gry
     */
    public void incrementTime() {
        if (status == Status.PLAYING) {
            time.incrementSecond();
        }
    }
    
    /**
     * Przywraca status gry PLAYING. Konczy status END lub HINT.
     */
    public void endHindOrPausa(){
        status=Status.PLAYING;
    }

    /**
     * Do sprawdzenia statusu gry
     * @return true jeżeli gra zakończyła się wygraną
     */
    public boolean isWin() {
        return status == Status.WIN;
    }

    /**
     * Do sprawdzenia statusu gry
     * @return true jeżeli gra zakończyła się przegraną
     */
    public boolean isLose() {
        return status == Status.LOSE;
    }

    /**
     * Do sprawdzenia statusu gry
     * @return true jeżeli gra jest w stanie pauzy
     */
    public boolean isPausa() {
        return status == Status.PAUSE;
    }
    
    /**
     * Obsługa wskaz. odkrycia min
     */
    public void activHint() {
        if (hintControl.isHintEnable()) {
            hintControl.useHint();
            status = Status.HINT;
        }
    }

    /**
     * Zwraca decyzje czy graczowi udało się rozbroić minę
     * @return 
     */
    public boolean canDefuse() {
        return this.defuseMine.getDefuseDecision();
    }

    /**
     * Zwraca czas w sekundach od rozpoczecia pojedynczej rozgrywki
     * @return 
     */
    public int getTime() {
        return time.getTime();
    }

}
