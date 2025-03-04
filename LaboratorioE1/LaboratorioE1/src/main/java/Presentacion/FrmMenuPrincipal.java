/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import Negocio.IAnalisisDetalleNegocio;
import Negocio.IAnalisisNegocio;
import Negocio.ICategoriaNegocio;
import Negocio.IParametroNegocio;
import Negocio.IPruebaNegocio;
import Negocio.IClienteNegocio;
import Negocio.IPruebaNegocio;
import Negocio.IResultadoNegocio;
import Utilidades.PanelManager;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author gaspa
 */
public class FrmMenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenuPrincipal
     */
    private IClienteNegocio clienteNegocio;
    private IPruebaNegocio pruebaNegocio;
    private IAnalisisNegocio analisisNegocio;
    private IAnalisisDetalleNegocio analisisDetalleNegocio;
    private ICategoriaNegocio categoriaNegocio;
    private IParametroNegocio parametroNegocio;
    private IResultadoNegocio resultadoNegocio;
    private PanelManager panel;
    public FrmMenuPrincipal(IAnalisisNegocio analisisNegocio, IPruebaNegocio pruebaNegocio, 
            ICategoriaNegocio categoriaNegocio, IParametroNegocio parametroNegocio,
            IResultadoNegocio resultadoNegocio,IClienteNegocio clienteNegocio, IAnalisisDetalleNegocio analisisDetalleNegocio) {
    
        initComponents();
        this.panel = new PanelManager(MainPanel);
        this.analisisNegocio = analisisNegocio;
        this.pruebaNegocio = pruebaNegocio;
        this.categoriaNegocio = categoriaNegocio;
        this.parametroNegocio = parametroNegocio;
        this.resultadoNegocio = resultadoNegocio;
        this.analisisDetalleNegocio=analisisDetalleNegocio;
        this.clienteNegocio = clienteNegocio;
    }

    public JPanel getMainPanel() {
        return MainPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pruebasBTN = new javax.swing.JButton();
        clientesBTN = new javax.swing.JButton();
        resultadosBTN = new javax.swing.JButton();
        reportesBTN = new javax.swing.JButton();
        analisisBTN = new javax.swing.JButton();
        MainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backgroundPanel.setBackground(new java.awt.Color(222, 255, 255));
        backgroundPanel.setPreferredSize(new java.awt.Dimension(1920, 1080));

        jPanel3.setBackground(new java.awt.Color(102, 204, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 60)); // NOI18N
        jLabel2.setText("Menu Principal");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(952, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(235, 255, 255));

        pruebasBTN.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        pruebasBTN.setText("Pruebas");
        pruebasBTN.setToolTipText("");
        pruebasBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruebasBTNActionPerformed(evt);
            }
        });

        clientesBTN.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        clientesBTN.setText("Clientes");
        clientesBTN.setToolTipText("");
        clientesBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesBTNActionPerformed(evt);
            }
        });

        resultadosBTN.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        resultadosBTN.setText("Resultados");
        resultadosBTN.setToolTipText("");
        resultadosBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultadosBTNActionPerformed(evt);
            }
        });

        reportesBTN.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        reportesBTN.setText("Reportes");
        reportesBTN.setToolTipText("");

        analisisBTN.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 36)); // NOI18N
        analisisBTN.setText("Análisis");
        analisisBTN.setToolTipText("");
        analisisBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analisisBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pruebasBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(clientesBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(resultadosBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                    .addComponent(analisisBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reportesBTN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(clientesBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(pruebasBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(analisisBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addComponent(resultadosBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(reportesBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );

        MainPanel.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(backgroundPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1936, 1088));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clientesBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesBTNActionPerformed
        ListadoClientesPanel listadoClientesPanel = new ListadoClientesPanel(clienteNegocio, panel);
        panel.cambiarPanel(listadoClientesPanel);
    }//GEN-LAST:event_clientesBTNActionPerformed

    private void pruebasBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruebasBTNActionPerformed
        PruebaPanel pruebaPanel = new PruebaPanel(pruebaNegocio, categoriaNegocio, parametroNegocio);
        MainPanel.setLayout(new BorderLayout());
        MainPanel.removeAll();
        MainPanel.add(pruebaPanel, BorderLayout.CENTER);
        MainPanel.revalidate();
        MainPanel.repaint();
    }//GEN-LAST:event_pruebasBTNActionPerformed


        
                                            

    private void analisisBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analisisBTNActionPerformed
        AnalisisPanel analisisPanel = new AnalisisPanel(analisisNegocio, panel, clienteNegocio, pruebaNegocio,analisisDetalleNegocio);
        panel.cambiarPanel(analisisPanel);
    }//GEN-LAST:event_analisisBTNActionPerformed

    private void resultadosBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultadosBTNActionPerformed
        ResultadosPanel resultadosPanel = new ResultadosPanel(panel, analisisNegocio, resultadoNegocio,parametroNegocio,pruebaNegocio);
        panel.cambiarPanel(resultadosPanel);
    }//GEN-LAST:event_resultadosBTNActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MainPanel;
    private javax.swing.JButton analisisBTN;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton clientesBTN;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton pruebasBTN;
    private javax.swing.JButton reportesBTN;
    private javax.swing.JButton resultadosBTN;
    // End of variables declaration//GEN-END:variables
}
