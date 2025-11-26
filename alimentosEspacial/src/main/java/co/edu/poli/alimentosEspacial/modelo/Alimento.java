package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

/**
 * Representa un producto de tipo Alimento para misiones espaciales.
 * <p>
 * Esta clase extiende de {@link Producto} y añade propiedades específicas
 * de alimentos como fecha de caducidad, tipo de alimento y contenido calórico.
 * Implementa {@link Serializable} para permitir la serialización de objetos.
 * </p>
 * 
 * @author Politécnico Grancolombiano
 * @version 1.0
 * @since 2024
 * @see Producto
 * @see Serializable
 */
public class Alimento extends Producto implements Serializable {
    
    /**
     * Identificador único para la serialización.
     * <p>
     * Garantiza la compatibilidad durante la deserialización.
     * </p>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Fecha de caducidad del alimento en formato de texto.
     * <p>
     * Formato recomendado: DD/MM/AAAA
     * </p>
     */
    private String fechaCaducidad;
    
    /**
     * Tipo o categoría del alimento.
     * <p>
     * Ejemplos: "Liofilizado", "Deshidratado", "Enlatado", "Fresh"
     * </p>
     */
    private String tipoAlimento;
    
    /**
     * Contenido calórico por ración del alimento.
     * <p>
     * Representado en kilocalorías (kcal) por ración estándar.
     * </p>
     */
    private int caloriasPorRacion;
    
    /**
     * Constructor completo para crear una instancia de Alimento.
     *
     * @param id Identificador único del alimento
     * @param nombre Nombre descriptivo del alimento
     * @param peso Peso del alimento en kilogramos
     * @param volumen Volumen ocupado en metros cúbicos
     * @param fechaCaducidad Fecha de caducidad del alimento
     * @param tipoAlimento Tipo o categoría del alimento
     * @param caloriasPorRacion Contenido calórico por ración en kcal
     * @throws IllegalArgumentException Si los parámetros numéricos son negativos
     *                                  o si los textos obligatorios son nulos/vacíos
     */
    public Alimento(String id, String nombre, double peso, double volumen, 
                   String fechaCaducidad, String tipoAlimento, int caloriasPorRacion) {
        super(id, nombre, peso, volumen);
        this.fechaCaducidad = fechaCaducidad;
        this.tipoAlimento = tipoAlimento;
        this.caloriasPorRacion = caloriasPorRacion;
    }
    
    /**
     * Obtiene la fecha de caducidad del alimento.
     *
     * @return Fecha de caducidad en formato de texto
     */
    public String getFechaCaducidad() {
        return fechaCaducidad;
    }
    
    /**
     * Establece la fecha de caducidad del alimento.
     *
     * @param fechaCaducidad Nueva fecha de caducidad en formato de texto
     */
    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }
    
    /**
     * Obtiene el tipo o categoría del alimento.
     *
     * @return Tipo de alimento (ej: "Liofilizado", "Deshidratado")
     */
    public String getTipoAlimento() {
        return tipoAlimento;
    }
    
    /**
     * Establece el tipo o categoría del alimento.
     *
     * @param tipoAlimento Nuevo tipo de alimento
     */
    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }
    
    /**
     * Obtiene el contenido calórico por ración.
     *
     * @return Número de kilocalorías por ración
     */
    public int getCaloriasPorRacion() {
        return caloriasPorRacion;
    }
    
    /**
     * Establece el contenido calórico por ración.
     *
     * @param caloriasPorRacion Nuevo valor calórico en kcal
     * @throws IllegalArgumentException Si el valor es negativo
     */
    public void setCaloriasPorRacion(int caloriasPorRacion) {
        this.caloriasPorRacion = caloriasPorRacion;
    }
    
    /**
     * Representación en texto del objeto Alimento.
     * <p>
     * Incluye información de la clase padre más los atributos específicos
     * de alimento.
     * </p>
     *
     * @return String con la representación completa del alimento
     * @see Producto#toString()
     */
    @Override
    public String toString() {
        return super.toString() + 
               ", Alimento{" +
               "fechaCaducidad='" + fechaCaducidad + '\'' +
               ", tipoAlimento='" + tipoAlimento + '\'' +
               ", caloriasPorRacion=" + caloriasPorRacion +
               '}';
    }
}