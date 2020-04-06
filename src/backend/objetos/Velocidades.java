package backend.objetos;


import gui.ventanas.Principal;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author richard
 */
public class Velocidades extends Thread{
    private JLabel eti;
    private Principal p;
    boolean bandera3=false;
    
    
    public Velocidades(JLabel eti, Principal p){
        this.eti = eti;
        this.p = p;
    }
    
    public void run(){
        int c1=0;
        if (Principal.vel1) {
            while (true){
                try{
                sleep((int)(Math.random()*3000));
                c1 = p.carroLabel.getLocation().x;
                    if (c1<p.getLabelMeta().getLocation().x-10) {
                        eti.setLocation(eti.getLocation().x+10,eti.getLocation().y);
                        p.repaint();
                    }else{
                        break;
                    }
                
    
                }catch(InterruptedException e){
            
                }
                
            }
        }else if (Principal.vel2) {
            while (true){
            try{
                sleep((int)(Math.random()*600));
                c1 = p.carroLabel.getLocation().x;
                    if (c1<p.getLabelMeta().getLocation().x-10) {
                        eti.setLocation(eti.getLocation().x+10,eti.getLocation().y);
                        p.repaint();
                    }else{
                        break;
                    }
    
            }catch(InterruptedException e){
            
            }
            }
        }else if (Principal.vel3) {
            while (true){
                try{
                    sleep((int)(Math.random()*200));
                    c1 = p.carroLabel.getLocation().x;
                        if (c1<p.getLabelMeta().getLocation().x-10) {
                            eti.setLocation(eti.getLocation().x+10,eti.getLocation().y);
                            p.repaint();
                        }else{
                            break;
                        }
                
    
                }catch(InterruptedException e){
            
                }
                
            }
       
            
        }
    }
}
