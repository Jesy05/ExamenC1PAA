package ni.edu.uam.examenc1paa;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class RegistroSolicitudController {

    @FXML
    private TextField txtNumero;

    @FXML
    private TextField txtCliente;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private ComboBox<String> cbTipo;

    @FXML
    private TextArea txtDescripcion;

    @FXML
    private ComboBox<String> cbEstado;

    @FXML
    private void initialize() {
        cbTipo.getItems().addAll("Soporte tecnico", "Mantenimiento", "Instalacion", "Consulta", "Reclamo");
        cbEstado.getItems().addAll("Pendiente", "En proceso", "Resuelta", "Cancelada");
        limpiarFormulario();
    }

    @FXML
    private void guardarSolicitud() {
        if (txtCliente.getText().isEmpty() || dpFecha.getValue() == null
                || cbTipo.getValue() == null || txtDescripcion.getText().isEmpty()
                || cbEstado.getValue() == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Complete todos los campos.");
            return;
        }

        String numero = SolicitudService.getInstancia().generarNumero();
        String cliente = txtCliente.getText().trim();
        String fecha = dpFecha.getValue().toString();
        String tipo = cbTipo.getValue();
        String descripcion = txtDescripcion.getText().trim();
        String estado = cbEstado.getValue();

        Solicitud solicitud = new Solicitud(numero, cliente, fecha, tipo, descripcion, estado);
        SolicitudService.getInstancia().registrar(solicitud);

        mostrarAlerta(Alert.AlertType.INFORMATION, "Solicitud " + numero + " guardada.");
        limpiarFormulario();
    }

    @FXML
    private void limpiarFormulario() {
        txtNumero.setText(SolicitudService.getInstancia().generarNumero());
        txtCliente.clear();
        dpFecha.setValue(null);
        cbTipo.setValue(null);
        cbEstado.setValue(null);
        txtDescripcion.clear();
    }

    @FXML
    private void verSolicitudes() throws IOException {
        HelloApplication.cambiarVista("lista-view.fxml");
    }

    @FXML
    private void volver() throws IOException {
        HelloApplication.cambiarVista("principal-view.fxml");
    }

    private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}