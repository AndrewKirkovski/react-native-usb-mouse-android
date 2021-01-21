declare module 'react-native-usb-mouse-android';

export type GenericMotionEvent = { action: number; keyCode: number; pressedKey: string; characters: string };

export type MouseScrollListener = (event: GenericMotionEvent) => void;
export type MouseHoverListener = (event: GenericMotionEvent) => void;
export type GenericMotionEventListener = (event: GenericMotionEvent) => void;

export function onMouseScroll(cb: MouseScrollListener): { remove: ()=>void };
export function onMouseHover(cb: MouseHoverListener): { remove: ()=>void };
export function onGenericMotionEvent(cb: GenericMotionEventListener): { remove: ()=>void };
