package Components;

import GUI.Map_Editor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author anclenius
 */
public class MapMatrix extends Thread implements Serializable {

    public Pixel[][] map = new Pixel[Map_Editor.ROW][Map_Editor.COLUMNS];
    private Coordinate[] previousCar = new Coordinate[4];
    private Coordinate[] car = new Coordinate[4];
    private boolean viewerModeOn;
    public MapMatrix() {
        viewerModeOn = false;
        for (int y = 0; y < Map_Editor.COLUMNS; y++) {
            for (int x = 0; x < Map_Editor.ROW; x++) {
                Pixel pixel = new Pixel(x, y);
                map[x][y] = pixel;
            }
        }
    }
    
    public MapMatrix(Pixel[][] map) {
        viewerModeOn = false;
        this.map = map;
        for (Pixel[] pixels : this.map) {
            for (Pixel pixel : pixels) {
                pixel.initializeListeners();
            }
        }
    }

    public Pixel[][] returnMatrix() {
        return map;
    }

    public Pixel getPixel(int x, int y) {
        try {
            return map[x][y];
        } catch (Exception ex) {
            System.out.println("laptm");
            return null;
        }
    }
    
    public boolean saveMap(String path) {

        File file = new File(path);

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
                ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);) {
            outputStream.writeObject(this);
        } catch (IOException e) {
            System.out.println("Error de conexion con el archivo");
        }

        return true;
    }

    public void loading() throws InterruptedException {
        int x = 47;
        int y = 40;
        int t = 0;
        while (Map_Editor.loading) {
            for (x = 47; x <= 53; x++) {
                this.blinkPixel(x, y);
            }
            for (y = 40; y <= 46; y++) {
                this.blinkPixel(x, y);
            }

            for (x = 53; x >= 47; x--) {
                this.blinkPixel(x, y);
            }

            for (y = 46; y >= 40; y--) {
                this.blinkPixel(x, y);
            }
            t++;
        }
    }

    public void blinkPixel(int x, int y) throws InterruptedException {
        Pixel pix;
        pix = getPixel(x, y);
        pix.fillPixel();
        Thread.sleep(100);
        pix.clearPixel();
        System.out.println("blinkee");
    }

    @Override
    public void run() {
        try {
            this.loading();
        } catch (InterruptedException ex) {
            Logger.getLogger(MapMatrix.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setCar() {
        this.car[0] = new Coordinate(4,5);
        this.car[1] = new Coordinate(4,6);
        this.car[2] = new Coordinate(3,5);
        this.car[3] = new Coordinate(3,6);
        this.map[this.car[0].x][this.car[0].y].carOn();
        this.map[this.car[1].x][this.car[1].y].carOn();
        this.map[this.car[2].x][this.car[2].y].carOn();
        this.map[this.car[3].x][this.car[3].y].carOn();
        
    }
    
    public String moveCar() {
        String log = "";
        log += this.map[this.car[0].x][this.car[0].y].carOn();
        log += this.map[this.car[1].x][this.car[1].y].carOn();
        log += this.map[this.car[2].x][this.car[2].y].carOn();
        log += this.map[this.car[3].x][this.car[3].y].carOn();
        return log;
    }
    
    public void removeCar() {
        this.map[this.car[0].x][this.car[0].y].carOff();
        this.map[this.car[1].x][this.car[1].y].carOff();
        this.map[this.car[2].x][this.car[2].y].carOff();
        this.map[this.car[3].x][this.car[3].y].carOff();
    }
    /*
    1 = left
    2 = up
    3 = right 
    4 = down
    */
    public String moveCar(int a) {
        String log = "";
        if(a == 1) {
            this.removeCar();
            this.car[0].setCoordinate(this.car[0].x-1, this.car[0].y);
            this.car[1].setCoordinate(this.car[1].x-1, this.car[1].y);
            this.car[2].setCoordinate(this.car[2].x-1, this.car[2].y);
            this.car[3].setCoordinate(this.car[3].x-1, this.car[3].y);
            log+="Me movi a la izquierda\n";
            log+=this.moveCar();
        } else if (a == 2) {
            this.removeCar();
            this.car[0].setCoordinate(this.car[0].x, this.car[0].y-1);
            this.car[1].setCoordinate(this.car[1].x, this.car[1].y-1);
            this.car[2].setCoordinate(this.car[2].x, this.car[2].y-1);
            this.car[3].setCoordinate(this.car[3].x, this.car[3].y-1);
            log+="Me movi hacia arriba\n";
            log+=this.moveCar();
        } else if (a == 3) {
            this.removeCar();
            this.car[0].setCoordinate(this.car[0].x+1, this.car[0].y);
            this.car[1].setCoordinate(this.car[1].x+1, this.car[1].y);
            this.car[2].setCoordinate(this.car[2].x+1, this.car[2].y);
            this.car[3].setCoordinate(this.car[3].x+1, this.car[3].y);
            log+="Me movi a la derecha\n";
            log+=this.moveCar();
        } else if (a == 4) {
            this.removeCar();
            this.car[0].setCoordinate(this.car[0].x, this.car[0].y+1);
            this.car[1].setCoordinate(this.car[1].x, this.car[1].y+1);
            this.car[2].setCoordinate(this.car[2].x, this.car[2].y+1);
            this.car[3].setCoordinate(this.car[3].x, this.car[3].y+1);
            log+="Me movi hacia abajo\n";
            log+=this.moveCar();
        }
        return log;
    }
}
