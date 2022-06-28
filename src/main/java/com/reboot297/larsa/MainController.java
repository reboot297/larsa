package com.reboot297.larsa;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    private Parent dialogPane;
    private Stage aboutDialog;

    public void initialize() throws IOException {
        dialogPane = FXMLLoader.load(getClass().getResource("about-dialog.fxml"));
    }

    private Stage getDialog() {
        if (aboutDialog == null) {
            Scene scene = new Scene(dialogPane);
            aboutDialog = new Stage();
            aboutDialog.setScene(scene);
            aboutDialog.setTitle("About...");
        }
        return aboutDialog;
    }

    public void onHelpAboutClick(ActionEvent actionEvent) {
        getDialog().show();
    }
}