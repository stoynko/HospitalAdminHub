package org.stoynko.hospitaladminhub.ui;

import java.util.Optional;

public enum Paths {

    /* FXML */

    ROOT_FXML ("/org/stoynko/hospitaladminhub/layout/Root.fxml"),
    DASHBOARD_FXML ("/org/stoynko/hospitaladminhub/layout/modules/Dashboard.fxml"),
    ICON_BAR_FXML ("/org/stoynko/hospitaladminhub/layout/modules/sidebar/IconBar.fxml"),
    SIDE_BAR_FXML ("/org/stoynko/hospitaladminhub/layout/modules/sidebar/SideBar.fxml"),
    PATIENTS_FXML ("/org/stoynko/hospitaladminhub/layout/modules/Patients.fxml"),

    ANALYTICS_TOOL_FXML ("/org/stoynko/hospitaladminhub/layout/modules/sidebar/panels/AnalyticsPanel.fxml"),
    PATIENTS_TOOL_FXML ("/org/stoynko/hospitaladminhub/layout/modules/sidebar/panels/PatientsPanel.fxml"),

    /* STYLESHEETS */

    STYLESHEET_DEFAULT ("/org/stoynko/hospitaladminhub/stylesheets/default.css"),
    PATIENTS_TOOL_CSS (String.valueOf(Optional.empty())),
    ANALYTICS_TOOL_CSS (String.valueOf(Optional.empty()));

    private final String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
