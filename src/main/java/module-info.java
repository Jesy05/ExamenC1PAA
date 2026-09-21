module ni.edu.uam.examenc1paa {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens ni.edu.uam.examenc1paa to javafx.fxml;
    exports ni.edu.uam.examenc1paa;
}