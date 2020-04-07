/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.ventanas;

import backend.analizadores.*;
import backend.objetos.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import javax.swing.text.Utilities;

/**
 *
 * @author jonyasus
 */
public class Principal extends javax.swing.JFrame implements Observer {

    manejadorCarrito manejador;
    Graphics dibujo;
    public static boolean vel1=false,vel2=false,vel3=false;

    ArrayList<Point> listaPuntos = new ArrayList<>();

     public JLabel getLabel1(){
        return carroLabel;
    }

     public JLabel getLabelMeta(){
        return labelMeta;
    }    
    public Principal() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
        manejador = new manejadorCarrito(this.editarKokTextArea, this.areaPrincipal, this.tortuga1);
        dibujo = this.getGraphics();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        editarKokTextArea = new javax.swing.JTextArea();
        MensajesServidorNoEditableLabel = new javax.swing.JLabel();
        ComandosKokNoEditableLabel = new javax.swing.JLabel();
        usuarioActualLabel = new javax.swing.JLabel();
        instrucciones1Label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        areaPrincipal = new javax.swing.JPanel();
        panelVel = new javax.swing.JPanel();
        carroLabel = new javax.swing.JLabel();
        labelMeta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        vel1Button = new javax.swing.JButton();
        vel2Button = new javax.swing.JButton();
        vel3Button = new javax.swing.JButton();
        tortuga1 = new gui.ventanas.Tortuga();
        jMenuBar1 = new javax.swing.JMenuBar();
        archivoMenu = new javax.swing.JMenu();
        abrirEditorMenuItem = new javax.swing.JMenuItem();
        abrirYejecutarMenuItem = new javax.swing.JMenuItem();
        guardarComoMenuItem = new javax.swing.JMenuItem();
        salirMenuItem = new javax.swing.JMenuItem();
        edicionMenu = new javax.swing.JMenu();
        limpiarComandosMenuItem = new javax.swing.JMenuItem();
        resetearjMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Movimiento LIbre Objeto Movil");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        editarKokTextArea.setColumns(20);
        editarKokTextArea.setRows(5);
        editarKokTextArea.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                editarKokTextAreaCaretUpdate(evt);
            }
        });
        editarKokTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                editarKokTextAreaKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editarKokTextAreaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(editarKokTextArea);

        ComandosKokNoEditableLabel.setText("Comandos");

        instrucciones1Label.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        instrucciones1Label.setText("Presiona enter para ejecutar la acción que escribiste.");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel1.setText("0,0 ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------>912");

        jLabel2.setText("Velocidades");

        areaPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout areaPrincipalLayout = new javax.swing.GroupLayout(areaPrincipal);
        areaPrincipal.setLayout(areaPrincipalLayout);
        areaPrincipalLayout.setHorizontalGroup(
            areaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        areaPrincipalLayout.setVerticalGroup(
            areaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 384, Short.MAX_VALUE)
        );

        panelVel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        carroLabel.setText("carro");

        labelMeta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));

        javax.swing.GroupLayout panelVelLayout = new javax.swing.GroupLayout(panelVel);
        panelVel.setLayout(panelVelLayout);
        panelVelLayout.setHorizontalGroup(
            panelVelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(carroLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addComponent(labelMeta, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelVelLayout.setVerticalGroup(
            panelVelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(carroLabel)
                .addContainerGap(68, Short.MAX_VALUE))
            .addComponent(labelMeta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        vel1Button.setText("Velocidad 1");
        vel1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vel1ButtonActionPerformed(evt);
            }
        });

        vel2Button.setText("Velocidad 2");
        vel2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vel2ButtonActionPerformed(evt);
            }
        });

        vel3Button.setText("Velocidad 3");
        vel3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vel3ButtonActionPerformed(evt);
            }
        });

        tortuga1.setBackground(new java.awt.Color(255, 255, 255));
        tortuga1.setForeground(new java.awt.Color(255, 255, 255));
        tortuga1.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout tortuga1Layout = new javax.swing.GroupLayout(tortuga1);
        tortuga1.setLayout(tortuga1Layout);
        tortuga1Layout.setHorizontalGroup(
            tortuga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        tortuga1Layout.setVerticalGroup(
            tortuga1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vel2Button)
                    .addComponent(vel1Button)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vel3Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tortuga1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tortuga1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vel1Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vel2Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vel3Button)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        archivoMenu.setText("Archivo");

        abrirEditorMenuItem.setText("Abrir Editor");
        abrirEditorMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirEditorMenuItemActionPerformed(evt);
            }
        });
        archivoMenu.add(abrirEditorMenuItem);

        abrirYejecutarMenuItem.setText("Abrir y Ejecutar");
        abrirYejecutarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirYejecutarMenuItemActionPerformed(evt);
            }
        });
        archivoMenu.add(abrirYejecutarMenuItem);

        guardarComoMenuItem.setText("Guardar Como");
        guardarComoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarComoMenuItemActionPerformed(evt);
            }
        });
        archivoMenu.add(guardarComoMenuItem);

        salirMenuItem.setText("Salir");
        salirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuItemActionPerformed(evt);
            }
        });
        archivoMenu.add(salirMenuItem);

        jMenuBar1.add(archivoMenu);

        edicionMenu.setText("Edicion");

        limpiarComandosMenuItem.setText("Limpiar Comandos");
        limpiarComandosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarComandosMenuItemActionPerformed(evt);
            }
        });
        edicionMenu.add(limpiarComandosMenuItem);

        resetearjMenuItem.setText("Resetear Programa");
        resetearjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetearjMenuItemActionPerformed(evt);
            }
        });
        edicionMenu.add(resetearjMenuItem);

        jMenuBar1.add(edicionMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuarioActualLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(areaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ComandosKokNoEditableLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2)
                                    .addGap(284, 284, 284))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(instrucciones1Label)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(MensajesServidorNoEditableLabel)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(panelVel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(usuarioActualLabel)
                .addGap(5, 5, 5)
                .addComponent(areaPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComandosKokNoEditableLabel)
                    .addComponent(MensajesServidorNoEditableLabel)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelVel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(instrucciones1Label)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Kok | Compiladores 1");

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void editarKokTextAreaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_editarKokTextAreaCaretUpdate

    }//GEN-LAST:event_editarKokTextAreaCaretUpdate


    private void editarKokTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editarKokTextAreaKeyTyped

    }//GEN-LAST:event_editarKokTextAreaKeyTyped

    private void abrirEditorMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirEditorMenuItemActionPerformed
        Editor nuevoEditor = new Editor(this);
        nuevoEditor.setVisible(true);
    }//GEN-LAST:event_abrirEditorMenuItemActionPerformed

    private void salirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirMenuItemActionPerformed

    private void guardarComoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarComoMenuItemActionPerformed
        GuardarComo();
    }//GEN-LAST:event_guardarComoMenuItemActionPerformed

    private void limpiarComandosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarComandosMenuItemActionPerformed
        editarKokTextArea.setText("");
    }//GEN-LAST:event_limpiarComandosMenuItemActionPerformed

    private void editarKokTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editarKokTextAreaKeyPressed
        if ((evt.getKeyCode() == KeyEvent.VK_ENTER)) {
            manejador.analizarTexto(obtenerUltimaLinea(editarKokTextArea.getText()));
        } else if (evt.getKeyCode() == 8) {
            String texto = obtenerUltimaLinea(editarKokTextArea.getText());
            if (texto.length() < 1) {
                editarKokTextArea.setText(editarKokTextArea.getText() + " ");
            }
        }
    }//GEN-LAST:event_editarKokTextAreaKeyPressed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

    }//GEN-LAST:event_formMousePressed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            
            tortuga1.loadimage("./resources/carro.png");
            tortuga1.invalidate();
            manejador.dibujarCuadroInicial();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void abrirYejecutarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirYejecutarMenuItemActionPerformed
        if (editarKokTextArea.getText().equals("")) {         
            abrirArchivoYEjecutar();
        } else {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(this, "Si realizas esta acción se perderan todos tus cambios en el area de instrucciones. ¿Deseas continuar?", "Guardar cambios", dialogButton);
            if (dialogResult == 0) {
                manejador.resetear();
                abrirArchivoYEjecutar();
            }
        }
    }//GEN-LAST:event_abrirYejecutarMenuItemActionPerformed

    private void resetearjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetearjMenuItemActionPerformed
        manejador.resetear();
        editarKokTextArea.setEditable(true);
    }//GEN-LAST:event_resetearjMenuItemActionPerformed

    private void vel1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vel1ButtonActionPerformed
        vel1=true;
        vel2=false;
        vel3=false;
        carroLabel.setLocation(0, carroLabel.getLocation().y);
        Velocidades hilo1 = new Velocidades(carroLabel, this);
        hilo1.start();
    }//GEN-LAST:event_vel1ButtonActionPerformed

    private void vel2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vel2ButtonActionPerformed
        vel1=false;
        vel2=true;
        vel3=false;
        carroLabel.setLocation(0, carroLabel.getLocation().y);
        Velocidades hilo1 = new Velocidades(carroLabel, this);
        hilo1.start();
    }//GEN-LAST:event_vel2ButtonActionPerformed

    private void vel3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vel3ButtonActionPerformed
        vel1=false;
        vel2=false;
        vel3=true;
        carroLabel.setLocation(0, carroLabel.getLocation().y);
        Velocidades hilo1 = new Velocidades(carroLabel, this);
        hilo1.start();
    }//GEN-LAST:event_vel3ButtonActionPerformed

    private String obtenerUltimaLinea(String textoEntrada) {
        int catENTER = 1;
        String textoSelect = "";
        String textoSalida = "";
        for (int i = (textoEntrada.length() - 1); i > -1; i--) {
            char letra = textoEntrada.charAt(i);
            if (catENTER > 0) {
                switch (letra) {
                    case '\r':
                    case '\n':
                        catENTER--;
                        break;
                    default:
                        textoSelect += letra;
                }
            }
        }
        for (int i = (textoSelect.length() - 1); i > -1; i--) {
            char letra = textoSelect.charAt(i);
            textoSalida += letra;
        }
        System.out.println(textoSalida);
        return textoSalida;
    }

    private void GuardarComo() {
        String texto = editarKokTextArea.getText();//variable para comparacion
        if (texto.matches("[[ ]*[\n]*[\t]]*")) {//compara si en el JTextArea hay texto sino muestrtra un mensaje en pantalla
            JOptionPane.showMessageDialog(null, "¡No hay comandos Kok para guardar!", "Oops!", JOptionPane.ERROR_MESSAGE);
        } else {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivos Kok", "kok", "KOK"));//filtro para ver solo archivos Kok
            int seleccion = fileChooser.showSaveDialog(null);
            try {
                if (seleccion == JFileChooser.APPROVE_OPTION) {//comprueba si ha presionado el boton de aceptar
                    File JFC = fileChooser.getSelectedFile();
                    String PATH = JFC.getAbsolutePath();//obtenemos el path del archivo a guardar
                    PrintWriter printwriter = new PrintWriter(JFC);
                    printwriter.print(editarKokTextArea.getText());//escribe en el archivo todo lo que se encuentre en el JTextArea
                    printwriter.close();//cierra el archivo
                    //comprobamos si a la hora de guardar obtuvo la extension y si no se la asignamos
                    if (!(PATH.endsWith(".kok"))) {
                        File temp = new File(PATH + ".kok");
                        JFC.renameTo(temp);//renombramos el archivo
                    }
                    JOptionPane.showMessageDialog(null, "Guardado exitoso!", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {//por alguna excepcion salta un mensaje de error
                JOptionPane.showMessageDialog(null, "Error al guardar el archivo!", "Oops! Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void ImportarArchivo() {
        editarKokTextArea.setText("");
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Importar");
        //Aqui se filtraran los archivos por su extension. Unicamente permitiraobservar archivos txt
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Kok", "kok");
        fileChooser.setFileFilter(filtro);
        //condición para verificar si selecciona algún archivo
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();

            String pathArchivo = fileChooser.getSelectedFile().getPath();
            try {
                try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
                    String lineaTotal = "";
                    String linea = reader.readLine();
                    while (linea != null) {
                        System.out.println("---- " + linea);
                        lineaTotal = lineaTotal + linea + System.getProperty("line.separator");
                        linea = reader.readLine();

                    }
                    editarKokTextArea.setText(lineaTotal);
                    reader.close();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No has elegido ningun archivo Kok", "Sin archivo Kok", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void abrirArchivoYEjecutar() {
        manejador.resetear();
        editarKokTextArea.setEditable(false);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Importar");
        //Aqui se filtraran los archivos por su extension. Unicamente permitiraobservar archivos txt
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos Kok", "kok");
        fileChooser.setFileFilter(filtro);
        //condición para verificar si selecciona algún archivo
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File fichero = fileChooser.getSelectedFile();
            String pathArchivo = fileChooser.getSelectedFile().getPath();
            try {
                try (BufferedReader reader = new BufferedReader(new FileReader(fichero))) {
                    String lineaTotal = "";
                    String linea = reader.readLine();
                    while (linea != null) {
                        manejador.analizarTexto(linea);
                        lineaTotal = lineaTotal + linea + System.getProperty("line.separator");
                        linea = reader.readLine();
                    }
                    editarKokTextArea.setText(lineaTotal);
                    reader.close();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No has elegido ningun archivo Kok", "Sin archivo Kok", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void abrirArchivoYEjecutarPath(String path) throws FileNotFoundException, IOException {
        manejador.resetear();
        editarKokTextArea.setEditable(false);
            FileReader f = new FileReader(path);
                try (BufferedReader reader = new BufferedReader(f)) {
                    String lineaTotal = "";
                    String linea = reader.readLine();
                    while (linea != null) {
                        manejador.analizarTexto(linea);
                        repaint();
                        lineaTotal = lineaTotal + linea + System.getProperty("line.separator");
                        linea = reader.readLine();
                    }
                    editarKokTextArea.setText(lineaTotal);
                    reader.close();
                }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ComandosKokNoEditableLabel;
    private javax.swing.JLabel MensajesServidorNoEditableLabel;
    private javax.swing.JMenuItem abrirEditorMenuItem;
    private javax.swing.JMenuItem abrirYejecutarMenuItem;
    private javax.swing.JMenu archivoMenu;
    private javax.swing.JPanel areaPrincipal;
    public javax.swing.JLabel carroLabel;
    private javax.swing.JMenu edicionMenu;
    private javax.swing.JTextArea editarKokTextArea;
    private javax.swing.JMenuItem guardarComoMenuItem;
    private javax.swing.JLabel instrucciones1Label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel labelMeta;
    private javax.swing.JMenuItem limpiarComandosMenuItem;
    private javax.swing.JPanel panelVel;
    private javax.swing.JMenuItem resetearjMenuItem;
    private javax.swing.JMenuItem salirMenuItem;
    private gui.ventanas.Tortuga tortuga1;
    private javax.swing.JLabel usuarioActualLabel;
    private javax.swing.JButton vel1Button;
    private javax.swing.JButton vel2Button;
    private javax.swing.JButton vel3Button;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
    }

}
