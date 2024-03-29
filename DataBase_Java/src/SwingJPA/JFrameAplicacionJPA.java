/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SwingJPA;

import LogicaClases.TarjetaCreditoDAOJPA;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import LogicaClases.ModeloTablaTarjetaCredito;
import poo_gestiontarjetascredito.TarjetaCredito;

/**
 *
 * @author Usuario
 */
public class JFrameAplicacionJPA extends javax.swing.JFrame {

    private ModeloTablaTarjetaCredito modelo;
    private TarjetaCreditoDAOJPA dao;

    /**
     *
     */
    public JFrameAplicacionJPA() {
        initComponents();
        modelo = new ModeloTablaTarjetaCredito();
        jTableAlmacenTarjetas.setModel(modelo);
        this.jTableAlmacenTarjetas.setComponentPopupMenu(this.jPopupMenuClickDerecho);
        dao = new TarjetaCreditoDAOJPA();
        this.modelo.añadirTarjetasList(dao.obtenerTarjetas());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuClickDerecho = new javax.swing.JPopupMenu();
        jMenuItemPopMostrarNumero = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemPopMostrarTitular = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemPopMostrarFecha = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemPopModificarPIN = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItemPopRealizarPago = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItemPopMovimientros = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItemPopGastoTotal = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlmacenTarjetas = new javax.swing.JTable();
        jMenuBarraGestion = new javax.swing.JMenuBar();
        jMenuCrearTarjeta = new javax.swing.JMenu();
        jMenuItemCrear = new javax.swing.JMenuItem();
        jMenuEliminarTarjeta = new javax.swing.JMenu();
        jMenuItemEliminar = new javax.swing.JMenuItem();
        jMenuGestionarTarjeta = new javax.swing.JMenu();
        jMenuItemMostrarNumero = new javax.swing.JMenuItem();
        jMenuItemMostrarTitular = new javax.swing.JMenuItem();
        jMenuItemMostrarFecha = new javax.swing.JMenuItem();
        jMenuItemModificarPin = new javax.swing.JMenuItem();
        jMenuItemRealizarPago = new javax.swing.JMenuItem();
        jMenuItemConsultarMovimientos = new javax.swing.JMenuItem();
        jMenuItemConsultarGastoTotal = new javax.swing.JMenuItem();
        jMenuConsultarGastosTotales = new javax.swing.JMenu();
        jMenuItemConsultar = new javax.swing.JMenuItem();
        jMenuEstadoPrograma = new javax.swing.JMenu();
        jMenuItemCargarTarjeta = new javax.swing.JMenuItem();
        jMenuItemGuardarTarjeta = new javax.swing.JMenuItem();

        jMenuItemPopMostrarNumero.setText("Consultar Numero");
        jMenuItemPopMostrarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMostrarNumeroActionPerformed(evt);
            }
        });
        jPopupMenuClickDerecho.add(jMenuItemPopMostrarNumero);
        jPopupMenuClickDerecho.add(jSeparator1);

        jMenuItemPopMostrarTitular.setText("Consultar Titular");
        jMenuItemPopMostrarTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMostrarTitularActionPerformed(evt);
            }
        });
        jPopupMenuClickDerecho.add(jMenuItemPopMostrarTitular);
        jPopupMenuClickDerecho.add(jSeparator2);

        jMenuItemPopMostrarFecha.setText("Mostrar fecha caducidad");
        jPopupMenuClickDerecho.add(jMenuItemPopMostrarFecha);
        jPopupMenuClickDerecho.add(jSeparator3);

        jMenuItemPopModificarPIN.setText("Modificar pin");
        jMenuItemPopModificarPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarPinActionPerformed(evt);
            }
        });
        jPopupMenuClickDerecho.add(jMenuItemPopModificarPIN);
        jPopupMenuClickDerecho.add(jSeparator4);

        jMenuItemPopRealizarPago.setText("Realizar pago");
        jMenuItemPopRealizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRealizarPagoActionPerformed(evt);
            }
        });
        jPopupMenuClickDerecho.add(jMenuItemPopRealizarPago);
        jPopupMenuClickDerecho.add(jSeparator5);

        jMenuItemPopMovimientros.setText("Consultar movimientos");
        jMenuItemPopMovimientros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultarMovimientosActionPerformed(evt);
            }
        });
        jPopupMenuClickDerecho.add(jMenuItemPopMovimientros);
        jPopupMenuClickDerecho.add(jSeparator6);

        jMenuItemPopGastoTotal.setText("Consultar gasto total");
        jMenuItemPopGastoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultarGastoTotalActionPerformed(evt);
            }
        });
        jPopupMenuClickDerecho.add(jMenuItemPopGastoTotal);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableAlmacenTarjetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableAlmacenTarjetas);

        jMenuCrearTarjeta.setMnemonic('c');
        jMenuCrearTarjeta.setText("Crear Tarjeta");

        jMenuItemCrear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemCrear.setText("Crear");
        jMenuItemCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearActionPerformed(evt);
            }
        });
        jMenuCrearTarjeta.add(jMenuItemCrear);

        jMenuBarraGestion.add(jMenuCrearTarjeta);

        jMenuEliminarTarjeta.setMnemonic('e');
        jMenuEliminarTarjeta.setText("Eliminar Tarjeta");

        jMenuItemEliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemEliminar.setText("Eliminar");
        jMenuItemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarActionPerformed(evt);
            }
        });
        jMenuEliminarTarjeta.add(jMenuItemEliminar);

        jMenuBarraGestion.add(jMenuEliminarTarjeta);

        jMenuGestionarTarjeta.setMnemonic('g');
        jMenuGestionarTarjeta.setText("Gestionar Tarjeta");

        jMenuItemMostrarNumero.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItemMostrarNumero.setText("Mostrar el numero");
        jMenuItemMostrarNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMostrarNumeroActionPerformed(evt);
            }
        });
        jMenuGestionarTarjeta.add(jMenuItemMostrarNumero);

        jMenuItemMostrarTitular.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItemMostrarTitular.setText("Mostrar el titular");
        jMenuItemMostrarTitular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMostrarTitularActionPerformed(evt);
            }
        });
        jMenuGestionarTarjeta.add(jMenuItemMostrarTitular);

        jMenuItemMostrarFecha.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItemMostrarFecha.setText("Mostrar fecha caducidad");
        jMenuItemMostrarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMostrarFechaActionPerformed(evt);
            }
        });
        jMenuGestionarTarjeta.add(jMenuItemMostrarFecha);

        jMenuItemModificarPin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItemModificarPin.setText("Modificar PIN");
        jMenuItemModificarPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarPinActionPerformed(evt);
            }
        });
        jMenuGestionarTarjeta.add(jMenuItemModificarPin);

        jMenuItemRealizarPago.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItemRealizarPago.setText("Realizar un pago");
        jMenuItemRealizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRealizarPagoActionPerformed(evt);
            }
        });
        jMenuGestionarTarjeta.add(jMenuItemRealizarPago);

        jMenuItemConsultarMovimientos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_6, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItemConsultarMovimientos.setText("Consultar Movimientos");
        jMenuItemConsultarMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultarMovimientosActionPerformed(evt);
            }
        });
        jMenuGestionarTarjeta.add(jMenuItemConsultarMovimientos);

        jMenuItemConsultarGastoTotal.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_7, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        jMenuItemConsultarGastoTotal.setText("Consultar Gasto Total");
        jMenuItemConsultarGastoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultarGastoTotalActionPerformed(evt);
            }
        });
        jMenuGestionarTarjeta.add(jMenuItemConsultarGastoTotal);

        jMenuBarraGestion.add(jMenuGestionarTarjeta);

        jMenuConsultarGastosTotales.setMnemonic('t');
        jMenuConsultarGastosTotales.setText("Consultar Gastos Totales");

        jMenuItemConsultar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_3, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemConsultar.setText("Consultar");
        jMenuItemConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultarActionPerformed(evt);
            }
        });
        jMenuConsultarGastosTotales.add(jMenuItemConsultar);

        jMenuBarraGestion.add(jMenuConsultarGastosTotales);

        jMenuEstadoPrograma.setMnemonic('p');
        jMenuEstadoPrograma.setText("Estado del programa");

        jMenuItemCargarTarjeta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemCargarTarjeta.setText("Cargar Tarjeta");
        jMenuItemCargarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargarTarjetaActionPerformed(evt);
            }
        });
        jMenuEstadoPrograma.add(jMenuItemCargarTarjeta);

        jMenuItemGuardarTarjeta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemGuardarTarjeta.setText("Guardar Tarjeta");
        jMenuItemGuardarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarTarjetaActionPerformed(evt);
            }
        });
        jMenuEstadoPrograma.add(jMenuItemGuardarTarjeta);

        jMenuBarraGestion.add(jMenuEstadoPrograma);

        setJMenuBar(jMenuBarraGestion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearActionPerformed
        JDialogCrearModificarTarjeta jDialog = new JDialogCrearModificarTarjeta(this, true);
        jDialog.setVisible(true);
        if (jDialog.getTarjeta() != null) {
            if (modelo.añadirTarjetaCredito(jDialog.getTarjeta())) {
                modelo.fireTableDataChanged();
                dao.insertarTarjeta(jDialog.getTarjeta());
                JOptionPane.showMessageDialog(rootPane, "Tarjeta de credito añadida correctamente", "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Tarjeta de credito no añadida", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItemCrearActionPerformed

    private void jMenuItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarActionPerformed
        int fila = this.jTableAlmacenTarjetas.getSelectedRow();
        if (this.modelo.existeIndice(fila)) {
            TarjetaCredito tarjeta = this.modelo.getTarjeta(fila);
            if (modelo.eliminarTarjetaCredito(fila)) {
                modelo.fireTableDataChanged();
                dao.eliminarTarjeta(tarjeta);
                JOptionPane.showMessageDialog(rootPane, "Tarjeta de credito eliminada correctamente", "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar", "¡Error!", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jMenuItemEliminarActionPerformed

    private void jMenuItemMostrarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMostrarNumeroActionPerformed
        int fila = this.jTableAlmacenTarjetas.getSelectedRow();
        if (this.modelo.existeIndice(fila)) {
            JOptionPane.showMessageDialog(this, "El numero es: " + this.modelo.getTarjeta(fila).getNumeroTarjeta(), "Exito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se ha seleccionado una fila", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemMostrarNumeroActionPerformed

    private void jMenuItemMostrarTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMostrarTitularActionPerformed
        int fila = this.jTableAlmacenTarjetas.getSelectedRow();
        if (this.modelo.existeIndice(fila)) {
            if (modelo.getTarjeta(fila) != null) {
                JOptionPane.showMessageDialog(rootPane, "El titular es: " + this.modelo.getTarjeta(fila).getTitular(), "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se pudo mostrar", "¡Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItemMostrarTitularActionPerformed

    private void jMenuItemMostrarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMostrarFechaActionPerformed
        int fila = this.jTableAlmacenTarjetas.getSelectedRow();
        if (this.modelo.existeIndice(fila)) {
            if (modelo.getTarjeta(fila) != null) {
                JOptionPane.showMessageDialog(rootPane, "La fecha caducidad es: " + this.modelo.getTarjeta(fila).getMesCaducidad() + "-" + this.modelo.getTarjeta(fila).getAñoCaducidad(), "¡Informacion!", JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se pudo mostrar", "¡Error!", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jMenuItemMostrarFechaActionPerformed

    private void jMenuItemModificarPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarPinActionPerformed
        int fila = this.jTableAlmacenTarjetas.getSelectedRow();
        if (this.modelo.existeIndice(fila)) {
            String pinNuevo = JOptionPane.showInputDialog(this, "Introduce el nuevo PIN de la tarjeta, recuerda que minimo tiene que tener 4 caracteres", "Seleccione el indice", JOptionPane.INFORMATION_MESSAGE);
            if (pinNuevo != null) {
                if (Funciones.Funciones.ValidarNumeroPin(pinNuevo)) {
                    if (modelo.setPin(fila, pinNuevo)) {
                        modelo.fireTableDataChanged();
                        TarjetaCredito tarjeta = this.modelo.getTarjeta(fila);
                        dao.modificarPIN(tarjeta, pinNuevo);
                        JOptionPane.showMessageDialog(rootPane, "PIN modificado correctamente", "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "No se pudo modificar el PIN", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }

    }//GEN-LAST:event_jMenuItemModificarPinActionPerformed

    private void jMenuItemConsultarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarMovimientosActionPerformed
        int fila = this.jTableAlmacenTarjetas.getSelectedRow();
        String movimiento;
        if (this.modelo.existeIndice(fila)) {
            String cantidadMovimientos = JOptionPane.showInputDialog(this, "Introduce la cantidad de movimientos que quieres consultar", "Introduce la cantidad", JOptionPane.INFORMATION_MESSAGE);
            if (Funciones.Funciones.expresionRegularNumeros(cantidadMovimientos)) {
                movimiento = this.modelo.movimientosTarjeta(fila, Integer.parseInt(cantidadMovimientos));
                JOptionPane.showMessageDialog(rootPane, "Sus movimientos con la tarjeta son: " + movimiento, "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }//GEN-LAST:event_jMenuItemConsultarMovimientosActionPerformed

    private void jMenuItemConsultarGastoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarGastoTotalActionPerformed
        int fila = this.jTableAlmacenTarjetas.getSelectedRow();
        if (this.modelo.existeIndice(fila)) {
            double gastoTotal = modelo.gastoTarjeta(fila);
            JOptionPane.showMessageDialog(rootPane, "El gasto total de tu tarjeta es: " + gastoTotal, "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Indice introducido invalido", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jMenuItemConsultarGastoTotalActionPerformed

    private void jMenuItemRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRealizarPagoActionPerformed
        int fila = this.jTableAlmacenTarjetas.getSelectedRow();
        if (this.modelo.existeIndice(fila)) {
            String concepto;
            double cantidad;
            JDialogRealizarPago jDialog = new JDialogRealizarPago(this, true);
            jDialog.setVisible(true);
            concepto = jDialog.getConcepto();
            cantidad = jDialog.getCantidad();
            if (concepto != null && cantidad != 0) {
                if (modelo.realizarPago(fila, cantidad, concepto)) {
                    modelo.fireTableDataChanged();
                    dao.introducirMovimiento(this.modelo.getTarjeta(fila));
                    JOptionPane.showMessageDialog(rootPane, "El pago se realizado correctamente", "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Algun campo es erroneo, se rechazo el pago", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                }

            }

        }
    }//GEN-LAST:event_jMenuItemRealizarPagoActionPerformed

    private void jMenuItemConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarActionPerformed
        double gastoTotal = modelo.gastoTotal();
        JOptionPane.showMessageDialog(rootPane, "El gasto total de sus tarjetas es: " + gastoTotal, "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jMenuItemConsultarActionPerformed

    private void jMenuItemCargarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCargarTarjetaActionPerformed
        JFileChooser jf = new JFileChooser();
        int comprobanteSeleccionFichero = jf.showOpenDialog(this);
        if (comprobanteSeleccionFichero == JFileChooser.APPROVE_OPTION) {
            File archivo = jf.getSelectedFile();
            ObjectInputStream flujoEntrada;
            try {
                flujoEntrada = new ObjectInputStream(new FileInputStream(archivo));
                TarjetaCredito tarjeta = (TarjetaCredito) flujoEntrada.readObject();
                if (tarjeta != null) {
                    this.modelo.añadirTarjetaCredito(tarjeta);
                    modelo.fireTableDataChanged();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Error al cargar la tarjeta", "¡ERROR!", JOptionPane.ERROR_MESSAGE);

                }
            } catch (IOException ex) {
                Logger.getLogger(JFrameAplicacionJPA.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JFrameAplicacionJPA.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jMenuItemCargarTarjetaActionPerformed

    private void jMenuItemGuardarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarTarjetaActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int respuesta = jf.showSaveDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File ubicacion = jf.getSelectedFile();
            String nombre = JOptionPane.showInputDialog(this, "Introduce el nombre", "Seleccione el nombre", JOptionPane.INFORMATION_MESSAGE);
            if (ubicacion.exists() && ubicacion.isDirectory()) {
                File archivo = new File(ubicacion, nombre + ".dat");
                ObjectOutputStream flujoSalida = null;
                try {
                    archivo.createNewFile();
                    flujoSalida = new ObjectOutputStream(new FileOutputStream(archivo));
                    for (int i = 0; i < this.modelo.getRowCount(); i++) {
                        flujoSalida.writeObject(this.modelo.getTarjeta(i));

                    }
                } catch (IOException ex) {
                    Logger.getLogger(JFrameAplicacionJPA.class
                            .getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        flujoSalida.close();

                    } catch (IOException ex) {
                        Logger.getLogger(JFrameAplicacionJPA.class
                                .getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_jMenuItemGuardarTarjetaActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameAplicacionJPA.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAplicacionJPA.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAplicacionJPA.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAplicacionJPA.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAplicacionJPA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBarraGestion;
    private javax.swing.JMenu jMenuConsultarGastosTotales;
    private javax.swing.JMenu jMenuCrearTarjeta;
    private javax.swing.JMenu jMenuEliminarTarjeta;
    private javax.swing.JMenu jMenuEstadoPrograma;
    private javax.swing.JMenu jMenuGestionarTarjeta;
    private javax.swing.JMenuItem jMenuItemCargarTarjeta;
    private javax.swing.JMenuItem jMenuItemConsultar;
    private javax.swing.JMenuItem jMenuItemConsultarGastoTotal;
    private javax.swing.JMenuItem jMenuItemConsultarMovimientos;
    private javax.swing.JMenuItem jMenuItemCrear;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JMenuItem jMenuItemGuardarTarjeta;
    private javax.swing.JMenuItem jMenuItemModificarPin;
    private javax.swing.JMenuItem jMenuItemMostrarFecha;
    private javax.swing.JMenuItem jMenuItemMostrarNumero;
    private javax.swing.JMenuItem jMenuItemMostrarTitular;
    private javax.swing.JMenuItem jMenuItemPopGastoTotal;
    private javax.swing.JMenuItem jMenuItemPopModificarPIN;
    private javax.swing.JMenuItem jMenuItemPopMostrarFecha;
    private javax.swing.JMenuItem jMenuItemPopMostrarNumero;
    private javax.swing.JMenuItem jMenuItemPopMostrarTitular;
    private javax.swing.JMenuItem jMenuItemPopMovimientros;
    private javax.swing.JMenuItem jMenuItemPopRealizarPago;
    private javax.swing.JMenuItem jMenuItemRealizarPago;
    private javax.swing.JPopupMenu jPopupMenuClickDerecho;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JTable jTableAlmacenTarjetas;
    // End of variables declaration//GEN-END:variables
}
