/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author gaspa
 */
public class PanelManager {
    JPanel MainPanel;
    public PanelManager(JPanel MainPanel){
        this.MainPanel = MainPanel;
    }
    public void cambiarPanel(JPanel nuevoPanel){
        MainPanel.setLayout(new BorderLayout());
        MainPanel.removeAll();
        MainPanel.add(nuevoPanel,BorderLayout.CENTER);
        MainPanel.revalidate();
        MainPanel.repaint();
    }
}
