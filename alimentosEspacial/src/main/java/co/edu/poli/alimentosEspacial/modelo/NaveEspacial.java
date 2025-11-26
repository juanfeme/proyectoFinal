package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

public class NaveEspacial implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String idNave;
    private String modelo;
    private double capacidadPeso;
    private double capacidadVol;
    private double pesoActual;
    private double volumenActual;
    
    public NaveEspacial(String idNave, String modelo, double capacidadPeso, double capacidadVol) {
        this.idNave = idNave;
        this.modelo = modelo;
        this.capacidadPeso = capacidadPeso;
        this.capacidadVol = capacidadVol;
        this.pesoActual = 0;
        this.volumenActual = 0;
    }
    
    public int verificarCapacidad() {
        if (pesoActual < capacidadPeso && volumenActual < capacidadVol) {
            return 1;
        }
        return 0;
    }
    
    public int calcularEspacioDisponible() {
        double espacioPeso = ((capacidadPeso - pesoActual) / capacidadPeso) * 100;
        double espacioVol = ((capacidadVol - volumenActual) / capacidadVol) * 100;
        return (int) Math.min(espacioPeso, espacioVol);
    }
    
    public int agregarProducto(Producto producto) {
        if (verificarCapacidad() == 1) {
            return 1; 
        }
        return 0; 
    }
    
    public String getIdNave() {
        return idNave;
    }
    
    public void setIdNave(String idNave) {
        this.idNave = idNave;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public double getCapacidadPeso() {
        return capacidadPeso;
    }
    
    public void setCapacidadPeso(double capacidadPeso) {
        this.capacidadPeso = capacidadPeso;
    }
    
    public double getCapacidadVol() {
        return capacidadVol;
    }
    
    public void setCapacidadVol(double capacidadVol) {
        this.capacidadVol = capacidadVol;
    }
    
    public double getPesoActual() {
        return pesoActual;
    }
    
    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }
    
    public double getVolumenActual() {
        return volumenActual;
    }
    
    public void setVolumenActual(double volumenActual) {
        this.volumenActual = volumenActual;
    }
}