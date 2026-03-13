package org.stoynko.hospitaladminhub.core.tools;

import org.stoynko.hospitaladminhub.core.tools.interfaces.Feature;

import java.util.EnumMap;

public class FeatureRegistry {

    private final EnumMap<FeatureReference, Feature> features =
            new EnumMap<>(FeatureReference.class);

    private final EnumMap<FeatureReference, FeatureMetaData> metaDataMap =
            new EnumMap<>(FeatureReference.class);

    public void register(FeatureMetaData metaData, Feature feature) {

        FeatureReference reference = metaData.getReference();

        features.put(reference, feature);
        metaDataMap.put(reference, metaData);
    }

    public Feature getFeature(FeatureReference reference) {
        return features.get(reference);
    }

    public FeatureMetaData getMetaData(FeatureReference reference) {
        return metaDataMap.get(reference);
    }
}