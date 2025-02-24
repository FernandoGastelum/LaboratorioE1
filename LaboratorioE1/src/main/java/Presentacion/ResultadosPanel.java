/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion;

import DTOS.AnalisisTablaDTO;
import Negocio.IAnalisisNegocio;
import Negocio.NegocioException;
import Utilidades.JButtonCellEditor;
import Utilidades.JButtonRenderer;
import Utilidades.PanelManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Ilian Fernando Gastelum Romo 228761
 */

public class ResultadosPanel extends javax.swing.JPanel {

    /**
     * Creates new form ResultadosPanel
     */
    private IAnalisisNegocio analisisNegocio;
    private PanelManager panel;
    public ResultadosPanel(PanelManager panel,IAnalisisNegocio analisisNegocio) {
        initComponents();
        this.panel=panel;
        this.analisisNegocio = analisisNegocio;
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
        int indiceColumnaEditar = 4;
        TableColumnModel modeloColumnas = this.TablaAnalisis.getColumnModel();
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
        int indiceColumnaEliminar = 5;
        modeloColumnas = this.TablaAnalisis.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }
    private void editar() {
        int id = this.getIdSeleccionadoTabla();
        System.out.println("El id que se va a editar es " + id);
        ResultadosCapturaPanel panelCapturaResultados = new ResultadosCapturaPanel(panel, analisisNegocio);
        panel.cambiarPanel(panelCapturaResultados);
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
    private int getIdSeleccionadoTabla() {
        int indiceFilaSeleccionada = this.TablaAnalisis.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.TablaAnalisis.getModel();
            int indiceColumnaId = 0;
            int idSocioSeleccionado = (int) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idSocioSeleccionado;
        } else {
            return 0;
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
    private void agregarRegistrosTabla(List<AnalisisTablaDTO> analisisLista) {
        if (analisisLista == null) {
            return;
        }
        DefaultTableModel modeloTabla = (DefaultTableModel) this.TablaAnalisis.getModel();
        modeloTabla.setRowCount(0); // Limpiar tabla antes de agregar nuevos registros

        for (AnalisisTablaDTO row : analisisLista) {
            boolean capturado = verificarSiResultadosCapturados(row.getIdAnalisis());

            Object[] fila = new Object[4];
            fila[0] = row.getIdAnalisis();
            fila[1] = row.getNombreCliente();
            fila[2] = row.getPruebasAsociadas();
            fila[3] = capturado ? "Sí" : "No"; // Mostrar si está capturado o no

            modeloTabla.addRow(fila);
        }
    }
    private void limpiarTabla() {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.TablaAnalisis.getModel();
        modeloTabla.setRowCount(0); // Elimina todas las filas de la tabla
    }
    private boolean verificarSiResultadosCapturados(int idAnalisis) {
        try {
            return analisisNegocio.analisisTieneResultados(idAnalisis);
        } catch (NegocioException ex) {
            System.out.println("Error al verificar resultados: " + ex.getMessage());
            return false;
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

        jLabel1 = new javax.swing.JLabel();
        filtroTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaAnalisis = new javax.swing.JTable();

        setBackground(new java.awt.Color(204, 255, 255));
        setMaximumSize(new java.awt.Dimension(1385, 897));
        setMinimumSize(new java.awt.Dimension(1385, 897));
        setPreferredSize(new java.awt.Dimension(1385, 897));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Ingrese el folio");

        filtroTextField.setColumns(50);
        filtroTextField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("Buscar");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Seleccione el análisis");

        TablaAnalisis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Nombre Cliente", "Pruebas", "Capturado", "Capturar", "Eliminar Captura"
            }
        ));
        jScrollPane1.setViewportView(TablaAnalisis);

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filtroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addGap(0, 699, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(filtroTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(299, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaAnalisis;
    private javax.swing.JTextField filtroTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
