package co.edu.poli.alimentosEspacial.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal de la aplicación de Gestión de Productos Espaciales.
 * <p>
 * Esta clase extiende {@link Application} de JavaFX y sirve como punto de entrada
 * principal para la interfaz gráfica de usuario. Se encarga de inicializar y
 * configurar la ventana principal de la aplicación, cargando la interfaz desde
 * un archivo FXML y estableciendo las propiedades básicas de la ventana.
 * </p>
 * 
 * @author Politécnico Grancolombiano
 * @version 1.0
 * @since 2024
 * @see Application
 * @see FXMLLoader
 * @see Stage
 * @see Scene
 */
public class App extends Application {

    /**
     * Método principal de inicialización de la interfaz gráfica de usuario.
     * <p>
     * Este método es llamado automáticamente por el framework JavaFX después de
     * que el método {@link #init()} ha retornado. Se encarga de:
     * <ul>
     *   <li>Cargar la interfaz de usuario desde el archivo FXML</li>
     *   <li>Crear la escena principal con dimensiones específicas</li>
     *   <li>Configurar las propiedades de la ventana principal (Stage)</li>
     *   <li>Mostrar la ventana al usuario</li>
     * </ul>
     * </p>
     *
     * @param stage El escenario principal (ventana) proporcionado por JavaFX.
     *              No debe ser {@code null}.
     * @throws Exception Si ocurre algún error durante la carga del archivo FXML,
     *                   la creación de la escena, o la configuración del stage.
     *                   Los errores comunes incluyen:
     *                   <ul>
     *                     <li>Archivo FXML no encontrado</li>
     *                     <li>Errores de sintaxis en el FXML</li>
     *                     <li>Problemas de recursos del sistema</li>
     *                   </ul>
     * @see FXMLLoader#load()
     * @see Scene#Scene(javafx.scene.Parent, double, double)
     * @see Stage#setScene(Scene)
     * @see Stage#show()
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ProductoView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 750);
        stage.setTitle("Sistema de Gestión de Productos Espaciales");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Punto de entrada principal de la aplicación JavaFX.
     * <p>
     * Este método es el punto de entrada convencional para aplicaciones Java
     * que utilizan JavaFX. Delega el control al framework JavaFX llamando al
     * método {@link Application#launch(String...)} que a su vez inicializa
     * la aplicación y llama al método {@link #start(Stage)}.
     * </p>
     * <p>
     * <strong>Nota:</strong> En aplicaciones JavaFX, el método {@code main}
     * simplemente delega a {@code launch()} y no debe contener lógica adicional
     * de inicialización.
     * </p>
     *
     * @param args Argumentos de línea de comandos pasados a la aplicación.
     *             Pueden incluir parámetros de configuración específicos de
     *             JavaFX o de la aplicación.
     * @see Application#launch(String...)
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Método de inicialización opcional de la aplicación.
     * <p>
     * Este método puede ser sobreescrito para realizar tareas de inicialización
     * antes de que se muestre la interfaz gráfica. Es útil para:
     * <ul>
     *   <li>Cargar configuraciones de la aplicación</li>
     *   <li>Inicializar servicios o conexiones a bases de datos</li>
     *   <li>Realizar verificaciones de requisitos del sistema</li>
     * </ul>
     * La implementación por defecto no realiza ninguna operación.
     * </p>
     *
     * @throws Exception Si ocurre algún error durante la inicialización
     */
    @Override
    public void init() throws Exception {
        // Inicialización opcional de la aplicación
        // Puede ser sobreescrita para cargar configuraciones, servicios, etc.
        super.init();
    }
    
    /**
     * Método de limpieza opcional de la aplicación.
     * <p>
     * Este método es llamado cuando la aplicación está terminando y puede ser
     * sobreescrito para realizar tareas de limpieza como:
     * <ul>
     *   <li>Guardar el estado de la aplicación</li>
     *   <li>Cerrar conexiones a bases de datos</li>
     *   <li>Liberar recursos del sistema</li>
     *   <li>Realizar backup de datos</li>
     * </ul>
     * La implementación por defecto no realiza ninguna operación.
     * </p>
     *
     * @throws Exception Si ocurre algún error durante la limpieza
     */
    @Override
    public void stop() throws Exception {
        // Limpieza opcional de la aplicación
        // Puede ser sobreescrita para guardar estado, liberar recursos, etc.
        super.stop();
    }
}