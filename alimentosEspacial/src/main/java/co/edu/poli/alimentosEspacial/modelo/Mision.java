package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

public class Mision implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String codigoMision;
    private String nombre;
    private String fechalnicio;
    private String fechaFin;
    private String destino;
    private String estado;
    
    public Mision(String codigoMision, String nombre, String fechalnicio, String fechaFin, String destino, String estado) {
        this.codigoMision = codigoMision;
        this.nombre = nombre;
        this.fechalnicio = fechalnicio;
        this.fechaFin = fechaFin;
        this.destino = destino;
        this.estado = estado;
    }
    
    public String cambiarEstado() {
        if ("Planificada".equals(estado)) {
            estado = "En Progreso";
        } else if ("En Progreso".equals(estado)) {
            estado = "Completada";
        }
        return estado;
    }
    
    public String calcularDuracion() {
        return "Duración calculada";
    }
    
    public String getCodigoMision() {
        return codigoMision;
    }
    
    public void setCodigoMision(String codigoMision) {
        this.codigoMision = codigoMision;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getFechalnicio() {
        return fechalnicio;
    }
    
    public void setFechalnicio(String fechalnicio) {
        this.fechalnicio = fechalnicio;
    }
    
    public String getFechaFin() {
        return fechaFin;
    }
    
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    public String getDestino() {
        return destino;
    }
    
    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
}