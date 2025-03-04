 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion;

import DTOS.AnalisisDTO;
import DTOS.ClientesTablaDTO;
import DTOS.GuardarAnalisisDTO;
import DTOS.GuardarAnalisisDetalleDTO;
import DTOS.PruebaTablaDTO;
import Entidades.AnalisisLaboratorio;
import Entidades.Cliente;
import Entidades.PruebaLaboratorio;
import Negocio.IAnalisisDetalleNegocio;
import Negocio.IAnalisisNegocio;
import Negocio.IClienteNegocio;
import Negocio.IPruebaNegocio;
import Negocio.NegocioException;
import Utilidades.PanelManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gaspa
 */
public class AnalisisRegistroPanel extends javax.swing.JPanel {

    /**
     * Creates new form AnalisisRegistroPanel
     */
    private IAnalisisNegocio analisisNegocio;
    private IAnalisisDetalleNegocio analisisDetalleNegocio;
    private IClienteNegocio clienteNegocio;
    private IPruebaNegocio pruebaNegocio;
    private PanelManager panel;
    private List<Integer> pruebasSeleccionadas;
    public AnalisisRegistroPanel(IClienteNegocio clienteNegocio, IPruebaNegocio pruebaNegocio, IAnalisisNegocio analisisNegocio, PanelManager panel,IAnalisisDetalleNegocio analisisDetalleNegocio) {
        initComponents();
        this.clienteNegocio = clienteNegocio;
        this.pruebaNegocio = pruebaNegocio;
        this.analisisNegocio = analisisNegocio;
        this.pruebasSeleccionadas = new ArrayList<>();
        this.panel = panel;
        this.analisisDetalleNegocio=analisisDetalleNegocio;
        this.metodosIniciales();
    }
    private void metodosIniciales(){
        this.cargarClientes();
        this.cargarPruebas();
    }
    private void cargarClientes() {
        try {
            List<ClientesTablaDTO> clientes = clienteNegocio.buscarClientes();
            this.agregarRegistrosClientesTabla(clientes);
        } catch (NegocioException ex) {
            Logger.getLogger(AnalisisRegistroPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void agregarRegistrosClientesTabla(List<ClientesTablaDTO> clientesLista) {
        if (clientesLista == null) {
            return;
        }
        DefaultTableModel modeloTabla = (DefaultTableModel) this.TableClientes.getModel();
        clientesLista.forEach(row -> {
            Object[] fila = new Object[5];
            fila[0] = row.getId();
            fila[1] = row.getNombre();
            fila[2] = row.getApellidoPaterno();
            fila[3] = row.getApellidoMaterno();
            fila[4] = row.getFechaNacimiento();
            modeloTabla.addRow(fila);
        });
    }
    
    private void cargarPruebas() {
        try {
            List<PruebaTablaDTO> pruebas = pruebaNegocio.tablaPrueba();
            for (PruebaTablaDTO prueba : pruebas) {
                pruebaComboBox.addItem(prueba.getNombrePrueba());
            }
        } catch (NegocioException ex) {
            Logger.getLogger(AnalisisRegistroPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void agregarPrueba() {
        int selectedIndex = pruebaComboBox.getSelectedIndex();
        if (selectedIndex != -1) {
            pruebasSeleccionadas.add(selectedIndex + 1); // Asume que los IDs de pruebas son secuenciales
            parametrosVistaPreviaTxtArea.append(pruebaComboBox.getSelectedItem() + "\n");
        }
    }
    
    private void registrarAnalisis() throws NegocioException {
        int filaSeleccionada = TableClientes.getSelectedRow();
        if (filaSeleccionada == -1 || pruebasSeleccionadas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente y al menos una prueba.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idCliente = (int) TableClientes.getValueAt(filaSeleccionada, 0);
        GuardarAnalisisDTO nuevoAnalisis = new GuardarAnalisisDTO(idCliente, new Date());
        AnalisisDTO analisis = analisisNegocio.Guardar(nuevoAnalisis);

        if (analisis != null) {
            int idAnalisis = analisis.getIdAnalisis(); // Obtener el ID del análisis registrado

            for (Integer idPrueba : pruebasSeleccionadas) {
                GuardarAnalisisDetalleDTO detalle = new GuardarAnalisisDetalleDTO(idAnalisis, idPrueba);
                analisisDetalleNegocio.guardar(detalle); // Guardar cada prueba en AnalisisDetalle
            }

            JOptionPane.showMessageDialog(this, "Análisis y detalles registrados con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el análisis.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableClientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        filtroBusquedaTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buscarBTN = new javax.swing.JButton();
        pruebaComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        agregarPruebaBTN = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        parametrosVistaPreviaTxtArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        registrarBTN = new javax.swing.JButton();
        cancelarBTN = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1385, 897));

        TableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Fecha de Nacimiento"
            }
        ));
        jScrollPane1.setViewportView(TableClientes);

        jLabel1.setText("Seleccione al cliente");

        filtroBusquedaTextField.setColumns(50);

        jLabel2.setText("Filtro de Busqueda");

        buscarBTN.setText("Buscar");
        buscarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBTNActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccione la prueba");

        agregarPruebaBTN.setBackground(new java.awt.Color(0, 204, 255));
        agregarPruebaBTN.setText("+ Agregar prueba");
        agregarPruebaBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarPruebaBTNActionPerformed(evt);
            }
        });

        jLabel4.setText("*agregue al menos una prueba");

        parametrosVistaPreviaTxtArea.setColumns(20);
        parametrosVistaPreviaTxtArea.setRows(5);
        parametrosVistaPreviaTxtArea.setEnabled(false);
        jScrollPane2.setViewportView(parametrosVistaPreviaTxtArea);

        jLabel5.setText("Pruebas agregadas");

        registrarBTN.setBackground(new java.awt.Color(33, 161, 46));
        registrarBTN.setText("Registrar");
        registrarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBTNActionPerformed(evt);
            }
        });

        cancelarBTN.setBackground(new java.awt.Color(255, 204, 0));
        cancelarBTN.setText("Cancelar");
        cancelarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(321, 321, 321)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filtroBusquedaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buscarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(agregarPruebaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(pruebaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addComponent(cancelarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(258, 258, 258)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(registrarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(filtroBusquedaTextField)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(pruebaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(agregarPruebaBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cancelarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(registrarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1385, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 897, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBTNActionPerformed

    }//GEN-LAST:event_buscarBTNActionPerformed

    private void cancelarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBTNActionPerformed
        AnalisisPanel analisisPanel = new AnalisisPanel(analisisNegocio, panel, clienteNegocio, pruebaNegocio,analisisDetalleNegocio);
        panel.cambiarPanel(analisisPanel);
    }//GEN-LAST:event_cancelarBTNActionPerformed

    private void agregarPruebaBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarPruebaBTNActionPerformed
        this.agregarPrueba();
    }//GEN-LAST:event_agregarPruebaBTNActionPerformed

    private void registrarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBTNActionPerformed
        try {
            this.registrarAnalisis();
        } catch (NegocioException ex) {
            Logger.getLogger(ex.getMessage());
        }
    }//GEN-LAST:event_registrarBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableClientes;
    private javax.swing.JButton agregarPruebaBTN;
    private javax.swing.JButton buscarBTN;
    private javax.swing.JButton cancelarBTN;
    private javax.swing.JTextField filtroBusquedaTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea parametrosVistaPreviaTxtArea;
    private javax.swing.JComboBox<String> pruebaComboBox;
    private javax.swing.JButton registrarBTN;
    // End of variables declaration//GEN-END:variables
}
