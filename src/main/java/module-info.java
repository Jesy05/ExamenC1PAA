module ni.edu.uam.examenc1paa {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.examenc1paa to javafx.fxml;
    exports ni.edu.uam.examenc1paa;
}