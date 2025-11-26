package co.edu.poli.alimentosEspacial.controlador;

import java.util.Optional;
import co.edu.poli.alimentosEspacial.modelo.*;
import co.edu.poli.alimentosEspacial.servicios.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

/**
 * Controlador principal para la gestión de productos espaciales.
 * <p>
 * Esta clase maneja la interfaz gráfica de usuario para realizar operaciones CRUD
 * sobre diferentes tipos de productos: alimentos, equipos médicos, herramientas
 * y equipos de comunicación.
 * </p>
 * 
 * @author Politécnico Grancolombiano
 * @version 1.0
 * @since 2024
 */
public class ProductoControlador {

    // Componentes de la interfaz gráfica
    @FXML private Button btnCrear, btnActualizar, btnEliminar, btnLimpiar, btnGuardar, btnCargar;
    @FXML private Label lblContador;
    @FXML private Label lblFechaCaducidad, lblTipoAlimento, lblCalorias;
    @FXML private Label lblUsoEspecifico, lblFechaEsterilizacion, lblUdt;
    @FXML private Label lblFuncion, lblMaterial;
    @FXML private Label lblTipoComunicacion, lblRangoFrecuencia, lblPotencia;
    
    @FXML private TextField txtId, txtNombre, txtPeso, txtVolumen;
    @FXML private TextField txtFechaCaducidad, txtTipoAlimento, txtCalorias;
    @FXML private TextField txtUsoEspecifico, txtFechaEsterilizacion, txtUdt;
    @FXML private TextField txtFuncion, txtMaterial;
    @FXML private TextField txtTipoComunicacion, txtRangoFrecuencia, txtPotencia;
    
    @FXML private ComboBox<String> cmbTipoProducto;
    @FXML private RadioButton rbAlimento, rbEquipoMedico, rbHerramienta, rbEquipoComunicacion;
    @FXML private CheckBox chkEsterilizado, chkRequiereEnergia;
    
    @FXML private TableView<Producto> tblView;
    @FXML private TableColumn<Producto, String> columnId, columnNombre, columnPeso, columnVolumen;
    @FXML private TableColumn<Producto, String> columnCategoria, columnDetalle1, columnDetalle2, columnDetalle3;
    
    @FXML private ToggleGroup categoria;
    
    /** Lista observable de productos para la tabla */
    ObservableList<Producto> productos;
    
    /** Servicio para operaciones CRUD */
    ImplementacionOperacionCRUD crud;
    
    /** Ruta del archivo de datos */
    private final String PATH = ".";
    
    /** Nombre del archivo de datos */
    private final String NOMBRE_ARCHIVO = "productos.dat";

    /**
     * Método de inicialización del controlador.
     * <p>
     * Se ejecuta automáticamente después de que se carga el FXML.
     * Configura los componentes iniciales y carga los datos existentes.
     * </p>
     */
    @FXML
    public void initialize() {
        productos = FXCollections.observableArrayList();
        crud = new ImplementacionOperacionCRUD();

        cargarDatosIniciales();
        configurarComboBoxes();
        configurarCamposPorCategoria();
        actualizarContador();
    }
    
    /**
     * Carga los datos iniciales desde el archivo de serialización.
     * <p>
     * Intenta cargar productos previamente guardados. Si no existen datos previos,
     * inicializa con una lista vacía.
     * </p>
     */
    private void cargarDatosIniciales() {
        try {
            Producto[] productosCargados = crud.deserializar(PATH, NOMBRE_ARCHIVO);
            if (productosCargados != null) {
                crud.setProductos(productosCargados);
                productos.clear();
                for (Producto p : crud.read()) {
                    if (p != null) {
                        productos.add(p);
                    }
                }
                loadTable();
            }
        } catch (Exception e) {
            System.out.println("No hay datos previos: " + e.getMessage());
        }
    }
    
    /**
     * Configura los ComboBoxes de la interfaz.
     * <p>
     * Establece los valores disponibles para el tipo de producto.
     * </p>
     */
    private void configurarComboBoxes() {
        ObservableList<String> tiposProducto = FXCollections.observableArrayList(
            "Esencial", "No Esencial", "Emergencia", "Experimental"
        );
        cmbTipoProducto.setItems(tiposProducto);
    }
    
    /**
     * Configura la visibilidad de campos según la categoría seleccionada.
     * <p>
     * Agrega un listener al grupo de categorías para mostrar/ocultar campos
     * específicos según el tipo de producto seleccionado.
     * </p>
     */
    private void configurarCamposPorCategoria() {
        categoria.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            ocultarTodosCampos();
            if (newVal == rbAlimento) {
                mostrarCamposAlimento();
            } else if (newVal == rbEquipoMedico) {
                mostrarCamposEquipoMedico();
            } else if (newVal == rbHerramienta) {
                mostrarCamposHerramienta();
            } else if (newVal == rbEquipoComunicacion) {
                mostrarCamposEquipoComunicacion();
            }
        });
        mostrarCamposAlimento();
    }
    
    /**
     * Oculta todos los campos específicos de categoría.
     * <p>
     * Utilizado antes de mostrar los campos correspondientes a la categoría seleccionada.
     * </p>
     */
    private void ocultarTodosCampos() {
        lblFechaCaducidad.setVisible(false);
        txtFechaCaducidad.setVisible(false);
        lblTipoAlimento.setVisible(false);
        txtTipoAlimento.setVisible(false);
        lblCalorias.setVisible(false);
        txtCalorias.setVisible(false);
        
        lblUsoEspecifico.setVisible(false);
        txtUsoEspecifico.setVisible(false);
        lblFechaEsterilizacion.setVisible(false);
        txtFechaEsterilizacion.setVisible(false);
        lblUdt.setVisible(false);
        txtUdt.setVisible(false);
        chkEsterilizado.setVisible(false);
        
        lblFuncion.setVisible(false);
        txtFuncion.setVisible(false);
        lblMaterial.setVisible(false);
        txtMaterial.setVisible(false);
        chkRequiereEnergia.setVisible(false);
        
        lblTipoComunicacion.setVisible(false);
        txtTipoComunicacion.setVisible(false);
        lblRangoFrecuencia.setVisible(false);
        txtRangoFrecuencia.setVisible(false);
        lblPotencia.setVisible(false);
        txtPotencia.setVisible(false);
    }
    
    /**
     * Muestra los campos específicos para productos de tipo Alimento.
     */
    private void mostrarCamposAlimento() {
        lblFechaCaducidad.setVisible(true);
        txtFechaCaducidad.setVisible(true);
        lblTipoAlimento.setVisible(true);
        txtTipoAlimento.setVisible(true);
        lblCalorias.setVisible(true);
        txtCalorias.setVisible(true);
    }
    
    /**
     * Muestra los campos específicos para productos de tipo Equipo Médico.
     */
    private void mostrarCamposEquipoMedico() {
        lblUsoEspecifico.setVisible(true);
        txtUsoEspecifico.setVisible(true);
        lblFechaEsterilizacion.setVisible(true);
        txtFechaEsterilizacion.setVisible(true);
        lblUdt.setVisible(true);
        txtUdt.setVisible(true);
        chkEsterilizado.setVisible(true);
    }
    
    /**
     * Muestra los campos específicos para productos de tipo Herramienta.
     */
    private void mostrarCamposHerramienta() {
        lblFuncion.setVisible(true);
        txtFuncion.setVisible(true);
        lblMaterial.setVisible(true);
        txtMaterial.setVisible(true);
        chkRequiereEnergia.setVisible(true);
    }
    
    /**
     * Muestra los campos específicos para productos de tipo Equipo de Comunicación.
     */
    private void mostrarCamposEquipoComunicacion() {
        lblTipoComunicacion.setVisible(true);
        txtTipoComunicacion.setVisible(true);
        lblRangoFrecuencia.setVisible(true);
        txtRangoFrecuencia.setVisible(true);
        lblPotencia.setVisible(true);
        txtPotencia.setVisible(true);
    }
    
    /**
     * Actualiza el contador de productos en la interfaz.
     * <p>
     * Muestra la cantidad total de productos en la lista.
     * </p>
     */
    private void actualizarContador() {
        if (lblContador != null) {
            lblContador.setText(String.valueOf(productos.size()));
        }
    }

    /**
     * Maneja el evento de crear un nuevo producto.
     * <p>
     * Valida los campos, crea el producto según la categoría seleccionada
     * y lo agrega a la lista.
     * </p>
     *
     * @param event Evento de acción del botón Crear
     */
    @FXML
    void pressCrear(ActionEvent event) {
        Alert a = new Alert(AlertType.CONFIRMATION);
        try {
            if (!validarCamposBasicos()) {
                throw new Exception("Complete todos los campos básicos (ID, Nombre, Peso, Volumen)");
            }

            RadioButton rbaux = (RadioButton) categoria.getSelectedToggle();
            if (rbaux == null) {
                throw new Exception("Debe seleccionar una categoría");
            }

            String id = txtId.getText();
            String nombre = txtNombre.getText();
            double peso = Double.parseDouble(txtPeso.getText());
            double volumen = Double.parseDouble(txtVolumen.getText());

            Producto nuevoProducto = null;

            if (rbaux == rbAlimento) {
                if (txtFechaCaducidad.getText().isEmpty() || txtTipoAlimento.getText().isEmpty() 
                    || txtCalorias.getText().isEmpty()) {
                    throw new Exception("Complete todos los campos de Alimento");
                }
                nuevoProducto = new Alimento(id, nombre, peso, volumen,
                    txtFechaCaducidad.getText(), txtTipoAlimento.getText(),
                    Integer.parseInt(txtCalorias.getText()));
                    
            } else if (rbaux == rbEquipoMedico) {
                if (txtUsoEspecifico.getText().isEmpty() || txtFechaEsterilizacion.getText().isEmpty() 
                    || txtUdt.getText().isEmpty()) {
                    throw new Exception("Complete todos los campos de Equipo Médico");
                }
                nuevoProducto = new EquipoMedico(id, nombre, peso, volumen,
                    txtUsoEspecifico.getText(), chkEsterilizado.isSelected(),
                    txtFechaEsterilizacion.getText(), txtUdt.getText());
                    
            } else if (rbaux == rbHerramienta) {
                if (txtFuncion.getText().isEmpty() || txtMaterial.getText().isEmpty()) {
                    throw new Exception("Complete todos los campos de Herramienta");
                }
                nuevoProducto = new Herramienta(id, nombre, peso, volumen,
                    txtFuncion.getText(), txtMaterial.getText(), chkRequiereEnergia.isSelected());
                    
            } else if (rbaux == rbEquipoComunicacion) {
                if (txtTipoComunicacion.getText().isEmpty() || txtRangoFrecuencia.getText().isEmpty() 
                    || txtPotencia.getText().isEmpty()) {
                    throw new Exception("Complete todos los campos de Equipo de Comunicación");
                }
                nuevoProducto = new EquipoComunicacion(id, nombre, peso, volumen,
                        txtTipoComunicacion.getText(), Double.parseDouble(txtRangoFrecuencia.getText()),
                        Integer.parseInt(txtPotencia.getText()));
                }

                if (nuevoProducto != null) {
                    a.setContentText(crud.create(nuevoProducto));
                    productos.add(nuevoProducto);
                    loadTable();
                    actualizarContador();
                    clear();
                }

                a.show();

            } catch (NumberFormatException e) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Error en formato numérico: verifique Peso, Volumen y otros campos numéricos");
                a.show();
            } catch (Exception e) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText(e.getMessage());
                a.show();
            }
        }

        /**
         * Maneja el evento de guardar los productos en archivo.
         * <p>
         * Serializa la lista actual de productos y los guarda en el archivo especificado.
         * </p>
         *
         * @param event Evento de acción del botón Guardar
         */
        @FXML
        void pressGuardar(ActionEvent event) {
            Alert a = new Alert(AlertType.INFORMATION);
            String mensaje = crud.serializar(crud.read(), PATH, NOMBRE_ARCHIVO);
            a.setContentText(mensaje);
            a.show();
        }

        /**
         * Maneja el evento de cargar productos desde archivo.
         * <p>
         * Deserializa los productos desde el archivo y los carga en la tabla.
         * </p>
         *
         * @param event Evento de acción del botón Cargar
         */
        @FXML
        void pressCargar(ActionEvent event) {
            Alert a = new Alert(AlertType.INFORMATION);
            try {
                Producto[] productosCargados = crud.deserializar(PATH, NOMBRE_ARCHIVO);
                if (productosCargados != null) {
                    crud.setProductos(productosCargados);
                    productos.clear();
                    
                    for (Producto p : crud.read()) {
                        if (p != null) {
                            productos.add(p);
                        }
                    }
                    
                    loadTable();
                    actualizarContador();
                    a.setContentText("Archivo cargado exitosamente");
                } else {
                    a.setAlertType(AlertType.WARNING);
                    a.setContentText("No se encontró el archivo");
                }
            } catch (Exception e) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Error al cargar archivo: " + e.getMessage());
            }
            a.show();
        }

        /**
         * Maneja el evento de actualizar un producto existente.
         * <p>
         * Toma el producto seleccionado en la tabla y actualiza sus datos
         * con la información de los campos del formulario.
         * </p>
         *
         * @param event Evento de acción del botón Actualizar
         */
        @FXML
        void pressActualizar(ActionEvent event) {
            Alert a = new Alert(AlertType.CONFIRMATION);
            try {
                Producto oldProducto = tblView.getSelectionModel().getSelectedItem();

                if (oldProducto == null) {
                    throw new Exception("Debe seleccionar un producto de la tabla");
                }

                RadioButton rbaux = (RadioButton) categoria.getSelectedToggle();
                if (rbaux == null) {
                    throw new Exception("Debe seleccionar una categoría");
                }

                String id = oldProducto.getId();
                String nombre = txtNombre.getText();
                double peso = Double.parseDouble(txtPeso.getText());
                double volumen = Double.parseDouble(txtVolumen.getText());

                Producto productoActualizado = null;

                if (rbaux == rbAlimento) {
                    productoActualizado = new Alimento(id, nombre, peso, volumen,
                        txtFechaCaducidad.getText(), txtTipoAlimento.getText(),
                        Integer.parseInt(txtCalorias.getText()));
                        
                } else if (rbaux == rbEquipoMedico) {
                    productoActualizado = new EquipoMedico(id, nombre, peso, volumen,
                        txtUsoEspecifico.getText(), chkEsterilizado.isSelected(),
                        txtFechaEsterilizacion.getText(), txtUdt.getText());
                        
                } else if (rbaux == rbHerramienta) {
                    productoActualizado = new Herramienta(id, nombre, peso, volumen,
                        txtFuncion.getText(), txtMaterial.getText(), chkRequiereEnergia.isSelected());
                        
                } else if (rbaux == rbEquipoComunicacion) {
                    productoActualizado = new EquipoComunicacion(id, nombre, peso, volumen,
                        txtTipoComunicacion.getText(), Double.parseDouble(txtRangoFrecuencia.getText()),
                        Integer.parseInt(txtPotencia.getText()));
                }

                if (productoActualizado != null) {
                    productos.set(productos.indexOf(oldProducto), productoActualizado);
                    a.setContentText(crud.update(oldProducto.getId(), productoActualizado));
                    loadTable();
                    actualizarContador();
                    clear();
                }

            } catch (Exception e) {
                a.setAlertType(AlertType.WARNING);
                a.setContentText("Error: " + e.getMessage());
            }
            a.show();
        }
        
        /**
         * Maneja el evento de eliminar un producto.
         * <p>
         * Solicita confirmación al usuario y elimina el producto seleccionado
         * tanto de la lista como del servicio CRUD.
         * </p>
         *
         * @param event Evento de acción del botón Eliminar
         */
        @FXML
        void pressEliminar(ActionEvent event) {
            Alert a = new Alert(AlertType.CONFIRMATION);
            try {
                a.setContentText("¿Desea eliminar el producto seleccionado?");
                Optional<ButtonType> result = a.showAndWait();
                
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    Producto p = tblView.getSelectionModel().getSelectedItem();
                    
                    if (p == null) {
                        throw new Exception("Debe seleccionar un producto");
                    }
                    
                    crud.delete(p.getId());
                    productos.remove(p);
                    loadTable();
                    actualizarContador();
                    clear();
                    
                    a = new Alert(AlertType.INFORMATION);
                    a.setContentText("Producto eliminado exitosamente");
                    a.show();
                }
            } catch (Exception e) {
                a = new Alert(AlertType.WARNING);
                a.setContentText("Error: " + e.getMessage());
                a.show();
            }
        }
        
        /**
         * Maneja el evento de limpiar el formulario.
         * <p>
         * Limpia todos los campos de entrada y restablece los valores por defecto.
         * </p>
         *
         * @param event Evento de acción del botón Limpiar
         */
        @FXML
        void pressLimpiar(ActionEvent event) {
            clear();
        }

        /**
         * Carga y configura los datos en la tabla.
         * <p>
         * Establece los cell value factories para cada columna y asigna los datos
         * a la tabla según el tipo específico de producto.
         * </p>
         */
        void loadTable() {
            columnId.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getId()));
            columnNombre.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombre()));
            columnPeso.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getPeso())));
            columnVolumen.setCellValueFactory(cell -> new SimpleStringProperty(String.valueOf(cell.getValue().getVolumen())));
            
            columnCategoria.setCellValueFactory(cell -> {
                if (cell.getValue() instanceof Alimento) return new SimpleStringProperty("Alimento");
                if (cell.getValue() instanceof EquipoMedico) return new SimpleStringProperty("Equipo Médico");
                if (cell.getValue() instanceof Herramienta) return new SimpleStringProperty("Herramienta");
                if (cell.getValue() instanceof EquipoComunicacion) return new SimpleStringProperty("Equipo Comunicación");
                return new SimpleStringProperty("");
            });
            
            columnDetalle1.setCellValueFactory(cell -> {
                if (cell.getValue() instanceof Alimento) {
                    return new SimpleStringProperty(((Alimento) cell.getValue()).getTipoAlimento());
                } else if (cell.getValue() instanceof EquipoMedico) {
                    return new SimpleStringProperty(((EquipoMedico) cell.getValue()).getUsoEspecifico());
                } else if (cell.getValue() instanceof Herramienta) {
                    return new SimpleStringProperty(((Herramienta) cell.getValue()).getFuncion());
                } else if (cell.getValue() instanceof EquipoComunicacion) {
                    return new SimpleStringProperty(((EquipoComunicacion) cell.getValue()).getTipoComunicacion());
                }
                return new SimpleStringProperty("-");
            });
            
            columnDetalle2.setCellValueFactory(cell -> {
                if (cell.getValue() instanceof Alimento) {
                    return new SimpleStringProperty(((Alimento) cell.getValue()).getFechaCaducidad());
                } else if (cell.getValue() instanceof EquipoMedico) {
                    return new SimpleStringProperty(((EquipoMedico) cell.getValue()).isEsEsterilizado() ? "Sí" : "No");
                } else if (cell.getValue() instanceof Herramienta) {
                    return new SimpleStringProperty(((Herramienta) cell.getValue()).getMaterial());
                } else if (cell.getValue() instanceof EquipoComunicacion) {
                    return new SimpleStringProperty(String.valueOf(((EquipoComunicacion) cell.getValue()).getRangoFrecuencia()));
                }
                return new SimpleStringProperty("-");
            });
            
            columnDetalle3.setCellValueFactory(cell -> {
                if (cell.getValue() instanceof Alimento) {
                    return new SimpleStringProperty(String.valueOf(((Alimento) cell.getValue()).getCaloriasPorRacion()) + " cal");
                } else if (cell.getValue() instanceof EquipoMedico) {
                    return new SimpleStringProperty(((EquipoMedico) cell.getValue()).getUdt());
                } else if (cell.getValue() instanceof Herramienta) {
                    return new SimpleStringProperty(((Herramienta) cell.getValue()).isRequiereEnergia() ? "Sí" : "No");
                } else if (cell.getValue() instanceof EquipoComunicacion) {
                    return new SimpleStringProperty(String.valueOf(((EquipoComunicacion) cell.getValue()).getPotencia()) + " W");
                }
                return new SimpleStringProperty("-");
            });
            
            tblView.setItems(productos);
        }

        /**
         * Limpia todos los campos del formulario.
         * <p>
         * Restablece todos los campos de texto, selecciones de combobox
         * y configuraciones de checkboxes a sus valores por defecto.
         * </p>
         */
        void clear() {
            txtId.clear();
            txtNombre.clear();
            txtPeso.clear();
            txtVolumen.clear();
            cmbTipoProducto.setValue(null);
            
            txtFechaCaducidad.clear();
            txtTipoAlimento.clear();
            txtCalorias.clear();
            
            txtUsoEspecifico.clear();
            txtFechaEsterilizacion.clear();
            txtUdt.clear();
            chkEsterilizado.setSelected(false);
            
            txtFuncion.clear();
            txtMaterial.clear();
            chkRequiereEnergia.setSelected(false);
            
            txtTipoComunicacion.clear();
            txtRangoFrecuencia.clear();
            txtPotencia.clear();
            
            rbAlimento.setSelected(true);
        }
        
        /**
         * Valida los campos básicos del formulario.
         * <p>
         * Verifica que los campos obligatorios (ID, Nombre, Peso, Volumen)
         * no estén vacíos.
         * </p>
         *
         * @return {@code true} si todos los campos básicos están completos,
         *         {@code false} en caso contrario
         */
        private boolean validarCamposBasicos() {
            return txtId.getText() != null && !txtId.getText().isEmpty() &&
                   txtNombre.getText() != null && !txtNombre.getText().isEmpty() &&
                   txtPeso.getText() != null && !txtPeso.getText().isEmpty() &&
                   txtVolumen.getText() != null && !txtVolumen.getText().isEmpty();
        }
        
        /**
         * Maneja el evento de selección en la tabla.
         * <p>
         * Cuando se selecciona un producto en la tabla, carga sus datos
         * en los campos correspondientes del formulario.
         * </p>
         *
         * @param event Evento de clic del mouse en la tabla
         */
        @FXML
        void displaySelected(MouseEvent event) {
            try {
                Producto producto = tblView.getSelectionModel().getSelectedItem();

                if (producto == null) return;

                txtId.setText(producto.getId());
                txtNombre.setText(producto.getNombre());
                txtPeso.setText(String.valueOf(producto.getPeso()));
                txtVolumen.setText(String.valueOf(producto.getVolumen()));

                if (producto instanceof Alimento) {
                    categoria.selectToggle(rbAlimento);
                    Alimento alimento = (Alimento) producto;
                    txtFechaCaducidad.setText(alimento.getFechaCaducidad());
                    txtTipoAlimento.setText(alimento.getTipoAlimento());
                    txtCalorias.setText(String.valueOf(alimento.getCaloriasPorRacion()));
                    
                } else if (producto instanceof EquipoMedico) {
                    categoria.selectToggle(rbEquipoMedico);
                    EquipoMedico equipo = (EquipoMedico) producto;
                    txtUsoEspecifico.setText(equipo.getUsoEspecifico());
                    chkEsterilizado.setSelected(equipo.isEsEsterilizado());
                    txtFechaEsterilizacion.setText(equipo.getFechaEsterilizacion());
                    txtUdt.setText(equipo.getUdt());
                    
                } else if (producto instanceof Herramienta) {
                    categoria.selectToggle(rbHerramienta);
                    Herramienta herramienta = (Herramienta) producto;
                    txtFuncion.setText(herramienta.getFuncion());
                    txtMaterial.setText(herramienta.getMaterial());
                    chkRequiereEnergia.setSelected(herramienta.isRequiereEnergia());
                    
                } else if (producto instanceof EquipoComunicacion) {
                    categoria.selectToggle(rbEquipoComunicacion);
                    EquipoComunicacion equipoComun = (EquipoComunicacion) producto;
                    txtTipoComunicacion.setText(equipoComun.getTipoComunicacion());
                    txtRangoFrecuencia.setText(String.valueOf(equipoComun.getRangoFrecuencia()));
                    txtPotencia.setText(String.valueOf(equipoComun.getPotencia()));
                }

            } catch (Exception e) {
                Alert a = new Alert(AlertType.WARNING);
                a.setContentText("Error al cargar datos: " + e.getMessage());
                a.show();
            }
        }
    }