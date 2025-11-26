package co.edu.poli.alimentosEspacial.servicios;

import java.io.*;
import co.edu.poli.alimentosEspacial.modelo.Producto;

/**
 * Implementación concreta de las operaciones CRUD y de archivo para productos espaciales.
 * <p>
 * Esta clase proporciona la funcionalidad completa para gestionar productos espaciales,
 * incluyendo operaciones básicas CRUD (Create, Read, Update, Delete) y operaciones
 * de serialización/deserialización para persistencia de datos.
 * </p>
 * 
 * @author Politécnico Grancolombiano
 * @version 1.0
 * @since 2024
 * @see OperacionCRUD
 * @see OperacionArchivo
 * @see Producto
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD, OperacionArchivo {

    /**
     * Arreglo que almacena los productos gestionados por el sistema.
     * <p>
     * Utiliza un arreglo dinámico que se expande automáticamente cuando se llena.
     * </p>
     */
    private Producto[] productos;
    
    /**
     * Capacidad inicial del arreglo de productos.
     * <p>
     * Define el tamaño inicial del arreglo y el incremento cuando se necesita expandir.
     * </p>
     */
    private int capacidadInicial = 5;

    /**
     * Constructor por defecto que inicializa el arreglo de productos.
     * <p>
     * Crea un arreglo vacío con la capacidad inicial definida.
     * </p>
     */
    public ImplementacionOperacionCRUD() {
        productos = new Producto[capacidadInicial];
    }

    /**
     * Crea un nuevo producto en el sistema.
     * <p>
     * Busca la primera posición disponible en el arreglo. Si no hay espacio disponible,
     * expande el arreglo automáticamente antes de agregar el producto.
     * </p>
     *
     * @param objeto Producto a ser creado/agregado al sistema
     * @return Mensaje de confirmación indicando la posición donde fue agregado
     * @throws IllegalArgumentException Si el producto es nulo
     * @see Producto
     */
    @Override
    public String create(Producto objeto) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {
                productos[i] = objeto;
                return "Producto agregado en posición " + i;
            }
        }
        Producto[] nuevoArreglo = new Producto[productos.length + capacidadInicial];
        System.arraycopy(productos, 0, nuevoArreglo, 0, productos.length);
        nuevoArreglo[productos.length] = objeto;
        productos = nuevoArreglo;
        return "Producto agregado en nueva posición " + productos.length;
    }

    /**
     * Obtiene todos los productos del sistema.
     * <p>
     * Retorna el arreglo completo de productos, incluyendo posiciones nulas.
     * </p>
     *
     * @return Arreglo con todos los productos gestionados
     * @see Producto
     */
    @Override
    public Producto[] read() {
        return productos;
    }

    /**
     * Busca un producto por su identificador único.
     * <p>
     * Recorre el arreglo de productos buscando coincidencia exacta del ID.
     * </p>
     *
     * @param id Identificador único del producto a buscar
     * @return El producto encontrado, o {@code null} si no existe
     * @throws IllegalArgumentException Si el id es nulo o vacío
     * @see Producto
     */
    @Override
    public Producto readId(String id) {
        for (Producto p : productos) {
            if (p != null && p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    /**
     * Actualiza un producto existente en el sistema.
     * <p>
     * Busca el producto por ID y lo reemplaza con el nuevo objeto proporcionado.
     * </p>
     *
     * @param id Identificador único del producto a actualizar
     * @param objeto Nuevo objeto producto con los datos actualizados
     * @return Mensaje de confirmación indicando el resultado de la operación
     * @throws IllegalArgumentException Si el id es nulo/vacío o el objeto es nulo
     * @see Producto
     */
    @Override
    public String update(String id, Producto objeto) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && productos[i].getId().equals(id)) {
                productos[i] = objeto;
                return "Producto actualizado en posición " + i;
            }
        }
        return "Producto con ID " + id + " no encontrado.";
    }

    /**
     * Elimina un producto del sistema.
     * <p>
     * Busca el producto por ID y lo elimina estableciendo la posición a {@code null}.
     * </p>
     *
     * @param id Identificador único del producto a eliminar
     * @return El producto eliminado, o {@code null} si no fue encontrado
     * @throws IllegalArgumentException Si el id es nulo o vacío
     * @see Producto
     */
    @Override
    public Producto delete(String id) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null && productos[i].getId().equals(id)) {
                Producto eliminado = productos[i];
                productos[i] = null;
                return eliminado;
            }
        }
        return null;
    }

    /**
     * Establece el arreglo de productos directamente.
     * <p>
     * Útil para inicializar el sistema con un conjunto preexistente de productos.
     * </p>
     *
     * @param nuevosProductos Nuevo arreglo de productos a gestionar
     * @see Producto
     */
    public void setProductos(Producto[] nuevosProductos) {
        this.productos = nuevosProductos;
    }

    /**
     * Serializa el arreglo de productos a un archivo binario.
     * <p>
     * Guarda el estado actual del sistema en un archivo para persistencia.
     * Utiliza serialización de objetos Java.
     * </p>
     *
     * @param productos Arreglo de productos a serializar
     * @param path Ruta del directorio donde se guardará el archivo
     * @param name Nombre del archivo a crear
     * @return Mensaje de confirmación del resultado de la operación
     * @throws IOException Si ocurre un error durante la escritura del archivo
     * @see Producto
     * @see Serializable
     */
    @Override
    public String serializar(Producto[] productos, String path, String name) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + File.separator + name))) {
            oos.writeObject(productos);
            return ">> Archivo '" + name + "' guardado exitosamente en '" + path + "'";
        } catch (IOException e) {
            return "Error al guardar el archivo: " + e.getMessage();
        }
    }

    /**
     * Deserializa un arreglo de productos desde un archivo binario.
     * <p>
     * Carga el estado del sistema desde un archivo previamente guardado.
     * Si el archivo no existe, retorna un arreglo vacío.
     * </p>
     *
     * @param path Ruta del directorio donde se encuentra el archivo
     * @param name Nombre del archivo a cargar
     * @return Arreglo de productos cargado desde el archivo, o arreglo vacío si el archivo no existe
     * @throws IOException Si ocurre un error durante la lectura del archivo
     * @throws ClassNotFoundException Si la clase del objeto serializado no se encuentra
     * @see Producto
     * @see Serializable
     */
    @Override
    public Producto[] deserializar(String path, String name) {
        File archivo = new File(path + File.separator + name);
        if (!archivo.exists()) {
            System.out.println(">> El archivo no existe. Se comenzará con una lista vacía.");
            return new Producto[10];
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Producto[]) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar el archivo: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Obtiene la cantidad actual de productos no nulos en el sistema.
     *
     * @return Número de productos activos en el sistema
     */
    public int getCantidadProductos() {
        int count = 0;
        for (Producto p : productos) {
            if (p != null) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Obtiene la capacidad total actual del arreglo de productos.
     *
     * @return Tamaño actual del arreglo de productos
     */
    public int getCapacidadTotal() {
        return productos.length;
    }
    
    /**
     * Verifica si existe un producto con el ID especificado.
     *
     * @param id Identificador único a verificar
     * @return {@code true} si existe un producto con ese ID, {@code false} en caso contrario
     */
    public boolean existeProducto(String id) {
        return readId(id) != null;
    }
    
    /**
     * Obtiene un resumen estadístico del sistema de productos.
     *
     * @return String con información sobre cantidad y capacidad del sistema
     */
    public String obtenerEstadisticas() {
        return String.format("Productos activos: %d/%d (%.1f%%)", 
                           getCantidadProductos(), getCapacidadTotal(),
                           (getCantidadProductos() * 100.0 / getCapacidadTotal()));
    }
}