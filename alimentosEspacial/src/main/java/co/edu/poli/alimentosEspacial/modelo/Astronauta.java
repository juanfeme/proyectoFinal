package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

public class Astronauta implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String idAstronauta;
    private String nombre;
    private String especialidad;
    private String rango;
    private boolean esEMision;
    
    public Astronauta(String idAstronauta, String nombre, String especialidad, String rango, boolean esEMision) {
        this.idAstronauta = idAstronauta;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.rango = rango;
        this.esEMision = esEMision;
    }
    
    public String getIdAstronauta() {
        return idAstronauta;
    }
    
    public void setIdAstronauta(String idAstronauta) {
        this.idAstronauta = idAstronauta;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public String getRango() {
        return rango;
    }
    
    public void setRango(String rango) {
        this.rango = rango;
    }
    
    public boolean isEsEMision() {
        return esEMision;
    }
    
    public void setEsEMision(boolean esEMision) {
        this.esEMision = esEMision;
    }
}