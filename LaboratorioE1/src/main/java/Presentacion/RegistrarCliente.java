/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

/**
 *
 * @author paula
 */
public class RegistrarCliente extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarCliente
     */
    public RegistrarCliente() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGrande = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabellogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelNombreClientes = new javax.swing.JLabel();
        jLabelApellidoPaternoCliente = new javax.swing.JLabel();
        jLabelApellidoMaternoCliente = new javax.swing.JLabel();
        jLabelFechaNacimientoCliente = new javax.swing.JLabel();
        jButtonCancelarRegistroCliente = new javax.swing.JButton();
        jButtonRegistrarCliente = new javax.swing.JButton();
        jTextFieldNombresCliente = new javax.swing.JTextField();
        jTextFieldApellidoPaternoCliente = new javax.swing.JTextField();
        jTextFieldFechaNacimientoCliente = new javax.swing.JTextField();
        jTextFieldApellidoMaternoCliente = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelGrande.setBackground(new java.awt.Color(102, 204, 255));

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabellogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elBueno.png"))); // NOI18N

        jLabel1.setBackground(new java.awt.Color(153, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 60)); // NOI18N
        jLabel1.setText("REGISTRAR CLIENTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabellogo, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabellogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
        );

        jLabelNombreClientes.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelNombreClientes.setText("Nombres:");

        jLabelApellidoPaternoCliente.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelApellidoPaternoCliente.setText("Apellido Paterno:");

        jLabelApellidoMaternoCliente.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelApellidoMaternoCliente.setText("Apellido Materno:");

        jLabelFechaNacimientoCliente.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabelFechaNacimientoCliente.setText("Fecha de Nacimiento:");

        jButtonCancelarRegistroCliente.setBackground(new java.awt.Color(255, 102, 51));
        jButtonCancelarRegistroCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCancelarRegistroCliente.setText("Cancelar");
        jButtonCancelarRegistroCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonCancelarRegistroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarRegistroClienteActionPerformed(evt);
            }
        });

        jButtonRegistrarCliente.setBackground(new java.awt.Color(51, 153, 0));
        jButtonRegistrarCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonRegistrarCliente.setText("Registrar");
        jButtonRegistrarCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTextFieldNombresCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombresClienteActionPerformed(evt);
            }
        });

        jTextFieldApellidoPaternoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoPaternoClienteActionPerformed(evt);
            }
        });

        jTextFieldApellidoMaternoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldApellidoMaternoClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGrandeLayout = new javax.swing.GroupLayout(jPanelGrande);
        jPanelGrande.setLayout(jPanelGrandeLayout);
        jPanelGrandeLayout.setHorizontalGroup(
            jPanelGrandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGrandeLayout.createSequentialGroup()
                .addGap(362, 362, 362)
                .addGroup(jPanelGrandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldFechaNacimientoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(jLabelNombreClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechaNacimientoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNombresCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelGrandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelApellidoPaternoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellidoMaternoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldApellidoPaternoCliente)
                    .addComponent(jTextFieldApellidoMaternoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                .addGap(107, 107, 107))
            .addGroup(jPanelGrandeLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButtonCancelarRegistroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelGrandeLayout.setVerticalGroup(
            jPanelGrandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGrandeLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165)
                .addGroup(jPanelGrandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNombreClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellidoPaternoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanelGrandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNombresCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jTextFieldApellidoPaternoCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanelGrandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaNacimientoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellidoMaternoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanelGrandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldFechaNacimientoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(jTextFieldApellidoMaternoCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 267, Short.MAX_VALUE)
                .addGroup(jPanelGrandeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelarRegistroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegistrarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1377, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelGrande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelGrande, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarRegistroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarRegistroClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarRegistroClienteActionPerformed

    private void jTextFieldNombresClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombresClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombresClienteActionPerformed

    private void jTextFieldApellidoPaternoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoPaternoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoPaternoClienteActionPerformed

    private void jTextFieldApellidoMaternoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldApellidoMaternoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldApellidoMaternoClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelarRegistroCliente;
    private javax.swing.JButton jButtonRegistrarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelApellidoMaternoCliente;
    private javax.swing.JLabel jLabelApellidoPaternoCliente;
    private javax.swing.JLabel jLabelFechaNacimientoCliente;
    private javax.swing.JLabel jLabelNombreClientes;
    private javax.swing.JLabel jLabellogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelGrande;
    private javax.swing.JTextField jTextFieldApellidoMaternoCliente;
    private javax.swing.JTextField jTextFieldApellidoPaternoCliente;
    private javax.swing.JTextField jTextFieldFechaNacimientoCliente;
    private javax.swing.JTextField jTextFieldNombresCliente;
    // End of variables declaration//GEN-END:variables
}
