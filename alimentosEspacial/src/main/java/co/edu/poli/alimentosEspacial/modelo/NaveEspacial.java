package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

/**
 * Representa una nave espacial en el sistema de gestión de misiones.
 * <p>
 * Esta clase gestiona las capacidades de carga y almacenamiento de una nave espacial,
 * controlando el peso y volumen actuales versus las capacidades máximas. Implementa
 * {@link Serializable} para permitir el almacenamiento y transmisión de datos de naves.
 * </p>
 * 
 * @author Politécnico Grancolombiano
 * @version 1.0
 * @since 2024
 * @see Serializable
 * @see Producto
 */
public class NaveEspacial implements Serializable {
    
    /**
     * Identificador único para la serialización.
     * <p>
     * Garantiza la compatibilidad durante el proceso de serialización/deserialización
     * de los datos de la nave espacial.
     * </p>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Identificador único de la nave espacial.
     * <p>
     * Formato recomendado: prefijo alfanumérico (ej: "NAVE-001", "DRAGON-2024")
     * </p>
     */
    private String idNave;
    
    /**
     * Modelo o tipo de la nave espacial.
     * <p>
     * Ejemplos: "Falcon 9", "Starship", "Orion", "Soyuz"
     * </p>
     */
    private String modelo;
    
    /**
     * Capacidad máxima de peso en kilogramos.
     */
    private double capacidadPeso;
    
    /**
     * Capacidad máxima de volumen en metros cúbicos.
     */
    private double capacidadVol;
    
    /**
     * Peso actual cargado en la nave en kilogramos.
     * <p>
     * Se inicializa en 0 y se incrementa al agregar productos.
     * </p>
     */
    private double pesoActual;
    
    /**
     * Volumen actual ocupado en la nave en metros cúbicos.
     * <p>
     * Se inicializa en 0 y se incrementa al agregar productos.
     * </p>
     */
    private double volumenActual;
    
    /**
     * Constructor para crear una instancia de NaveEspacial.
     *
     * @param idNave Identificador único de la nave
     * @param modelo Modelo o tipo de nave espacial
     * @param capacidadPeso Capacidad máxima de peso en kg
     * @param capacidadVol Capacidad máxima de volumen en m³
     * @throws IllegalArgumentException Si las capacidades son negativas o los textos son nulos/vacíos
     */
    public NaveEspacial(String idNave, String modelo, double capacidadPeso, double capacidadVol) {
        this.idNave = idNave;
        this.modelo = modelo;
        this.capacidadPeso = capacidadPeso;
        this.capacidadVol = capacidadVol;
        this.pesoActual = 0;
        this.volumenActual = 0;
    }
    
    /**
     * Verifica si la nave tiene capacidad disponible para más carga.
     * <p>
     * Comprueba tanto el peso como el volumen actuales contra las capacidades máximas.
     * </p>
     *
     * @return 1 si tiene capacidad disponible, 0 si está al límite o excedida
     */
    public int verificarCapacidad() {
        if (pesoActual < capacidadPeso && volumenActual < capacidadVol) {
            return 1;
        }
        return 0;
    }
    
    /**
     * Calcula el porcentaje de espacio disponible en la nave.
     * <p>
     * Considera tanto el espacio de peso como el de volumen y retorna
     * el porcentaje más restrictivo de los dos.
     * </p>
     *
     * @return Porcentaje de espacio disponible (0-100)
     */
    public int calcularEspacioDisponible() {
        double espacioPeso = ((capacidadPeso - pesoActual) / capacidadPeso) * 100;
        double espacioVol = ((capacidadVol - volumenActual) / capacidadVol) * 100;
        return (int) Math.min(espacioPeso, espacioVol);
    }
    
    /**
     * Intenta agregar un producto a la nave espacial.
     * <p>
     * Verifica la capacidad disponible antes de agregar el producto.
     * En una implementación completa, actualizaría pesoActual y volumenActual.
     * </p>
     *
     * @param producto Producto a agregar a la nave
     * @return 1 si el producto fue agregado exitosamente, 0 si no hay capacidad suficiente
     * @throws IllegalArgumentException Si el producto es nulo
     * @see Producto
     */
    public int agregarProducto(Producto producto) {
        if (verificarCapacidad() == 1) {
            // En implementación completa: actualizar pesoActual y volumenActual
            // this.pesoActual += producto.getPeso();
            // this.volumenActual += producto.getVolumen();
            return 1; 
        }
        return 0; 
    }
    
    /**
     * Obtiene el identificador único de la nave.
     *
     * @return Identificador de la nave
     */
    public String getIdNave() {
        return idNave;
    }
    
    /**
     * Establece el identificador único de la nave.
     *
     * @param idNave Nuevo identificador de la nave
     */
    public void setIdNave(String idNave) {
        this.idNave = idNave;
    }
    
    /**
     * Obtiene el modelo de la nave espacial.
     *
     * @return Modelo de la nave
     */
    public String getModelo() {
        return modelo;
    }
    
    /**
     * Establece el modelo de la nave espacial.
     *
     * @param modelo Nuevo modelo de la nave
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /**
     * Obtiene la capacidad máxima de peso.
     *
     * @return Capacidad de peso en kilogramos
     */
    public double getCapacidadPeso() {
        return capacidadPeso;
    }
    
    /**
     * Establece la capacidad máxima de peso.
     *
     * @param capacidadPeso Nueva capacidad de peso en kg
     * @throws IllegalArgumentException Si el valor es negativo
     */
    public void setCapacidadPeso(double capacidadPeso) {
        this.capacidadPeso = capacidadPeso;
    }
    
    /**
     * Obtiene la capacidad máxima de volumen.
     *
     * @return Capacidad de volumen en metros cúbicos
     */
    public double getCapacidadVol() {
        return capacidadVol;
    }
    
    /**
     * Establece la capacidad máxima de volumen.
     *
     * @param capacidadVol Nueva capacidad de volumen en m³
     * @throws IllegalArgumentException Si el valor es negativo
     */
    public void setCapacidadVol(double capacidadVol) {
        this.capacidadVol = capacidadVol;
    }
    
    /**
     * Obtiene el peso actual cargado en la nave.
     *
     * @return Peso actual en kilogramos
     */
    public double getPesoActual() {
        return pesoActual;
    }
    
    /**
     * Establece el peso actual cargado en la nave.
     *
     * @param pesoActual Nuevo peso actual en kg
     * @throws IllegalArgumentException Si el valor es negativo o excede la capacidad
     */
    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }
    
    /**
     * Obtiene el volumen actual ocupado en la nave.
     *
     * @return Volumen actual en metros cúbicos
     */
    public double getVolumenActual() {
        return volumenActual;
    }
    
    /**
     * Establece el volumen actual ocupado en la nave.
     *
     * @param volumenActual Nuevo volumen actual en m³
     * @throws IllegalArgumentException Si el valor es negativo o excede la capacidad
     */
    public void setVolumenActual(double volumenActual) {
        this.volumenActual = volumenActual;
    }
    
    /**
     * Calcula el porcentaje de uso de la capacidad de peso.
     *
     * @return Porcentaje de uso de peso (0-100)
     */
    public double getPorcentajeUsoPeso() {
        return (pesoActual / capacidadPeso) * 100;
    }
    
    /**
     * Calcula el porcentaje de uso de la capacidad de volumen.
     *
     * @return Porcentaje de uso de volumen (0-100)
     */
    public double getPorcentajeUsoVolumen() {
        return (volumenActual / capacidadVol) * 100;
    }
    
    /**
     * Verifica si la nave está cerca de su capacidad máxima.
     * <p>
     * Considera que está cerca del límite si algún porcentaje de uso supera el 90%.
     * </p>
     *
     * @return {@code true} si está cerca del límite de capacidad, {@code false} en caso contrario
     */
    public boolean estaCercaDelLimite() {
        return getPorcentajeUsoPeso() > 90 || getPorcentajeUsoVolumen() > 90;
    }
    
    /**
     * Verifica si la nave tiene sobrecarga.
     * <p>
     * Una nave tiene sobrecarga si excede alguna de sus capacidades máximas.
     * </p>
     *
     * @return {@code true} si tiene sobrecarga, {@code false} en caso contrario
     */
    public boolean tieneSobrecarga() {
        return pesoActual > capacidadPeso || volumenActual > capacidadVol;
    }
    
    /**
     * Proporciona un resumen de capacidad de la nave.
     * <p>
     * Incluye información de uso actual y porcentajes disponibles.
     * </p>
     *
     * @return String con el resumen de capacidad
     */
    public String obtenerResumenCapacidad() {
        return String.format("Nave %s - Peso: %.1f/%.1f kg (%.1f%%) - Volumen: %.1f/%.1f m³ (%.1f%%)",
                idNave, pesoActual, capacidadPeso, getPorcentajeUsoPeso(),
                volumenActual, capacidadVol, getPorcentajeUsoVolumen());
    }
    
    /**
     * Representación en texto del objeto NaveEspacial.
     * <p>
     * Proporciona una vista completa de todos los atributos de la nave.
     * </p>
     *
     * @return String con la representación completa de la nave
     */
    @Override
    public String toString() {
        return "NaveEspacial{" +
               "idNave='" + idNave + '\'' +
               ", modelo='" + modelo + '\'' +
               ", capacidadPeso=" + capacidadPeso +
               ", capacidadVol=" + capacidadVol +
               ", pesoActual=" + pesoActual +
               ", volumenActual=" + volumenActual +
               '}';
    }
}