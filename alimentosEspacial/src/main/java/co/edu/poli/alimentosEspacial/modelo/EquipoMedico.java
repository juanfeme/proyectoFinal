package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

public class EquipoMedico extends Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String usoEspecifico;
    private boolean esEsterilizado;
    private String fechaEsterilizacion;
    private String udt;
    
    public EquipoMedico(String id, String nombre, double peso, double volumen, 
                       String usoEspecifico, boolean esEsterilizado, String fechaEsterilizacion, String udt) {
        super(id, nombre, peso, volumen);
        this.usoEspecifico = usoEspecifico;
        this.esEsterilizado = esEsterilizado;
        this.fechaEsterilizacion = fechaEsterilizacion;
        this.udt = udt;
    }
    
    public String getUsoEspecifico() {
        return usoEspecifico;
    }
    
    public void setUsoEspecifico(String usoEspecifico) {
        this.usoEspecifico = usoEspecifico;
    }
    
    public boolean isEsEsterilizado() {
        return esEsterilizado;
    }
    
    public void setEsEsterilizado(boolean esEsterilizado) {
        this.esEsterilizado = esEsterilizado;
    }
    
    public String getFechaEsterilizacion() {
        return fechaEsterilizacion;
    }
    
    public void setFechaEsterilizacion(String fechaEsterilizacion) {
        this.fechaEsterilizacion = fechaEsterilizacion;
    }
    
    public String getUdt() {
        return udt;
    }
    
    public void setUdt(String udt) {
        this.udt = udt;
    }
}