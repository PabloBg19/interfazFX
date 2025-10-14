package org.example.interfazfx;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Button accederButton;
    @FXML
    private TextField userTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private ComboBox<String> cursoComboBox;

    @FXML
    public void initialize() {
        // Configura el evento del botón "ACCEDER"
        accederButton.setOnAction(event -> {
            // Validar si los campos están vacíos
            StringBuilder errorMessage = new StringBuilder();
            if (userTextField.getText().trim().isEmpty()) {
                errorMessage.append("El campo de usuario está vacío.\n");
            }
            if (passwordTextField.getText().trim().isEmpty()) {
                errorMessage.append("El campo de contraseña está vacío.\n");
            }
            if (cursoComboBox.getValue() == null) {
                errorMessage.append("Debes seleccionar un curso.\n");
            }

            // Mostrar ventana de error si hay campos vacíos
            if (!errorMessage.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error de Validación");
                alert.setHeaderText("Campos Requeridos");
                alert.setContentText(errorMessage.toString());
                alert.showAndWait();
            }
        });
    }
}