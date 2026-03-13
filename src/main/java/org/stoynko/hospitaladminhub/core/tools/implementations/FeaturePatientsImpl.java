package org.stoynko.hospitaladminhub.core.tools.implementations;

import javafx.scene.Node;
import org.stoynko.hospitaladminhub.core.tools.AbstractFXMLFeature;
import org.stoynko.hospitaladminhub.core.tools.FeatureReference;
import org.stoynko.hospitaladminhub.ui.Paths;
import org.stoynko.hospitaladminhub.ui.view.FXMLViewLoader;

public class FeaturePatientsImpl extends AbstractFXMLFeature {

    public FeaturePatientsImpl(FXMLViewLoader fxmlViewLoader) {
        super(fxmlViewLoader);
    }

    @Override
    public FeatureReference getReference() {
        return FeatureReference.PATIENTS_REFERENCE;
    }

    @Override
    public Node getPanel() {
        return loadView(Paths.PATIENTS_TOOL_FXML.getPath());
    }
}