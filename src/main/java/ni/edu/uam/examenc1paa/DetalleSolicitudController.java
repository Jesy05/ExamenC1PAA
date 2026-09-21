package ni.edu.uam.examenc1paa;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;

public class DetalleSolicitudController {

    @FXML
    private Label lblNumero;

    @FXML
    private Label lblCliente;

    @FXML
    private Label lblFecha;

    @FXML
    private Label lblTipo;

    @FXML
    private Label lblDescripcion;

    @FXML
    private ComboBox<String> cbEstado;

    @FXML
    private Button btnGuardar;

    private Solicitud solicitud;

    @FXML
    private void initialize() {
        solicitud = SolicitudService.getInstancia().getSolicitudSeleccionada();

        if (solicitud == null) {
            lblNumero.setText("N/A");
            lblCliente.setText("No seleccionada");
            lblFecha.setText("-");
            lblTipo.setText("-");
            lblDescripcion.setText("Seleccione una solicitud desde la lista para ver su detalle.");
            cbEstado.setPromptText("Sin selección");
            return;
        }

        cbEstado.getItems().addAll("Pendiente", "En proceso", "Resuelta", "Cancelada");

        lblNumero.setText(solicitud.getNumeroSolicitud());
        lblCliente.setText(solicitud.getCliente());
        lblFecha.setText(solicitud.getFecha());
        lblTipo.setText(solicitud.getTipoSolicitud());
        lblDescripcion.setText(solicitud.getDescripcion());
        cbEstado.setValue(solicitud.getEstado());
    }

    @FXML
    private void guardarEstado() {
        if (cbEstado.getValue() == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Seleccione un estado.");
            return;
        }
        SolicitudService.getInstancia().actualizarEstado(solicitud, cbEstado.getValue());
        mostrarAlerta(Alert.AlertType.INFORMATION, "Estado actualizado a " + cbEstado.getValue() + ".");
        volver();
    }

    @FXML
    private void volver() {
        try {
            HelloApplication.cambiarVista("lista-view.fxml");
        } catch (IOException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "No se pudo cargar la pantalla.");
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String mensaje) {
        if (!Platform.isFxApplicationThread()) {
            Platform.runLater(() -> mostrarAlerta(tipo, mensaje));
            return;
        }

        Alert alerta = new Alert(tipo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
}