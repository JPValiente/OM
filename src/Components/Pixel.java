/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import GUI.Map_Editor;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.JLabel;

/**
 *
 * @author anclenius
 */

//Se hace saber que cada pixel que representa esta clase corresponde a 5 centimetros a escala completa
public class Pixel extends JLabel implements Serializable{
    private int x;
    private int y;
    private boolean wall;
    public String texture;
    private boolean isCarOn;
    private MouseAdapter mouse;
    public Pixel(int x, int y) {
        super();
        this.isCarOn = false;
        this.texture = "/Resources/Empty_Square_Mini.JPG";
        this.x = x;
        this.y = y;
        this.wall = false;
        super.setText("");
        super.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Empty_Square_Mini.JPG")));
        this.initializeListeners();
    }
    
    public String carOn() {
        if(this.wall) return "Estoy sobre una textura\n";
        super.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/gray.JPG")));
        return "";
    }
    
    public void carOff() {
        super.setIcon(new javax.swing.ImageIcon(getClass().getResource(this.texture)));
    }
    
    public void fillPixel() {
        this.wall = true;
        super.setBackground(Color.BLACK);
        this.texture = Map_Editor.currentTexture;
        super.setIcon(new javax.swing.ImageIcon(getClass().getResource(this.texture)));
        
        MapMatrix map = Map_Editor.map;
        for (int i = 0; i < Map_Editor.pixelSize; i++) {
            for (int j = 0; j < Map_Editor.pixelSize; j++) {
                try {
                    map.getPixel(x+i, y+j).fillPixelRecursive();
                } catch (Exception ex) {
                    System.out.println("Excepcion encontrada");
                }
            }
        }
    }
    
    public void fillPixelRecursive() {
        this.wall = true;
        super.setBackground(Color.BLACK);
        this.texture = Map_Editor.currentTexture;
        super.setIcon(new javax.swing.ImageIcon(getClass().getResource(this.texture)));
    }
    
    public void clearPixel() {
        this.wall = false;
        super.setBackground(Color.yellow);
        super.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Empty_Square_Mini.JPG")));
        MapMatrix map = Map_Editor.map;
        for (int i = 0; i < Map_Editor.pixelSize; i++) {
            for (int j = 0; j < Map_Editor.pixelSize; j++) {
                try {
                    map.getPixel(x+i, y+j).clearPixelRecursive();
                } catch (Exception ex) {
                    System.out.println("Excepcion encontrada");
                }
            }
        }
    }
    
    public void clearPixelRecursive() {
        this.wall = false;
        super.setBackground(Color.yellow);
        super.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Empty_Square_Mini.JPG")));
        
    }
    
    public void initializeListeners() {
        this.mouse = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Map_Editor.mouseOn = true;
                if(Map_Editor.writing) {
                    
                    fillPixel();
                } else {
                    clearPixel();
                }
            }
            
            public void mouseReleased(MouseEvent e) {
                Map_Editor.mouseOn = false;
            }
            public void mouseEntered(MouseEvent e) {
                if(Map_Editor.mouseOn) {
                    if(Map_Editor.writing) {
                        fillPixel();
                    } else {
                        clearPixel();
                    }
                }
            }
            
            public void mouseClicked(MouseEvent e) {
                if(Map_Editor.writing) {
                    fillPixel();
                } else {
                    clearPixel();
                }
            }
            
            
        };
        this.addMouseListener(this.mouse);
    }

    
    
}
