package th.co.nextcorp.thaibraille;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Set;

import th.co.nextcorp.thaibraille.ble.BleManager;
import th.co.nextcorp.thaibraille.ble.BleUtils;

/**
 * Created by May on 11/28/2017.
 */

public class BrailleService extends AccessibilityService implements BleManager.BleManagerListener {
    private final AccessibilityServiceInfo info = new AccessibilityServiceInfo();
    private boolean bleConnnected = false;

    // Log
    public final static String TAG = "Test";
    private static final String kGenericAttributeService = "00001801-0000-1000-8000-00805F9B34FB";
    private static final String kServiceChangedCharacteristic = "00002A05-0000-1000-8000-00805F9B34FB";
    // Service Constants
    public static final String UUID_SERVICE = "6e400001-b5a3-f393-e0a9-e50e24dcca9e";
    public static final String UUID_RX = "6e400003-b5a3-f393-e0a9-e50e24dcca9e";
    public static final String UUID_TX = "6e400002-b5a3-f393-e0a9-e50e24dcca9e";
    //public static final String UUID_DFU = "00001530-1212-EFDE-1523-785FEABCD123";
    public static final int kTxMaxCharacters = 20;

    // Data
    public BleManager mBleManager;
    public BluetoothGattService mUartService;
    public boolean isRxNotificationEnabled;

    private void BLEConnect() {
        BluetoothAdapter bluetoothAdapter = BleUtils.getBluetoothAdapter(getApplicationContext());
        //BleUtils.getBluetoothAdapter()
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        for (BluetoothDevice bt : pairedDevices) {
            //Log.d("AddressDevicexx", bt.getAddress());
            Log.d("nameDevicexx", bt.getName());
            String thai = "Thai braille";
            if (thai.contains(bt.getName())) {
                Log.d("MainFragment", "Thai braille");
                Log.d("AddressDevicexx", bt.getAddress());
                Log.d("nameDevicexx", bt.getName());
                //  mComponentToStartWhenConnected = UartActivity.class;
                //
                connect(bt);
                break;

            }
        }
    }

    private void connect(BluetoothDevice device) {
        mBleManager = BleManager.getInstance(this);
        mUartService = mBleManager.getGattService(UUID_SERVICE);
        boolean isConnecting = mBleManager.connect(this, device.getAddress());
        //mBleManager.setConnectedDevice(device);
        mBleManager.getConnectedDevice();

        if (isConnecting) {
            onServicesDiscovered();
            enableRxNotifications();
            bleConnnected = true;
        }
    }


    @Override
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {

        if (!this.bleConnnected) {
            this.BLEConnect();
        } else {
            String data = accessibilityEvent.getText().toString();
            if (data != "[]") {
                String newStr = data.substring(1, data.length() - 1);
                sendData(newStr); // Send Data
            }

        }
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    public void onServiceConnected() {
        // Set the type of events that this service wants to listen to.
        //Others won't be passed to this service.
        info.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        info.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        info.notificationTimeout = 100;

        this.setServiceInfo(info);
    }

    /**
     * Check if Accessibility Service is enabled.
     *
     * @param mContext
     * @return <code>true</code> if Accessibility Service is ON, otherwise <code>false</code>
     */
//    public static boolean isAccessibilitySettingsOn(Context mContext) {
//        int accessibilityEnabled = 0;
//        //your package /   accesibility service path/class
//        final String service = "com.accessibilityexample/com.accessibilityexample.Service.MyAccessibilityService";
//
//        boolean accessibilityFound = false;
//        try {
//            accessibilityEnabled = Settings.Secure.getInt(
//                    mContext.getApplicationContext().getContentResolver(),
//                    android.provider.Settings.Secure.ACCESSIBILITY_ENABLED);
//            Log.v(TAG, "accessibilityEnabled = " + accessibilityEnabled);
//        } catch (Settings.SettingNotFoundException e) {
//            Log.e(TAG, "Error finding setting, default accessibility to not found: "
//                    + e.getMessage());
//        }
//        TextUtils.SimpleStringSplitter mStringColonSplitter = new TextUtils.SimpleStringSplitter(':');
//
//        if (accessibilityEnabled == 1) {
//            Log.v(TAG, "***ACCESSIBILIY IS ENABLED*** -----------------");
//            String settingValue = Settings.Secure.getString(
//                    mContext.getApplicationContext().getContentResolver(),
//                    Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES);
//            if (settingValue != null) {
//                TextUtils.SimpleStringSplitter splitter = mStringColonSplitter;
//                splitter.setString(settingValue);
//                while (splitter.hasNext()) {
//                    String accessabilityService = splitter.next();
//
//                    Log.v(TAG, "-------------- > accessabilityService :: " + accessabilityService);
//                    if (accessabilityService.equalsIgnoreCase(service)) {
//                        Log.v(TAG, "We've found the correct setting - accessibility is switched on!");
//                        return true;
//                    }
//                }
//            }
//        } else {
//            Log.v(TAG, "***ACCESSIBILIY IS DISABLED***");
//        }
//
//        return accessibilityFound;
//    }

    //***************************************************************************

    // region Send Data to UART
    public void sendData(String text) {
        Braille braille = new Braille();
        final char[] value = text.toCharArray();
        byte[] data = new byte[value.length];
        for (int i = 0; i < value.length; i++) {
            if ((int) value[i] > 0xA0) {
                data[i] = braille.list.get(value[i] - 0xD60);
            } else {
                data[i] = braille.list.get(value[i]);
            }
        }
        Log.d("map", Arrays.toString(data));
        if (mUartService != null) {
            mBleManager.writeService(mUartService, UUID_TX, data);
        } else {
            Log.w(TAG, "Uart Service not discovered. Unable to send data");
        }
    }

//    public void sendData(byte[] data) {
//
//    }

    // Send data to UART and add a byte with a custom CRC
//    public void sendDataWithCRC(byte[] data) {
//
//        // Calculate checksum
//        byte checksum = 0;
//        for (byte aData : data) {
//            checksum += aData;
//        }
//        checksum = (byte) (~checksum);       // Invert
//
//        // Add crc to data
//        byte dataCrc[] = new byte[data.length + 1];
//        System.arraycopy(data, 0, dataCrc, 0, data.length);
//        dataCrc[data.length] = checksum;
//
//        // Send it
//        Log.d(TAG, "Send to UART: " + BleUtils.bytesToHexWithSpaces(dataCrc));
//        sendData(dataCrc);
//    }
    // endregion

    // region SendDataWithCompletionHandler
    public interface SendDataCompletionHandler {
        void sendDataResponse(String data);
    }

    final private Handler sendDataTimeoutHandler = new Handler();
    private Runnable sendDataRunnable = null;
    private SendDataCompletionHandler sendDataCompletionHandler = null;

//    public void sendData(byte[] data, SendDataCompletionHandler completionHandler) {
//
//        if (completionHandler == null) {
//            sendData(data);
//            return;
//        }
//
//        if (!isRxNotificationEnabled) {
//            Log.w(TAG, "sendData warning: RX notification not enabled. completionHandler will not be executed");
//        }
//
//        if (sendDataRunnable != null || sendDataCompletionHandler != null) {
//            Log.d(TAG, "sendData error: waiting for a previous response");
//            return;
//        }
//
//        Log.d(TAG, "sendData");
//        sendDataCompletionHandler = completionHandler;
//        sendDataRunnable = new Runnable() {
//            @Override
//            public void run() {
//                Log.d(TAG, "sendData timeout");
//                final SendDataCompletionHandler dataCompletionHandler = sendDataCompletionHandler;
//
//                sendDataRunnable = null;
//                sendDataCompletionHandler = null;
//
//                dataCompletionHandler.sendDataResponse(null);
//            }
//        };
//
//        sendDataTimeoutHandler.postDelayed(sendDataRunnable, 2 * 1000);
//        sendData(data);
//
//    }

//    public boolean isWaitingForSendDataResponse() {
//        return sendDataRunnable != null;
//    }

    // endregion

    // region BleManagerListener  (used to implement sendData with completionHandler)

    @Override
    public void onConnected() {

    }

    @Override
    public void onConnecting() {

    }

    @Override
    public void onDisconnected() {

    }

    @Override
    public void onServicesDiscovered() {
        while (null == mBleManager.getGattService(UUID_SERVICE)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mUartService = mBleManager.getGattService(UUID_SERVICE);

    }

    public void enableRxNotifications() {
        isRxNotificationEnabled = true;
        mBleManager.enableNotification(mUartService, UUID_RX, true);
    }

    @Override
    public void onDataAvailable(BluetoothGattCharacteristic characteristic) {
        // Check if there is a pending sendDataRunnable
        if (sendDataRunnable != null) {
            if (characteristic.getService().getUuid().toString().equalsIgnoreCase(UUID_SERVICE)) {
                if (characteristic.getUuid().toString().equalsIgnoreCase(UUID_RX)) {

                    Log.d(TAG, "sendData received data");
                    sendDataTimeoutHandler.removeCallbacks(sendDataRunnable);
                    sendDataRunnable = null;

                    if (sendDataCompletionHandler != null) {
                        final byte[] bytes = characteristic.getValue();
                        final String data = new String(bytes, Charset.forName("UTF-8"));

                        final SendDataCompletionHandler dataCompletionHandler = sendDataCompletionHandler;
                        sendDataCompletionHandler = null;
                        dataCompletionHandler.sendDataResponse(data);
                    }
                }
            }
        }
    }

    @Override
    public void onDataAvailable(BluetoothGattDescriptor descriptor) {

    }

    @Override
    public void onReadRemoteRssi(int rssi) {

    }


}

