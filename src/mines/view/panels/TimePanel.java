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
public class TimePanel extends javax.swing.JPanel {

    private ImgNumberLoader loader;
    private int second;
    
    public TimePanel() {
        loader=new ImgNumberLoader();
        initComponents();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(loader.getImage(((second-second%60)/60)%10), 0, 0, this);
        g.drawImage(loader.getImage(((second-second%60)/60)/10), Constans.NUMBER_WIDTH, 0, this);
        g.drawImage(loader.getImage(10),Constans.NUMBER_WIDTH*2 , 0, this);
        g.drawImage(loader.getImage(((second-second%10)/10)%6),Constans.NUMBER_WIDTH/3+Constans.NUMBER_WIDTH*2, 0, this);
        g.drawImage(loader.getImage(second%10),Constans.NUMBER_WIDTH/3+Constans.NUMBER_WIDTH*3, 0, this);
    }
    
    public void setTimeInfo(int second){
        this.second=second;
        repaint();
        //timeLabel.setText("[" + (second / 60) + ":" + (second % 60 < 10 ? "0" : "") + (second % 60) + "]");
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setMinimumSize(new java.awt.Dimension(50, 30));
        setPreferredSize(new java.awt.Dimension(50, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
