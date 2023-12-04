package dev.saure;

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "AngularComponent")
public class AngularComponent {


    public static native Promise<AngularComponent> create(Element element, AngularInterface api);

    public native void destroy();


}
