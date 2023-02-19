package dev.saure;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.RootPanel;

public class App implements EntryPoint {

    @Override
    public void onModuleLoad() {

        Element div = DOM.createDiv();
        RootPanel.getBodyElement().appendChild(div);

        TestComponent testComponent = new TestComponent(div);

        TestComponent.State state = new TestComponent.State("Hello from the React Component!", 2);

        testComponent.render(state, s -> GWT.log("Count is now: " + s.count));
    }
}