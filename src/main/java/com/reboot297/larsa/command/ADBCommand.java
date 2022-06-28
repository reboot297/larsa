package com.reboot297.larsa.command;

public abstract class ADBCommand<T> extends Command<T> {
    @Override
    protected String getName() {
        return "adb";
    }
}
