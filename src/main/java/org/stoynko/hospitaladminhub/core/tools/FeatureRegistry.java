package org.stoynko.hospitaladminhub.core.tools;

import org.stoynko.hospitaladminhub.core.tools.implementations.FeatureAnalyticsImpl;
import org.stoynko.hospitaladminhub.core.tools.implementations.FeaturePatientsImpl;
import org.stoynko.hospitaladminhub.core.tools.interfaces.Feature;
import org.stoynko.hospitaladminhub.core.utility.IconFactory;
import org.stoynko.hospitaladminhub.ui.Icons;
import org.stoynko.hospitaladminhub.ui.Paths;

import java.util.EnumMap;

public class FeatureRegistry {

    private final EnumMap<FeatureReference, Feature> features =
            new EnumMap<>(FeatureReference.class);

    private final EnumMap<FeatureReference, FeatureMetaData> metaDataMap =
            new EnumMap<>(FeatureReference.class);

    public void register(FeatureMetaData metaData, Feature feature) {

        FeatureReference featureReference = metaData.getReference();
        features.put(featureReference, feature);
        metaDataMap.put(featureReference, metaData);
    }

    public Feature getFeature(FeatureReference featureReference) {

        Feature feature = features.get(featureReference);

        if (feature == null) {
            throw new IllegalStateException("Feature _" + featureReference + "_ is not registered");
        }

        return feature;
    }

    public FeatureMetaData getMetaData(FeatureReference featureReference) {

        FeatureMetaData metaData = metaDataMap.get(featureReference);

        if (metaData == null) {
            throw new IllegalStateException("No meta data _" + featureReference + "_ is registered");
        }

        return metaData;
    }

    public static FeatureRegistry createDefault() {

        FeatureRegistry registry = new FeatureRegistry();

        FeatureMetaData analyticsMeta = new FeatureMetaData(
            FeatureReference.ANALYTICS_REFERENCE,
            Paths.ANALYTICS_TOOL_FXML.getPath(),
            Paths.ANALYTICS_TOOL_CSS.getPath(),
            IconFactory.create(Icons.ICON_ANALYTICS)
        );

        registry.register(analyticsMeta, new FeatureAnalyticsImpl(analyticsMeta));

        FeatureMetaData patientsMeta = new FeatureMetaData(
            FeatureReference.PATIENTS_REFERENCE,
            Paths.PATIENTS_TOOL_FXML.getPath(),
            Paths.PATIENTS_TOOL_CSS.getPath(),
            IconFactory.create(Icons.ICON_DASHBOARD)
        );

        registry.register(patientsMeta, new FeaturePatientsImpl(patientsMeta));

        return registry;
    }
}