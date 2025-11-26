package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

/**
 * Representa un astronauta en el sistema de gestión espacial.
 * <p>
 * Esta clase almacena la información personal y profesional de un astronauta,
 * incluyendo su especialidad, rango y estado de misión. Implementa 
 * {@link Serializable} para permitir el almacenamiento y transmisión de objetos.
 * </p>
 * 
 * @author Politécnico Grancolombiano
 * @version 1.0
 * @since 2024
 * @see Serializable
 */
public class Astronauta implements Serializable {
    
    /**
     * Identificador único para la serialización.
     * <p>
     * Garantiza la compatibilidad durante el proceso de serialización/deserialización.
     * </p>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Identificador único del astronauta.
     * <p>
     * Formato recomendado: prefijo numérico o alfanumérico único.
     * </p>
     */
    private String idAstronauta;
    
    /**
     * Nombre completo del astronauta.
     */
    private String nombre;
    
    /**
     * Área de especialización del astronauta.
     * <p>
     * Ejemplos: "Ingeniería", "Medicina", "Geología", "Pilotaje"
     * </p>
     */
    private String especialidad;
    
    /**
     * Rango o grado del astronauta en la organización.
     * <p>
     * Ejemplos: "Comandante", "Piloto", "Especialista", "Ingeniero"
     * </p>
     */
    private String rango;
    
    /**
     * Indica si el astronauta se encuentra actualmente en misión.
     * <p>
     * {@code true} si está en misión activa, {@code false} si está disponible.
     * </p>
     */
    private boolean esEMision;
    
    /**
     * Constructor completo para crear una instancia de Astronauta.
     *
     * @param idAstronauta Identificador único del astronauta
     * @param nombre Nombre completo del astronauta
     * @param especialidad Área de especialización del astronauta
     * @param rango Rango o grado en la organización
     * @param esEMision Estado de misión actual
     * @throws IllegalArgumentException Si los parámetros obligatorios son nulos o vacíos
     */
    public Astronauta(String idAstronauta, String nombre, String especialidad, String rango, boolean esEMision) {
        this.idAstronauta = idAstronauta;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.rango = rango;
        this.esEMision = esEMision;
    }
    
    /**
     * Obtiene el identificador único del astronauta.
     *
     * @return Identificador del astronauta
     */
    public String getIdAstronauta() {
        return idAstronauta;
    }
    
    /**
     * Establece el identificador único del astronauta.
     *
     * @param idAstronauta Nuevo identificador del astronauta
     */
    public void setIdAstronauta(String idAstronauta) {
        this.idAstronauta = idAstronauta;
    }
    
    /**
     * Obtiene el nombre completo del astronauta.
     *
     * @return Nombre del astronauta
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre completo del astronauta.
     *
     * @param nombre Nuevo nombre del astronauta
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene la especialidad del astronauta.
     *
     * @return Área de especialización
     */
    public String getEspecialidad() {
        return especialidad;
    }
    
    /**
     * Establece la especialidad del astronauta.
     *
     * @param especialidad Nueva especialidad
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    /**
     * Obtiene el rango del astronauta.
     *
     * @return Rango o grado en la organización
     */
    public String getRango() {
        return rango;
    }
    
    /**
     * Establece el rango del astronauta.
     *
     * @param rango Nuevo rango
     */
    public void setRango(String rango) {
        this.rango = rango;
    }
    
    /**
     * Verifica si el astronauta está actualmente en misión.
     *
     * @return {@code true} si está en misión activa, {@code false} en caso contrario
     */
    public boolean isEsEMision() {
        return esEMision;
    }
    
    /**
     * Establece el estado de misión del astronauta.
     *
     * @param esEMision Nuevo estado de misión
     */
    public void setEsEMision(boolean esEMision) {
        this.esEMision = esEMision;
    }
    
    /**
     * Representación en texto del objeto Astronauta.
     * <p>
     * Proporciona una vista completa de todos los atributos del astronauta.
     * </p>
     *
     * @return String con la representación completa del astronauta
     */
    @Override
    public String toString() {
        return "Astronauta{" +
               "idAstronauta='" + idAstronauta + '\'' +
               ", nombre='" + nombre + '\'' +
               ", especialidad='" + especialidad + '\'' +
               ", rango='" + rango + '\'' +
               ", esEMision=" + esEMision +
               '}';
    }
    
    /**
     * Proporciona una descripción resumida del astronauta.
     * <p>
     * Incluye información básica para identificación rápida.
     * </p>
     *
     * @return String con información resumida del astronauta
     */
    public String getInfoResumida() {
        return nombre + " (" + rango + ") - " + especialidad;
    }
}