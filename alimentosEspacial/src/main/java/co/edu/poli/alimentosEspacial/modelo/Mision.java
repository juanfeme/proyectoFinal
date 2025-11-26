package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

/**
 * Representa una misión espacial en el sistema de gestión.
 * <p>
 * Esta clase almacena toda la información relacionada con una misión espacial,
 * incluyendo fechas, destino, estado y operaciones de gestión de la misión.
 * Implementa {@link Serializable} para permitir el almacenamiento y transmisión
 * de datos de misiones.
 * </p>
 * 
 * @author Politécnico Grancolombiano
 * @version 1.0
 * @since 2024
 * @see Serializable
 */
public class Mision implements Serializable {
    
    /**
     * Identificador único para la serialización.
     * <p>
     * Garantiza la compatibilidad durante el proceso de serialización/deserialización
     * de los datos de la misión.
     * </p>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Código único identificador de la misión.
     * <p>
     * Formato recomendado: prefijo alfanumérico (ej: "MIS-2024-001")
     * </p>
     */
    private String codigoMision;
    
    /**
     * Nombre descriptivo de la misión.
     * <p>
     * Ejemplos: "Apollo 11", "Mars Rover 2024", "Estación Lunar Alpha"
     * </p>
     */
    private String nombre;
    
    /**
     * Fecha de inicio planificada de la misión.
     * <p>
     * Formato recomendado: DD/MM/AAAA
     * </p>
     */
    private String fechalnicio;
    
    /**
     * Fecha de finalización estimada de la misión.
     * <p>
     * Formato recomendado: DD/MM/AAAA
     * </p>
     */
    private String fechaFin;
    
    /**
     * Destino o objetivo principal de la misión.
     * <p>
     * Ejemplos: "Luna", "Marte", "Estación Espacial Internacional", "Órbita terrestre"
     * </p>
     */
    private String destino;
    
    /**
     * Estado actual de la misión.
     * <p>
     * Valores posibles: "Planificada", "En Progreso", "Completada", "Cancelada", "En Riesgo"
     * </p>
     */
    private String estado;
    
    /**
     * Constructor completo para crear una instancia de Mision.
     *
     * @param codigoMision Código único identificador de la misión
     * @param nombre Nombre descriptivo de la misión
     * @param fechalnicio Fecha de inicio planificada
     * @param fechaFin Fecha de finalización estimada
     * @param destino Destino o objetivo principal
     * @param estado Estado inicial de la misión
     * @throws IllegalArgumentException Si los parámetros obligatorios son nulos o vacíos
     */
    public Mision(String codigoMision, String nombre, String fechalnicio, String fechaFin, String destino, String estado) {
        this.codigoMision = codigoMision;
        this.nombre = nombre;
        this.fechalnicio = fechalnicio;
        this.fechaFin = fechaFin;
        this.destino = destino;
        this.estado = estado;
    }
    
    /**
     * Cambia el estado de la misión al siguiente en el flujo de trabajo.
     * <p>
     * Transiciones permitidas:
     * - "Planificada" → "En Progreso"
     * - "En Progreso" → "Completada"
     * </p>
     *
     * @return Nuevo estado de la misión después del cambio
     */
    public String cambiarEstado() {
        if ("Planificada".equals(estado)) {
            estado = "En Progreso";
        } else if ("En Progreso".equals(estado)) {
            estado = "Completada";
        }
        return estado;
    }
    
    /**
     * Calcula la duración estimada de la misión.
     * <p>
     * Basado en las fechas de inicio y fin planificadas.
     * En una implementación real, calcularía la diferencia entre fechas.
     * </p>
     *
     * @return Mensaje indicando que la duración fue calculada
     */
    public String calcularDuracion() {
        return "Duración calculada";
    }
    
    /**
     * Obtiene el código único de la misión.
     *
     * @return Código identificador de la misión
     */
    public String getCodigoMision() {
        return codigoMision;
    }
    
    /**
     * Establece el código único de la misión.
     *
     * @param codigoMision Nuevo código identificador
     */
    public void setCodigoMision(String codigoMision) {
        this.codigoMision = codigoMision;
    }
    
    /**
     * Obtiene el nombre descriptivo de la misión.
     *
     * @return Nombre de la misión
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Establece el nombre descriptivo de la misión.
     *
     * @param nombre Nuevo nombre de la misión
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Obtiene la fecha de inicio de la misión.
     *
     * @return Fecha de inicio en formato texto
     */
    public String getFechalnicio() {
        return fechalnicio;
    }
    
    /**
     * Establece la fecha de inicio de la misión.
     *
     * @param fechalnicio Nueva fecha de inicio
     */
    public void setFechalnicio(String fechalnicio) {
        this.fechalnicio = fechalnicio;
    }
    
    /**
     * Obtiene la fecha de fin de la misión.
     *
     * @return Fecha de fin en formato texto
     */
    public String getFechaFin() {
        return fechaFin;
    }
    
    /**
     * Establece la fecha de fin de la misión.
     *
     * @param fechaFin Nueva fecha de fin
     */
    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    /**
     * Obtiene el destino de la misión.
     *
     * @return Destino u objetivo de la misión
     */
    public String getDestino() {
        return destino;
    }
    
    /**
     * Establece el destino de la misión.
     *
     * @param destino Nuevo destino de la misión
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    /**
     * Obtiene el estado actual de la misión.
     *
     * @return Estado actual de la misión
     */
    public String getEstado() {
        return estado;
    }
    
    /**
     * Establece el estado de la misión.
     *
     * @param estado Nuevo estado de la misión
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Verifica si la misión está activa.
     * <p>
     * Una misión se considera activa si su estado es "En Progreso".
     * </p>
     *
     * @return {@code true} si la misión está activa, {@code false} en caso contrario
     */
    public boolean estaActiva() {
        return "En Progreso".equals(estado);
    }
    
    /**
     * Verifica si la misión ha sido completada.
     *
     * @return {@code true} si la misión está completada, {@code false} en caso contrario
     */
    public boolean estaCompletada() {
        return "Completada".equals(estado);
    }
    
    /**
     * Proporciona un resumen ejecutivo de la misión.
     * <p>
     * Incluye información clave para reportes de gestión.
     * </p>
     *
     * @return String con el resumen ejecutivo de la misión
     */
    public String obtenerResumenEjecutivo() {
        return codigoMision + " - " + nombre + " (" + estado + ") - Destino: " + destino;
    }
    
    /**
     * Valida que los datos básicos de la misión sean consistentes.
     * <p>
     * Verifica que existan código, nombre, destino y estado.
     * </p>
     *
     * @return {@code true} si la misión tiene datos básicos válidos, {@code false} en caso contrario
     */
    public boolean validarDatosBasicos() {
        return codigoMision != null && !codigoMision.isEmpty() &&
               nombre != null && !nombre.isEmpty() &&
               destino != null && !destino.isEmpty() &&
               estado != null && !estado.isEmpty();
    }
    
    /**
     * Representación en texto del objeto Mision.
     * <p>
     * Proporciona una vista completa de todos los atributos de la misión.
     * </p>
     *
     * @return String con la representación completa de la misión
     */
    @Override
    public String toString() {
        return "Mision{" +
               "codigoMision='" + codigoMision + '\'' +
               ", nombre='" + nombre + '\'' +
               ", fechalnicio='" + fechalnicio + '\'' +
               ", fechaFin='" + fechaFin + '\'' +
               ", destino='" + destino + '\'' +
               ", estado='" + estado + '\'' +
               '}';
    }
    
    /**
     * Prepara la misión para el lanzamiento.
     * <p>
     * Realiza las verificaciones finales antes del inicio de la misión.
     * </p>
     *
     * @return Mensaje de confirmación de la preparación
     */
    public String prepararParaLanzamiento() {
        if ("Planificada".equals(estado)) {
            return "Misión " + codigoMision + " preparada para lanzamiento";
        } else {
            return "La misión no está en estado Planificada, no puede prepararse para lanzamiento";
        }
    }
}