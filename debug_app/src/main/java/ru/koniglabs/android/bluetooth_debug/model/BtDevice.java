package ru.koniglabs.android.bluetooth_debug.model;

/**
 * Created by nikolay on 08.08.17.
 */

public class BtDevice {
    public final String name;
    public final String mac;

    public BtDevice(String name, String mac) {
        this.name = name;
        this.mac = mac;
    }

    @Override
    public String toString() {
        return name;
    }
}
