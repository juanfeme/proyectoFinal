package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

/**
 * Representa un equipo médico para misiones espaciales.
 * <p>
 * Esta clase extiende de {@link Producto} y añade propiedades específicas
 * de equipos médicos como uso específico, estado de esterilización,
 * fechas de esterilización y UDT (Unidad de Dosificación Terapéutica).
 * Implementa {@link Serializable} para permitir la serialización de objetos.
 * </p>
 * 
 * @author Politécnico Grancolombiano
 * @version 1.0
 * @since 2024
 * @see Producto
 * @see Serializable
 */
public class EquipoMedico extends Producto implements Serializable {
    
    /**
     * Identificador único para la serialización.
     * <p>
     * Garantiza la compatibilidad durante la deserialización.
     * </p>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Uso específico o aplicación médica del equipo.
     * <p>
     * Ejemplos: "Reanimación", "Cirugía menor", "Monitorización", "Diagnóstico"
     * </p>
     */
    private String usoEspecifico;
    
    /**
     * Indica si el equipo ha sido esterilizado.
     * <p>
     * {@code true} si el equipo está esterilizado y listo para uso médico,
     * {@code false} si requiere esterilización previa al uso.
     * </p>
     */
    private boolean esEsterilizado;
    
    /**
     * Fecha de la última esterilización del equipo.
     * <p>
     * Formato recomendado: DD/MM/AAAA. Solo aplica si {@code esEsterilizado} es true.
     * </p>
     */
    private String fechaEsterilizacion;
    
    /**
     * Unidad de Dosificación Terapéutica o identificador del equipo.
     * <p>
     * Puede representar dosis, concentración o código identificador del equipo médico.
     * </p>
     */
    private String udt;
    
    /**
     * Constructor completo para crear una instancia de EquipoMedico.
     *
     * @param id Identificador único del equipo médico
     * @param nombre Nombre descriptivo del equipo médico
     * @param peso Peso del equipo en kilogramos
     * @param volumen Volumen ocupado en metros cúbicos
     * @param usoEspecifico Aplicación médica específica del equipo
     * @param esEsterilizado Estado de esterilización del equipo
     * @param fechaEsterilizacion Fecha de la última esterilización
     * @param udt Unidad de Dosificación Terapéutica o identificador
     * @throws IllegalArgumentException Si los parámetros obligatorios son nulos o vacíos
     */
    public EquipoMedico(String id, String nombre, double peso, double volumen, 
                       String usoEspecifico, boolean esEsterilizado, String fechaEsterilizacion, String udt) {
        super(id, nombre, peso, volumen);
        this.usoEspecifico = usoEspecifico;
        this.esEsterilizado = esEsterilizado;
        this.fechaEsterilizacion = fechaEsterilizacion;
        this.udt = udt;
    }
    
    /**
     * Obtiene el uso específico o aplicación médica del equipo.
     *
     * @return Uso específico del equipo médico
     */
    public String getUsoEspecifico() {
        return usoEspecifico;
    }
    
    /**
     * Establece el uso específico o aplicación médica del equipo.
     *
     * @param usoEspecifico Nuevo uso específico del equipo
     */
    public void setUsoEspecifico(String usoEspecifico) {
        this.usoEspecifico = usoEspecifico;
    }
    
    /**
     * Verifica si el equipo está esterilizado.
     *
     * @return {@code true} si el equipo está esterilizado, {@code false} en caso contrario
     */
    public boolean isEsEsterilizado() {
        return esEsterilizado;
    }
    
    /**
     * Establece el estado de esterilización del equipo.
     *
     * @param esEsterilizado Nuevo estado de esterilización
     */
    public void setEsEsterilizado(boolean esEsterilizado) {
        this.esEsterilizado = esEsterilizado;
    }
    
    /**
     * Obtiene la fecha de la última esterilización.
     *
     * @return Fecha de esterilización en formato de texto
     */
    public String getFechaEsterilizacion() {
        return fechaEsterilizacion;
    }
    
    /**
     * Establece la fecha de la última esterilización.
     *
     * @param fechaEsterilizacion Nueva fecha de esterilización
     */
    public void setFechaEsterilizacion(String fechaEsterilizacion) {
        this.fechaEsterilizacion = fechaEsterilizacion;
    }
    
    /**
     * Obtiene la Unidad de Dosificación Terapéutica o identificador.
     *
     * @return UDT o identificador del equipo médico
     */
    public String getUdt() {
        return udt;
    }
    
    /**
     * Establece la Unidad de Dosificación Terapéutica o identificador.
     *
     * @param udt Nueva UDT o identificador
     */
    public void setUdt(String udt) {
        this.udt = udt;
    }
    
    /**
     * Verifica si el equipo requiere re-esterilización.
     * <p>
     * Considera que un equipo requiere re-esterilización si ha pasado
     * mucho tiempo desde la última esterilización o si nunca fue esterilizado.
     * </p>
     *
     * @return {@code true} si el equipo requiere re-esterilización, {@code false} si está listo para uso
     */
    public boolean requiereReEsterilizacion() {
        return !esEsterilizado || fechaEsterilizacion == null || fechaEsterilizacion.isEmpty();
    }
    
    /**
     * Valida si el equipo es apto para uso en procedimientos críticos.
     * <p>
     * Un equipo se considera apto para procedimientos críticos si está
     * esterilizado y tiene una fecha de esterilización reciente.
     * </p>
     *
     * @return {@code true} si es apto para procedimientos críticos, {@code false} en caso contrario
     */
    public boolean esAptoParaProcedimientosCriticos() {
        return esEsterilizado && fechaEsterilizacion != null && !fechaEsterilizacion.isEmpty();
    }
    
    /**
     * Representación en texto del objeto EquipoMedico.
     * <p>
     * Incluye información de la clase padre más los atributos específicos
     * del equipo médico.
     * </p>
     *
     * @return String con la representación completa del equipo médico
     * @see Producto#toString()
     */
    @Override
    public String toString() {
        return super.toString() + 
               ", EquipoMedico{" +
               "usoEspecifico='" + usoEspecifico + '\'' +
               ", esEsterilizado=" + esEsterilizado +
               ", fechaEsterilizacion='" + fechaEsterilizacion + '\'' +
               ", udt='" + udt + '\'' +
               '}';
    }
    
    /**
     * Proporciona información de seguridad del equipo médico.
     * <p>
     * Incluye estado de esterilización y recomendaciones de uso.
     * </p>
     *
     * @return String con información de seguridad del equipo
     */
    public String getInfoSeguridad() {
        String estadoEsterilizacion = esEsterilizado ? 
            "ESTERILIZADO (Fecha: " + fechaEsterilizacion + ")" : "NO ESTERILIZADO";
        
        return "Equipo: " + getNombre() + 
               " - Uso: " + usoEspecifico + 
               " - Estado: " + estadoEsterilizacion +
               " - UDT: " + udt;
    }
}