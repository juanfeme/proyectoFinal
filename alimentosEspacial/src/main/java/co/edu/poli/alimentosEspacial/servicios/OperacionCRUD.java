package co.edu.poli.alimentosEspacial.servicios;

import co.edu.poli.alimentosEspacial.modelo.Producto;

/**
 * Interfaz que define las operaciones básicas CRUD (Create, Read, Update, Delete)
 * para la gestión de productos espaciales en el sistema.
 * <p>
 * Esta interfaz establece el contrato fundamental para las operaciones de mantenimiento
 * de datos de productos espaciales, proporcionando una API consistente para todas las
 * implementaciones de almacenamiento y gestión de productos.
 * </p>
 * 
 * @author Politécnico Grancolombiano
 * @version 1.0
 * @since 2024
 * @see Producto
 * @see ImplementacionOperacionCRUD
 * @see OperacionArchivo
 */
public interface OperacionCRUD {
    
    /**
     * Crea y agrega un nuevo producto al sistema.
     * <p>
     * Esta operación debe validar la unicidad del ID del producto y almacenar
     * el objeto en el sistema de persistencia. La implementación debe garantizar
     * que no se permitan productos duplicados con el mismo ID.
     * </p>
     *
     * @param objeto El producto a ser creado y agregado al sistema. No debe ser {@code null}.
     * @return Mensaje descriptivo que confirma la creación exitosa o describe el error
     *         ocurrido. Debe incluir información sobre la ubicación o identificación
     *         del producto creado.
     * @throws IllegalArgumentException Si el {@code objeto} es {@code null}, o si el ID
     *                                  del producto es {@code null} o vacío, o si ya
     *                                  existe un producto con el mismo ID.
     * @throws RuntimeException Si ocurre un error durante el proceso de almacenamiento.
     * @see Producto
     */
    String create(Producto objeto);
    
    /**
     * Recupera todos los productos existentes en el sistema.
     * <p>
     * Esta operación retorna un arreglo con todos los productos almacenados.
     * El arreglo puede contener elementos {@code null} si la implementación
     * utiliza un arreglo de tamaño fijo con posiciones vacías.
     * </p>
     *
     * @return Arreglo que contiene todos los productos en el sistema. El arreglo
     *         nunca debe ser {@code null}, pero puede estar vacío si no hay productos.
     *         Las implementaciones pueden retornar un arreglo con elementos {@code null}.
     * @see Producto
     */
    Producto[] read();
    
    /**
     * Busca y recupera un producto específico por su identificador único.
     * <p>
     * Esta operación realiza una búsqueda exacta por ID en el sistema de almacenamiento.
     * La búsqueda es case-sensitive y debe coincidir exactamente con el ID proporcionado.
     * </p>
     *
     * @param id El identificador único del producto a buscar. No debe ser {@code null} o vacío.
     * @return El producto encontrado con el ID especificado, o {@code null} si no se
     *         encuentra ningún producto con ese ID.
     * @throws IllegalArgumentException Si el {@code id} es {@code null} o una cadena vacía.
     * @see Producto
     */
    Producto readId(String id);
    
    /**
     * Actualiza un producto existente en el sistema.
     * <p>
     * Esta operación busca un producto por su ID y lo reemplaza completamente con
     * el nuevo objeto proporcionado. El ID en el objeto de actualización debe coincidir
     * con el ID proporcionado como parámetro.
     * </p>
     *
     * @param id El identificador único del producto a actualizar. No debe ser {@code null} o vacío.
     * @param objeto El nuevo objeto producto con los datos actualizados. No debe ser {@code null}.
     * @return Mensaje descriptivo que confirma la actualización exitosa o describe el error
     *         ocurrido. Debe incluir información sobre la ubicación del producto actualizado.
     * @throws IllegalArgumentException Si {@code id} o {@code objeto} son {@code null},
     *                                  o si el ID no existe en el sistema, o si el ID
     *                                  en el objeto no coincide con el parámetro {@code id}.
     * @throws RuntimeException Si ocurre un error durante el proceso de actualización.
     * @see Producto
     */
    String update(String id, Producto objeto);
    
    /**
     * Elimina un producto del sistema.
     * <p>
     * Esta operación busca un producto por su ID y lo elimina permanentemente del
     * sistema de almacenamiento. La implementación debe liberar los recursos
     * asociados al producto eliminado.
     * </p>
     *
     * @param id El identificador único del producto a eliminar. No debe ser {@code null} o vacío.
     * @return El producto que fue eliminado del sistema, o {@code null} si no se
     *         encontró ningún producto con el ID especificado.
     * @throws IllegalArgumentException Si el {@code id} es {@code null} o una cadena vacía.
     * @throws RuntimeException Si ocurre un error durante el proceso de eliminación.
     * @see Producto
     */
    Producto delete(String id);
}