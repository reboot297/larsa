module com.reboot297.elam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.reboot297.elam to javafx.fxml;
    exports com.reboot297.elam;
}