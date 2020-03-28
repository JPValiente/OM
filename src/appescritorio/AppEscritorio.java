/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appescritorio;

import Analizadores.Cup.parser;
import Analizadores.Flex.Lexer;
import GUI.Interfaz;
import Objetos.Estructura;
import Objetos.EstructuraIndividual;
import java.io.StringReader;

/**
 *
 * @author jpmazate
 */
public class AppEscritorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        try{
            String a = "initrayectoini moverArribaDerecha(300) fin ini moverDerecha(100) fin fintrayecto";
           // a = "ini moverDerecha(100) fin";
        StringReader r = new StringReader(a);
        Lexer lex = new Lexer(r);
        parser par = new parser(lex);
        par.parse();
            Estructura estructura = par.getEstructura();
            estructura.mandarDatos();
            
        }catch(Exception e){
        }
        
        Interfaz l = new Interfaz();
        l.setVisible(true);
    }
    
}
