package mines.controller.events;

import java.util.EventObject;
import mines.commons.NewBoardPack;

/**
 * Event wywoływany w przypadku tworzenia nowej planszy. Zawiera informacje o
 * niej.
 *
 * @author wojciech
 */
public class NewBoardEvent extends EventObject {

    public final NewBoardPack newBoard;

    public NewBoardEvent(Object source, NewBoardPack newBoard) {
        super(source);
        this.newBoard = newBoard;
    }
}
