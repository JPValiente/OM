/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Analizadores.Cup.parser;
import Analizadores.Flex.Lexer;
import Controllers.ArchivoController;
import Objetos.Estructura;
import java.io.File;
import java.io.StringReader;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author jpmazate
 */
public class Interfaz extends javax.swing.JFrame {
    
    File file;
    
    public Interfaz() {
        initComponents();
    }
    
    public void abrir() {
        JFileChooser buscadorArchivos = new JFileChooser();
        int opcion = buscadorArchivos.showOpenDialog(this);
        // si se acepta el archivo entra
        if (opcion == JFileChooser.APPROVE_OPTION) {
            String archivo = buscadorArchivos.getSelectedFile().getAbsolutePath();
            String archivo1 = buscadorArchivos.getSelectedFile().toString();
            // si se encuentra el archivo pide el tiempo en milisegundos
            System.out.println("Se ha encontrado el archivo: " + archivo1);
            try {
                
                File file = new File(archivo1);
                if (file.exists()) {
                    ArchivoController carga = new ArchivoController(file);
                    this.file = file;
                    carga.leerArchivo(this.areaComandos);
                    asignarNombreArchivo(this.file.getName());
                }
                
            } catch (Exception e) {
                System.out.println("Hubo algun error");
                
            }
        } else if (opcion == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "No se ha cargado ningun archivo");
        }
        try {
            // crea el archivo que se selecciono

        } catch (Exception e) {
            System.out.println("No se selecciono ningun archivo");
        }
    }
    
    public void asignarNombreArchivo(String nombre) {
        this.labelArchivo.setText("Archivo: " + nombre);
    }
    
    public void agregarInstruccion() {
        String instruccion = comandoTextField.getText();
        if (instruccion == null || instruccion.equals("")) {
            JOptionPane.showMessageDialog(null, "LA INSTRUCCION ESTA VACIA POR FAVOR INGRESE UNA INSTRUCCION VALIDA");
        } else {
            areaComandos.append(instruccion + "\n");
        }
    }
    
    public void guardar() {
        if (file == null) {
            file = guardarComo();
            if (file != null) {
                asignarNombreArchivo(this.file.getName());
            }
        } else {
            ArchivoController carga = new ArchivoController(file);
            carga.guardarArchivo(file, areaComandos);
        }
        
    }
    
    public File guardarComo() {
        ArchivoController carga = new ArchivoController(file);
        File file = carga.guardarComoArchivo(areaComandos);
        asignarNombreArchivo(this.file.getName());
        return file;
    }
    
    public void ejecutarInstrucciones() {
        try {
            String texto = areaComandos.getText();
            StringReader reader = new StringReader(texto);
            Lexer lex = new Lexer(reader);
            parser parser = new parser(lex);
            parser.parse();
            operarComandos(parser.getEstructura());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL INTENTAR EJECUTAR LOS COMANDOS");
        }
    }
    
    public void operarComandos(Estructura estructura) throws InterruptedException {
        estructura.asignarArea(areaResultados);
        estructura.mandarDatos();
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        comandoTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaComandos = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        labelArchivo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaResultados = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        desktopPane.add(comandoTextField);
        comandoTextField.setBounds(150, 130, 360, 35);

        jLabel1.setText("Ingrese Comando");
        desktopPane.add(jLabel1);
        jLabel1.setBounds(20, 140, 130, 18);

        areaComandos.setColumns(20);
        areaComandos.setRows(5);
        jScrollPane1.setViewportView(areaComandos);

        desktopPane.add(jScrollPane1);
        jScrollPane1.setBounds(20, 180, 500, 320);

        jLabel2.setText("Archivo:");
        desktopPane.add(jLabel2);
        jLabel2.setBounds(30, 20, 70, 18);

        labelArchivo.setText("No hay ningun archivo en uso");
        desktopPane.add(labelArchivo);
        labelArchivo.setBounds(100, 20, 230, 18);

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton1);
        jButton1.setBounds(520, 130, 100, 40);

        areaResultados.setColumns(20);
        areaResultados.setRows(5);
        jScrollPane2.setViewportView(areaResultados);

        desktopPane.add(jScrollPane2);
        jScrollPane2.setBounds(530, 220, 262, 280);

        jLabel3.setText("RESULTADOS");
        desktopPane.add(jLabel3);
        jLabel3.setBounds(610, 180, 110, 18);

        jButton2.setText("Ejecutar Comandos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        desktopPane.add(jButton2);
        jButton2.setBounds(20, 100, 170, 28);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Archivo");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Abrir");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Guardar");
        saveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("GuardarComo");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setText("Acciones");

        jMenuItem1.setText("EjecutarComandos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Limpiar Area");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        abrir();
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void saveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMenuItemActionPerformed
        guardar();
    }//GEN-LAST:event_saveMenuItemActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        guardarComo();
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregarInstruccion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.areaComandos.setText("");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        ejecutarInstrucciones();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ejecutarInstrucciones();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaComandos;
    private javax.swing.JTextArea areaResultados;
    private javax.swing.JTextField comandoTextField;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelArchivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables

}
