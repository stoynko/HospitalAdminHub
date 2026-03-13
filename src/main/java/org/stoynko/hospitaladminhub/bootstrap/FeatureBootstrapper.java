package org.stoynko.hospitaladminhub.bootstrap;

import org.stoynko.hospitaladminhub.core.tools.FeatureMetaData;
import org.stoynko.hospitaladminhub.core.tools.FeatureReference;
import org.stoynko.hospitaladminhub.core.tools.FeatureRegistry;
import org.stoynko.hospitaladminhub.core.tools.implementations.FeatureAnalyticsImpl;
import org.stoynko.hospitaladminhub.core.tools.implementations.FeaturePatientsImpl;
import org.stoynko.hospitaladminhub.core.utility.IconFactory;
import org.stoynko.hospitaladminhub.ui.Icon;
import org.stoynko.hospitaladminhub.ui.Paths;
import org.stoynko.hospitaladminhub.ui.view.FXMLViewLoader;

public class FeatureBootstrapper {

    private final FXMLViewLoader viewLoader;

    public FeatureBootstrapper(FXMLViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    public FeatureRegistry initialize() {
        FeatureRegistry registry = new FeatureRegistry();

        FeatureMetaData analyticsMeta = new FeatureMetaData(
                FeatureReference.ANALYTICS_REFERENCE,
                Paths.ANALYTICS_TOOL_FXML.getPath(),
                Paths.ANALYTICS_TOOL_CSS.getPath(),
                Icon.ICON_ANALYTICS
        );

        registry.register(analyticsMeta, new FeatureAnalyticsImpl(viewLoader));

        FeatureMetaData patientsMeta = new FeatureMetaData(
                FeatureReference.PATIENTS_REFERENCE,
                Paths.PATIENTS_TOOL_FXML.getPath(),
                Paths.PATIENTS_TOOL_CSS.getPath(),
                Icon.ICON_DASHBOARD
        );

        registry.register(patientsMeta, new FeaturePatientsImpl(viewLoader));

        return registry;
    }
}
