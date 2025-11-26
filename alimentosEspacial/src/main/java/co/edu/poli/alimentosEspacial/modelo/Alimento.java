package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

public class Alimento extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String fechaCaducidad;
    private String tipoAlimento;
    private int caloriasPorRacion;
    
    public Alimento(String id, String nombre, double peso, double volumen, 
                   String fechaCaducidad, String tipoAlimento, int caloriasPorRacion) {
        super(id, nombre, peso, volumen);
        this.fechaCaducidad = fechaCaducidad;
        this.tipoAlimento = tipoAlimento;
        this.caloriasPorRacion = caloriasPorRacion;
    }
    
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }
    
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    public String getTipoAlimento() {
        return tipoAlimento;
    }
    
    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }
    
    public int getCaloriasPorRacion() {
        return caloriasPorRacion;
    }
    
    public void setCaloriasPorRacion(int caloriasPorRacion) {
        this.caloriasPorRacion = caloriasPorRacion;
    }
}