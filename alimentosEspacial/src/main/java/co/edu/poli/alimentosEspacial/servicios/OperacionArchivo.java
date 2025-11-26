package co.edu.poli.alimentosEspacial.servicios;

import co.edu.poli.alimentosEspacial.modelo.Producto;

public interface OperacionArchivo {
    
    String serializar(Producto[] productos, String path, String name);
    
    Producto[] deserializar(String path, String name);
}