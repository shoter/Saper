/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mines.view.panels;

import java.awt.Graphics;
import mines.commons.Constans;
import mines.view.ImgNumberLoader;

/**
 *
 * @author wojciech
 */
public class FlagsPanel extends javax.swing.JPanel {

    private final ImgNumberLoader loader;
    private int leftToMark;
    
    /**
     * Creates new form FlagsPanel
     */
    
    
    public FlagsPanel() {
        loader=new ImgNumberLoader();
        initComponents();
    }

    public void setMarkedInfo(int marked,int max){
        this.leftToMark=max-marked;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(loader.getImage((leftToMark/1000)%10), 0, 0, this);
        g.drawImage(loader.getImage((leftToMark/100)%10),Constans.NUMBER_WIDTH, 0, this);
        g.drawImage(loader.getImage((leftToMark/10)%10), Constans.NUMBER_WIDTH*2, 0, this);
        g.drawImage(loader.getImage((leftToMark)%10), Constans.NUMBER_WIDTH*3, 0, this);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(60, 30));
        setPreferredSize(new java.awt.Dimension(60, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
