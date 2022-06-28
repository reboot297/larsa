module com.reboot297.larsa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.reboot297.larsa to javafx.fxml;
    exports com.reboot297.larsa;
}