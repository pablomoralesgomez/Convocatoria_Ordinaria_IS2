/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import java.util.List;
import model.Producto;
import model.Pujas;
import model.Subject;

/**
 *
 * @author Pablo
 */
public class CasaSubastas {
    
    private static CasaSubastas casaSubastas;
    private List<Subject> listaProductos;
    
    private CasaSubastas() {
        listaProductos = new ArrayList<>();
    }
    
    public static CasaSubastas getInstance() {
        if (casaSubastas == null) {
            casaSubastas = new CasaSubastas();
        }
        return casaSubastas;
    }
    
    public void addProducto(Subject newProducto) {
        listaProductos.add(newProducto);
    }
    
    public void removeProducto(Subject producto) {
        listaProductos.remove(producto);
    }
    
    public void empezarSubastaDe(Subject producto) {
        Producto prod = (Producto) listaProductos.get(listaProductos.
                indexOf(producto));
        prod.empezarPuja();
    }
    
    public List<Pujas> getPujasDe(Subject producto) {
        Producto prod = (Producto) listaProductos.get(listaProductos.
                indexOf(producto));
        return  prod.getPujasHistory();
    }
    
    public String getTiempoRestanteDe(Subject producto) {
        Producto prod = (Producto) listaProductos.get(listaProductos.
                indexOf(producto));
        return prod.getTiempoRestante();
    }
    
    public List<Subject> getSubastasActivas() {
        List<Subject> result = new ArrayList<>();
        
        for (Subject sub : listaProductos) {
            Producto producto = (Producto) sub;
            if(producto.estaActiva()) {
                result.add(producto);
            }
        }
        return result
    }
}
