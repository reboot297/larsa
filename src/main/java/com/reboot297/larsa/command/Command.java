package com.reboot297.larsa.command;

import java.util.Arrays;
import java.util.List;

public abstract class Command<T> {

    private static final String[] WIN_RUNTIME = {"cmd.exe", "/C"};
    private static final String[] OS_LINUX_RUNTIME = {"/bin/bash", "-l", "-c"};

    protected abstract String getName();

    protected abstract String[] getParameters();

    public abstract List<T> getResult(List<String> terminalOutput);

    public String toString() {
        return getName() + " " + getParameters();
    }

    public String[] toStringArray() {

        var command = concat(new String[]{getName()}, getParameters());
        String[] prefix;
        if (isWindows()) {
            prefix = WIN_RUNTIME;
        } else {
            prefix = OS_LINUX_RUNTIME;
        }

        return concat(prefix, command);
    }

    private static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
    public static boolean isWindows() {
        return System.getProperty("os.name").startsWith("Windows");
    }
}
