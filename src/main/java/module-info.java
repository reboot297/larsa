module com.reboot297.larsa {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.reboot297.larsa to javafx.fxml;
    exports com.reboot297.larsa;
    exports com.reboot297.larsa.command;
    opens com.reboot297.larsa.command to javafx.fxml;
    exports com.reboot297.larsa.ui.about;
    opens com.reboot297.larsa.ui.about to javafx.fxml;
    exports com.reboot297.larsa.ui.devices;
    opens com.reboot297.larsa.ui.devices to javafx.fxml;
}