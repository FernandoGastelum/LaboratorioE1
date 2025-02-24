/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Presentacion;

import DTOS.CategoriaTablaDTO;
import DTOS.ParametroTablaDTO;
import DTOS.PruebaDTO;
import Negocio.ICategoriaNegocio;
import Negocio.IParametroNegocio;
import Negocio.IPruebaNegocio;
import Negocio.NegocioException;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Knocmare
 */
public class PruebaEntidadPanel extends javax.swing.JPanel {

    private IPruebaNegocio pruebaNegocio;
    private ICategoriaNegocio categoriaNegocio;
    private IParametroNegocio parametroNegocio;
    private List<Integer> categoriasSeleccionadas;
    private List<Integer> parametrosSeleccionadas;

    public PruebaEntidadPanel(IPruebaNegocio pruebaNegocio, ICategoriaNegocio categoriaNegocio, IParametroNegocio parametroNegocio) {
        initComponents();
        this.pruebaNegocio = pruebaNegocio;
        this.categoriaNegocio = categoriaNegocio;
        this.parametroNegocio = parametroNegocio;
        this.parametrosSeleccionadas = new ArrayList<>();
        this.metodosIniciales();
    }

    private void metodosIniciales() {
        this.cargarCategoria();
        this.cargarParametro();
    }

    private void guardarPrueba() {
        try {
            // Obtener el nombre de la prueba
            String nombrePrueba = txtNombrePrueba.getText().trim();
            if (nombrePrueba.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese un nombre para la prueba.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener la categoría seleccionada
            String categoriaSeleccionada = (String) categoriaComboBox.getSelectedItem(); // Asumo que es un ComboBox de Strings
            if (categoriaSeleccionada == null || categoriaSeleccionada.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione una categoría.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener los parámetros seleccionados
            List<String> parametros = new ArrayList<>(); // Lista de parámetros
            // Si estás usando un JList dentro de un JComboBox o algo similar
            List<String> seleccionados = Arrays.asList((String) parametroComboBox.getSelectedItem());
            parametros.addAll(seleccionados);

            if (parametros.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Seleccione al menos un parámetro.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear el objeto de prueba (PruebaDTO) con los datos
            PruebaDTO pruebaDTO = new PruebaDTO();
            pruebaDTO.setNombrePrueba(nombrePrueba);
            pruebaDTO.setCategoria(categoriaSeleccionada); // Solo la categoría como String, sin ID si no lo necesitas
            pruebaDTO.setParametros(parametros); // Lista de parámetros como Strings (ajustar según tu estructura)

            // Registrar la prueba llamando a la capa de negocio
            pruebaNegocio.guardarPrueba(pruebaDTO);

            // Mostrar mensaje de éxito y limpiar campos
            JOptionPane.showMessageDialog(this, "Prueba registrada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar la prueba: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        txtNombrePrueba.setText("");
        categoriaComboBox.setSelectedIndex(-1);
        parametroComboBox.setSelectedIndex(-1);
        parametrosSeleccionadas.clear();
        txtAreaParametros.setText("");
    }

    // Categoria
    private void cargarCategoria() {
        try {
            List<CategoriaTablaDTO> categorias = categoriaNegocio.tablaCategorias();
            for (CategoriaTablaDTO categoria : categorias) {
                categoriaComboBox.addItem(categoria.getNombreCategoria());
            }
        } catch (NegocioException ex) {
            Logger.getLogger(PruebaEntidadPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Parametro
    private void cargarParametro() {
        try {
            List<ParametroTablaDTO> parametros = parametroNegocio.tablaParametros();
            for (ParametroTablaDTO parametro : parametros) {
                parametroComboBox.addItem(parametro.getNombreParametro());
            }
        } catch (NegocioException ex) {
            Logger.getLogger(PruebaEntidadPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarParametro() {
        int selectedIndex = parametroComboBox.getSelectedIndex();
        if (selectedIndex != -1) {
            parametrosSeleccionadas.add(selectedIndex + 1); // Asume que los IDs de Parametros son secuenciales
            txtAreaParametros.append(parametroComboBox.getSelectedItem() + "\n");
        }
    }

    // Paneles
    private void abrirPrueba() {
        // Obtener el JFrame padre (FrmMenuPrincipal)
        java.awt.Container parent = this.getParent();
        while (parent != null && !(parent instanceof FrmMenuPrincipal)) {
            parent = parent.getParent();
        }

        if (parent != null) {
            FrmMenuPrincipal menuPrincipal = (FrmMenuPrincipal) parent;
            PruebaPanel insPruebaPanel = new PruebaPanel(pruebaNegocio, categoriaNegocio, parametroNegocio);

            // Cambiar el contenido de MainPanel en FrmMenuPrincipal
            menuPrincipal.getMainPanel().removeAll();
            menuPrincipal.getMainPanel().setLayout(new BorderLayout());
            menuPrincipal.getMainPanel().add(insPruebaPanel, BorderLayout.CENTER);
            menuPrincipal.getMainPanel().revalidate();
            menuPrincipal.getMainPanel().repaint();
        }
    }

    private void abrirCategoriaEntidad() {
        // Obtener el JFrame padre (FrmMenuPrincipal)
        java.awt.Container parent = this.getParent();
        while (parent != null && !(parent instanceof FrmMenuPrincipal)) {
            parent = parent.getParent();
        }

        if (parent != null) {
            FrmMenuPrincipal menuPrincipal = (FrmMenuPrincipal) parent;
            CategoriaEntidadPanel insCategoriaEntidadPanel = new CategoriaEntidadPanel(pruebaNegocio, categoriaNegocio, parametroNegocio);

            // Cambiar el contenido de MainPanel en FrmMenuPrincipal
            menuPrincipal.getMainPanel().removeAll();
            menuPrincipal.getMainPanel().setLayout(new BorderLayout());
            menuPrincipal.getMainPanel().add(insCategoriaEntidadPanel, BorderLayout.CENTER);
            menuPrincipal.getMainPanel().revalidate();
            menuPrincipal.getMainPanel().repaint();
        }
    }

    private void abrirParametroEntidad() {
        // Obtener el JFrame padre (FrmMenuPrincipal)
        java.awt.Container parent = this.getParent();
        while (parent != null && !(parent instanceof FrmMenuPrincipal)) {
            parent = parent.getParent();
        }

        if (parent != null) {
            FrmMenuPrincipal menuPrincipal = (FrmMenuPrincipal) parent;
            ParametroEntidadPanel insParametroEntidadPanel = new ParametroEntidadPanel(pruebaNegocio, categoriaNegocio, parametroNegocio);

            // Cambiar el contenido de MainPanel en FrmMenuPrincipal
            menuPrincipal.getMainPanel().removeAll();
            menuPrincipal.getMainPanel().setLayout(new BorderLayout());
            menuPrincipal.getMainPanel().add(insParametroEntidadPanel, BorderLayout.CENTER);
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
        btnCategoria = new javax.swing.JButton();
        btnParametro = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        parametroComboBox = new javax.swing.JComboBox<>();
        categoriaComboBox = new javax.swing.JComboBox<>();
        btnAgregarParametro = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 255));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel3.setText("Selecciona los parámetro");

        txtAreaParametros.setEditable(false);
        txtAreaParametros.setColumns(20);
        txtAreaParametros.setRows(5);
        jScrollPane2.setViewportView(txtAreaParametros);

        txtNombrePrueba.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel4.setText("Selecciona la categoría");

        btnRegistrar.setBackground(new java.awt.Color(33, 161, 46));
        btnRegistrar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

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

        btnCancelar.setBackground(new java.awt.Color(255, 204, 0));
        btnCancelar.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 24)); // NOI18N
        jLabel2.setText("Prueba");

        btnAgregarParametro.setBackground(new java.awt.Color(0, 204, 255));
        btnAgregarParametro.setFont(new java.awt.Font("Franklin Gothic Medium", 0, 18)); // NOI18N
        btnAgregarParametro.setText("+ Agregar Parámetro");
        btnAgregarParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarParametroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(663, 663, 663))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombrePrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 535, Short.MAX_VALUE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(categoriaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(parametroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnParametro))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnAgregarParametro)))
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCategoria)
                    .addComponent(categoriaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombrePrueba, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(parametroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnParametro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregarParametro)
                        .addGap(229, 229, 229)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(311, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        guardarPrueba();
        //PruebaDTO prueba = new PruebaDTO(txtNombrePrueba.getText());
        //int idPruebaLab = this.pruebaNegocio.guardarPrueba(prueba);
        
        //CategoriaDTO categoria = new CategoriaDTO(idPruebaLab, txtCategoria.getText());
        //this.categoriaNegocio.guardarCategoria(idPruebaLab, categoria);
        //ParametroDTO parametro = new ParametroDTO(idPruebaLab, "");
        //this.parametroNegocio.guardarParametro(idPruebaLab, parametro);
        abrirPrueba();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        abrirCategoriaEntidad();
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void btnParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnParametroActionPerformed
        abrirParametroEntidad();
    }//GEN-LAST:event_btnParametroActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        abrirPrueba();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarParametroActionPerformed
        agregarParametro();
    }//GEN-LAST:event_btnAgregarParametroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarParametro;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCategoria;
    private javax.swing.JButton btnParametro;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> categoriaComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> parametroComboBox;
    private javax.swing.JTextArea txtAreaParametros;
    private javax.swing.JTextField txtNombrePrueba;
    // End of variables declaration//GEN-END:variables
}
