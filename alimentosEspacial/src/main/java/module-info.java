module co.edu.poli.alimentosEspacial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    
    opens co.edu.poli.alimentosEspacial.vista to javafx.graphics, javafx.fxml;
    opens co.edu.poli.alimentosEspacial.controlador to javafx.fxml;
    opens co.edu.poli.alimentosEspacial.modelo to javafx.base;
    
    exports co.edu.poli.alimentosEspacial.vista;
    exports co.edu.poli.alimentosEspacial.controlador;
    exports co.edu.poli.alimentosEspacial.modelo;
}
