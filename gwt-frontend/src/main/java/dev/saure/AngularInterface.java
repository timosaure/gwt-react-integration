package dev.saure;

import com.google.gwt.user.client.Window;
import jsinterop.annotations.JsType;

@JsType
public class AngularInterface {

    public String _title;

    public AngularInterface(String title) {
        this._title = title;
    }

    public String title() {
        return _title;
    }

    public void alertGwt(String text) {
        Window.alert(text);
    }
}