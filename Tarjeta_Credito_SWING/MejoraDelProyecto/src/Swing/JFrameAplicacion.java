/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Swing;

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
import poo_gestiontarjetascredito.ModeloTablaTarjetaCredito;
import poo_gestiontarjetascredito.TarjetaCredito;

/**
 *
 * @author Usuario
 */
public class JFrameAplicacion extends javax.swing.JFrame {

    ModeloTablaTarjetaCredito modelo;

    public JFrameAplicacion() {
        initComponents();
        modelo = new ModeloTablaTarjetaCredito();
        jTableAlmacenTarjetas.setModel(modelo);
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
        jMenu1 = new javax.swing.JMenu();
        jMenuItemCargarTarjeta = new javax.swing.JMenuItem();
        jMenuItemGuardarTarjeta = new javax.swing.JMenuItem();

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

        jMenu1.setMnemonic('p');
        jMenu1.setText("Estado del programa");

        jMenuItemCargarTarjeta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_4, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemCargarTarjeta.setText("Cargar Tarjeta");
        jMenuItemCargarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargarTarjetaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemCargarTarjeta);

        jMenuItemGuardarTarjeta.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_5, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemGuardarTarjeta.setText("Guardar Tarjeta");
        jMenuItemGuardarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarTarjetaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGuardarTarjeta);

        jMenuBarraGestion.add(jMenu1);

        setJMenuBar(jMenuBarraGestion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
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
                JOptionPane.showMessageDialog(rootPane, "Tarjeta de credito añadida correctamente", "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Tarjeta de credito no añadida", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItemCrearActionPerformed

    private void jMenuItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarActionPerformed
        String indiceString = JOptionPane.showInputDialog(this, "Introduce el indice de la tarjeta que quieres eliminar", "Seleccione el indice", JOptionPane.INFORMATION_MESSAGE);
        if (indiceString != null) {
            if (Funciones.Funciones.expresionRegularNumeros(indiceString)) {
                int indice = Integer.parseInt(indiceString);
                if (modelo.eliminarTarjetaCredito(indice)) {
                    modelo.fireTableDataChanged();
                    JOptionPane.showMessageDialog(rootPane, "Tarjeta de credito eliminada correctamente", "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar", "¡Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jMenuItemEliminarActionPerformed

    private void jMenuItemMostrarNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMostrarNumeroActionPerformed
        String indiceString = JOptionPane.showInputDialog(this, "Introduce el indice de la tarjeta que quieres eliminar", "Seleccione el indice", JOptionPane.INFORMATION_MESSAGE);
        if (indiceString != null) {
            if (Funciones.Funciones.expresionRegularNumeros(indiceString)) {
                int indice = Integer.parseInt(indiceString);
                if (modelo.getTarjeta(indice) != null) {
                    JOptionPane.showMessageDialog(rootPane, "El numero es: " + modelo.getTarjeta(indice).getNumeroTarjeta(), "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se pudo mostrar", "¡Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jMenuItemMostrarNumeroActionPerformed

    private void jMenuItemMostrarTitularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMostrarTitularActionPerformed
        String indiceString = JOptionPane.showInputDialog(this, "Introduce el indice de la tarjeta que quieres eliminar", "Seleccione el indice", JOptionPane.INFORMATION_MESSAGE);
        if (indiceString != null) {
            if (Funciones.Funciones.expresionRegularNumeros(indiceString)) {
                int indice = Integer.parseInt(indiceString);
                if (modelo.getTarjeta(indice) != null) {
                    JOptionPane.showMessageDialog(rootPane, "El titular es: " + modelo.getTarjeta(indice).getTitular(), "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se pudo mostrar", "¡Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jMenuItemMostrarTitularActionPerformed

    private void jMenuItemMostrarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMostrarFechaActionPerformed
        String indiceString = JOptionPane.showInputDialog(this, "Introduce el indice de la tarjeta que quieres eliminar", "Seleccione el indice", JOptionPane.INFORMATION_MESSAGE);
        if (indiceString != null) {
            if (Funciones.Funciones.expresionRegularNumeros(indiceString)) {
                int indice = Integer.parseInt(indiceString);
                if (modelo.getTarjeta(indice) != null) {
                    JOptionPane.showMessageDialog(rootPane, "La fecha caducidad es: " + modelo.getTarjeta(indice).getMesCaducidad() + "-" + modelo.getTarjeta(indice).getAñoCaducidad(), "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se pudo mostrar", "¡Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jMenuItemMostrarFechaActionPerformed

    private void jMenuItemModificarPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarPinActionPerformed
        String indiceString = JOptionPane.showInputDialog(this, "Introduce el indice de la tarjeta a la cual quieres modificar el pin", "Seleccione el indice", JOptionPane.INFORMATION_MESSAGE);
        if (indiceString != null) {
            int indice = -1;
            if (Funciones.Funciones.expresionRegularNumeros(indiceString)) {
                indice = Integer.parseInt(indiceString);
                String pinNuevo = JOptionPane.showInputDialog(this, "Introduce el nuevo PIN de la tarjeta, recuerda que minimo tiene que tener 4 caracteres", "Seleccione el indice", JOptionPane.INFORMATION_MESSAGE);
                if (Funciones.Funciones.ValidarNumeroPin(pinNuevo) && indice != -1) {
                    if (modelo.setPin(indice, pinNuevo)) {
                        modelo.fireTableDataChanged();
                        JOptionPane.showMessageDialog(rootPane, "PIN modificado correctamente", "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "No se pudo modificar el PIN", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        }

    }//GEN-LAST:event_jMenuItemModificarPinActionPerformed

    private void jMenuItemConsultarMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarMovimientosActionPerformed
        String indiceString = JOptionPane.showInputDialog(this, "Introduce el indice de la tarjeta a la cual quieres consultar sus movimientos", "Seleccione el indice", JOptionPane.INFORMATION_MESSAGE);
        if (indiceString != null) {
            int indice = -1;
            if (Funciones.Funciones.expresionRegularNumeros(indiceString)) {
                indice = Integer.parseInt(indiceString);
                String cantidadMovimientos = JOptionPane.showInputDialog(this, "Introduce la cantidad de movimientos que quieres consultar", "Introduce la cantidad", JOptionPane.INFORMATION_MESSAGE);
                if (Funciones.Funciones.expresionRegularNumeros(cantidadMovimientos)) {
                    String movimiento = modelo.movimientosTarjeta(indice, Integer.parseInt(cantidadMovimientos));
                    JOptionPane.showMessageDialog(rootPane, "Sus movimientos con la tarjeta son: " + movimiento, "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
    }//GEN-LAST:event_jMenuItemConsultarMovimientosActionPerformed

    private void jMenuItemConsultarGastoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarGastoTotalActionPerformed
        String indiceString = JOptionPane.showInputDialog(this, "Introduce el indice de la tarjeta a la que quieres consultar el pago", "Seleccione el indice", JOptionPane.INFORMATION_MESSAGE);
        if (indiceString != null) {
            int indice = -1;
            if (Funciones.Funciones.expresionRegularNumeros(indiceString)) {
                indice = Integer.parseInt(indiceString);
                double gastoTotal = modelo.gastoTarjeta(indice);
                JOptionPane.showMessageDialog(rootPane, "El gasto total de tu tarjeta es: " + gastoTotal, "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Indice introducido invalido", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItemConsultarGastoTotalActionPerformed

    private void jMenuItemRealizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRealizarPagoActionPerformed
        String indiceString = JOptionPane.showInputDialog(this, "Introduce el indice de la tarjeta a la cual quieres realizar un pago", "Seleccione el indice", JOptionPane.INFORMATION_MESSAGE);
        if (indiceString != null) {
            int indice = -1;
            String concepto = "";
            double cantidad = 0;
            if (Funciones.Funciones.expresionRegularNumeros(indiceString)) {
                indice = Integer.parseInt(indiceString);
                JDialogRealizarPago jDialog = new JDialogRealizarPago(this, true);
                jDialog.setVisible(true);
                concepto = jDialog.getConcepto();
                cantidad = jDialog.getCantidad();
                if (concepto != null && cantidad != 0) {
                    if (modelo.realizarPago(indice, cantidad, concepto)) {
                        modelo.fireTableDataChanged();
                        JOptionPane.showMessageDialog(rootPane, "El pago se realizado correctamente", "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Algun campo es erroneo, se rechazo el pago", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                    }

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
                Logger.getLogger(JFrameAplicacion.class
                        .getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JFrameAplicacion.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(JFrameAplicacion.class
                            .getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        flujoSalida.close();

                    } catch (IOException ex) {
                        Logger.getLogger(JFrameAplicacion.class
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
            java.util.logging.Logger.getLogger(JFrameAplicacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameAplicacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameAplicacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameAplicacion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameAplicacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBarraGestion;
    private javax.swing.JMenu jMenuConsultarGastosTotales;
    private javax.swing.JMenu jMenuCrearTarjeta;
    private javax.swing.JMenu jMenuEliminarTarjeta;
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
    private javax.swing.JMenuItem jMenuItemRealizarPago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAlmacenTarjetas;
    // End of variables declaration//GEN-END:variables
}