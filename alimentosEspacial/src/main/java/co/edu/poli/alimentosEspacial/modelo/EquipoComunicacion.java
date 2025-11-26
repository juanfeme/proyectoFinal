package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

/**
 * Representa un equipo de comunicación para misiones espaciales.
 * <p>
 * Esta clase extiende de {@link Producto} y añade propiedades específicas
 * de equipos de comunicación como tipo de comunicación, rango de frecuencia
 * y potencia de transmisión. Implementa {@link Serializable} para permitir
 * la serialización de objetos.
 * </p>
 * 
 * @author Politécnico Grancolombiano
 * @version 1.0
 * @since 2024
 * @see Producto
 * @see Serializable
 */
public class EquipoComunicacion extends Producto implements Serializable {
    
    /**
     * Identificador único para la serialización.
     * <p>
     * Garantiza la compatibilidad durante la deserialización.
     * </p>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Tipo de tecnología de comunicación utilizada.
     * <p>
     * Ejemplos: "UHF", "VHF", "SATCOM", "Laser", "Radio digital"
     * </p>
     */
    private String tipoComunicacion;
    
    /**
     * Rango de frecuencia de operación del equipo.
     * <p>
     * Representado en Megahertz (MHz) o Gigahertz (GHz) según el equipo.
     * </p>
     */
    private double rangoFrecuencia;
    
    /**
     * Potencia de transmisión del equipo.
     * <p>
     * Representada en vatios (W) o kilovatios (kW).
     * </p>
     */
    private int potencia;
    
    /**
     * Constructor completo para crear una instancia de EquipoComunicacion.
     *
     * @param id Identificador único del equipo
     * @param nombre Nombre descriptivo del equipo de comunicación
     * @param peso Peso del equipo en kilogramos
     * @param volumen Volumen ocupado en metros cúbicos
     * @param tipoComunicacion Tecnología de comunicación utilizada
     * @param rangoFrecuencia Frecuencia de operación en MHz/GHz
     * @param potencia Potencia de transmisión en vatios
     * @throws IllegalArgumentException Si los parámetros numéricos son negativos
     *                                  o si los textos obligatorios son nulos/vacíos
     */
    public EquipoComunicacion(String id, String nombre, double peso, double volumen, 
                             String tipoComunicacion, double rangoFrecuencia, int potencia) {
        super(id, nombre, peso, volumen);
        this.tipoComunicacion = tipoComunicacion;
        this.rangoFrecuencia = rangoFrecuencia;
        this.potencia = potencia;
    }
    
    /**
     * Obtiene el tipo de tecnología de comunicación.
     *
     * @return Tipo de comunicación (ej: "UHF", "SATCOM")
     */
    public String getTipoComunicacion() {
        return tipoComunicacion;
    }
    
    /**
     * Establece el tipo de tecnología de comunicación.
     *
     * @param tipoComunicacion Nuevo tipo de comunicación
     */
    public void setTipoComunicacion(String tipoComunicacion) {
        this.tipoComunicacion = tipoComunicacion;
    }
    
    /**
     * Obtiene el rango de frecuencia de operación.
     *
     * @return Frecuencia en MHz o GHz
     */
    public double getRangoFrecuencia() {
        return rangoFrecuencia;
    }
    
    /**
     * Establece el rango de frecuencia de operación.
     *
     * @param rangoFrecuencia Nueva frecuencia en MHz o GHz
     * @throws IllegalArgumentException Si el valor es negativo
     */
    public void setRangoFrecuencia(double rangoFrecuencia) {
        this.rangoFrecuencia = rangoFrecuencia;
    }
    
    /**
     * Obtiene la potencia de transmisión del equipo.
     *
     * @return Potencia en vatios
     */
    public int getPotencia() {
        return potencia;
    }
    
    /**
     * Establece la potencia de transmisión del equipo.
     *
     * @param potencia Nueva potencia en vatios
     * @throws IllegalArgumentException Si el valor es negativo
     */
    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    
    /**
     * Calcula el alcance aproximado de comunicación basado en potencia y frecuencia.
     * <p>
     * Fórmula simplificada para estimación de alcance en espacio libre.
     * </p>
     *
     * @return Alcance estimado en kilómetros
     */
    public double calcularAlcanceEstimado() {
        // Fórmula simplificada para espacio libre
        return (potencia * 10) / (rangoFrecuencia / 1000);
    }
    
    /**
     * Verifica si el equipo es adecuado para comunicaciones de larga distancia.
     * <p>
     * Considera equipos de alta potencia y baja frecuencia como aptos para larga distancia.
     * </p>
     *
     * @return {@code true} si es apto para larga distancia, {@code false} en caso contrario
     */
    public boolean esAptoParaLargaDistancia() {
        return potencia > 100 && rangoFrecuencia < 3000;
    }
    
    /**
     * Representación en texto del objeto EquipoComunicacion.
     * <p>
     * Incluye información de la clase padre más los atributos específicos
     * del equipo de comunicación.
     * </p>
     *
     * @return String con la representación completa del equipo
     * @see Producto#toString()
     */
    @Override
    public String toString() {
        return super.toString() + 
               ", EquipoComunicacion{" +
               "tipoComunicacion='" + tipoComunicacion + '\'' +
               ", rangoFrecuencia=" + rangoFrecuencia + " MHz" +
               ", potencia=" + potencia + " W" +
               '}';
    }
}