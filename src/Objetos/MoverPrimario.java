/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import javax.swing.JTextArea;

/**
 *
 * @author jpmazate
 */
public class MoverPrimario {

    private String tipoMovimiento;
    private int distancia;
    private String tipoDistancia;
    private int velocidad;
    private JTextArea area;

    public MoverPrimario(String tipoMovimiento, int distancia, String tipoDistancia, int velocidad) {
        this.tipoMovimiento = tipoMovimiento;
        this.distancia = distancia;
        this.tipoDistancia = tipoDistancia;
        if(velocidad>3){
            velocidad = 3;
        }else if(velocidad<0){
            velocidad = 1;
        }
        
        this.velocidad = velocidad;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void asignarArea(JTextArea area) {
        this.area = area;
    }

    public void mandarCadena() {
        ComunicarArduino.getInstance();
        if (!ComunicarArduino.isConectado()) {
            ComunicarArduino.conectarArduino(ComunicarArduino.puerto);
            
        }
        String cadena = "";
        String motorA = "1";
        String motorB = "2";
        String motorC = "3";
        String motorD = "4";
        switch (tipoMovimiento) {
            case "adelante":
                cadena = "<" + motorA + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1><" + motorB + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1><" + motorC + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1><" + motorD + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1>";
                break;
            case "atras":
                cadena = "<" + motorA + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2><" + motorB + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2><" + motorC + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2><" + motorD + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2>";
                break;
            case "derecha":

                cadena = "<" + motorA + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1><" + motorB + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2><" + motorC + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2><" + motorD + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1>";
                break;
            case "izquierda":

                cadena = "<" + motorA + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2><" + motorB + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1><" + motorC + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1><" + motorD + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2>";
                break;
            case "arribaIzquierda":

                cadena = "<" + motorA + "," + 0 + "," + tipoDistancia + "," + velocidad + ",1><" + motorB + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1><" + motorC + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1><" + motorD + "," + 0 + "," + tipoDistancia + "," + velocidad + ",1>";
                break;
            case "arribaDerecha":

                cadena = "<" + motorA + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1><" + motorB + "," + 0 + "," + tipoDistancia + "," + velocidad + ",1><" + motorC + "," + 0 + "," + tipoDistancia + "," + velocidad + ",1><" + motorD + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1>";
                break;
            case "abajoIzquierda":

                cadena = "<" + motorA + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2><" + motorB + "," + 0 + "," + tipoDistancia + "," + velocidad + ",1><" + motorC + "," + 0 + "," + tipoDistancia + "," + velocidad + ",1><" + motorD + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2>";
                break;
            case "abajoDerecha":

                cadena = "<" + motorA + "," + 0 + "," + tipoDistancia + "," + velocidad + ",1><" + motorB + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2><" + motorC + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2><" + motorD + "," + 0 + "," + tipoDistancia + "," + velocidad + ",1>";
                break;
            case "girarDerecha":

                cadena = "<" + motorA + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2><" + motorB + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1><" + motorC + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2><" + motorD + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1>";
                break;
            case "girarIzquierda":
                cadena = "<" + motorA + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1><" + motorB + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2><" + motorC + "," + distancia + "," + tipoDistancia + "," + velocidad + ",1><" + motorD + "," + distancia + "," + tipoDistancia + "," + velocidad + ",2>";
                break;
            default:
                cadena = "error";
                break;
        }

        System.out.println(cadena);
        area.append(cadena + "\n");
        ComunicarArduino.mandarCadena(cadena);
    }

}
/*
  switch (tipoMovimiento) {
            case "adelante":
                 cadena = "<a,"+distancia+",10,1><b,"+distancia+",10,1><c,"+distancia+",10,1><d,"+distancia+",10,1>";
                break;
            case "atras":
                cadena = "<a,"+distancia+",10,2><b,"+distancia+",10,2><c,"+distancia+",10,2><d,"+distancia+",10,2>";
                break;
            case "derecha":
                cadena = "<a,"+distancia+",10,1><b,"+distancia+",10,2><c,"+distancia+",10,2><d,"+distancia+",10,1>";
                break;
            case "izquierda":
                cadena = "<a,"+distancia+",10,2><b,"+distancia+",10,1><c,"+distancia+",10,1><d,"+distancia+",10,2>";
                break;
            case "arribaIzquierda":
                cadena = "<a,0,10,1><b,"+distancia+",10,1><c,"+distancia+",10,1><d,0,10,0>";
                break;
            case "arribaDerecha":
                cadena = "<a,"+distancia+",10,1><b,0,10,0><c,0,10,0><d,"+distancia+",10,1>";
                break;
            case "abajoIzquierda":
                cadena = "<a,"+distancia+",10,2><b,0,10,0><c,0,10,0><d,"+distancia+",10,2>";
                break;
            case "abajoDerecha":
                cadena = "<a,0,10,0><b,"+distancia+",10,2><c,"+distancia+",10,2><d,0,10,0>";
                break;
            case "girarDerecha":
                cadena = "<a,"+distancia+",10,2><b,"+distancia+",10,1><c,"+distancia+",10,2><d,"+distancia+",10,1>";
                break;
            case "girarIzquierda":
                cadena = "<a,"+distancia+",10,1><b,"+distancia+",10,2><c,"+distancia+",10,1><d,"+distancia+",10,2>";
                break;
            default:
                cadena = "error";
                break;
        }

 */
