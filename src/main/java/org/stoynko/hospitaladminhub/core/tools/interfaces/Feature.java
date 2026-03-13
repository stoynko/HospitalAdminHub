package org.stoynko.hospitaladminhub.core.tools.interfaces;

import javafx.scene.Node;
import org.stoynko.hospitaladminhub.core.tools.FeatureReference;

public interface Feature {

    FeatureReference getReference();
    Node getPanel();
}
