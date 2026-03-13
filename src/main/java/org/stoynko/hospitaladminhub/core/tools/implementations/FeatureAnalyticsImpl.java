package org.stoynko.hospitaladminhub.core.tools.implementations;

import javafx.scene.Node;
import org.stoynko.hospitaladminhub.core.tools.AbstractFXMLFeature;
import org.stoynko.hospitaladminhub.core.tools.FeatureReference;
import org.stoynko.hospitaladminhub.ui.Paths;
import org.stoynko.hospitaladminhub.ui.view.FXMLViewLoader;

public class FeatureAnalyticsImpl extends AbstractFXMLFeature {

    public FeatureAnalyticsImpl(FXMLViewLoader fxmlViewLoader) {
        super(fxmlViewLoader);
    }

    @Override
    public FeatureReference getReference() {
        return FeatureReference.ANALYTICS_REFERENCE;
    }

    @Override
    public Node getPanel() {
        return loadView(Paths.ANALYTICS_TOOL_FXML.getPath());
    }
}