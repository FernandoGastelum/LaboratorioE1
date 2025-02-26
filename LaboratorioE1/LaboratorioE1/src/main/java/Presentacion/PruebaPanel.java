/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion;

import DTOS.PruebaTablaDTO;
import Negocio.IAnalisisNegocio;
import Negocio.ICategoriaNegocio;
import Negocio.IParametroNegocio;
import Negocio.IPruebaNegocio;
import Negocio.NegocioException;
import Utilidades.JButtonCellEditor;
import Utilidades.JButtonRenderer;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Knocmare
 */
public class PruebaPanel extends javax.swing.JPanel {

    private IPruebaNegocio pruebaNegocio;
    private ICategoriaNegocio categoriaNegocio;
    private IParametroNegocio parametroNegocio;
    private IAnalisisNegocio analisisNegocio;// No esta inicializada

    public PruebaPanel(IPruebaNegocio pruebaNegocio, ICategoriaNegocio categoriaNegocio, IParametroNegocio parametroNegocio) {
        initComponents();
        this.pruebaNegocio = pruebaNegocio;
        this.categoriaNegocio = categoriaNegocio;
        this.parametroNegocio = parametroNegocio;
        this.metodosIniciales();
    }

    private void metodosIniciales() {
        this.cargarConfiguracionInicialTabla();
        this.buscarPruebasParaTabla();
    }

    private void cargarConfiguracionInicialTabla() {
        ActionListener onEditarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Metodo para editar
                    editarPrueba();
                } catch (NegocioException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };
        int indiceColumnaEditar = 3;
        TableColumnModel modeloColumnas = this.tblPruebas.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Editar", onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Metodo para eliminar
                    eliminarPrueba();
                } catch (NegocioException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };
        int indiceColumnaEliminar = 4;
        modeloColumnas = this.tblPruebas.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    private void buscarPruebasParaTabla() {
        try {
            List<PruebaTablaDTO> pruebasTablaLista = this.pruebaNegocio.tablaPrueba();
            this.agregarRegistrosTabla(pruebasTablaLista);
        } catch (NegocioException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void agregarRegistrosTabla(List<PruebaTablaDTO> pruebasLista) {
        if (pruebasLista == null) {
            return;
        }

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblPruebas.getModel();
        modeloTabla.setRowCount(0); // Limpia la tabla antes de agregar nuevos datos

        pruebasLista.forEach(row -> {
            Object[] fila = new Object[3];
            fila[0] = row.getCategoria() != null ? row.getCategoria() : "Sin Categoría"; // Evita valores nulos
            fila[1] = row.getNombrePrueba();
            fila[2] = row.getNombreParametro() != null ? row.getNombreParametro() : "Sin Parámetro"; // Evita valores nulos

            modeloTabla.addRow(fila);
        });
    }

    private int getIdSeleccionadoTabla() {
        int indiceFilaSeleccionada = this.tblPruebas.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblPruebas.getModel();
            int indiceColumnaId = 0;
            int idSocioSeleccionado = (int) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idSocioSeleccionado;
        } else {
            return 0;
        }
    }

    private void editarPrueba() throws NegocioException {
        int id = this.getIdSeleccionadoTabla();
        pruebaNegocio.buscarID(id);
        PruebaEntidadPanel insPruebaEntidadPanel = new PruebaEntidadPanel(pruebaNegocio, categoriaNegocio, parametroNegocio);
        insPruebaEntidadPanel.setVisible(true);
    }

    private void eliminarPrueba() throws NegocioException {
        int id = this.getIdSeleccionadoTabla();
        this.pruebaNegocio.eliminarPrueba(id);
    }

    private void abrirPruebaEntidad() {
        // Obtener el JFrame padre (FrmMenuPrincipal)
        java.awt.Container parent = this.getParent();
        while (parent != null && !(parent instanceof FrmMenuPrincipal)) {
            parent = parent.getParent();
        }

        if (parent != null) {
            FrmMenuPrincipal menuPrincipal = (FrmMenuPrincipal) parent;
            PruebaEntidadPanel insPruebaEntidadPanel = new PruebaEntidadPanel(pruebaNegocio, categoriaNegocio, parametroNegocio);

            // Cambiar el contenido de MainPanel en FrmMenuPrincipal
            menuPrincipal.getMainPanel().removeAll();
            menuPrincipal.getMainPanel().setLayout(new BorderLayout());
            menuPrincipal.getMainPanel().add(insPruebaEntidadPanel, BorderLayout.CENTER);
            menuPrincipal.getMainPanel().revalidate();
            menuPrincipal.getMainPanel().repaint();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblPruebas = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        buscarBTN = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));
        setPreferredSize(new java.awt.Dimension(1385, 897));

        tblPruebas.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 12)); // NOI18N
        tblPruebas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoria", "Nombre de la Prueba", "Parámetro", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblPruebas);

        btnNuevo.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel2.setText("Filtro de Busqueda");

        buscarBTN.setBackground(new java.awt.Color(51, 153, 255));
        buscarBTN.setText("Buscar");
        buscarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBTNActionPerformed(evt);
            }
        });

        jTextField1.setColumns(50);

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel1.setText("Pruebas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(317, 317, 317))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscarBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        abrirPruebaEntidad();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void buscarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBTNActionPerformed

    }//GEN-LAST:event_buscarBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton buscarBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblPruebas;
    // End of variables declaration//GEN-END:variables
}
