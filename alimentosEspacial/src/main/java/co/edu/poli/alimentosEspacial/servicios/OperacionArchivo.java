package co.edu.poli.alimentosEspacial.servicios;

import co.edu.poli.alimentosEspacial.modelo.Producto;

/**
 * Interfaz que define las operaciones de archivo para el sistema de gestión espacial.
 * <p>
 * Esta interfaz establece el contrato para las operaciones de serialización y deserialización
 * de productos espaciales, permitiendo la persistencia de datos en almacenamiento secundario.
 * Las implementaciones deben proporcionar funcionalidad para guardar y cargar arreglos de productos
 * desde/hacia archivos en el sistema de archivos.
 * </p>
 * 
 * @author Politécnico Grancolombiano
 * @version 1.0
 * @since 2024
 * @see Producto
 * @see ImplementacionOperacionCRUD
 */
public interface OperacionArchivo {
    
    /**
     * Serializa un arreglo de productos y los guarda en un archivo binario.
     * <p>
     * Esta operación toma un arreglo de productos y los guarda en un archivo especificado
     * utilizando serialización de objetos Java. El archivo resultante contendrá una
     * representación binaria de todos los productos que puede ser recuperada posteriormente.
     * </p>
     *
     * @param productos Arreglo de productos a serializar y guardar. Puede contener
     *                  elementos {@code null} que serán preservados en la serialización.
     * @param path Ruta del directorio donde se creará el archivo. Debe ser una ruta
     *             válida y accesible en el sistema de archivos.
     * @param name Nombre del archivo a crear. No debe incluir la ruta completa, solo
     *             el nombre del archivo con extensión si es necesario.
     * @return Mensaje descriptivo que indica el resultado de la operación. Debe incluir
     *         información sobre éxito o detalles del error si falla.
     * @throws IllegalArgumentException Si {@code path} o {@code name} son {@code null} o vacíos,
     *                                  o si la ruta especificada no es válida o accesible.
     * @throws RuntimeException Si ocurre un error durante el proceso de serialización o
     *                         escritura del archivo.
     * @see Producto
     * @see java.io.Serializable
     */
    String serializar(Producto[] productos, String path, String name);
    
    /**
     * Deserializa un arreglo de productos desde un archivo binario.
     * <p>
     * Esta operación carga un arreglo de productos previamente guardado desde un archivo
     * binario. Si el archivo no existe, la implementación debe manejar este caso de manera
     * apropiada, ya sea retornando un arreglo vacío o manejando la excepción según la
     * estrategia definida.
     * </p>
     *
     * @param path Ruta del directorio donde se encuentra el archivo. Debe ser una ruta
     *             válida en el sistema de archivos.
     * @param name Nombre del archivo a cargar. No debe incluir la ruta completa, solo
     *             el nombre del archivo.
     * @return Arreglo de productos cargado desde el archivo. El arreglo puede contener
     *         elementos {@code null} si el archivo original los contenía. Si el archivo
     *         no existe, el comportamiento depende de la implementación (puede retornar
     *         un arreglo vacío o {@code null}).
     * @throws IllegalArgumentException Si {@code path} o {@code name} son {@code null} o vacíos.
     * @throws RuntimeException Si ocurre un error durante la deserialización, como
     *                         corrupción de datos o versión incompatible de clases.
     * @see Producto
     * @see java.io.Serializable
     */
    Producto[] deserializar(String path, String name);
}