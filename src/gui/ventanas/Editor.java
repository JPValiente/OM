/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ventanas;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import backend.objetos.manejadorCarrito;

/**
 *
 * @author Jony Chiroy
 */
public class Editor extends javax.swing.JFrame {

    ArrayList<String> Errores;
    ArrayList<String> tokensCorrectos;
    ArrayList<String> numeroLinea;
    manejadorCarrito nuevoManejador;
    int indice;
    int estado;
    String lexema;
    Principal ventanaP;
    
    

//Inicializamos todas las variables que vamos a utilizar, en este caso contadores y listas para guardar lexemas y errores
    private void inicializar() {
        indice = 0;
        estado = 0;
        lexema = "";

        numeroLinea = new ArrayList<>();
        Errores = new ArrayList<>();
        tokensCorrectos = new ArrayList<>();
    }

    /**
     * Creates new form Interfaz
     */
    public Editor(Principal ventanaP) {
        initComponents();
        inicializar();
        this.setLocationRelativeTo(null);
        this.ventanaP = ventanaP;
 

//        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//
//        this.addWindowListener(new WindowAdapter() {
//            @Override
//            //Con este metodo podemos configurar la accion que queremos que realize antes de cerrar nuestro programa
//            public void windowClosing(WindowEvent e) {
//
//                if (DisplayTextArea.getText().isEmpty()) {
//                    //si no hay contenido en el Display entonces se cierra automaticamente
//                    System.exit(0);
//                } else {
//                    //si encuentra texto te preguntara si realmente deseas cerrar el programa
//                    int x = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea cerrar el programa?", "Cerrar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
//                    if (x == JOptionPane.YES_OPTION) {
//                        e.getWindow().dispose();
//                    }
//                }
//
//            }
//
//        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DisplayTextArea = new javax.swing.JTextArea();
        PathTextfield = new javax.swing.JTextField();
        ArchivoLabel = new javax.swing.JLabel();
        AnalizadorLabel = new javax.swing.JLabel();
        BarraManu = new javax.swing.JMenuBar();
        ArchivoMenu = new javax.swing.JMenu();
        AbrirMenu = new javax.swing.JMenuItem();
        NuevoMenu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        GuardarMenu = new javax.swing.JMenuItem();
        SalirMenu = new javax.swing.JMenuItem();
        EditarMenu = new javax.swing.JMenu();
        CopiarMenu = new javax.swing.JMenuItem();
        CortarMenu = new javax.swing.JMenuItem();
        PegarMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor Objeto Movil");

        DisplayTextArea.setColumns(20);
        DisplayTextArea.setRows(5);
        DisplayTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DisplayTextAreaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DisplayTextAreaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DisplayTextAreaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(DisplayTextArea);

        PathTextfield.setEditable(false);
        PathTextfield.setFocusable(false);

        ArchivoLabel.setText("Archivo:");

        AnalizadorLabel.setText("↓Editor de Comandos ");
        AnalizadorLabel.setAutoscrolls(true);
        AnalizadorLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        AnalizadorLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ArchivoMenu.setText("Archivo");
        ArchivoMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ArchivoMenuMouseClicked(evt);
            }
        });

        AbrirMenu.setText("Abrir");
        AbrirMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirMenuActionPerformed(evt);
            }
        });
        ArchivoMenu.add(AbrirMenu);

        NuevoMenu.setText("Nuevo");
        NuevoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoMenuActionPerformed(evt);
            }
        });
        ArchivoMenu.add(NuevoMenu);

        jMenuItem1.setText("Guardar y Ejecutar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        ArchivoMenu.add(jMenuItem1);

        GuardarMenu.setText("Guardar");
        GuardarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarMenuActionPerformed(evt);
            }
        });
        ArchivoMenu.add(GuardarMenu);

        SalirMenu.setText("Salir");
        SalirMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirMenuActionPerformed(evt);
            }
        });
        ArchivoMenu.add(SalirMenu);

        BarraManu.add(ArchivoMenu);

        EditarMenu.setText("Editar");

        CopiarMenu.setText("Copiar");
        CopiarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CopiarMenuActionPerformed(evt);
            }
        });
        EditarMenu.add(CopiarMenu);

        CortarMenu.setText("Cortar");
        CortarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CortarMenuActionPerformed(evt);
            }
        });
        EditarMenu.add(CortarMenu);

        PegarMenu.setText("Pegar");
        PegarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PegarMenuActionPerformed(evt);
            }
        });
        EditarMenu.add(PegarMenu);

        BarraManu.add(EditarMenu);

        setJMenuBar(BarraManu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AnalizadorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ArchivoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PathTextfield))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArchivoLabel)
                    .addComponent(PathTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnalizadorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImportarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Importar");
        //Aqui se filtraran los archivos por su extension. Unicamente permitiraobservar archivos txt
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Kok", "kok");
        fileChooser.setFileFilter(filtro);
        //condición para verificar si selecciona algún archivo
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();

            String pathArchivo = fileChooser.getSelectedFile().getPath();
            PathTextfield.setText(pathArchivo);
            try {
                try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
                    String lineaTotal = "";
                    String linea = reader.readLine();
                    while (linea != null) {
                        lineaTotal = lineaTotal + linea + System.getProperty("line.separator");
                        linea = reader.readLine();
                    }
                    DisplayTextArea.setText(lineaTotal);
                    reader.close();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No importaste ningun archivo", "Sin importacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void AbrirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirMenuActionPerformed
        //si no hay modificaciones entonces abre el archivo sin inconveniente
        if (DisplayTextArea.getText().isEmpty()) {
            ImportarArchivo();

            Errores.clear();
            tokensCorrectos.clear();

        } else if (PathTextfield.getText().isEmpty() == false) {
            //si detecta que hay un archivo abierto te pregunta si deseas guardar los cambios antes de importar el archivo
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "¿Deseas guardar los cambios en el archivo actual?", "Guardar cambios", dialogButton);
            if (dialogResult == 0) {
                GuardarMenu();
                ImportarArchivo();
                Errores.clear();
                tokensCorrectos.clear();
            } else {
                JOptionPane.showMessageDialog(this, "Cambios descartados", "Sin guardar", JOptionPane.INFORMATION_MESSAGE);
                //si no queres guardar los cambios simplemente importa el archivo
                ImportarArchivo();
                Errores.clear();
                tokensCorrectos.clear();
            }
        } else {
            //Si detecta que estas trabajando un nuevo archivo te preguntara si deseas guardar cambios
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "¿Deseas guardar el texto actual?", "Guardar nuevo documento", dialogButton);
            if (dialogResult == 0) {

                JFileChooser saveFile = new JFileChooser();
                int saveOption = saveFile.showSaveDialog(this);
                if (saveOption == JFileChooser.APPROVE_OPTION) {

                    try {
                        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(saveFile.getSelectedFile().getPath()));
                        fileWriter.write(DisplayTextArea.getText());
                        fileWriter.close();
                        ImportarArchivo();
                        Errores.clear();
                        tokensCorrectos.clear();
                    } catch (Exception ex) {
                    }
                }
            } else {
                //si no queres guardar el nuevo archivo con los cambios simplemente importa el archivo
                ImportarArchivo();
                Errores.clear();
                tokensCorrectos.clear();
            }
        }
    }//GEN-LAST:event_AbrirMenuActionPerformed

    private void NuevoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoMenuActionPerformed
        if (DisplayTextArea.getText().equals("")) {

        } else if (PathTextfield.getText().isEmpty()) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "¿Deseas guardar el texto actual?", "Guardar nuevo documento", dialogButton);
            if (dialogResult == 0) {

                JFileChooser saveFile = new JFileChooser();
                int saveOption = saveFile.showSaveDialog(this);
                if (saveOption == JFileChooser.APPROVE_OPTION) {

                    try {
                        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(saveFile.getSelectedFile().getPath()));
                        fileWriter.write(DisplayTextArea.getText());
                        fileWriter.close();
                        DisplayTextArea.setText("");
                    } catch (Exception ex) {
                    }
                    JOptionPane.showMessageDialog(this, "Archivo guardado correctamente", "Guardado", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se han guardado los cambios", "Sin guardar", JOptionPane.INFORMATION_MESSAGE);
                DisplayTextArea.setText("");
            }
        } else if (PathTextfield.getText().isEmpty() == false) {
            {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                int dialogResult = JOptionPane.showConfirmDialog(this, "¿Deseas guardar los cambios del archivo actual?", "Guardar cambios", dialogButton);
                if (dialogResult == 0) {
                    GuardarMenu();
                    DisplayTextArea.setText("");
                    JOptionPane.showMessageDialog(this, "Cambios guardados correctamente", "Guardado", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    DisplayTextArea.setText("");
                    JOptionPane.showMessageDialog(this, "No se han guardado los cambios", "Sin guardar", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        PathTextfield.setText("");
    }//GEN-LAST:event_NuevoMenuActionPerformed

    private void GuardarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarMenuActionPerformed
        GuardarMenu();
    }//GEN-LAST:event_GuardarMenuActionPerformed

    private void SalirMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirMenuActionPerformed
        salir();
//        if (DisplayTextArea.getText().isEmpty() == false) {
//            int dialogButton = JOptionPane.YES_NO_OPTION;
//            int dialogResult = JOptionPane.showConfirmDialog(this, "¿Deseas cerrar sin guardar los cambios?", "Guardar documento", dialogButton);
//            if (dialogResult == 0) {
//                JOptionPane.showMessageDialog(this, "Cambios descartados", "Sin guardar", JOptionPane.INFORMATION_MESSAGE);
//                System.exit(0);
//            }
//        } else {
//            if (PathTextfield.equals("")) {
//            try {
//                GuardarComo();
//            } catch (IOException ex) {
//                Logger.getLogger(Interfaz.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            GuardarMenu();
//        }
//        }
    }//GEN-LAST:event_SalirMenuActionPerformed

    private void ArchivoMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ArchivoMenuMouseClicked
    }//GEN-LAST:event_ArchivoMenuMouseClicked

    private void CopiarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CopiarMenuActionPerformed
        DisplayTextArea.copy();
    }//GEN-LAST:event_CopiarMenuActionPerformed

    private void CortarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CortarMenuActionPerformed
        DisplayTextArea.cut();
    }//GEN-LAST:event_CortarMenuActionPerformed

    private void PegarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PegarMenuActionPerformed
        DisplayTextArea.paste();
    }//GEN-LAST:event_PegarMenuActionPerformed

    private void DisplayTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DisplayTextAreaKeyTyped
    }//GEN-LAST:event_DisplayTextAreaKeyTyped

    private void DisplayTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DisplayTextAreaKeyPressed
    }//GEN-LAST:event_DisplayTextAreaKeyPressed

    private void DisplayTextAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DisplayTextAreaKeyReleased
    }//GEN-LAST:event_DisplayTextAreaKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        GuardarMenu();
        if (PathTextfield.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "¡No hay comandos Kok para guardar!", "Oops!", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                ventanaP.manejador.resetear();
                ventanaP.abrirArchivoYEjecutarPath(PathTextfield.getText());
                repaint();
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private String path() {
        String texto = PathTextfield.getText();
        return texto;
    }

    private void GuardarComo() {
        String texto = DisplayTextArea.getText();//variable para comparacion
        if (texto.matches("[[ ]*[\n]*[\t]]*")) {//compara si en el JTextArea hay texto sino muestrtra un mensaje en pantalla
            JOptionPane.showMessageDialog(null, "¡No hay comandos Kok para guardar!", "Oops!", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivos Kok", "kok", "KOK"));//filtro para ver solo archivos Kok
            int seleccion = fileChooser.showSaveDialog(null);
            try {
                if (seleccion == JFileChooser.APPROVE_OPTION) {//comprueba si ha presionado el boton de aceptar
                    File JFC = fileChooser.getSelectedFile();
                    String PATH = JFC.getAbsolutePath();//obtenemos el path del archivo a guardar
                    PrintWriter printwriter = new PrintWriter(JFC);
                    printwriter.print(DisplayTextArea.getText());//escribe en el archivo todo lo que se encuentre en el JTextArea
                    printwriter.close();//cierra el archivo
                    //comprobamos si a la hora de guardar obtuvo la extension y si no se la asignamos
                    if (!(PATH.endsWith(".kok"))) {
                        File temp = new File(PATH + ".kok");
                        JFC.renameTo(temp);//renombramos el archivo
                        PathTextfield.setText(PATH + ".kok");
                    }
                    JOptionPane.showMessageDialog(null, "Guardado exitoso!", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {//por alguna excepcion salta un mensaje de error
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo!", "Oops! Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void GuardarMenu() {
        if (PathTextfield.getText().equals("")) {
            //Si detecta que estas trabajando un nuevo archivo abrira Guardar Como
            GuardarComo();
        } else {
            //si tienes un archivo abierto simplemente sobreescribira los cambios
            String ruta = PathTextfield.getText();
            File archivo = new File(ruta);
            BufferedWriter bw;
            if (archivo.exists()) {
                try {
                    bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write(DisplayTextArea.getText());
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Cambios guardados correctamente", "Guardado", JOptionPane.INFORMATION_MESSAGE);
                //Si el archivo abierto no existe por alguna razon, entonces creara uno nuevo
            } else {
                GuardarComo();
            }
        }
    }

    private void salir() {
        if (DisplayTextArea.getText().isEmpty() == false) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "¿Deseas cerrar sin guardar los cambios?", "Guardar documento", dialogButton);
            if (dialogResult == 0) {
                JOptionPane.showMessageDialog(this, "Cambios descartados", "Sin guardar", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        } else {
            if (PathTextfield.equals("")) {
                GuardarComo();
            } else {
                GuardarMenu();
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AbrirMenu;
    private javax.swing.JLabel AnalizadorLabel;
    private javax.swing.JLabel ArchivoLabel;
    private javax.swing.JMenu ArchivoMenu;
    private javax.swing.JMenuBar BarraManu;
    private javax.swing.JMenuItem CopiarMenu;
    private javax.swing.JMenuItem CortarMenu;
    private javax.swing.JTextArea DisplayTextArea;
    private javax.swing.JMenu EditarMenu;
    private javax.swing.JMenuItem GuardarMenu;
    private javax.swing.JMenuItem NuevoMenu;
    private javax.swing.JTextField PathTextfield;
    private javax.swing.JMenuItem PegarMenu;
    private javax.swing.JMenuItem SalirMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
