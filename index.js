import {DeviceEventEmitter, Platform} from 'react-native';


export function onMouseScroll(cb) {
    if (Platform.OS === "android") {
        return DeviceEventEmitter.addListener('onMouseScroll', cb);
    } else {
        console.warn('onMouseScroll supported only on Android')
    }
}

export function onMouseHover(cb) {
    if (Platform.OS === "android") {
        return DeviceEventEmitter.addListener('onMouseHover', cb);
    } else {
        console.warn('onMouseHover supported only on Android')
    }
}

export function onGenericMotionEvent(cb) {
    if (Platform.OS === "android") {
        return DeviceEventEmitter.addListener('onGenericMotionEvent', cb);
    } else {
        console.warn('onGenericMotionEvent supported only on Android')
    }
}
