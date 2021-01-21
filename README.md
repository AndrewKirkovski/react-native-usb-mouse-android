# React Native Usb Mouse Event

[![npm version](https://badge.fury.io/js/react-native-keyevent.svg)](http://badge.fury.io/js/react-native-keyevent)

Capture external usb or bluetooth hardware mouse events like scroll and hover. Useful for RN applications that run on Chromebooks.

**Supports Android / Chromebooks only**

[Learn about Android MotionEvent here](https://developer.android.com/reference/android/view/MotionEvent).


### Installation

#### via npm

Run `npm install react-native-keyevent --save`

#### via yarn

Run `yarn add react-native-keyevent`

### Linking

No manual linking required on RN >=0.60 and module is not supporting React Native <= 0.59

### Configuration

#### Android

Implement onConfigurationChanged method in MainActivity.java

```
    import android.view.MotionEvent; // <--- import
    import com.github.andrewkirkovski.usbmouse.UsbMouseModule; // <--- import


    public class MainActivity extends ReactActivity {
      ......
      @Override
          public boolean onGenericMotionEvent(MotionEvent event) {
              if (event.getAction() == MotionEvent.ACTION_HOVER_MOVE) {
                  UsbMouseModule.getInstance().onMouseHover(event);
                  // return true; // <-- Uncomment to prevent default handler
              } else if (event.getAction() == MotionEvent.ACTION_SCROLL) {
                  UsbMouseModule.getInstance().onMouseScroll(event);
                  // return true; // <-- Uncomment to prevent default handler  
              }
              UsbMouseModule.getInstance().onGenericMotionEvent(event); // Comment out if you dont need all events
              // return true; // <-- Uncomment to prevent default handler
              return super.onGenericMotionEvent(event);
          }
    }
```

## Usage

Whenever you want to use it within React Native code now you can:

`import KeyEvent from 'react-native-keyevent';`

```javascript
  import * as UsbMouse from 'react-native-usb-mouse-android';
  
  useEffect(()=>{
    const listener = UsbMouse.onMouseScroll((event: GenericMotionEvent)=>{
        console.log('Mouse Scroll', event);
    });
    return listener.remove;
  }, []);
```

## TODOS

- [ ] iOS Support
- [ ] Automatic MainActivity configuration
