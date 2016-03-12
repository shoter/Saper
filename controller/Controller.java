package saper01.controller;

import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import saper01.commons.Constans;
import saper01.model.Model;
import saper01.view.View;
import javax.swing.Timer;

public class Controller {

    final private Model m;
    final private View v;
    Timer timer;

    public Controller(Model m, View v) throws Exception {
        this.m = m;
        this.v = v;
        setListeners();
        m.startNewGame(m.getBoardHeight(), m.getBoardWidth(), m.getBoardNumOfMines());
        v.drawSaperPanel(m.getPack());
    }

    private void setListeners() {
        timer = new Timer(Constans.ONE_SECOND, (ActionEvent event) -> {
            if (m.gameStarted() == true && m.gameEnd() == false &&m.gamePaused()==false) {
                v.setTimeLabel(m.getTime());
                m.incrementTime();
            }
        });
        timer.start();

        v.addMenuExitListener((ActionEvent e) -> {
            java.awt.Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(new java.awt.event.WindowEvent(v, java.awt.event.WindowEvent.WINDOW_CLOSING));
        });
        
        v.addPanelListener(new CalcList());
        
        v.addMenuNewListener((ActionEvent e) -> {
            try {
                startNewGame(m.getBoardHeight(), m.getBoardWidth(), m.getBoardNumOfMines());
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        v.addMenuRestartListener((ActionEvent e) -> {
            try {
                m.restartGame();
                m.setGamePause(false);
                v.setSaperSize(m.getBoardHeight(), m.getBoardWidth());
                v.drawSaperPanel(m.getPack());
                v.setTimeLabel(m.getTime());
                v.setMarkLabel(m.getMarkedStr());
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        v.addMenuPauseListen((ActionEvent e) -> {
            m.setGamePause(!m.gamePaused());
        });
        
        v.addMenuRadioBeginner((ActionEvent e) -> {
            startNewGame(Constans.BEGINNER_H, Constans.BEGINNER_W, Constans.BEGINNER_M);
        });

        v.addMenuRadioInter((ActionEvent e) -> {
            startNewGame(Constans.MEDIUM_H, Constans.MEDIUM_W, Constans.MEDIUM_MINES);
        });

        v.addMenuRadioExpert((ActionEvent e) -> {
            startNewGame(Constans.EXPERT_H, Constans.EXPERT_W, Constans.EXPERT_MINES);
        });
    }

    private void startNewGame(final int h, final int w, final int mines) {
        try{
            m.startNewGame(h,w,mines);
            m.setGamePause(false);
            v.setSaperSize(h,w);
            v.drawSaperPanel(m.getPack());
            v.setTimeLabel(m.getTime());
            v.setMarkLabel(m.getMarkedStr());
        } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }

    }

    class CalcList implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {
            try {
                if (m.gameEnd() == false &&m.gamePaused()==false) {
                    
                    if(e.getButton()==MouseEvent.BUTTON1)
                        m.checkField((e.getY() / Constans.FIELD_SIZE), (e.getX() / Constans.FIELD_SIZE));
                    else
                        m.markField((e.getY() / Constans.FIELD_SIZE), (e.getX() / Constans.FIELD_SIZE));
                    v.drawSaperPanel(m.getPack());
                    v.setMarkLabel(m.getMarkedStr());
                    if(m.gameEnd()==true){
                        if(m.gameWin())
                            v.setMarkLabel("COMPLETED!");
                        else
                            v.setMarkLabel("DEAD!");
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public void mouseClicked(MouseEvent arg0) {
        }

        public void mouseEntered(MouseEvent arg0) {
        }

        public void mouseExited(MouseEvent arg0) {
        }

        public void mouseReleased(MouseEvent arg0) {
        }
    }
}
