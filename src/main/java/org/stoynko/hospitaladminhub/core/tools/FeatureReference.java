package org.stoynko.hospitaladminhub.core.tools;

public enum FeatureReference {

    ANALYTICS_REFERENCE("analytics"),
    PATIENTS_REFERENCE("patients");

    private final String displayName;

    FeatureReference(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}