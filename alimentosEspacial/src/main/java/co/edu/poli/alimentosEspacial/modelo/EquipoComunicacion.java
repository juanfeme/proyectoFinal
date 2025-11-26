package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

public class EquipoComunicacion extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String tipoComunicacion;
    private double rangoFrecuencia;
    private int potencia;
    
    public EquipoComunicacion(String id, String nombre, double peso, double volumen, 
                             String tipoComunicacion, double rangoFrecuencia, int potencia) {
        super(id, nombre, peso, volumen);
        this.tipoComunicacion = tipoComunicacion;
        this.rangoFrecuencia = rangoFrecuencia;
        this.potencia = potencia;
    }
    
    public String getTipoComunicacion() {
        return tipoComunicacion;
    }
    
    public void setTipoComunicacion(String tipoComunicacion) {
        this.tipoComunicacion = tipoComunicacion;
    }
    
    public double getRangoFrecuencia() {
        return rangoFrecuencia;
    }
    
    public void setRangoFrecuencia(double rangoFrecuencia) {
        this.rangoFrecuencia = rangoFrecuencia;
    }
    
    public int getPotencia() {
        return potencia;
    }
    
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
}