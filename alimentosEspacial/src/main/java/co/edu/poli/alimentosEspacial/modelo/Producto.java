package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String id;
    private String nombre;
    private double peso;
    private double volumen;

    public Producto(String id, String nombre, double peso, double volumen) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.volumen = volumen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }
}