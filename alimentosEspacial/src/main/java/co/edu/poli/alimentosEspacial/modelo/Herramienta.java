package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

/**
 * Representa una herramienta para misiones espaciales.
 * <p>
 * Esta clase extiende de {@link Producto} y añade propiedades específicas
 * de herramientas como función específica, material de construcción y
 * requerimiento de energía. Implementa {@link Serializable} para permitir
 * la serialización de objetos.
 * </p>
 * 
 * @author Politécnico Grancolombiano
 * @version 1.0
 * @since 2024
 * @see Producto
 * @see Serializable
 */
public class Herramienta extends Producto implements Serializable {
    
    /**
     * Identificador único para la serialización.
     * <p>
     * Garantiza la compatibilidad durante la deserialización.
     * </p>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Función específica o uso principal de la herramienta.
     * <p>
     * Ejemplos: "Reparación", "Montaje", "Medición", "Corte", "Sujeción"
     * </p>
     */
    private String funcion;
    
    /**
     * Material principal de construcción de la herramienta.
     * <p>
     * Ejemplos: "Acero inoxidable", "Titanio", "Aleación aluminio", "Compuesto carbono"
     * </p>
     */
    private String material;
    
    /**
     * Indica si la herramienta requiere fuente de energía para operar.
     * <p>
     * {@code true} si requiere energía eléctrica o de otro tipo,
     * {@code false} si es una herramienta manual o mecánica.
     * </p>
     */
    private boolean requiereEnergia;
    
    /**
     * Constructor completo para crear una instancia de Herramienta.
     *
     * @param id Identificador único de la herramienta
     * @param nombre Nombre descriptivo de la herramienta
     * @param peso Peso de la herramienta en kilogramos
     * @param volumen Volumen ocupado en metros cúbicos
     * @param funcion Función específica o uso principal
     * @param material Material de construcción principal
     * @param requiereEnergia Indicador de requerimiento de energía
     * @throws IllegalArgumentException Si los parámetros obligatorios son nulos o vacíos
     */
    public Herramienta(String id, String nombre, double peso, double volumen, 
                     String funcion, String material, boolean requiereEnergia) {
        super(id, nombre, peso, volumen);
        this.funcion = funcion;
        this.material = material;
        this.requiereEnergia = requiereEnergia;
    }
    
    /**
     * Obtiene la función específica de la herramienta.
     *
     * @return Función o uso principal de la herramienta
     */
    public String getFuncion() {
        return funcion;
    }
    
    /**
     * Establece la función específica de la herramienta.
     *
     * @param funcion Nueva función de la herramienta
     */
    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
    
    /**
     * Obtiene el material de construcción de la herramienta.
     *
     * @return Material principal de construcción
     */
    public String getMaterial() {
        return material;
    }
    
    /**
     * Establece el material de construcción de la herramienta.
     *
     * @param material Nuevo material de construcción
     */
    public void setMaterial(String material) {
        this.material = material;
    }
    
    /**
     * Verifica si la herramienta requiere fuente de energía.
     *
     * @return {@code true} si requiere energía, {@code false} si es manual/mecánica
     */
    public boolean isRequiereEnergia() {
        return requiereEnergia;
    }
    
    /**
     * Establece el requerimiento de energía de la herramienta.
     *
     * @param requiereEnergia Nuevo estado de requerimiento de energía
     */
    public void setRequiereEnergia(boolean requiereEnergia) {
        this.requiereEnergia = requiereEnergia;
    }
    
    /**
     * Determina si la herramienta es apta para EVA (Actividad Extravehicular).
     * <p>
     * Considera herramientas con materiales compatibles con vacío y
     * que no generen chispas o riesgos en ambiente espacial.
     * </p>
     *
     * @return {@code true} si es apta para EVA, {@code false} en caso contrario
     */
    public boolean esAptaParaEVA() {
        return material != null && 
               (material.contains("Titanio") || 
                material.contains("Acero inoxidable") || 
                material.contains("Compuesto"));
    }
    
    /**
     * Calcula la prioridad de empaque basado en criticidad y requerimientos.
     * <p>
     * Herramientas críticas para supervivencia y reparación tienen mayor prioridad.
     * </p>
     *
     * @return Valor numérico representando la prioridad (mayor valor = mayor prioridad)
     */
    public int calcularPrioridadEmpaque() {
        int prioridad = 1;
        
        // Herramientas de reparación tienen alta prioridad
        if (funcion != null && funcion.toLowerCase().contains("reparación")) {
            prioridad += 2;
        }
        
        // Herramientas que no requieren energía son más versátiles
        if (!requiereEnergia) {
            prioridad += 1;
        }
        
        // Herramientas livianas son preferibles
        if (getPeso() < 2.0) {
            prioridad += 1;
        }
        
        return prioridad;
    }
    
    /**
     * Verifica si la herramienta es considerada de emergencia.
     * <p>
     * Herramientas críticas para situaciones de contingencia.
     * </p>
     *
     * @return {@code true} si es herramienta de emergencia, {@code false} en caso contrario
     */
    public boolean esHerramientaEmergencia() {
        return funcion != null && 
               (funcion.toLowerCase().contains("corte") || 
                funcion.toLowerCase().contains("escape") ||
                funcion.toLowerCase().contains("supervivencia"));
    }
    
    /**
     * Representación en texto del objeto Herramienta.
     * <p>
     * Incluye información de la clase padre más los atributos específicos
     * de la herramienta.
     * </p>
     *
     * @return String con la representación completa de la herramienta
     * @see Producto#toString()
     */
    @Override
    public String toString() {
        return super.toString() + 
               ", Herramienta{" +
               "funcion='" + funcion + '\'' +
               ", material='" + material + '\'' +
               ", requiereEnergia=" + requiereEnergia +
               '}';
    }
    
    /**
     * Proporciona una descripción técnica resumida de la herramienta.
     * <p>
     * Incluye información clave para identificación rápida en inventarios.
     * </p>
     *
     * @return String con descripción técnica resumida
     */
    public String getDescripcionTecnica() {
        String tipoEnergia = requiereEnergia ? "Eléctrica" : "Manual";
        return getNombre() + " - " + funcion + 
               " (" + material + ", " + tipoEnergia + ")";
    }
}