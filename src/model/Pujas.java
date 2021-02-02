/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Pablo
 */
public class Pujas {
    
    private final Observer pujador;
    private final double precio;
    private final Date momentoPuja;
    
    public Pujas(Observer pujador, double precio, Date momentoPuja) {
        this.pujador = pujador;
        this.precio = precio;
        this.momentoPuja = momentoPuja;
    }

    public Observer getPujador() {
        return pujador;
    }

    public double getPrecio() {
        return precio;
    }

    public Date getMomentoPuja() {
        return momentoPuja;
    }
    
    
    
}
