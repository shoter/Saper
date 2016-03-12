
package saper01.view;

import java.awt.*;
import saper01.commons.Constans;
import saper01.commons.Pack;
//import javax.swing.*;

public class SaperPanel extends javax.swing.JPanel {

    private byte[][] tab;
    public SaperPanel() {
        tab=new byte[Constans.BEGINNER_H][Constans.BEGINNER_W];
        initComponents();
    }
    @Override
    public void paintComponent(Graphics g){
	super.paintComponent(g);
        int x,y;
        for(int i=0;i<=tab.length;i++){
            g.drawLine(0,i*Constans.FIELD_SIZE,Constans.FIELD_SIZE*tab[0].length,i*Constans.FIELD_SIZE);
        }
        for(int i=0;i<=tab[0].length;i++){
            g.drawLine(i*Constans.FIELD_SIZE,0,i*Constans.FIELD_SIZE,Constans.FIELD_SIZE*tab.length);
        }
        for(int i=0;i<tab.length;i++){
            for(int j=0;j<tab[i].length;j++){
                x=Constans.FIELD_SIZE/2+j*Constans.FIELD_SIZE;
                y=Constans.FIELD_SIZE/2+i*Constans.FIELD_SIZE;
                g.drawString(Byte.toString(tab[i][j]),x,y);
            }
        }
    }
    public void drawSaperFields(Pack p){
        tab=p.getTab();
        repaint();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(220, 220));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
