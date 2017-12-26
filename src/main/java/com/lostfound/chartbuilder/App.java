package com.lostfound.chartbuilder;

import com.lostfound.chartbuilder.util.IOUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage primaryStage;

    /**
     * Returns primary stage.
     * Allows to manipulate with window from javafx controllers.
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        App.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(IOUtils.getResource("chart-builder.fxml"));

        primaryStage.setTitle("Chart Builder | © Panas Sydor, 2017");
//        primaryStage.getIcons().add(new Image("icon.png"));

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
