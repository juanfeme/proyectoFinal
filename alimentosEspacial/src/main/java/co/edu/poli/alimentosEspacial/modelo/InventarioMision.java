package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

public class InventarioMision implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String fechaRegistro;
    
    public InventarioMision(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    public String agregarProducto() {
        return "Producto agregado al inventario";
    }
    
    public String eliminarProducto() {
        return "Producto eliminado del inventario";
    }
    
    public String generarReporte() {
        return "Reporte generado del inventario";
    }
    
    public String getFechaRegistro() {
        return fechaRegistro;
    }
    
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}