package Components;

import java.io.Serializable;

/**
 *
 * @author anclenius
 */
public class Coordinate implements Serializable{
    
    public int x;
    public int y;
    
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setCoordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
}
