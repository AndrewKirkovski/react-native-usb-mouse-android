package com.github.andrewkirkovski.usbmouse;


import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.WritableMap;

import android.view.MotionEvent;

import static android.view.MotionEvent.AXIS_HSCROLL;
import static android.view.MotionEvent.AXIS_VSCROLL;

/**
 * Created by Andrew Kirkovski 21 Jan 2021.
 */
public class UsbMouseModule extends ReactContextBaseJavaModule {
    private ReactContext mReactContext;
    private DeviceEventManagerModule.RCTDeviceEventEmitter mJSModule = null;

    private static UsbMouseModule instance = null;

    public static UsbMouseModule initUsbMouseModule(ReactApplicationContext reactContext) {
        instance = new UsbMouseModule(reactContext);
        return instance;
    }

    public static UsbMouseModule getInstance() {
        return instance;
    }

    public void onMouseScroll(MotionEvent event) {
        if (!mReactContext.hasActiveCatalystInstance()) {
            return;
        }

        if (mJSModule == null) {
            mJSModule = mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        }
        mJSModule.emit("onMouseScroll", getJsEventParams(event));
    }

    public void onMouseHover(MotionEvent event) {
        if (!mReactContext.hasActiveCatalystInstance()) {
            return;
        }

        if (mJSModule == null) {
            mJSModule = mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        }
        mJSModule.emit("onMouseHover", getJsEventParams(event));
    }

    public void onGenericMotionEvent(MotionEvent event) {
        if (!mReactContext.hasActiveCatalystInstance()) {
            return;
        }

        if (mJSModule == null) {
            mJSModule = mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        }
        mJSModule.emit("onGenericMotionEvent", getJsEventParams(event));
    };

    protected UsbMouseModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mReactContext = reactContext;
    }

    private WritableMap getJsEventParams(MotionEvent event) {
        WritableMap params = new WritableNativeMap();
        int action = event.getAction();
        float scrollY = event.getAxisValue(AXIS_VSCROLL);
        float scrollX = event.getAxisValue(AXIS_HSCROLL);
        float x = event.getX();
        float y = event.getY();

        params.putDouble("x", x);
        params.putDouble("y", y);
        params.putDouble("scrollY", scrollY);
        params.putDouble("scrollX", scrollX);
        params.putInt("action", action);

        return params;
    }

    @Override
    public String getName() {
        return "UsbMouseModule";
    }
}
