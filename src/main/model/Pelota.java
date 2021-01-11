package main.model;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

//Primer forma de crear hilos: Extendiendo a la clase Thread
//Segunda forma de trabajar hilos: Implementación de la interfaz Runnable
public class Pelota extends Observable implements Runnable{
    private Random random;
    private Coordenada punto;
    public Pelota(){
        random = new Random(System.currentTimeMillis());
        punto = new Coordenada(1,1);
    }

    @Override
    public void run() {
        while (true){
            punto.x = random.nextInt(600);
            punto.y = random.nextInt(400);
            this.setChanged();
            this.notifyObservers(punto);
            System.out.println(punto.x + ":" + punto.y);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
