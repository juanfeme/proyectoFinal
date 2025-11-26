package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

public class Herramienta extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String funcion;
    private String material;
    private boolean requiereEnergia;
    
    public Herramienta(String id, String nombre, double peso, double volumen, 
                     String funcion, String material, boolean requiereEnergia) {
        super(id, nombre, peso, volumen);
        this.funcion = funcion;
        this.material = material;
        this.requiereEnergia = requiereEnergia;
    }
    
    public String getFuncion() {
        return funcion;
    }
    
    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public void setMaterial(String material) {
        this.material = material;
    }
    
    public boolean isRequiereEnergia() {
        return requiereEnergia;
    }
    
    public void setRequiereEnergia(boolean requiereEnergia) {
        this.requiereEnergia = requiereEnergia;
    }
}