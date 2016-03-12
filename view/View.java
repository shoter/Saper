package saper01.view;

import java.awt.event.*;
import saper01.commons.Constans;
import saper01.commons.Pack;
import javax.swing.JOptionPane;


public class View extends javax.swing.JFrame {

    public View() {
        initComponents();
    }
    public void addPanelListener(MouseListener ml){
	panel.addMouseListener(ml);
    }
    public void addMenuNewListener(ActionListener al){
        menuNew.addActionListener(al);
    }
    public void addMenuRestartListener(ActionListener al){
        menuRestart.addActionListener(al);
    }
    public void addMenuExitListener(ActionListener al){
        menuExit.addActionListener(al);
    }
    public void addMenuRadioBeginner(ActionListener al){
        menuRadioBeginner.addActionListener(al);
    }
    public void addMenuRadioInter(ActionListener al){
        menuRadioInter.addActionListener(al);
    }
    public void addMenuRadioExpert(ActionListener al){
        menuRadioExpert.addActionListener(al);
    }
    public void setSaperSize(final int h,final int w){
        setSize(w*Constans.FIELD_SIZE+Constans.HORIZONTAL_MARGIN,h*Constans.FIELD_SIZE+Constans.VERTICAL_MARGIN);
        panel.setPreferredSize(new java.awt.Dimension(w*Constans.FIELD_SIZE,h*Constans.FIELD_SIZE));
    }
    public void drawSaperPanel(Pack p){
        panel.drawSaperFields(p);
    }
    public void setTimeLabel(String str){
        timeLabel.setText(str);
    }
    public void setMarkLabel(String str){
        markLabel.setText(str);
    }
    public void addMenuPauseListen(ActionListener al){
        menuPause.addActionListener(al);
    }
    public void showWinMsg(){
        JOptionPane.showMessageDialog(null, "COMPLETED!","",JOptionPane.INFORMATION_MESSAGE);
    }
    public void showLoseMsg(){
        JOptionPane.showMessageDialog(null, "DEAD!","",JOptionPane.ERROR_MESSAGE);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel = new saper01.view.SaperPanel();
        timeLabel = new javax.swing.JLabel();
        markLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuNew = new javax.swing.JMenuItem();
        menuRestart = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuPause = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuRadioBeginner = new javax.swing.JRadioButtonMenuItem();
        menuRadioInter = new javax.swing.JRadioButtonMenuItem();
        menuRadioExpert = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );

        timeLabel.setText("[0:00]");

        markLabel.setText("0/10 Marked");

        jMenu1.setText("Game");

        menuNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, 0));
        menuNew.setText("New");
        menuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNewActionPerformed(evt);
            }
        });
        jMenu1.add(menuNew);

        menuRestart.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
        menuRestart.setText("Restart");
        jMenu1.add(menuRestart);
        jMenu1.add(jSeparator2);

        menuPause.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        menuPause.setText("Pause");
        jMenu1.add(menuPause);
        jMenu1.add(jSeparator1);

        menuExit.setText("Exit");
        jMenu1.add(menuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Type");

        buttonGroup1.add(menuRadioBeginner);
        menuRadioBeginner.setSelected(true);
        menuRadioBeginner.setText("Beginner");
        menuRadioBeginner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRadioBeginnerActionPerformed(evt);
            }
        });
        jMenu2.add(menuRadioBeginner);

        buttonGroup1.add(menuRadioInter);
        menuRadioInter.setText("Intermediate");
        jMenu2.add(menuRadioInter);

        buttonGroup1.add(menuRadioExpert);
        menuRadioExpert.setText("Expert");
        menuRadioExpert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRadioExpertActionPerformed(evt);
            }
        });
        jMenu2.add(menuRadioExpert);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(markLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeLabel)
                    .addComponent(markLabel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void menuRadioExpertActionPerformed(ActionEvent evt){}
    void menuNewActionPerformed(ActionEvent evt){}
    void menuRadioBeginnerActionPerformed(ActionEvent evt){}

    private Pack p;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel markLabel;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuNew;
    private javax.swing.JMenuItem menuPause;
    private javax.swing.JRadioButtonMenuItem menuRadioBeginner;
    private javax.swing.JRadioButtonMenuItem menuRadioExpert;
    private javax.swing.JRadioButtonMenuItem menuRadioInter;
    private javax.swing.JMenuItem menuRestart;
    private saper01.view.SaperPanel panel;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}
