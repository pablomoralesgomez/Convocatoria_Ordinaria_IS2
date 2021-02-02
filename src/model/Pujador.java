/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pablo
 */
public class Pujador implements Observer{
    
    private final String nombre;
    

    public Pujador(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void update(Observer observer, String productName, double cantidad) {
        if(observer.toString().equals(nombre)) {
            System.out.println("Has pujado " + cantidad + "€.");
        } else {
            System.out.println(productName +" ha pujado " + cantidad + "€.");
        }
    } 
    
    @Override
    public String toString() {
        return nombre;
    }
}
