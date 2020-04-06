/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Components.MapMatrix;
import Components.Pixel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author anclenius
 */
public class Map_Editor extends javax.swing.JFrame implements Runnable{

    /**
     * Creates new form Map_Editor
     */
    public static MapMatrix map;
    public static MapMatrix newMap;
    public static final int COLUMNS = 100;
    public static final int ROW = 100;
    public static int pixelSize;
    public static boolean writing = true;
    public static boolean mouseOn = false;
    public static String currentTexture = "/Resources/Filled_Square_Mini.JPG";
    public static boolean loading = false;
    public static String path = "";
    public static String loadingPath = "";

    public Map_Editor() {
        initComponents();
        pixelSize = 1;
        map = new MapMatrix();
        for (int y = 0; y < COLUMNS; y++) {
            for (int x = 0; x < ROW; x++) {
                this.mapBuilder.add(map.getPixel(x, y));
            }
        }
        this.loading = false;
        this.pixelSize1.setSelected(true);
        this.pixelSize2.setSelected(false);
        this.pixelSize4.setSelected(false);
        this.pixelSize8.setSelected(false);
    }

    public Map_Editor(MapMatrix ma) {
        initComponents();
        pixelSize = 1;
        map = new MapMatrix(ma.returnMatrix());
        for (int y = 0; y < COLUMNS; y++) {
            for (int x = 0; x < ROW; x++) {
                Pixel pixel = map.getPixel(x, y);
                this.mapBuilder.add(pixel);
                pixel.initializeListeners();
            }
        }
        this.pixelSize1.setSelected(true);
        this.pixelSize2.setSelected(false);
        this.pixelSize4.setSelected(false);
        this.pixelSize8.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        mapBuilder = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Status = new javax.swing.JLabel();
        black = new javax.swing.JButton();
        red = new javax.swing.JButton();
        blue = new javax.swing.JButton();
        yellow = new javax.swing.JButton();
        orange = new javax.swing.JButton();
        green = new javax.swing.JButton();
        purple = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        pixelSize1 = new javax.swing.JRadioButtonMenuItem();
        pixelSize2 = new javax.swing.JRadioButtonMenuItem();
        pixelSize4 = new javax.swing.JRadioButtonMenuItem();
        pixelSize8 = new javax.swing.JRadioButtonMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editor de mapas");
        setPreferredSize(new java.awt.Dimension(740, 780));
        setResizable(false);

        mapBuilder.setPreferredSize(new java.awt.Dimension(720, 780));
        mapBuilder.setLayout(new java.awt.GridLayout(100, 100));

        jToolBar1.setRollover(true);

        jButton1.setText("Trazo");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton2.setText("Borrar");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jLabel1.setText("                          ");
        jToolBar1.add(jLabel1);

        Status.setText("Trazando...                ");
        jToolBar1.add(Status);

        black.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Filled_Square_Mini.JPG"))); // NOI18N
        black.setFocusable(false);
        black.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        black.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        black.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blackActionPerformed(evt);
            }
        });
        jToolBar1.add(black);

        red.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/red.JPG"))); // NOI18N
        red.setFocusable(false);
        red.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        red.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        red.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redActionPerformed(evt);
            }
        });
        jToolBar1.add(red);

        blue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/blue.JPG"))); // NOI18N
        blue.setFocusable(false);
        blue.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        blue.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        blue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueActionPerformed(evt);
            }
        });
        jToolBar1.add(blue);

        yellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/yellow.JPG"))); // NOI18N
        yellow.setFocusable(false);
        yellow.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        yellow.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        yellow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yellowActionPerformed(evt);
            }
        });
        jToolBar1.add(yellow);

        orange.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/orange.JPG"))); // NOI18N
        orange.setFocusable(false);
        orange.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        orange.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        orange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orangeActionPerformed(evt);
            }
        });
        jToolBar1.add(orange);

        green.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/green.JPG"))); // NOI18N
        green.setFocusable(false);
        green.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        green.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        green.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenActionPerformed(evt);
            }
        });
        jToolBar1.add(green);

        purple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/purple.JPG"))); // NOI18N
        purple.setFocusable(false);
        purple.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        purple.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        purple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purpleActionPerformed(evt);
            }
        });
        jToolBar1.add(purple);

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Guardar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Cargar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem6.setText("Ver mapa actual");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Pixel");

        pixelSize1.setSelected(true);
        pixelSize1.setText("1x1");
        pixelSize1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pixelSize1ActionPerformed(evt);
            }
        });
        jMenu3.add(pixelSize1);

        pixelSize2.setSelected(true);
        pixelSize2.setText("2x2");
        pixelSize2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pixelSize2ActionPerformed(evt);
            }
        });
        jMenu3.add(pixelSize2);

        pixelSize4.setSelected(true);
        pixelSize4.setText("4x4");
        pixelSize4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pixelSize4ActionPerformed(evt);
            }
        });
        jMenu3.add(pixelSize4);

        pixelSize8.setSelected(true);
        pixelSize8.setText("8x8");
        pixelSize8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pixelSize8ActionPerformed(evt);
            }
        });
        jMenu3.add(pixelSize8);
        jMenu3.add(jSeparator1);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Mapas prediseñados");

        jMenuItem3.setText("Facil");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Medio");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Dificil");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mapBuilder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapBuilder, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        writing = true;
        this.Status.setText("Trazando...");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        writing = false;
        this.Status.setText("Borrando...");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pixelSize1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pixelSize1ActionPerformed
        pixelSize = 1;
        this.pixelSize1.setSelected(true);
        this.pixelSize2.setSelected(false);
        this.pixelSize4.setSelected(false);
        this.pixelSize8.setSelected(false);
    }//GEN-LAST:event_pixelSize1ActionPerformed

    private void pixelSize2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pixelSize2ActionPerformed
        pixelSize = 2;
        this.pixelSize1.setSelected(false);
        this.pixelSize2.setSelected(true);
        this.pixelSize4.setSelected(false);
        this.pixelSize8.setSelected(false);
    }//GEN-LAST:event_pixelSize2ActionPerformed

    private void pixelSize4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pixelSize4ActionPerformed
        pixelSize = 4;
        this.pixelSize1.setSelected(false);
        this.pixelSize2.setSelected(false);
        this.pixelSize4.setSelected(true);
        this.pixelSize8.setSelected(false);
    }//GEN-LAST:event_pixelSize4ActionPerformed

    private void pixelSize8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pixelSize8ActionPerformed
        pixelSize = 8;
        this.pixelSize1.setSelected(false);
        this.pixelSize2.setSelected(false);
        this.pixelSize4.setSelected(false);
        this.pixelSize8.setSelected(true);
    }//GEN-LAST:event_pixelSize8ActionPerformed

    private void blackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blackActionPerformed
        Map_Editor.currentTexture = "/Resources/Filled_Square_Mini.JPG";
    }//GEN-LAST:event_blackActionPerformed

    private void redActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redActionPerformed
        Map_Editor.currentTexture = "/Resources/red.JPG";
    }//GEN-LAST:event_redActionPerformed

    private void blueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueActionPerformed
        Map_Editor.currentTexture = "/Resources/blue.JPG";
    }//GEN-LAST:event_blueActionPerformed

    private void yellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yellowActionPerformed
        Map_Editor.currentTexture = "/Resources/yellow.JPG";
    }//GEN-LAST:event_yellowActionPerformed

    private void orangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orangeActionPerformed
        Map_Editor.currentTexture = "/Resources/orange.JPG";
    }//GEN-LAST:event_orangeActionPerformed

    private void greenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenActionPerformed
        Map_Editor.currentTexture = "/Resources/green.JPG";
    }//GEN-LAST:event_greenActionPerformed

    private void purpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purpleActionPerformed
        Map_Editor.currentTexture = "/Resources/purple.JPG";
    }//GEN-LAST:event_purpleActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int status = fileChooser.showOpenDialog(rootPane);
        if (status == JFileChooser.APPROVE_OPTION) {
            String fileName = fileChooser.getSelectedFile().toString();
            if (!fileName.contains(".bm")) {
                fileName += ".bm";
            }

            boolean flag = Map_Editor.map.saveMap(fileName);
            if (flag) {
                JOptionPane.showMessageDialog(null, "Mapa guardado");
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el mapa");
            }

        }
        
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.loading = true;
        this.start();
        this.run();
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.loading = true;
        
        loadingPath = "./src/Maps/easy.bm";
        this.start();
        this.run();
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.loading = true;
        
        loadingPath = "./src/Maps/medium.bm";
        this.start();
        this.run();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.loading = true;
        loadingPath = "./src/Maps/hard.bm";
        this.start();
        this.run();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Viewer v = new Viewer(map);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    public MapMatrix loadMap(String path) throws IOException {
        File file = new File(path);
        System.out.println(file.exists());
        try (FileInputStream fileInputStream = new FileInputStream(file);
                ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);) {
            return (MapMatrix) inputStream.readObject();
        } catch (IOException e) {
            System.out.println(path);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Esto no es un mapa");
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public void run() {
        String currentEditingFile = "";
        if(loadingPath.equals("")) {
            int status = fileChooser.showOpenDialog(rootPane);
            if (status == fileChooser.APPROVE_OPTION) {
                currentEditingFile = fileChooser.getSelectedFile().getAbsolutePath();
                System.out.println(currentEditingFile);
                path = currentEditingFile;
                try {newMap = loadMap(path);} catch (IOException ex) {}
                loading = false;
                this.dispose();

                Map_Editor a = new Map_Editor(newMap);
                a.setVisible(true);

            }
        } else {
                currentEditingFile = loadingPath;
                path = currentEditingFile;
                try {newMap = loadMap(path);} catch (IOException ex) {}
                loading = false;
                this.dispose();

                Map_Editor a = new Map_Editor(newMap);
                a.setVisible(true);
        }
        loading = false;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Status;
    private javax.swing.JButton black;
    private javax.swing.JButton blue;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton green;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel mapBuilder;
    private javax.swing.JButton orange;
    private javax.swing.JRadioButtonMenuItem pixelSize1;
    private javax.swing.JRadioButtonMenuItem pixelSize2;
    private javax.swing.JRadioButtonMenuItem pixelSize4;
    private javax.swing.JRadioButtonMenuItem pixelSize8;
    private javax.swing.JButton purple;
    private javax.swing.JButton red;
    private javax.swing.JButton yellow;
    // End of variables declaration//GEN-END:variables

    private void start() {
        Thread loadingScreen = new Thread() {
            public void run() {
                try {
                    map.loading();
                } catch (InterruptedException ex) {
                }
            }
        };
        loadingScreen.start();
    }

    //Metodo de Carga
}
