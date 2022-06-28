package com.reboot297.larsa;

import com.reboot297.larsa.command.Command;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommandUtils {
    private CommandUtils() {
    }

    public static List<String> runProcess(Command command) {
        System.out.print("command to run: ");
        System.out.print(command.toString());
        System.out.print("\n");
        try {
            var processBuilder = new ProcessBuilder(command.toStringArray());
            processBuilder.redirectErrorStream(true);
            var process = processBuilder.start();
            process.waitFor();
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String _temp;
            List<String> line = new ArrayList<>();
            while ((_temp = in.readLine()) != null) {
                line.add(_temp);
            }
            return line;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
