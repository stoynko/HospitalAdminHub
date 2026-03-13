package org.stoynko.hospitaladminhub.core.tools;

import javafx.scene.Node;
import org.stoynko.hospitaladminhub.core.tools.interfaces.Feature;
import org.stoynko.hospitaladminhub.ui.view.FXMLView;
import org.stoynko.hospitaladminhub.ui.view.FXMLViewLoader;

public abstract class AbstractFXMLFeature implements Feature {

    private final FXMLViewLoader viewLoader;

    protected AbstractFXMLFeature(FXMLViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    protected Node loadView(String fxmlPath) {
        FXMLView<?> view = viewLoader.loadFromPath(fxmlPath);
        return view.getRoot();
    }
}