package com.reboot297.larsa;

import com.reboot297.larsa.command.GetListDevicesCommand;
import com.reboot297.larsa.model.Device;
import com.reboot297.larsa.ui.devices.DevicesListController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

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

    public void onListDevicesClick(ActionEvent actionEvent) {
        var command = new GetListDevicesCommand();
        var result = command.getResult(CommandUtils.runProcess(command));

        for (var device : result) {
            System.out.println(device.getId());
        }
        showDevices(result);
    }

    public void showDevices(List<Device> devices) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("devices-list.fxml"));
            Parent root1 = fxmlLoader.load();
            DevicesListController controller = fxmlLoader.getController();
            controller.initialize(devices);
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}