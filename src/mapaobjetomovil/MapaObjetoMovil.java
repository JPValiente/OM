package mapaobjetomovil;

import GUI.Map_Editor;

public class MapaObjetoMovil implements Runnable{

    public static void main(String[] args) {
        MapaObjetoMovil a = new MapaObjetoMovil();
        a.run();
    }

    @Override
    public void run() {
        Map_Editor a = new Map_Editor();
        a.setVisible(true);
    }
    
}
