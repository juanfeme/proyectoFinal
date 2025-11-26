package co.edu.poli.alimentosEspacial.servicios;

import java.io.*;
import co.edu.poli.alimentosEspacial.modelo.Producto;

public class ImplementacionOperacionCRUD implements OperacionCRUD, OperacionArchivo {

    private Producto[] productos;
    private int capacidadInicial = 5;

    public ImplementacionOperacionCRUD() {
        productos = new Producto[capacidadInicial];
    }

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

    @Override
    public Producto[] read() {
        return productos;
    }

    @Override
    public Producto readId(String id) {
        for (Producto p : productos) {
            if (p != null && p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

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

    public void setProductos(Producto[] nuevosProductos) {
        this.productos = nuevosProductos;
    }

    @Override
    public String serializar(Producto[] productos, String path, String name) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + File.separator + name))) {
            oos.writeObject(productos);
            return ">> Archivo '" + name + "' guardado exitosamente en '" + path + "'";
        } catch (IOException e) {
            return "Error al guardar el archivo: " + e.getMessage();
        }
    }

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
}