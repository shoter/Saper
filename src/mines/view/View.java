package mines.view;

import mines.view.dialogs.CustomDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.EventListenerList;
import mines.commons.Constans;
import mines.commons.MinesPack;
import mines.commons.NewBoardPack;
import mines.controller.NewBoardListener;
import mines.controller.events.NewBoardEvent;
import mines.view.dialogs.DefuseDialog;
import mines.view.dialogs.EndGameDialog;
import mines.view.dialogs.StartGameDialog;

/**
 *
 * @author wojciech
 */
public class View extends javax.swing.JFrame {

    EventListenerList list = new EventListenerList();
    NewBoardPack lastBoard = NewBoardPack.BEGINNER_PACK;

    /**
     * Creates new form View
     */
    public View() {
        customDialog = new CustomDialog(this, true);
        endGameDialog = new EndGameDialog(this, true);
        defuseDialog = new DefuseDialog(this, true);
        startGameDialog = new StartGameDialog(this, true);

        initComponents();
        setListeners();
        setSaperSize(lastBoard.height, lastBoard.width);
    }

    public void showStartGameDialog() {
        startGameDialog.setVisible(true);
        fireNewBoardEvent(startGameDialog.getNewBoardPack());

    }

    private void setListeners() {
        customButton.addActionListener((ActionEvent e) -> {
            customDialog.setVisible(true);
        });

        customDialog.addOkButtonListener((ActionEvent e) -> {
            fireNewBoardEvent(customDialog.getNewBoardPack());
        });

        beginnerButton.addActionListener((ActionEvent e) -> {
            fireNewBoardEvent(NewBoardPack.BEGINNER_PACK);
        });

        mediumButton.addActionListener((ActionEvent e) -> {
            fireNewBoardEvent(NewBoardPack.MEDIUM_PACK);
        });

        expertButton.addActionListener((ActionEvent e) -> {
            fireNewBoardEvent(NewBoardPack.EXPERT_PACK);
        });
        
        facePanel1.addMouseListener(new FacePanelListener());
        
        newGameButton.addActionListener((ActionEvent e) -> {
            fireNewBoardEvent(lastBoard);
        });
        modernButton.addActionListener((ActionEvent e) -> {
            facePanel1.changeStyle(false);
            facePanel1.drawSaperFace(false, false);
        });
        oldStyleButton.addActionListener((ActionEvent e) -> {
            facePanel1.changeStyle(true);
            facePanel1.drawSaperFace(false, false);
        });

    }

    public void addNewBoardListener(NewBoardListener nbl) {
        list.add(NewBoardListener.class, nbl);

    }

    final protected void fireNewBoardEvent(NewBoardPack newBoard) {

        Object[] listeners = list.getListenerList();
        lastBoard = newBoard;
        NewBoardEvent nbe = new NewBoardEvent(this, newBoard);
        for (int i = 0; i < listeners.length; i++) {
            if (listeners[i] == NewBoardListener.class) {
                ((NewBoardListener) listeners[i + 1]).actionPerformed(nbe);
            }
        }
    }

    public void addPanelListener(MouseListener ml) {
        minesPanel1.addMouseListener(ml);
    }

    public void addExitListener(ActionListener al) {
        endGameButton.addActionListener(al);
        startGameDialog.addExitListener(al);
    }

    public void addHintMinesListener(ActionListener al) {
        showMinesButton.addActionListener(al);
    }

    public void addSafeCheckListener(ActionListener al) {
        safeMoveButton.addActionListener(al);
    }

    public void setSafeCheckEnable(final boolean safeCheckEnable) {
        safeMoveButton.setEnabled(safeCheckEnable);
    }

    public void setHintMineEnable(final boolean showMineEnable) {
        showMinesButton.setEnabled(showMineEnable);
    }

    public void updateFacePanel(boolean isWin, boolean isLose) {
        facePanel1.drawSaperFace(isWin, isLose);
    }

    public void updateFacePanel(boolean isPressed) {
        facePanel1.drawSaperFace(isPressed);
    }

    public void addCustomDialogExitListener(ActionListener al) {
        customDialog.addCancelButtonListener(al);
    }

    /**
     * Aktualizuje rozmiar planszy i okna
     *
     * @param h
     * @param w
     */
    public final void setSaperSize(int h, int w) {
        setSize(w * Constans.FIELD_SIZE + Constans.HORIZONTAL_MARGIN, h * Constans.FIELD_SIZE + Constans.VERTICAL_MARGIN);
        minesPanel1.setPreferredSize(new java.awt.Dimension(w * Constans.FIELD_SIZE, h * Constans.FIELD_SIZE));
    }

    /**
     * Aktualizuje plansze i Labele
     *
     * @param p
     */
    public void drawSaperPanel(MinesPack p) {
        flagsPanel1.setMarkedInfo(p.fieldsMarked, p.numbOfMines);
        minesPanel1.drawSaperFields(p);
    }

    public void updateSaperTime(int time) {
        timePanel1.setTimeInfo(time);
    }

    public void addMenuPauseListen(ActionListener al) {
        pauseGameButton.addActionListener(al);
        customButton.addActionListener(al);
    }

    public boolean playAgain(boolean isWin) {
        if (isWin) {
            endGameDialog.setMessage("Wygrana!");
        } else {
            endGameDialog.setMessage("Przegrana!");
        }
        endGameDialog.setVisible(true);
        return endGameDialog.getReturnStatus() == 1;
    }

    public boolean getDefuseDecision() {
        defuseDialog.setVisible(true);
        return defuseDialog.getReturnStatus() == 1;

    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        facePanel1 = new mines.view.panels.FacePanel();
        minesPanel1 = new mines.view.panels.MinesPanel();
        timePanel1 = new mines.view.panels.TimePanel();
        flagsPanel1 = new mines.view.panels.FlagsPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newGameButton = new javax.swing.JMenuItem();
        pauseGameButton = new javax.swing.JMenuItem();
        endGameButton = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        beginnerButton = new javax.swing.JRadioButtonMenuItem();
        mediumButton = new javax.swing.JRadioButtonMenuItem();
        expertButton = new javax.swing.JRadioButtonMenuItem();
        customButton = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        safeMoveButton = new javax.swing.JMenuItem();
        showMinesButton = new javax.swing.JMenuItem();
        oldStyleButton = new javax.swing.JRadioButtonMenuItem();
        modernButton = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout facePanel1Layout = new javax.swing.GroupLayout(facePanel1);
        facePanel1.setLayout(facePanel1Layout);
        facePanel1Layout.setHorizontalGroup(
            facePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );
        facePanel1Layout.setVerticalGroup(
            facePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        minesPanel1.setPreferredSize(new java.awt.Dimension(220, 220));

        javax.swing.GroupLayout minesPanel1Layout = new javax.swing.GroupLayout(minesPanel1);
        minesPanel1.setLayout(minesPanel1Layout);
        minesPanel1Layout.setHorizontalGroup(
            minesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );
        minesPanel1Layout.setVerticalGroup(
            minesPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        timePanel1.setPreferredSize(new java.awt.Dimension(39, 25));

        flagsPanel1.setMinimumSize(new java.awt.Dimension(50, 30));
        flagsPanel1.setPreferredSize(new java.awt.Dimension(36, 25));

        jMenu1.setText("Gra");

        newGameButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, 0));
        newGameButton.setText("Nowa gra");
        jMenu1.add(newGameButton);

        pauseGameButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        pauseGameButton.setText("Wstrzymaj");
        jMenu1.add(pauseGameButton);

        endGameButton.setText("Zakończ");
        jMenu1.add(endGameButton);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Tryb");

        buttonGroup1.add(beginnerButton);
        beginnerButton.setSelected(true);
        beginnerButton.setText("Łatwy");
        jMenu2.add(beginnerButton);

        buttonGroup1.add(mediumButton);
        mediumButton.setText("Średni");
        jMenu2.add(mediumButton);

        buttonGroup1.add(expertButton);
        expertButton.setText("Trudny");
        jMenu2.add(expertButton);

        customButton.setText("Własny");
        jMenu2.add(customButton);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Opcje");

        safeMoveButton.setText("Bezpieczny ruch");
        jMenu3.add(safeMoveButton);

        showMinesButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, 0));
        showMinesButton.setText("Pokaż miny");
        jMenu3.add(showMinesButton);

        buttonGroup2.add(oldStyleButton);
        oldStyleButton.setSelected(true);
        oldStyleButton.setText("Stary styl");
        jMenu3.add(oldStyleButton);

        buttonGroup2.add(modernButton);
        modernButton.setText("Nowoczesny styl");
        jMenu3.add(modernButton);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(minesPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(facePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(flagsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(facePanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(flagsPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(timePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(minesPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem beginnerButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JMenuItem customButton;
    private javax.swing.JMenuItem endGameButton;
    private javax.swing.JRadioButtonMenuItem expertButton;
    private mines.view.panels.FacePanel facePanel1;
    private mines.view.panels.FlagsPanel flagsPanel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JRadioButtonMenuItem mediumButton;
    private mines.view.panels.MinesPanel minesPanel1;
    private javax.swing.JRadioButtonMenuItem modernButton;
    private javax.swing.JMenuItem newGameButton;
    private javax.swing.JRadioButtonMenuItem oldStyleButton;
    private javax.swing.JMenuItem pauseGameButton;
    private javax.swing.JMenuItem safeMoveButton;
    private javax.swing.JMenuItem showMinesButton;
    private mines.view.panels.TimePanel timePanel1;
    // End of variables declaration//GEN-END:variables
    private final CustomDialog customDialog;
    private final EndGameDialog endGameDialog;
    private final DefuseDialog defuseDialog;
    private final StartGameDialog startGameDialog;

    private class FacePanelListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {
            fireNewBoardEvent(lastBoard);
            facePanel1.drawSaperFace(true);
            facePanel1.drawSaperFace(false,false);
        }

        public void mouseClicked(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent arg0) {
        }

        public void mouseReleased(MouseEvent e) {
            facePanel1.drawSaperFace(false);
            facePanel1.drawSaperFace(false,false);
        }
    }
}