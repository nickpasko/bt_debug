package ru.koniglabs.android.bluetooth_debug.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BtDevicesContent {
    private static final List<BtDevice> devices = new ArrayList<>();
    private static final Map<String, BtDevice> device_map = new HashMap<>();
    private static int COUNT = 0;

    public static List<BtDevice> getDevices() { return devices; }

    public static void addDevice(BtDevice device) {
        devices.add(device);
        device_map.put(device.uuid, device);
    }

    public static void addDevice(String uuids, String name, String deviceHardwareAddress) {
        addDevice(new BtDevice(uuids, name, deviceHardwareAddress));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Device details: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static BtDevice getDeviceById(String uuid) {
        return device_map.get(uuid);
    }

    public static void addAll(List<BtDevice> newDevices) {
        for (BtDevice device : newDevices)
            addDevice(device);
    }
    public static void set(List<BtDevice> newDevices) {
        clear();
        addAll(newDevices);
    }

    private static void clear() {
        devices.clear();
        device_map.clear();
    }
}
