package org.stoynko.hospitaladminhub.core.tools;

import javafx.scene.Node;

public final class FeatureMetaData {

    private final FeatureReference reference;
    private final String fxmlPath;
    private final String cssPath;
    private final Node icon;

    public FeatureMetaData(FeatureReference reference, String fxmlPath, String cssPath, Node icon) {
        this.reference = reference;
        this.fxmlPath = fxmlPath;
        this.cssPath = cssPath;
        this.icon = icon;
    }

    public FeatureReference getReference() {
        return this.reference;
    }

    public String getFxmlPath() {
        return this.fxmlPath;
    }

    public String getCssPath() {
        return this.cssPath;
    }

    public Node getIcon() {
        return this.icon;
    }
}
