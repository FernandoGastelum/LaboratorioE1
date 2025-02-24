/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion;

import DTOS.CategoriaDTO;
import DTOS.CategoriaTablaDTO;
import DTOS.ParametroDTO;
import DTOS.ParametroTablaDTO;
import DTOS.PruebaDTO;
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
public class PruebaEntidadPanel extends javax.swing.JPanel {

    private IPruebaNegocio pruebaNegocio;
    private ICategoriaNegocio categoriaNegocio;
    private IParametroNegocio parametroNegocio;

    public PruebaEntidadPanel(IPruebaNegocio pruebaNegocio, ICategoriaNegocio categoriaNegocio, IParametroNegocio parametroNegocio) {
        initComponents();
        this.pruebaNegocio = pruebaNegocio;
        this.categoriaNegocio = categoriaNegocio;
        this.parametroNegocio = parametroNegocio;
        this.metodosIniciales();
    }

    private void metodosIniciales() {
        this.cargarConfiguracionInicialTablaCategoria();
        this.buscarCategoriasParaTabla();
        this.cargarConfiguracionInicialTablaParametro();
        this.buscarParametrosParaTabla();
    }

    // Categoria
    private void cargarConfiguracionInicialTablaCategoria() {
        ActionListener onSeleccionarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarCategoria();
            }
        };
        int indiceColumnaSeleccionar = 1;
        TableColumnModel modeloColumnas = this.tblCategorias.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaSeleccionar)
                .setCellRenderer(new JButtonRenderer("Seleccionar"));
        modeloColumnas.getColumn(indiceColumnaSeleccionar)
                .setCellEditor(new JButtonCellEditor("Seleccionar", onSeleccionarClickListener));

        ActionListener onEditarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para editar
                editarCategoria();
            }
        };
        int indiceColumnaEditar = 2;
        modeloColumnas = this.tblCategorias.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Editar", onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para eliminar
                eliminarCategoria();
            }
        };
        int indiceColumnaEliminar = 3;
        modeloColumnas = this.tblCategorias.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    private void buscarCategoriasParaTabla() {
        try {
            List<CategoriaTablaDTO> categoriasTablaLista = this.categoriaNegocio.tablaCategorias();
            this.agregarRegistrosCategoriasTabla(categoriasTablaLista);
        } catch (NegocioException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void agregarRegistrosCategoriasTabla(List<CategoriaTablaDTO> categoriasLista) {
        if (categoriasLista == null) {
            return;
        }

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblCategorias.getModel();
        modeloTabla.setRowCount(0); // Limpia la tabla antes de agregar nuevos datos

        categoriasLista.forEach(row -> {
            Object[] fila = new Object[1];
            fila[0] = row.getNombreCategoria();

            modeloTabla.addRow(fila);
        });
    }

    private int getIdSeleccionadoTablaCategoria() {
        int indiceFilaSeleccionada = this.tblCategorias.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblCategorias.getModel();
            int indiceColumnaId = 0;
            int idSocioSeleccionado = (int) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idSocioSeleccionado;
        } else {
            return 0;
        }
    }

    private void seleccionarCategoria() {
        int indiceFilaSeleccionada = this.tblCategorias.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblCategorias.getModel();
            int indiceColumnaNombre = 0;
            String nombreCategoria = (String) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaNombre);

            txtCategoria.setText(nombreCategoria);
        } else {
            System.out.println("No se ha seleccionado ninguna categoría.");
        }
    }

    private void editarCategoria() {
        int id = this.getIdSeleccionadoTablaCategoria();
        System.out.println("El id que se va a editar es " + id);
        //this.pruebaNegocio.editarPrueba(id, prueba);
    }

    private void eliminarCategoria() {
        int id = this.getIdSeleccionadoTablaCategoria();
        System.out.println("El id que se va a eliminar es " + id);
    }

    // Parametro
    private void cargarConfiguracionInicialTablaParametro() {
        ActionListener onSeleccionarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccionarParametro();
            }
        };
        int indiceColumnaSeleccionar = 1;
        TableColumnModel modeloColumnas = this.tblParametros.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaSeleccionar)
                .setCellRenderer(new JButtonRenderer("Seleccionar"));
        modeloColumnas.getColumn(indiceColumnaSeleccionar)
                .setCellEditor(new JButtonCellEditor("Seleccionar", onSeleccionarClickListener));

        ActionListener onEditarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para editar
                editarCategoria();
            }
        };
        int indiceColumnaEditar = 2;
        modeloColumnas = this.tblParametros.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Editar", onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para eliminar
                eliminarCategoria();
            }
        };
        int indiceColumnaEliminar = 3;
        modeloColumnas = this.tblParametros.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    private void buscarParametrosParaTabla() {
        try {
            List<ParametroTablaDTO> parametrosTablaLista = this.parametroNegocio.tablaParametros();
            this.agregarRegistrosParametrosTabla(parametrosTablaLista);
        } catch (NegocioException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void agregarRegistrosParametrosTabla(List<ParametroTablaDTO> parametrosLista) {
        if (parametrosLista == null) {
            return;
        }

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblParametros.getModel();
        modeloTabla.setRowCount(0); // Limpia la tabla antes de agregar nuevos datos

        parametrosLista.forEach(row -> {
            Object[] fila = new Object[1];
            fila[0] = row.getNombreParametro();

            modeloTabla.addRow(fila);
        });
    }

    private int getIdSeleccionadoTablaParametro() {
        int indiceFilaSeleccionada = this.tblParametros.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblParametros.getModel();
            int indiceColumnaId = 0;
            int idSocioSeleccionado = (int) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idSocioSeleccionado;
        } else {
            return 0;
        }
    }

    private void seleccionarParametro() {
        int indiceFilaSeleccionada = this.tblParametros.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblParametros.getModel();
            int indiceColumnaNombre = 0;
            String nombreParametro = (String) modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaNombre);
            
            txtAreaParametros.append(nombreParametro + "\n");
        } else {
            System.out.println("No se ha seleccionado ningún parámetro.");
        }
    }

    private void editarParametro() {
        int id = this.getIdSeleccionadoTablaParametro();
        System.out.println("El id que se va a editar es " + id);
        //this.pruebaNegocio.editarPrueba(id, prueba);
    }

    private void eliminarParametro() {
        int id = this.getIdSeleccionadoTablaParametro();
        System.out.println("El id que se va a eliminar es " + id);
    }
    
    // Paneles
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

        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaParametros = new javax.swing.JTextArea();
        txtNombrePrueba = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParametros = new javax.swing.JTable();
        btnCategoria = new javax.swing.JButton();
        btnParametro = new javax.swing.JButton();
        txtCategoria = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 255));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel3.setText("Elige los parámetro");

        txtAreaParametros.setEditable(false);
        txtAreaParametros.setColumns(20);
        txtAreaParametros.setRows(5);
        jScrollPane2.setViewportView(txtAreaParametros);

        txtNombrePrueba.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel4.setText("Elige la categoría");

        btnRegistrar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        tblCategorias.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 12)); // NOI18N
        tblCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoría", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblCategorias);

        tblParametros.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 12)); // NOI18N
        tblParametros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Parámetro", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblParametros);

        btnCategoria.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        btnCategoria.setText("Nuevo Categoría");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        btnParametro.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        btnParametro.setText("Nuevo Parámetro");
        btnParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnParametroActionPerformed(evt);
            }
        });

        txtCategoria.setEditable(false);
        txtCategoria.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N

        btnCancelar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel5.setText("Categoría");

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel2.setText("Prueba");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnParametro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 901, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1)
                                        .addGap(21, 21, 21)))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNombrePrueba))
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(663, 663, 663))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategoria))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombrePrueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnParametro)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            PruebaDTO prueba = new PruebaDTO(txtNombrePrueba.getText());
            int idPruebaLab = this.pruebaNegocio.guardarPrueba(prueba);
            
            //CategoriaDTO categoria = new CategoriaDTO(idPruebaLab, txtCategoria.getText());
            //this.categoriaNegocio.guardarCategoria(idPruebaLab, categoria);
            
            //ParametroDTO parametro = new ParametroDTO(idPruebaLab, "");
            //this.parametroNegocio.guardarParametro(idPruebaLab, parametro);
            
        } catch (NegocioException ex) {
            System.out.println(ex.getMessage());
        }
        abrirPruebaEntidad();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        CategoriaEntidadPanel insCategoriaEntidadPanel = new CategoriaEntidadPanel(pruebaNegocio, categoriaNegocio, parametroNegocio);
        insCategoriaEntidadPanel.setVisible(true);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParametroActionPerformed
        ParametroEntidadPanel insParametroEntidadPanel = new ParametroEntidadPanel(pruebaNegocio, categoriaNegocio, parametroNegocio);
        insParametroEntidadPanel.setVisible(true);
    }//GEN-LAST:event_btnParametroActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        PruebaPanel insPruebaPanel = new PruebaPanel(pruebaNegocio, categoriaNegocio, parametroNegocio);
        insPruebaPanel.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnParametro;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTable tblParametros;
    private javax.swing.JTextArea txtAreaParametros;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtNombrePrueba;
    // End of variables declaration//GEN-END:variables
}
