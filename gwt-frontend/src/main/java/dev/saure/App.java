package dev.saure;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class App implements EntryPoint {

    @Override
    public void onModuleLoad() {


        VerticalPanel widgets = new VerticalPanel();
        RootLayoutPanel.get().add(widgets);

        HTMLPanel appPanel = new HTMLPanel("");
        widgets.add(appPanel);

        AngularInterface api = new AngularInterface("Title sent from GWT");

        AngularComponent.create(appPanel.getElement(), api)
                .then(e -> {
                    GWT.log("Created angular component");
                    Button button = new Button("Destroy Angular");
                    button.addClickHandler(c -> {
                        e.destroy();
                    });
                    widgets.add(button);
                    return null;
                })
                .error(e -> {
                    GWT.log(e + "");
                    return null;
                });

//        TestComponent testComponent = new TestComponent(div);
//
//        TestComponent.State state = new TestComponent.State("Hello from the React Component!", 2);
//
//        testComponent.render(state, s -> GWT.log("Count is now: " + s.count));
    }
}