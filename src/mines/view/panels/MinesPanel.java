/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines.view.panels;

import java.awt.Graphics;
import mines.commons.Constans;
import mines.commons.MinesPack;
import mines.view.ImgFieldLoader;

/**
 *
 * @author wojciech
 */
public class MinesPanel extends javax.swing.JPanel {

    private byte[][] tab;
    private final ImgFieldLoader imgLoad;

    /**
     * Creates new form MinesPanel
     */
    public MinesPanel() {
        tab = new byte[Constans.BEGINNER_H][Constans.BEGINNER_W];
        for(int i=0;i<tab.length;i++){
            for(int j=0;j<tab[i].length;j++)
                tab[i][j]=9;
        }
        initComponents();
        imgLoad = new ImgFieldLoader();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x, y;
        for (int i = 0; i <= tab.length; i++) {
            g.drawLine(0, i * Constans.FIELD_SIZE, Constans.FIELD_SIZE * tab[0].length, i * Constans.FIELD_SIZE);
        }
        for (int i = 0; i <= tab[0].length; i++) {
            g.drawLine(i * Constans.FIELD_SIZE, 0, i * Constans.FIELD_SIZE, Constans.FIELD_SIZE * tab.length);
        }
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                x = j * Constans.FIELD_SIZE;
                y = i * Constans.FIELD_SIZE;
                g.drawImage(imgLoad.getImage(tab[i][j]), x, y, this);
            }
        }
    }

    public void drawSaperFields(MinesPack p) {
        tab = p.tab;
        repaint();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(220, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
