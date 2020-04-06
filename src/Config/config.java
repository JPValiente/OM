/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Models.Texture;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author anclenius
 */
public class config {
    
    public static List<Texture> textures;
    
    public static void runConfig() {
        
    }
    
    public static void setTextures() {
        textures = new ArrayList<>();
        textures.add(new Texture("",""));
    }
    
}
