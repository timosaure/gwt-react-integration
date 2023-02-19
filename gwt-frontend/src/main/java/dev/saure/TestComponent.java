package dev.saure;

import com.google.gwt.dom.client.Element;
import jsinterop.annotations.JsFunction;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * GWT class that exposes the component from the react-frontend library using <a href="https://www.gwtproject.org/doc/latest/DevGuideCodingBasicsJsInterop.html">JsInterop</a>
 */
@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "TestComponent")
public class TestComponent {

    public TestComponent(Element element) {
        // Dummy constructor. The JS one will be used
    }

    public native void render(State state, StateUpdater stateUpdater);

    public native void destroy();

    @JsFunction
    public interface StateUpdater {

        void updateState(State state);

    }

    @JsType
    public static class State {

        public String message;
        public int count;

        public State(String message, int count) {
            this.message = message;
            this.count = count;
        }
        
    }


}