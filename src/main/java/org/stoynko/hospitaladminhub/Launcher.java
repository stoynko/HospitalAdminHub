package org.stoynko.hospitaladminhub;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.stoynko.hospitaladminhub.bootstrap.ApplicationBootstrapper;
import org.stoynko.hospitaladminhub.bootstrap.FXControllerFactory;
import org.stoynko.hospitaladminhub.bootstrap.ServiceRegistry;
import org.stoynko.hospitaladminhub.core.controllers.RootController;
import org.stoynko.hospitaladminhub.ui.Paths;
import org.stoynko.hospitaladminhub.ui.view.FXMLView;
import org.stoynko.hospitaladminhub.ui.view.FXMLViewLoader;

import java.io.IOException;

public class Launcher extends Application {

    @Override
    public void start(Stage stage) {

        ApplicationBootstrapper bootstrap = new ApplicationBootstrapper();
        bootstrap.initialize();

        ServiceRegistry services = bootstrap.services();

        FXMLViewLoader loader = services.get(FXMLViewLoader.class);

        FXMLView<RootController> view =
                loader.loadFromPath("/org/stoynko/hospitaladminhub/layout/Root.fxml");

        Scene scene = new Scene(view.getRoot());

        stage.setScene(scene);
        stage.show();
    }
}
