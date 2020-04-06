/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author anclenius
 */
public class Texture {
    String name;
    String source;
    
    public Texture(String letter, String texture) {
        this.name = letter;
        this.source = texture;
    }

    public String getLetter() {
        return name;
    }

    public void setLetter(String letter) {
        this.name = letter;
    }

    public String getTexture() {
        return source;
    }

    public void setTexture(String texture) {
        this.source = texture;
    }
    
    
}
