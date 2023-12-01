package ListaMusicales;

import Clases.Cancion;
import Clases.ModeloTablaCanciones;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Esta clase es un JFrame con el cual gestionamos toda la aplicacion entera, ya
 * que esta compuesta por diversos menus que tienen eventos ActionPerfomarmed,
 * con los cuales realizamos diferentes acciones como crear una lista nueva,
 * modificar canciones de una lista existenten, agregar canciones o eliminarlas
 * ademas de poder cargar archivos de las extensiones permitidas o poder guardar
 * esa lista en un archivo.
 *
 * @author Aleksander Trujillo Prokhorenko
 * @version JDK 16
 */
public class JFrameMain extends javax.swing.JFrame {

    ModeloTablaCanciones modelo;

    public JFrameMain() {
        initComponents();
        modelo = new ModeloTablaCanciones();
        jTableAlmacenCanciones.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableAlmacenCanciones = new javax.swing.JTable();
        jMenuBarra = new javax.swing.JMenuBar();
        jMenuCrearLista = new javax.swing.JMenu();
        jMenuItemCrear = new javax.swing.JMenuItem();
        jMenuModificarCanciones = new javax.swing.JMenu();
        jMenuItemModificar = new javax.swing.JMenuItem();
        jMenuEditarLista = new javax.swing.JMenu();
        jMenuItemAgregarCancion = new javax.swing.JMenuItem();
        jMenuItemEliminarCancion = new javax.swing.JMenuItem();
        jMenuEstadoPrograma = new javax.swing.JMenu();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jMenuItemCargarPrograma = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableAlmacenCanciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableAlmacenCanciones);

        jMenuCrearLista.setMnemonic('c');
        jMenuCrearLista.setText("Crear Lista");

        jMenuItemCrear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemCrear.setMnemonic('c');
        jMenuItemCrear.setText("Crear");
        jMenuItemCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCrearActionPerformed(evt);
            }
        });
        jMenuCrearLista.add(jMenuItemCrear);

        jMenuBarra.add(jMenuCrearLista);

        jMenuModificarCanciones.setMnemonic('m');
        jMenuModificarCanciones.setText("Modificar Cancion");

        jMenuItemModificar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemModificar.setText("Modificar");
        jMenuItemModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemModificarActionPerformed(evt);
            }
        });
        jMenuModificarCanciones.add(jMenuItemModificar);

        jMenuBarra.add(jMenuModificarCanciones);

        jMenuEditarLista.setMnemonic('l');
        jMenuEditarLista.setText("Editar lista");

        jMenuItemAgregarCancion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemAgregarCancion.setText("Agregar Cancion");
        jMenuItemAgregarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAgregarCancionActionPerformed(evt);
            }
        });
        jMenuEditarLista.add(jMenuItemAgregarCancion);

        jMenuItemEliminarCancion.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemEliminarCancion.setText("Eliminar Cancion");
        jMenuItemEliminarCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarCancionActionPerformed(evt);
            }
        });
        jMenuEditarLista.add(jMenuItemEliminarCancion);

        jMenuBarra.add(jMenuEditarLista);

        jMenuEstadoPrograma.setMnemonic('p');
        jMenuEstadoPrograma.setText("Estado del Programa");

        jMenuItemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemGuardar.setText("Guardar");
        jMenuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarActionPerformed(evt);
            }
        });
        jMenuEstadoPrograma.add(jMenuItemGuardar);

        jMenuItemCargarPrograma.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemCargarPrograma.setText("Cargar");
        jMenuItemCargarPrograma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCargarProgramaActionPerformed(evt);
            }
        });
        jMenuEstadoPrograma.add(jMenuItemCargarPrograma);

        jMenuBarra.add(jMenuEstadoPrograma);

        setJMenuBar(jMenuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCrearActionPerformed
        modelo.crearListaNueva();
        modelo.fireTableDataChanged();

    }//GEN-LAST:event_jMenuItemCrearActionPerformed

    private void jMenuItemAgregarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAgregarCancionActionPerformed
        JDialogCrearModificarCancion jDialog = new JDialogCrearModificarCancion(this, true);
        jDialog.setVisible(true);
        if (jDialog.getCancion() != null) {
            modelo.añadirCancion(jDialog.getCancion());
            modelo.fireTableDataChanged();
            JOptionPane.showMessageDialog(rootPane, "Se añadio correctamente", "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Cancelaste antes de terminar el proceso, por lo tanto no se añadio nada", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jMenuItemAgregarCancionActionPerformed

    private void jMenuItemEliminarCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarCancionActionPerformed
        JDialogPedirIndiceCancion jDialogIndice = new JDialogPedirIndiceCancion(this, true);
        jDialogIndice.setVisible(true);
        int indice = jDialogIndice.getIndice();
        if (modelo.eliminarCancion(indice)) {
            modelo.fireTableDataChanged();
            JOptionPane.showMessageDialog(rootPane, "Se elimino correctamente", "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se pudo eliminar", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jMenuItemEliminarCancionActionPerformed

    private void jMenuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarActionPerformed

        JFileChooser jf = new JFileChooser();
        jf.showSaveDialog(this);
        jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        File ubicacion = jf.getSelectedFile();
        String ruta = ubicacion.getParent();
        FileNameExtensionFilter filtroFicheroM3U = new FileNameExtensionFilter("Solo listas de canciones M3U", "M3U");
        FileNameExtensionFilter filtroFicheroPLS = new FileNameExtensionFilter("Solo listas de canciones PLS", "PLS");
        FileNameExtensionFilter filtroFicheroXSPF = new FileNameExtensionFilter("Solo listas de canciones XSPF", "XSPF");
        jf.setFileFilter(filtroFicheroM3U);
        jf.setFileFilter(filtroFicheroPLS);
        jf.setFileFilter(filtroFicheroXSPF);
        String extension = "";
        String nombre = "";
        int l = ubicacion.getName().lastIndexOf(".");
        if (l > 0) {
            extension = ubicacion.getName().substring(l + 1);
            nombre = ubicacion.getName().substring(0, l);
        }

        BufferedWriter bf = null;
        try {
            File archivo = new File(ruta, nombre + "." + extension);
            archivo.createNewFile();
            switch (extension.toLowerCase()) {
                case "m3u" -> {
                    bf = new BufferedWriter(new FileWriter(archivo, false));
                    PrintWriter salida = new PrintWriter(bf);
                    salida.write("#EXTM3U");
                    salida.println();
                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        salida.println("#EXTINF:" + modelo.getCancion(i).getDuracion() + "," + modelo.getCancion(i).getTitulo());
                        salida.print("");
                        salida.println(modelo.getCancion(i).getRuta());
                    }
                    bf.close();
                    JOptionPane.showMessageDialog(rootPane, "Archivo guardado correctamente", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
                }
                case "pls" -> {
                    try {
                        bf = new BufferedWriter(new FileWriter(archivo, false));
                        PrintWriter salidaPLS = new PrintWriter(bf);
                        salidaPLS.write("[playlist]");
                        salidaPLS.println();
                        int contador = 1;
                        for (int i = 0; i < modelo.getRowCount(); i++) {
                            salidaPLS.println("File" + contador + "=" + this.modelo.getCancion(i).getRuta());
                            salidaPLS.print("");
                            salidaPLS.println("Title" + contador + "=" + this.modelo.getCancion(i).getTitulo());
                            salidaPLS.print("");
                            salidaPLS.println("Length" + contador + "=" + this.modelo.getCancion(i).getDuracion());
                            contador++;
                        }
                        salidaPLS.println("NumberOfEntries" + contador);
                        salidaPLS.println("Version: 2");
                        JOptionPane.showMessageDialog(rootPane, "Archivo guardado correctamente", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        try {
                            bf.close();
                        } catch (IOException ex) {
                            System.err.println(ex.getMessage());
                        }
                    }
                }
                case "xspf" -> {
                    try {

                        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                        Document doc = docBuilder.newDocument();

                        Element playlistElement = doc.createElementNS("http://xspf.org/ns/0/", "playlist");
                        playlistElement.setAttribute("version", "1");
                        doc.appendChild(playlistElement);

                        Element trackListElement = doc.createElement("trackList");
                        playlistElement.appendChild(trackListElement);

                        TransformerFactory transformerFactory = TransformerFactory.newInstance();

                        for (int i = 0; i < this.modelo.getRowCount(); i++) {
                            NodeList listaNodo = doc.getElementsByTagName("trackList");
                            Node cancionesNode = listaNodo.item(0);
                            Cancion cancion = new Cancion(this.modelo.getCancion(i));
                            Element cancionEtiqueta;
                            cancionEtiqueta = doc.createElement("track");
                            cancionEtiqueta.appendChild(doc.createElement("location")).appendChild(doc.createTextNode(cancion.getRuta()));
                            cancionEtiqueta.appendChild(doc.createElement("title")).appendChild(doc.createTextNode(cancion.getTitulo()));
                            cancionEtiqueta.appendChild(doc.createElement("duration")).appendChild(doc.createTextNode(cancion.getDuracion() * 1000 + ""));
                            cancionesNode.appendChild(cancionEtiqueta);
                            TransformerFactory transFactory = TransformerFactory.newInstance();
                            Transformer transformer = transformerFactory.newTransformer();
                            DOMSource source = new DOMSource(doc);
                            StreamResult result = new StreamResult(new File(archivo.getAbsolutePath()));
                            transformer.transform(source, result);
                            JOptionPane.showMessageDialog(rootPane, "Se guardo correctamente", "¡Enhorabuena!", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (ParserConfigurationException | TransformerException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println("Salto este error maquina: " + ex.getMessage());
        }


    }//GEN-LAST:event_jMenuItemGuardarActionPerformed

    private void jMenuItemCargarProgramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCargarProgramaActionPerformed
        JFileChooser jf = new JFileChooser();
        jf.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filtroFichero = new FileNameExtensionFilter("Solo listas de canciones", "M3U", "PLS", "XSPF");
        jf.setFileFilter(filtroFichero);
        int comprobanteSeleccionFichero = jf.showOpenDialog(this);
        if (comprobanteSeleccionFichero == JFileChooser.APPROVE_OPTION) {
            try {
                File archivo = jf.getSelectedFile();
                String nombreArchivo = archivo.getName();
                String extension = "";
                int i = nombreArchivo.lastIndexOf(".");
                if (i > 0) {
                    extension = nombreArchivo.substring(i + 1);
                }
                switch (extension.toLowerCase()) {
                    case "m3u" -> {
                        try {
                            String tituloCancion = "";
                            String cadenaDuracion;
                            int duracion = -1;
                            String path;
                            String linea;
                            File file = new File(archivo.getPath());
                            BufferedReader bfr = new BufferedReader(new FileReader(file));
                            while ((linea = bfr.readLine()) != null) {
                                if (!linea.equals("#EXTM3U")) {
                                    String inicio = linea.substring(0, 8);
                                    if (inicio.equals("#EXTINF:")) {
                                        String lineaSplitear = linea.substring(8);
                                        String[] arraySplits = lineaSplitear.split(",");
                                        tituloCancion = arraySplits[1];
                                        cadenaDuracion = arraySplits[0];
                                        duracion = Integer.parseInt(cadenaDuracion);
                                    } else {
                                        path = linea;
                                        Cancion cancion = new Cancion(tituloCancion, path, duracion);
                                        this.modelo.añadirCancion(cancion);
                                        modelo.fireTableDataChanged();
                                    }
                                }
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println(e.getMessage());
                        } catch (IOException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    case "pls" -> {
                        String titulo = "";
                        String numero;
                        int duracion;
                        String path = "";
                        try {
                            String linea;
                            File file = new File(archivo.getPath());
                            BufferedReader bfr = new BufferedReader(new FileReader(file));
                            while ((linea = bfr.readLine()) != null) {
                                if (!linea.equals("[playlist]")) {
                                    String inicio = linea.substring(0, 4);
                                    if (inicio.equals("File")) {
                                        path = linea.substring(6);
                                    }
                                    if (inicio.equals("Titl")) {
                                        titulo = linea.substring(7);
                                    }
                                    if (inicio.equals("Leng")) {
                                        numero = linea.substring(8);
                                        duracion = Integer.parseInt(numero);
                                        Cancion cancion = new Cancion(titulo, path, duracion);
                                        this.modelo.añadirCancion(cancion);
                                        this.modelo.fireTableDataChanged();
                                    }
                                }
                            }
                        } catch (FileNotFoundException e) {
                            System.err.println(e.getMessage());
                        } catch (IOException ex) {
                            System.err.println(ex.getMessage());
                        }
                    }
                    case "xspf" -> {
                        Document documentoXML;
                        try {
                            File archivoXML = new File(archivo.getPath());
                            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                            DocumentBuilder builder = dbFactory.newDocumentBuilder();
                            documentoXML = builder.parse(archivoXML);

                            documentoXML.getDocumentElement().normalize();

                            NodeList track = documentoXML.getElementsByTagName("track");
                            for (int j = 0; j < track.getLength(); j++) {
                                Node cancion = track.item(j);
                                if (cancion.getNodeType() == Node.ELEMENT_NODE) {
                                    Element elemento = (Element) cancion;
                                    int duracionXPSF = Integer.parseInt(elemento.getElementsByTagName("duration").item(0).getTextContent());
                                    Cancion cancionXSPF = new Cancion(elemento.getElementsByTagName("title").item(0).getTextContent(), elemento.getElementsByTagName("location").item(0).getTextContent(), duracionXPSF / 1000);
                                    this.modelo.añadirCancion(cancionXSPF);
                                    this.modelo.fireTableDataChanged();
                                }
                            }
                        } catch (IOException | ParserConfigurationException | SAXException e) {
                            System.err.println(e.getMessage());
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } finally {
                JOptionPane.showMessageDialog(rootPane, "Archivo cargado correctamente", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItemCargarProgramaActionPerformed

    private void jMenuItemModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemModificarActionPerformed
        JDialogPedirIndiceCancion jDialogIndice = new JDialogPedirIndiceCancion(this, true);
        jDialogIndice.setVisible(true);
        int indice = jDialogIndice.getIndice();

        if (indice != -1) {
            if (indice >= 0 && indice <= this.modelo.getRowCount()) {
                JDialogCrearModificarCancion jDialogModificar = new JDialogCrearModificarCancion(this, true, indice, this.modelo);
                jDialogModificar.setVisible(true);
                if (jDialogModificar.getCancion() != null) {
                    this.modelo.setTitulo(indice, jDialogModificar.getCancion().getTitulo());
                    this.modelo.setRuta(indice, jDialogModificar.getCancion().getRuta());
                    this.modelo.setDuracion(indice, jDialogModificar.getCancion().getDuracion());
                    this.modelo.fireTableDataChanged();
                    JOptionPane.showMessageDialog(rootPane, "Se modifico correctamente", "¡Informacion!", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Cancelaste antes de terminar el proceso, por lo tanto no se añadio nada", "¡ERROR!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jMenuItemModificarActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBarra;
    private javax.swing.JMenu jMenuCrearLista;
    private javax.swing.JMenu jMenuEditarLista;
    private javax.swing.JMenu jMenuEstadoPrograma;
    private javax.swing.JMenuItem jMenuItemAgregarCancion;
    private javax.swing.JMenuItem jMenuItemCargarPrograma;
    private javax.swing.JMenuItem jMenuItemCrear;
    private javax.swing.JMenuItem jMenuItemEliminarCancion;
    private javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JMenuItem jMenuItemModificar;
    private javax.swing.JMenu jMenuModificarCanciones;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableAlmacenCanciones;
    // End of variables declaration//GEN-END:variables
}
