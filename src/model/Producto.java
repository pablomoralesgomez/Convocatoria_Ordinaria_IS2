/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import static model.Producto.Estado.*;

/**
 *
 * @author Pablo
 */
public class Producto implements Subject{
    
    private double precioInicial;
    private final List<Observer> pujadores;
    private final List<Image> imagenesProducto;
    private final List<Pujas> pujas;
    private final String nombreProducto;
    private Estado estado;
    private Timer timer;
    private int tiempoRestante;

    public Producto(double precioInicial, String nombreProducto, List<Image> imagenesProducto) {
        this.precioInicial = precioInicial;
        this.pujadores = new ArrayList<>();
        this.imagenesProducto = imagenesProducto;
        this.nombreProducto = nombreProducto;
        this.estado = SIN_SUBASTAR;
        this.tiempoRestante = 30;
        
        this.pujas = new ArrayList<>();
        this.pujas.add(new Pujas(null, precioInicial, new Date())); 
    }
    
    @Override    
    public void registerObserver(Observer observer) {
        pujadores.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        pujadores.remove(observer);
    }

    @Override
    public void notifyObservers(Observer observer, double precio) {
        for (Observer pujador : pujadores) {
            pujador.update(observer, nombreProducto, precio);
        }
    }
    
    public void setPuja(Observer pujador, double nuevoPrecio) {
        if(!estado.equals(SUBASTANDO))   {
            if(nuevoPrecio <= precioInicial) {
                System.out.println(pujador.toString() + "no puedes hacer una puja"
                        + " menor o igual a la actual (" + precioInicial + "€);");
            } else {
                this.pujas.add(new Pujas(pujador, nuevoPrecio, new Date())); 
                precioInicial = nuevoPrecio;
                notifyObservers(pujador, nuevoPrecio);
            } 
        } else {
            System.out.println("No puedes pujar por este producto.");
        }
    } 
    
    public List<Image> getProductImages(){
        return imagenesProducto;
    }
    
    public List<Pujas> getPujasHistory(){
        return pujas;
    }
    
    public String getTiempoRestante() {
        return "Quedan " + tiempoRestante + " segundos.";
    }
    
    public void empezarPuja() {
        System.out.println("La puja del producto " + nombreProducto 
                + " ha comenzado.");
        
        timer = new Timer();
        this.timer.schedule(task(), 0, 1000);
        changeState();
        System.out.println("Comienza la subasta.");
    }
    
    public void changeState() {
        if(estado.equals(SIN_SUBASTAR)) {
            estado = SUBASTANDO;
        } else {
            estado = SUBASTADO;
        }
    }

    private TimerTask task() {
        return new TimerTask() {
            
            private int totalTime = 30;
            private int startTime = 0;
            
            @Override
            public void run() {
                if(estado.equals(SUBASTADO)) timer.cancel();
                
                startTime++;
                tiempoRestante = totalTime - startTime;
                if(tiempoRestante == 0) {
                    changeState();
                }
            }
            
            
        };
    }
    
    
    
    public enum Estado {
        SIN_SUBASTAR, SUBASTANDO, SUBASTADO;
    }
    
}
