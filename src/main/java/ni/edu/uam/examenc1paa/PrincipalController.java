package ni.edu.uam.examenc1paa;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class PrincipalController {

    @FXML
    private Label lblTotal;

    @FXML
    private Label lblPendientes;

    @FXML
    private Button btnRegistrar;

    @FXML
    private Button btnConsultar;

    @FXML
    private void initialize() {
        int total = SolicitudService.getInstancia().getSolicitudes().size();
        int pendientes = 0;
        for (Solicitud s : SolicitudService.getInstancia().getSolicitudes()) {
            if (s.getEstado().equals("Pendiente")) {
                pendientes++;
            }
        }
        lblTotal.setText("Solicitudes registradas: " + total);
        lblPendientes.setText("Solicitudes pendientes: " + pendientes);
    }

    @FXML
    private void abrirRegistro() throws IOException {
        HelloApplication.cambiarVista("registro-view.fxml");
    }

    @FXML
    private void abrirConsultas() throws IOException {
        HelloApplication.cambiarVista("lista-view.fxml");
    }

    @FXML
    private void salir() {
        Stage stage = (Stage) btnRegistrar.getScene().getWindow();
        stage.close();
    }
}