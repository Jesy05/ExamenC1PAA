package ni.edu.uam.examenc1paa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage ventana;

    @Override
    public void start(Stage stage) throws IOException {
        ventana = stage;
        cambiarVista("principal-view.fxml");
        stage.setTitle("Sistema de Gestion de Solicitudes");
        stage.setOnCloseRequest(e -> stage.close());
        stage.show();
    }

    public static void cambiarVista(String nombreVista) throws IOException {
        FXMLLoader cargador = new FXMLLoader(HelloApplication.class.getResource(nombreVista));
        Scene escena = new Scene(cargador.load(), 620, 520);
        ventana.setScene(escena);
        ventana.centerOnScreen();
    }

    public static void main(String[] args) {
        launch(args);
    }
}