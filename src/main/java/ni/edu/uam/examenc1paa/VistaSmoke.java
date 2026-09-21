package ni.edu.uam.examenc1paa;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class VistaSmoke extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        String[] vistas = {
                "principal-view.fxml",
                "registro-view.fxml",
                "lista-view.fxml",
                "detalle-view.fxml"
        };
        boolean todasOk = true;
        for (String vista : vistas) {
            try {
                Parent raiz = FXMLLoader.load(getClass().getResource(vista));
                System.out.println("SMOKE_OK: " + vista + " -> " + raiz.getClass().getSimpleName());
            } catch (Throwable t) {
                todasOk = false;
                System.out.println("SMOKE_ERROR: " + vista + " -> " + t);
            }
        }
        System.out.println(todasOk ? "SMOKE_RESULT_OK" : "SMOKE_RESULT_FAIL");
        Platform.exit();
    }
}