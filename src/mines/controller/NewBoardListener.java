package mines.controller;

import java.util.EventListener;
import mines.controller.events.NewBoardEvent;

/**
 * Listener wykonujacy Eventy powstania nowej planszy.
 *
 * @author wojciech
 */
public interface NewBoardListener extends EventListener {

    public void actionPerformed(NewBoardEvent e);
}
