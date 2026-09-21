package ni.edu.uam.examenc1paa;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class VistaSmokeTest {

    @Test
    void todasLasVistasCargan() throws Exception {
        new JFXPanel();
        Platform.setImplicitExit(false);

        String[] vistas = {
                "principal-view.fxml",
                "registro-view.fxml",
                "lista-view.fxml",
                "detalle-view.fxml"
        };

        for (String vista : vistas) {
            Object raiz = new FXMLLoader(getClass().getResource("/ni/edu/uam/examenc1paa/" + vista)).load();
            assertNotNull(raiz, "La vista no cargo: " + vista);
        }
    }
}