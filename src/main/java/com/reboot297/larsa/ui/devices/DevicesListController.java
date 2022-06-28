package com.reboot297.larsa.ui.devices;

import com.reboot297.larsa.model.Device;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class DevicesListController {

    @FXML
    private ListView<Device> devicesListView;

    private ObservableList<Device> observableList = FXCollections.observableArrayList();

    public void initialize(List<Device> devices){
        observableList.clear();
        observableList.addAll(devices);
        devicesListView.setItems(observableList);
        System.out.println(devicesListView);
    }

    @FXML
    public void handleMouseClick(MouseEvent arg0) {
        System.out.println("clicked on " + devicesListView.getSelectionModel().getSelectedItem().getModel());
    }
}
