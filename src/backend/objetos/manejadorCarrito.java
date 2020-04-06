package backend.objetos;

import backend.*;
import backend.analizadores.*;
import gui.ventanas.*;
import java.awt.Color;
import java.awt.Graphics;
import java.io.StringReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author jonyasus
 */
public class manejadorCarrito {

    ArrayList<String> mensajesServidor = new ArrayList<>();
    ArrayList<String> mensajesEncontrados = new ArrayList<>();
    JTextArea textAreaAnalizador;
    JTextArea textAreaMensajes;
    JPanel ventanaPrincipal;
    Tortuga carrito;
    int anteriorX = 453;
    int anteriorY = 279;
    int nuevaX = 0;
    int nuevaY = 50;
    int color = 0;
    int grados = 0;
    Boolean seVeCarrito = true;
    Boolean todraw = true;
    Boolean dibujar = true;
    Graphics dibujo2d;
    String cuerpo="";
    Principal p;

    public manejadorCarrito(JTextArea textAreaA, JPanel ventanaPrincipal, Tortuga koky) {
        this.textAreaAnalizador = textAreaA;
        this.carrito = koky;
        this.ventanaPrincipal = ventanaPrincipal;
        dibujo2d = ventanaPrincipal.getGraphics();
    }
    
    public String firmware(){
        String estructura="ini "
                         +cuerpo  
                         +"fin";
        return estructura;
    }

    public void resetear() {
        mensajesServidor.clear();
        mensajesEncontrados.clear();
        textAreaAnalizador.setText("");
        anteriorX = 453;
        anteriorY = 279;
        nuevaX = 0;
        nuevaY = 50;
        color = 0;
        grados = 0;
        seVeCarrito = true;
        todraw = true;
        dibujar = true;
        dibujo2d.drawRect(453, 279, 5, 5);
        carrito.RotateImage(grados);
        JOptionPane.showMessageDialog(ventanaPrincipal, "¡Programa reseteado! Ahora inicias desde cero.");
    }

    public void dibujarCuadroInicial() {
        dibujo2d.drawRect(453, 279, 5, 5);
    }

    public void clears() {
        carrito.setVisible(false);
        carrito.setVisible(true);

        if (seVeCarrito.equals(true)) {
            dibujo2d.drawRect(453, 279, 5, 5);
        }
        anteriorX = 453;
        anteriorY = 279;
    }

    public void analizarTexto(String texto) {
        mensajesEncontrados.clear();
        Analizador_Lexico_Kok lexico = new Analizador_Lexico_Kok(new StringReader(texto));
        Analizador_Sintactico_Kok sintactico = new Analizador_Sintactico_Kok(lexico, this);
        try {
            sintactico.parse();
        } catch (Exception e) {
        }
        imprimirMensajes();
    }

    public void capturarMensajes(String mensaje) {
        mensajesEncontrados.add(mensaje);
    }

    public void imprimirMensajes() {
        for (int i = 0; i < mensajesEncontrados.size(); i++) {
        }
    }


    public void right(String ang) {
        int gis = Integer.parseInt(ang);
        grados = grados + gis;       
        carrito.RotateImage(grados);
    }

    public void left(String ang) {
        int gis = Integer.parseInt(ang);
        grados = grados + (360 - gis);
       
        carrito.RotateImage(grados);
    }

    public void forward(String hipotenusa) {
        int hipotenusaInt = Integer.parseInt(hipotenusa);
        int x = (int) (anteriorX + hipotenusaInt * Math.sin(Math.toRadians(grados)));
        int y = (int) (anteriorY - hipotenusaInt * Math.cos(Math.toRadians(grados)));
        if (dibujar.equals(true)) {
            dibujo2d.drawLine(anteriorX, anteriorY, x, y);
            if (seVeCarrito.equals(true)) {
                dibujo2d.drawRect(x, y, 5, 5);
                
            }
        } else {
            if (seVeCarrito.equals(true)) {
                dibujo2d.drawRect(x, y, 5, 5);
            }
        }
        anteriorX = x;
        anteriorY = y;
        cuerpo+="";
        if (Principal.vel1) {
             cuerpo+="MoverA("+hipotenusa+",CM,1,ADELANTE";
             cuerpo+="MoverB("+hipotenusa+",CM,1,ADELANTE";
             cuerpo+="MoverC("+hipotenusa+",CM,1,ADELANTE";
             cuerpo+="MoverD("+hipotenusa+",CM,1,ADELANTE";
        }else if (Principal.vel2) {
            cuerpo+="MoverA("+hipotenusa+",CM,2,ADELANTE";
            cuerpo+="MoverB("+hipotenusa+",CM,2,ADELANTE";
            cuerpo+="MoverC("+hipotenusa+",CM,2,ADELANTE";
            cuerpo+="MoverD("+hipotenusa+",CM,2,ADELANTE";
        }else if (Principal.vel3) {
            cuerpo+="MoverA("+hipotenusa+",CM,3,ADELANTE";
            cuerpo+="MoverB("+hipotenusa+",CM,3,ADELANTE";
            cuerpo+="MoverC("+hipotenusa+",CM,3,ADELANTE";
            cuerpo+="MoverD("+hipotenusa+",CM,3,ADELANTE";
        }       
    }

    public void backward(String hipotenusa) {
        int hipotenusaInt = Integer.parseInt(hipotenusa);
        int x = (int) (anteriorX - hipotenusaInt * Math.sin(Math.toRadians(grados)));
        int y = (int) (anteriorY + hipotenusaInt * Math.cos(Math.toRadians(grados)));
        if (dibujar.equals(true)) {
            dibujo2d.drawLine(anteriorX, anteriorY, x, y);
            if (seVeCarrito.equals(true)) {
                dibujo2d.drawRect(x, y, 5, 5);
            }
        } else {
            if (seVeCarrito.equals(true)) {
                dibujo2d.drawRect(x, y, 5, 5);
            }
        }
        anteriorX = x;
        anteriorY = y;
        cuerpo+="";
         if (Principal.vel1) {
             cuerpo+="MoverA("+hipotenusa+",CM,1,ATRAS";
             cuerpo+="MoverB("+hipotenusa+",CM,1,ATRAS";
             cuerpo+="MoverC("+hipotenusa+",CM,1,ATRAS";
             cuerpo+="MoverD("+hipotenusa+",CM,1,ATRAS";
        }else if (Principal.vel2) {
            cuerpo+="MoverA("+hipotenusa+",CM,2,ATRAS";
            cuerpo+="MoverB("+hipotenusa+",CM,2,ATRAS";
            cuerpo+="MoverC("+hipotenusa+",CM,2,ATRAS";
            cuerpo+="MoverD("+hipotenusa+",CM,2,ATRAS";
        }else if (Principal.vel3) {
            cuerpo+="MoverA("+hipotenusa+",CM,3,ATRAS";
            cuerpo+="MoverB("+hipotenusa+",CM,3,ATRAS";
            cuerpo+="MoverC("+hipotenusa+",CM,3,ATRAS";
            cuerpo+="MoverD("+hipotenusa+",CM,3,ATRAS";
        }
    }

    public void tocenter() {
        if (dibujar.equals(true)) {
            if (seVeCarrito.equals(true)) {
                dibujo2d.drawRect(453, 279, 5, 5);
            }
            dibujo2d.drawLine(anteriorX, anteriorY, 453, 279);
            anteriorX = 453;
            anteriorY = 279;
        } else {
            if (seVeCarrito.equals(true)) {
                dibujo2d.drawRect(453, 279, 5, 5);
            }
            anteriorX = 453;
            anteriorY = 279;
        }
       
    }

    public void positionX(String valorX) {
        int valX = Integer.parseInt(valorX);
        if (dibujar.equals(true)) {
            if (seVeCarrito.equals(true)) {
                dibujo2d.drawRect(valX, anteriorY, 5, 5);
            }
           // dibujo2d.drawLine(anteriorX, anteriorY, valX, anteriorY);
            anteriorX = valX;
        } else {
            if (seVeCarrito.equals(true)) {
                dibujo2d.drawRect(valX, anteriorY, 5, 5);
            }
            anteriorX = valX;
        }
      
    }

    public void repeat(String n, ArrayList<String> funciones) {
        int nInt = Integer.parseInt(n);
        System.out.println(funciones);
        for (int i = 1; i < nInt; i++) {
            for (int j = 0; j < funciones.size(); j++) {
                analizarTexto(funciones.get(j));
            }
        }
  
    }

    public void positionY(String valorY) {
        int valY = Integer.parseInt(valorY);
        if (dibujar.equals(true)) {
            if (seVeCarrito.equals(true)) {
                dibujo2d.drawRect(anteriorX, valY, 5, 5);
            }
            //dibujo2d.drawLine(anteriorX, anteriorY, anteriorX, valY);
            anteriorY = valY;
        } else {
            if (seVeCarrito.equals(true)) {
               dibujo2d.drawRect(anteriorX, valY, 5, 5);
            }
            anteriorY = valY;
        }
       
    }

    public void positionXY(String valorX, String valorY) {
        int valY = Integer.parseInt(valorY);
        int valX = Integer.parseInt(valorX);
        if (dibujar.equals(true)) {
            if (seVeCarrito.equals(true)) {
               dibujo2d.drawRect(valX, valY, 5, 5);
            }
           // dibujo2d.drawLine(anteriorX, anteriorY, valX, valY);
            anteriorY = valY;
            anteriorX = valX;
        } else {
            if (seVeCarrito.equals(true)) {
                dibujo2d.drawRect(valX, valY, 5, 5);
            }
            anteriorY = valY;
            anteriorX = valX;
        }
      
    }
}
