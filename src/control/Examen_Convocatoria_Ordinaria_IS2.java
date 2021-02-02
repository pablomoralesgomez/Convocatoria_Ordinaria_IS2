/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import model.Image;
import model.Producto;
import model.Subject;

/**
 *
 * @author Pablo
 */
public class Examen_Convocatoria_Ordinaria_IS2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Image> listaImagenes = new ArrayList<>();
        listaImagenes.add(new Image("Imagen1"));
        listaImagenes.add(new Image("Imagen2"));
        
        Subject producto1 = new Producto(100, "Consola Nintendo DS",listaImagenes);
        Subject producto2 = new Producto(150, "Collar de oro", listaImagenes);
        
        CasaSubastas casa = CasaSubastas.getInstance();
        casa.addProducto(producto2);
        casa.addProducto(producto2);
        
        
    }
    
}
