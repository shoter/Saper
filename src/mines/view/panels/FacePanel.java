/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines.view.panels;

import java.awt.Graphics;
import mines.view.ImgFacesLoader;

/**
 *
 * @author wojciech
 */
public class FacePanel extends javax.swing.JPanel {

    private final ImgFacesLoader imgFace;
    private int img;
    private boolean isOldStyle = true;
    private boolean isPressed = false;

    public FacePanel() {
        initComponents();
        imgFace = new ImgFacesLoader();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgFace.getImage(img), 0, 0, this);
    }

    public void drawSaperFace(boolean isWin, boolean isLose) {
        this.img = isOldStyle ? 0 : 4;
        if (isPressed == false) {
            if (isWin == true && isLose == false) {
                this.img += 2;
            } else if (isWin == false && isLose == true) {
                this.img += 1;
            }
        } else if(isWin!=true&&isLose!=true){
                this.img += 3;
        }
        repaint();
    }

    public void drawSaperFace(boolean isPressed) {
        this.isPressed = isPressed;
        repaint();
    }

    public void changeStyle(boolean isOldStyle) {
        this.isOldStyle = isOldStyle;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
