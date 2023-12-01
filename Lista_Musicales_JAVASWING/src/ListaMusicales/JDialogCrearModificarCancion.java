package ListaMusicales;

import Clases.Cancion;
import Clases.ModeloTablaCanciones;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Es una clase JDialog que se usa como ventana emergente para dos cosas
 * diferentes, por eso tiene dos constructores. La primera funcionalidad es
 * crear canciones o poder modificarlas. El primer constructor se usa para poder
 * crear canciones y con el segundo constructor lo uso para poder modificar las
 * canciones mediante un parametro indice, y otro parametro modelo.
 *
 * @author Aleksander Trujillo Prokhorenko
 * @version JDK 16
 */
public class JDialogCrearModificarCancion extends javax.swing.JDialog {

    private Cancion cancion;
    private String rutaJF;

    /**
     * Constructor del JDialog por defecto que se crea cuando creas la ventana,
     * lo utilizo para crear canciones ya que todo esta incializado a valores
     * por defecto
     *
     * @param parent, datos principales del Frame.
     * @param modal, para bloquear el raton fuera de la ventana mientras este
     * abierta.
     */
    public JDialogCrearModificarCancion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }

    /**
     * Constructor sobre cargado que recibe por paremtro los mismos parametros
     * que el anterior ademas de un inidce de cancion que se desee modificar y
     * el modelo de la tabla, para poder acceder a los metodos para poder
     * modificar los datos de la cancion.
     *
     * @param parent, datos del Jframe 
     * @param modal, para bloquear el raton fuera de la ventana mientras este
     * @param indice, int
     * @param modelo, modelo de la tabla
     */
    public JDialogCrearModificarCancion(java.awt.Frame parent, boolean modal, int indice, ModeloTablaCanciones modelo) {
        super(parent, modal);
        initComponents();
        jTextIntroduceTitulo.setText(modelo.getCancion(indice).getTitulo());
        jTextIntroduceRuta.setText(modelo.getCancion(indice).getRuta());
        jTextIntroduceDuracion.setText(modelo.getCancion(indice).getDuracion() + "");
        jButtonAgregarCancion.setText("Modificar Cancion");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelCabecera = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelDuracion = new javax.swing.JLabel();
        jTextIntroduceTitulo = new javax.swing.JTextField();
        jTextIntroduceDuracion = new javax.swing.JTextField();
        jButtonAgregarCancion = new javax.swing.JButton();
        jLabelRUta = new javax.swing.JLabel();
        jTextIntroduceRuta = new javax.swing.JTextField();
        jButtonEscogerRuta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelCabecera.setText("AGREGADOR DE CANCIONES");

        jLabelTitulo.setText("Titulo");

        jLabelDuracion.setText("Duracion");

        jTextIntroduceTitulo.setToolTipText("Introduce el titulo de la cancion");

        jTextIntroduceDuracion.setToolTipText("Introduce la duracion de la cancion, -1 para duraciones desconocidas");

        jButtonAgregarCancion.setText("Aceptar datos");
        jButtonAgregarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarCancionActionPerformed(evt);
            }
        });

        jLabelRUta.setText("Ruta");

        jTextIntroduceRuta.setToolTipText("Introduce la ruta donde deses guardar la cancion");

        jButtonEscogerRuta.setText("Escoger Ruta");
        jButtonEscogerRuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEscogerRutaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAgregarCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDuracion)
                            .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRUta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonEscogerRuta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextIntroduceTitulo)
                                .addComponent(jTextIntroduceDuracion)
                                .addComponent(jTextIntroduceRuta)))))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelCabecera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo)
                    .addComponent(jTextIntroduceTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDuracion)
                    .addComponent(jTextIntroduceDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRUta)
                    .addComponent(jTextIntroduceRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEscogerRuta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAgregarCancion))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCancionActionPerformed
        if ((jTextIntroduceTitulo.getText() != null) && (jTextIntroduceDuracion.getText() != null) && (jTextIntroduceRuta.getText() != null || this.rutaJF != null)) {
            jButtonAgregarCancion.setEnabled(true);
            if ((Clases.Funciones.ValidarCadenaTexto(jTextIntroduceTitulo.getText())) && (Clases.Funciones.expresionRegularNumeros(jTextIntroduceDuracion.getText())) && (Clases.Funciones.comprobarRuta(jTextIntroduceRuta.getText()))) {
                int duracion = Integer.parseInt(jTextIntroduceDuracion.getText());
                this.cancion = new Cancion(jTextIntroduceTitulo.getText(), jTextIntroduceRuta.getText(), duracion);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Alguno de los campos introducidos es erroneo", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonAgregarCancionActionPerformed

    private void jButtonEscogerRutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEscogerRutaActionPerformed
        jTextIntroduceRuta.setEnabled(false);
        JFileChooser jf = new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int comprobanteSeleccionFichero = jf.showOpenDialog(this);
        if (comprobanteSeleccionFichero == JFileChooser.APPROVE_OPTION) {
            File ubicacion = jf.getSelectedFile();
            if (ubicacion.exists() && ubicacion.isDirectory()) {
                this.rutaJF = ubicacion.getPath();
                jTextIntroduceRuta.setText(this.rutaJF);
            }
        }
    }//GEN-LAST:event_jButtonEscogerRutaActionPerformed
    /**
     * Metodo getter que devuelve una cancion, cuando se crea.
     * @return 
     */
    public Cancion getCancion() {
        return this.cancion;
    }

    /**
     *
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
            java.util.logging.Logger.getLogger(JDialogCrearModificarCancion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDialogCrearModificarCancion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDialogCrearModificarCancion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDialogCrearModificarCancion.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDialogCrearModificarCancion dialog = new JDialogCrearModificarCancion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarCancion;
    private javax.swing.JButton jButtonEscogerRuta;
    private javax.swing.JLabel jLabelCabecera;
    private javax.swing.JLabel jLabelDuracion;
    private javax.swing.JLabel jLabelRUta;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JTextField jTextIntroduceDuracion;
    private javax.swing.JTextField jTextIntroduceRuta;
    private javax.swing.JTextField jTextIntroduceTitulo;
    // End of variables declaration//GEN-END:variables

}
