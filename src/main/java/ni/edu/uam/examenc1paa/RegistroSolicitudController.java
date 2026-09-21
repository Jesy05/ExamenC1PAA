package ni.edu.uam.examenc1paa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ni.edu.uam.examenc1paa.Solicitud;


import java.net.URL;
import java.util.ResourceBundle;


    public class RegistroSolicitudController implements Initializable {

        @FXML private TextField txtNumeroSolicitud;
        @FXML private TextField txtCliente;
        @FXML private DatePicker dpFecha;
        @FXML private ComboBox<String> cbTipoSolicitud;
        @FXML private TextArea txtDescripcion;
        @FXML private ComboBox<String> cbEstado;

        @FXML private TableView<Solicitud> tablaSolicitudes;
        @FXML private TableColumn<Solicitud, String> colNumero;
        @FXML private TableColumn<Solicitud, String> colCliente;
        @FXML private TableColumn<Solicitud, String> colEstado;

        private ObservableList<Solicitud> listaSolicitudes;

        @Override
        public void initialize(URL location, ResourceBundle resources) {
            listaSolicitudes = FXCollections.observableArrayList();
            tablaSolicitudes.setItems(listaSolicitudes);

            colNumero.setCellValueFactory(new PropertyValueFactory<>("numeroSolicitud"));
            colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
            colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

            cbTipoSolicitud.getItems().addAll("Mantenimiento", "Instalación", "Soporte");
            cbEstado.getItems().addAll("Pendiente", "En Proceso", "Completado");
        }

        @FXML
        public void guardarSolicitud(ActionEvent event) {
            String numero = txtNumeroSolicitud.getText();
            String cliente = txtCliente.getText();
            String fecha = (dpFecha.getValue() != null) ? dpFecha.getValue().toString() : "";
            String tipo = cbTipoSolicitud.getValue();
            String descripcion = txtDescripcion.getText();
            String estado = cbEstado.getValue();

            Solicitud nuevaSolicitud = new Solicitud(numero, cliente, fecha, tipo, descripcion, estado);
            listaSolicitudes.add(nuevaSolicitud);

            limpiarFormulario();
        }

        private void limpiarFormulario() {
            txtNumeroSolicitud.clear();
            txtCliente.clear();
            dpFecha.setValue(null);
            cbTipoSolicitud.setValue(null);
            txtDescripcion.clear();
            cbEstado.setValue(null);
        }
    }

