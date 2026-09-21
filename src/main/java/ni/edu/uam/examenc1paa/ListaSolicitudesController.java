package ni.edu.uam.examenc1paa;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class ListaSolicitudesController {

    @FXML
    private TextField txtBuscar;

    @FXML
    private TableView<Solicitud> tablaSolicitudes;

    @FXML
    private TableColumn<Solicitud, String> colNumero;

    @FXML
    private TableColumn<Solicitud, String> colCliente;

    @FXML
    private TableColumn<Solicitud, String> colFecha;

    @FXML
    private TableColumn<Solicitud, String> colTipo;

    @FXML
    private TableColumn<Solicitud, String> colEstado;

    @FXML
    private Button btnActualizar;

    @FXML
    private void initialize() {
        colNumero.setCellValueFactory(new PropertyValueFactory<>("numeroSolicitud"));
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoSolicitud"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        ObservableList<Solicitud> lista = SolicitudService.getInstancia().getSolicitudes();
        FilteredList<Solicitud> filtrada = new FilteredList<>(lista, s -> true);

        txtBuscar.textProperty().addListener((obs, antes, ahora) ->
                filtrada.setPredicate(s -> s.getCliente().toLowerCase().contains(ahora.toLowerCase())
                        || s.getNumeroSolicitud().toLowerCase().contains(ahora.toLowerCase())));

        tablaSolicitudes.setItems(filtrada);
    }

    @FXML
    private void cambiarEstado() throws IOException {
        Solicitud seleccionada = tablaSolicitudes.getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Seleccione una solicitud.");
            return;
        }
        SolicitudService.getInstancia().setSolicitudSeleccionada(seleccionada);
        HelloApplication.cambiarVista("detalle-view.fxml");
    }

    @FXML
    private void eliminarSolicitud() {
        Solicitud seleccionada = tablaSolicitudes.getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Seleccione una solicitud.");
            return;
        }
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setHeaderText(null);
        alerta.setContentText("Desea eliminar la solicitud " + seleccionada.getNumeroSolicitud() + "?");
        if (alerta.showAndWait().get() == ButtonType.OK) {
            SolicitudService.getInstancia().eliminar(seleccionada);
        }
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