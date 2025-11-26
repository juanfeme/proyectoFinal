package co.edu.poli.alimentosEspacial.servicios;

import co.edu.poli.alimentosEspacial.modelo.Producto;

public interface OperacionCRUD {
    
    String create(Producto objeto);
    
    Producto[] read();
    
    Producto readId(String id);
    
    String update(String id, Producto objeto);
    
    Producto delete(String id);
}