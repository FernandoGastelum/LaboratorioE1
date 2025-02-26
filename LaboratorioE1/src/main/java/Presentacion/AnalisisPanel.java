/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion;

import DTOS.AnalisisTablaDTO;
import Negocio.IAnalisisDetalleNegocio;
import Negocio.IAnalisisNegocio;
import Negocio.IClienteNegocio;
import Negocio.IPruebaNegocio;
import Negocio.NegocioException;
import Utilidades.JButtonCellEditor;
import Utilidades.JButtonRenderer;
import Utilidades.PanelManager;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author gaspa
 */
public class AnalisisPanel extends javax.swing.JPanel {
    
    /**
     * Creates new form AnalisisPanel
     */
    private IAnalisisDetalleNegocio analisisDetalleNegocio;
    private IClienteNegocio clienteNegocio;
    private IPruebaNegocio pruebaNegocio;
    private IAnalisisNegocio analisisNegocio;
    private PanelManager panel;
    public AnalisisPanel(IAnalisisNegocio analisisNegocio, PanelManager panel,IClienteNegocio clienteNegocio, IPruebaNegocio pruebaNegocio,IAnalisisDetalleNegocio analisisDetalleNegocio) {
        initComponents();
        this.analisisNegocio = analisisNegocio;
        this.panel=panel;
        this.clienteNegocio = clienteNegocio;
        this.pruebaNegocio = pruebaNegocio;
        this.analisisDetalleNegocio=analisisDetalleNegocio;
        this.metodosIniciales();
        
    }
    private void metodosIniciales(){
        this.limpiarTabla();
        this.cargarConfiguracionInicialTabla();
        this.buscarAnalisisParaTabla();
    }
    private void cargarConfiguracionInicialTabla() {
        ActionListener onEditarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para editar
                editar();
            }
        };
        int indiceColumnaEditar = 3;
        TableColumnModel modeloColumnas = this.TableAnalisis.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Editar", onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para eliminar
                eliminar();
            }
        };
        int indiceColumnaEliminar = 4;
        modeloColumnas = this.TableAnalisis.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }
    private int getIdSeleccionadoTabla() {
        int indiceFilaSeleccionada = this.TableAnalisis.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.TableAnalisis.getModel();
            int indiceColumnaId = 0;
            int idSocioSeleccionado = (int) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idSocioSeleccionado;
        } else {
            return 0;
        }
    }

    private void editar() {
        int id = this.getIdSeleccionadoTabla();
        System.out.println("El id que se va a editar es " + id);
        //frmClientes ventanaClientes = new frmClientes("Editar",id,this.alumnoNegocio);
        //ventanaClientes.setVisible(true);
    }

    private void eliminar() {
        int id = this.getIdSeleccionadoTabla();
        System.out.println("El id que se va a eliminar es " + id);
        int opcion = JOptionPane.showConfirmDialog(
            null,
            "¿Deseas eliminar el analisis con ID:"+id+"?",
            "Confirmación",
            JOptionPane.YES_NO_OPTION
        );
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                this.analisisNegocio.Eliminar(id);
            } catch (NegocioException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            
        }
    }

    private void buscarAnalisisParaTabla() {
        try {
            List<AnalisisTablaDTO> analisisTablaLista = this.analisisNegocio.listarAnalisis();
            this.agregarRegistrosTabla(analisisTablaLista);
        } catch (NegocioException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void limpiarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.TableAnalisis.getModel();
        modeloTabla.setRowCount(0); // Elimina todas las filas de la tabla
    }
    
    private void agregarRegistrosTabla(List<AnalisisTablaDTO> analisisLista) {
        if (analisisLista == null) {
            return;
        }
        DefaultTableModel modeloTabla = (DefaultTableModel) this.TableAnalisis.getModel();
        analisisLista.forEach(row -> {
            Object[] fila = new Object[3];
            fila[0] = row.getIdAnalisis();
            fila[1] = row.getNombreCliente();
            fila[2] = row.getPruebasAsociadas();

            modeloTabla.addRow(fila);
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableAnalisis = new javax.swing.JTable();
        nuevoBTN = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buscarBTN = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(1385, 897));

        TableAnalisis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Cliente", "Pruebas", "Editar", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(TableAnalisis);

        nuevoBTN.setText("Nuevo Analisis");
        nuevoBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBTNActionPerformed(evt);
            }
        });

        jLabel1.setText("Analisis");

        jTextField1.setColumns(50);

        jLabel2.setText("Filtro de Busqueda");

        buscarBTN.setText("Buscar");
        buscarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nuevoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(384, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nuevoBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBTNActionPerformed
    
    }//GEN-LAST:event_buscarBTNActionPerformed

    private void nuevoBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoBTNActionPerformed
        AnalisisRegistroPanel analisisRegistro = new AnalisisRegistroPanel(clienteNegocio, pruebaNegocio, analisisNegocio, panel,analisisDetalleNegocio);
        panel.cambiarPanel(analisisRegistro);
    }//GEN-LAST:event_nuevoBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableAnalisis;
    private javax.swing.JButton buscarBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton nuevoBTN;
    // End of variables declaration//GEN-END:variables
}
