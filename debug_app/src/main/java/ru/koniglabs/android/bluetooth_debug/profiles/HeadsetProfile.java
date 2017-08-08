package ru.koniglabs.android.bluetooth_debug.profiles;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;

/**
 * Created by nikolay on 02.08.17.
 */

public class HeadsetProfile {
    private BluetoothHeadset mBluetoothHeadset;

    // Get the default adapter
    private BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    private BluetoothProfile.ServiceListener mProfileListener = new BluetoothProfile.ServiceListener() {
            public void onServiceConnected(int profile, BluetoothProfile proxy) {
                if (profile == BluetoothProfile.HEADSET) {
                    mBluetoothHeadset = (BluetoothHeadset) proxy;
                }
            }
            public void onServiceDisconnected(int profile) {
                if (profile == BluetoothProfile.HEADSET) {
                    mBluetoothHeadset = null;
                }
            }
        }
    ;

    public void connect(Context context) {
        // Establish connection to the proxy.
        mBluetoothAdapter.getProfileProxy(context, mProfileListener, BluetoothProfile.HEADSET);
    }

    public void disconnect() {
        // Close proxy connection after use.
        mBluetoothAdapter.closeProfileProxy(BluetoothProfile.HEADSET, mBluetoothHeadset);
    }

    public BluetoothHeadset getDevice() { return mBluetoothHeadset; }
}
