package org.stoynko.hospitaladminhub;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.stoynko.hospitaladminhub.bootstrap.ApplicationBootstrapper;
import org.stoynko.hospitaladminhub.bootstrap.ServiceRegistry;
import org.stoynko.hospitaladminhub.core.controllers.RootController;
import org.stoynko.hospitaladminhub.ui.view.FXMLView;
import org.stoynko.hospitaladminhub.ui.view.FXMLViewLoader;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) {

        ApplicationBootstrapper bootstrap = new ApplicationBootstrapper();
        bootstrap.initialize();

        FXMLViewLoader loader = bootstrap.getServices().get(FXMLViewLoader.class);
        FXMLView<RootController> view =
                loader.loadFromPath("/org/stoynko/hospitaladminhub/layout/Root.fxml");

        Scene scene = new Scene(view.getRoot());

        stage.setScene(scene);
        stage.show();
    }
}
