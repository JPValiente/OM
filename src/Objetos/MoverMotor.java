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
public class MoverMotor {
    
    private String motor;
    private int distancia;
    private int velocidadMotor;
    private String tipoMovimiento;
    private int sentido;
    private JTextArea area;

    public MoverMotor(String motor, int distancia, int velocidadMotor, String tipoMovimiento, int sentido) {
        if(velocidadMotor>3){
            velocidadMotor = 3;
        }else if(velocidadMotor<0){
            velocidadMotor = 1;
        }
        
        this.motor = motor;
        this.distancia = distancia;
        this.velocidadMotor = velocidadMotor;
        this.tipoMovimiento = tipoMovimiento;
        this.sentido = sentido;
        
    }
    
    
    

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getVelocidadMotor() {
        return velocidadMotor;
    }

    public void setVelocidadMotor(int velocidadMotor) {
        this.velocidadMotor = velocidadMotor;
    }
    
    
    public void asignarArea(JTextArea area){
        this.area = area;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getSentido() {
        return sentido;
    }

    public void setSentido(int sentido) {
        this.sentido = sentido;
    }

    public JTextArea getArea() {
        return area;
    }

    public void setArea(JTextArea area) {
        this.area = area;
    }
    
    
}
