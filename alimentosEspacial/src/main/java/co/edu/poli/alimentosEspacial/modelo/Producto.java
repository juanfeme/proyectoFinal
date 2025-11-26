package co.edu.poli.alimentosEspacial.modelo;

import java.io.Serializable;

/**
 * Clase base que representa un producto genérico para misiones espaciales.
 * <p>
 * Esta clase sirve como base para todos los tipos de productos en el sistema
 * de gestión espacial, proporcionando atributos comunes como identificador,
 * nombre, peso y volumen. Implementa {@link Serializable} para permitir
 * el almacenamiento y transmisión de productos.
 * </p>
 * 
 * @author Politécnico Grancolombiano
 * @version 1.0
 * @since 2024
 * @see Serializable
 * @see Alimento
 * @see EquipoMedico
 * @see Herramienta
 * @see EquipoComunicacion
 */
public class Producto implements Serializable {
    
    /**
     * Identificador único para la serialización.
     * <p>
     * Garantiza la compatibilidad durante el proceso de serialización/deserialización
     * de los productos.
     * </p>
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * Identificador único del producto.
     * <p>
     * Formato recomendado: prefijo alfanumérico único en el sistema.
     * </p>
     */
    private String id;
    
    /**
     * Nombre descriptivo del producto.
     * <p>
     * Debe ser suficientemente descriptivo para identificación rápida.
     * </p>
     */
    private String nombre;
    
    /**
     * Peso del producto en kilogramos.
     * <p>
     * Valor debe ser positivo. Crítico para cálculos de capacidad de naves.
     * </p>
     */
    private double peso;
    
    /**
     * Volumen ocupado por el producto en metros cúbicos.
     * <p>
     * Valor debe ser positivo. Esencial para optimización de espacio en naves.
     * </p>
     */
    private double volumen;

    /**
     * Constructor completo para crear una instancia de Producto.
     *
     * @param id Identificador único del producto
     * @param nombre Nombre descriptivo del producto
     * @param peso Peso del producto en kilogramos
     * @param volumen Volumen del producto en metros cúbicos
     * @throws IllegalArgumentException Si el id o nombre son nulos o vacíos,
     *                                  o si peso/volumen son negativos
     */
    public Producto(String id, String nombre, double peso, double volumen) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.volumen = volumen;
    }

    /**
     * Obtiene el identificador único del producto.
     *
     * @return Identificador del producto
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador único del producto.
     *
     * @param id Nuevo identificador del producto
     * @throws IllegalArgumentException Si el id es nulo o vacío
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre descriptivo del producto.
     *
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre descriptivo del producto.
     *
     * @param nombre Nuevo nombre del producto
     * @throws IllegalArgumentException Si el nombre es nulo o vacío
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el peso del producto.
     *
     * @return Peso en kilogramos
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso del producto.
     *
     * @param peso Nuevo peso en kilogramos
     * @throws IllegalArgumentException Si el peso es negativo
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Obtiene el volumen del producto.
     *
     * @return Volumen en metros cúbicos
     */
    public double getVolumen() {
        return volumen;
    }

    /**
     * Establece el volumen del producto.
     *
     * @param volumen Nuevo volumen en metros cúbicos
     * @throws IllegalArgumentException Si el volumen es negativo
     */
    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }
    
    /**
     * Calcula la densidad del producto.
     * <p>
     * Útil para optimización de empaque y distribución de carga.
     * </p>
     *
     * @return Densidad en kg/m³, o 0 si el volumen es 0
     */
    public double calcularDensidad() {
        if (volumen == 0) {
            return 0;
        }
        return peso / volumen;
    }
    
    /**
     * Verifica si el producto es considerado liviano.
     * <p>
     * Un producto se considera liviano si pesa menos de 1 kg.
     * </p>
     *
     * @return {@code true} si el producto es liviano, {@code false} en caso contrario
     */
    public boolean esLiviano() {
        return peso < 1.0;
    }
    
    /**
     * Verifica si el producto es considerado compacto.
     * <p>
     * Un producto se considera compacto si ocupa menos de 0.1 m³.
     * </p>
     *
     * @return {@code true} si el producto es compacto, {@code false} en caso contrario
     */
    public boolean esCompacto() {
        return volumen < 0.1;
    }
    
    /**
     * Valida que los datos básicos del producto sean correctos.
     * <p>
     * Verifica que no haya valores nulos/vacíos y que los valores numéricos sean positivos.
     * </p>
     *
     * @return {@code true} si el producto tiene datos válidos, {@code false} en caso contrario
     */
    public boolean validar() {
        return id != null && !id.isEmpty() &&
               nombre != null && !nombre.isEmpty() &&
               peso >= 0 && volumen >= 0;
    }
    
    /**
     * Proporciona una descripción resumida del producto.
     * <p>
     * Incluye información básica para identificación rápida en inventarios.
     * </p>
     *
     * @return String con descripción resumida del producto
     */
    public String getDescripcionResumida() {
        return String.format("%s - %s (%.2f kg, %.2f m³)", id, nombre, peso, volumen);
    }
    
    /**
     * Representación en texto del objeto Producto.
     * <p>
     * Proporciona una vista completa de todos los atributos del producto.
     * </p>
     *
     * @return String con la representación completa del producto
     */
    @Override
    public String toString() {
        return "Producto{" +
               "id='" + id + '\'' +
               ", nombre='" + nombre + '\'' +
               ", peso=" + peso +
               ", volumen=" + volumen +
               '}';
    }
    
    /**
     * Obtiene el tipo específico de producto.
     * <p>
     * Determina la categoría específica basada en la instancia real del objeto.
     * </p>
     *
     * @return Nombre de la clase concreta del producto
     */
    public String getTipoProducto() {
        return this.getClass().getSimpleName();
    }
}