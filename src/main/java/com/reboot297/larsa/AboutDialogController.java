package com.reboot297.larsa;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AboutDialogController {

    @FXML
    Label appVersionLabel;

    public void initialize() {
        //TODO read the version from the build
        appVersionLabel.setText("0.1.0");
    }
}
