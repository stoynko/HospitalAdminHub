package org.stoynko.hospitaladminhub.core.tools.implementations;

import org.stoynko.hospitaladminhub.core.tools.AbstractFXMLFeature;
import org.stoynko.hospitaladminhub.core.tools.FeatureMetaData;
import org.stoynko.hospitaladminhub.core.tools.FeatureReference;
import org.stoynko.hospitaladminhub.ui.Paths;


public class FeaturePatientsImpl extends AbstractFXMLFeature {

    public FeaturePatientsImpl(FeatureMetaData featureMetaData) {
        super(featureMetaData);
    }

    @Override
    public FeatureReference getReference() {
        return FeatureReference.PATIENTS_REFERENCE;
    }

    @Override
    protected String viewPath() {
        return Paths.PATIENTS_TOOL_FXML.getPath();
    }

}