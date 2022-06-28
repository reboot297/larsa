package com.reboot297.larsa.command;

import com.reboot297.larsa.model.Device;

import java.util.LinkedList;
import java.util.List;

public class GetListDevicesCommand extends ADBCommand<Device> {
    @Override
    protected String[] getParameters() {
        return new String[] {"devices", "-l"};
    }

    @Override
    public List<Device> getResult(List<String> terminalOutput) {
        System.out.println("Output:" + terminalOutput);
        var resultPrefix = "List of devices attached";
        var devices = new LinkedList<Device>();
        for (var str : terminalOutput) {
            if (str.isBlank() || str.contains(resultPrefix)) {
                continue;
            }

            var item = str.split(" ");
            var id = item[0].trim();
            String model = "";
            for (var chunk: item) {
                if (chunk.contains(":")) {
                    var parameter = chunk.split(":");
                    if (parameter[0].equals("model")){
                        model = parameter[1];
                    }
                }
            }
            devices.add(new Device(id, model));
        }

        return devices;
    }


}
