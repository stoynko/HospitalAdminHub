package org.stoynko.hospitaladminhub.ui.modules;

import static org.stoynko.hospitaladminhub.ui.Paths.*;

public enum ModuleReference {

    DASHBOARD_MODULE(DASHBOARD_FXML.getPath()),
    SIDEBAR_MODULE(SIDE_BAR_FXML.getPath()),
    ICON_BAR_MODULE(ICON_BAR_FXML.getPath()),
    PATIENTS_MODULE(PATIENTS_FXML.getPath());

    private final String path;

    ModuleReference(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
