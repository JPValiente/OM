/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import com.panamahitek.PanamaHitek_Arduino;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author jpmazate
 */
public class EstructuraIndividual implements Estructura {

    private List<MoverMotor> lista;
    private JTextArea area;

    public EstructuraIndividual(List<MoverMotor> lista) {
        this.lista = lista;
    }

    public List<MoverMotor> getLista() {
        return lista;
    }

    public void setLista(List<MoverMotor> lista) {
        this.lista = lista;
    }

    @Override
    public void mandarDatos() {
        convertirEnCadena();
    }

    public void convertirEnCadena() {
        ComunicarArduino.getInstance();
        if (!ComunicarArduino.isConectado()) {
            ComunicarArduino.conectarArduino("puerto");
        }
        boolean bandera1 = validarInfo();

        String cadena = "";
        for (int i = 0; i < lista.size(); i++) {
            if (i == 0) {
                cadena = "<" + convertirMotor(lista.get(i).getMotor()) + "," + lista.get(i).getDistancia() + "," + lista.get(i).getTipoMovimiento()+","+lista.get(i).getVelocidadMotor() +"," +lista.get(i).getSentido()+">";
            } else {
                cadena = cadena + "<" + convertirMotor(lista.get(i).getMotor()) + "," + lista.get(i).getDistancia() + "," + lista.get(i).getTipoMovimiento()+","+lista.get(i).getVelocidadMotor() +"," +lista.get(i).getSentido()+">";
            }
        }
        System.out.println(cadena);
        area.append(cadena + "\n");
        ComunicarArduino.mandarCadena(cadena);

    }
    
    public String convertirMotor(String motor){
        switch (motor) {
            case "a":
                return "1";
            case "b":
                return "2";
            case "c":
                return "3";
            case "d":
                return "4";
            default:
                return "";
        }
    }

    public boolean validarInfo() {
        validarRepetidos();
        if (lista.size() > 4) {
            convertirEn4();
        }
        if (lista.size() < 4) {
            agregarDatosFaltantes();
        }

        return lista.size() == 4;

    }

    public void agregarDatosFaltantes() {
        boolean a = false, b = false, c = false, d = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getMotor().equals("a")) {
                a = true;
            } else if (lista.get(i).getMotor().equals("b")) {
                b = true;
            } else if (lista.get(i).getMotor().equals("c")) {
                c = true;
            } else if (lista.get(i).getMotor().equals("d")) {
                d = true;
            }
        }

        MoverMotor motor;
        if (!a) {
            motor = new MoverMotor("a", 0, 0,"C",0);
            lista.add(motor);
        }
        if (!b) {
            motor = new MoverMotor("b", 0, 0,"C",0);
            lista.add(motor);
        }
        if (!c) {
            motor = new MoverMotor("c", 0, 0,"C",0);
            lista.add(motor);
        }
        if (!d) {
            motor = new MoverMotor("d", 0, 0,"C",0);
            lista.add(motor);
                        
        }
    }

    public void validarRepetidos() {
        boolean a = false, b = false, c = false, d = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getMotor().equals("a")) {
                if (a) {
                    lista.remove(i);
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN REPETIR MOVIMIENTOS A MOTORES EN UNA MISMA INSTRUCCION");
                    i--;
                } else {
                    a = true;
                }
            } else if (lista.get(i).getMotor().equals("b")) {
                if (b) {
                    lista.remove(i);
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN REPETIR MOVIMIENTOS A MOTORES EN UNA MISMA INSTRUCCION");
                    i--;
                } else {
                    b = true;
                }
            } else if (lista.get(i).getMotor().equals("c")) {
                if (c) {
                    lista.remove(i);
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN REPETIR MOVIMIENTOS A MOTORES EN UNA MISMA INSTRUCCION");
                    i--;
                } else {
                    c = true;
                }

            } else if (lista.get(i).getMotor().equals("d")) {
                if (d) {
                    lista.remove(i);
                    JOptionPane.showMessageDialog(null, "NO SE PUEDEN REPETIR MOVIMIENTOS A MOTORES EN UNA MISMA INSTRUCCION");
                    i--;
                } else {
                    d = true;
                }
            }
        }
    }

    public void convertirEn4() {
        JOptionPane.showMessageDialog(null, "NO PUEDEN HABER MAS DE 4 INSTRUCCIONES DENTRO DE UN CICLO INI-FIN SE BORRARAN LAS ULTIMAS INSTRUCCIONES\n HASTA QUE QUEDEN SOLO 4");
        int tamano = lista.size();
        while (tamano > 4) {
            lista.remove(tamano - 1);
        }
    }

   

    @Override
    public void asignarArea(JTextArea area) {
        this.area = area;
    }

}
