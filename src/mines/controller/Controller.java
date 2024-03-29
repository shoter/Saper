package mines.controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;
import mines.commons.Constans;
import mines.commons.NewBoardPack;
import mines.controller.events.NewBoardEvent;
import mines.model.Model;
import mines.view.View;
import java.awt.Toolkit; // do dzwieku

/**
 * Kontroler ze wzorca Model-View-Controller przyjmuje dane wejściowe od
 * użytkownika i reaguje na jego poczynania, zarządzając aktualizacje modelu
 * oraz odświeżenie widoków.
 *
 * @author wojciech
 */
public class Controller {

    final private Model model;
    final private View view;
    private Timer timer;
    private Timer hintTimer;

    /**
     * Tworzy obiekt typu Controller
     *
     * @param model referencja na obiekt typu Model
     * @param view referencja na obiekt typu View
     */
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        addListeners();
        view.showStartGameDialog();
        setTimer();
    }

    /**
     * Ustawia zegar przerwan dla zegara odliczajacego czas i inicjalizuje zegar
     * do wskazowki pokazywania min.
     */
    private void setTimer() {
        timer = new Timer(Constans.ONE_SECOND, (ActionEvent event) -> {
            if (!(model.isPausa() || model.isLose() || model.isWin())) {
                view.updateSaperTime(model.getTime());
                model.incrementTime();
                view.drawSaperPanel(model.getPack());
            }
        });
        timer.start();

        hintTimer = new Timer(Constans.HINT_TIME, (ActionEvent e) -> {
            model.endHindOrPausa();
            hintTimer.stop();
        });
    }

    /**
     * Uzupelnia odpowiedzi na akcje gracza.
     */
    private void addListeners() {

        //Obsługa akcji tworzenia nowej planszy
        view.addNewBoardListener((NewBoardEvent e) -> startNewGame(e.newBoard));
        //Obsługa akcji zamykania okna przez Exit
        view.addExitListener((ActionEvent e) -> {
            java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new java.awt.event.WindowEvent(view, java.awt.event.WindowEvent.WINDOW_CLOSING));
        });

        //Obsługa myszki na panelu.
        view.addPanelListener(new PanelListener());

        //Obsługa Pauzy
        view.addMenuPauseListen((ActionEvent e) -> {
            model.setGamePause();
            view.drawSaperPanel(model.getPack());
        });

        //Pokazanie wszystkich min.
        view.addHintMinesListener((ActionEvent e) -> {
            if (!model.isPausa()) {
                if(!model.activHint()){
                    view.showMessage("Brak dostępnych skanowań!");
                }
                hintTimer.start();
            }
            view.drawSaperPanel(model.getPack());
        });

        //Obsługa zamykania okna custom 
        view.addCustomDialogExitListener((ActionEvent e) -> {
            model.setGamePause();
            view.drawSaperPanel(model.getPack());
        });

        //Obsługa klik bezpiecznego ruchu.
        view.addSafeCheckListener((ActionEvent e) -> {
            model.safeCheckField();
            view.setSafeCheckEnable(false);
            view.drawSaperPanel(model.getPack());
        });
    }

    /**
     * Tworzy nową rozgrywkę. Tworzenie rozgrywki w oparciu o info z newBoard.
     * Zmiana rozmiarów widoku.
     */
    private void startNewGame(NewBoardPack newBoard) {
        model.startNewGame(newBoard);
        view.setSaperSize(newBoard.height, newBoard.width);
        view.setHintMineEnable(newBoard.showMineEnable);
        view.setSafeCheckEnable(true);
        view.drawSaperPanel(model.getPack());
        view.updateFacePanel(model.isWin(), model.isLose());
    }

    /**
     * Powtarza rozgrywkę o takich samych własnościach.
     */
    private void restartGame() {
        model.restartGame();
        view.drawSaperPanel(model.getPack());
        view.setSafeCheckEnable(true);
        view.updateFacePanel(model.isWin(), model.isLose());
    }

    /**
     * Metoda sprawdza czy rozgrywka się zakończyła i wyświetla panel
     * zakończenia gry
     */
    private void checkGameEnd() {
        if ((model.isLose() || model.isWin())) {
            Toolkit.getDefaultToolkit().beep(); // dzwiek
            view.updateFacePanel(false);
            view.updateFacePanel(model.isWin(), model.isLose());
            view.drawSaperPanel(model.getPack());
            if (view.playAgain(model.isWin())) {
                restartGame();
            } else {
                java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new java.awt.event.WindowEvent(view, java.awt.event.WindowEvent.WINDOW_CLOSING));
            }
        }
    }

    /**
     * Klasa zapewnia odpowiedzi na Event wywołany przez klikniecie na panel
     * sapera.
     */
    private class PanelListener implements MouseListener {

        /**
         * Obsługa wciśniecia klawisza myszki.
         *
         * @param e
         */
        @Override
        public void mousePressed(MouseEvent e) {

            //Sprawdzenie czy wcisniety został lewy klawisz myszki.
            int eY = (e.getY() / Constans.FIELD_SIZE);
            int eX = (e.getX() / Constans.FIELD_SIZE);
            if (e.getButton() == MouseEvent.BUTTON1) {

                if (model.defuseFieldEnable(eY, eX)) {
                    view.updateFacePanel(false);
                    if (view.getDefuseDecision() == false || model.canDefuse() == false) {
                        model.checkField(eY, eX);
                    } else {
                        model.defuseField(eY, eX);
                    }
                } else {
                    view.updateFacePanel(true);
                    model.checkField(eY, eX);
                }
                view.setSafeCheckEnable(false);
            } else if (e.getButton() == MouseEvent.BUTTON3) {
                model.markField(eY, eX);
                view.setSafeCheckEnable(false);
            }
            checkGameEnd();

            view.drawSaperPanel(model.getPack());
            view.updateFacePanel(model.isWin(), model.isLose());

        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent arg0) {
        }

        /**
         * Obsługa podniesienia myszki. Zmienia twarz.
         * @param e
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            view.updateFacePanel(false);
            view.updateFacePanel(model.isWin(), model.isLose());
        }
    }
}
