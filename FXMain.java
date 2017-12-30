package AreaCalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FXMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("FXMLTest.fxml"));

        TabPane tabPane = loader.load();

        Image image = new Image("/AreaCalculator/styles/logo.png");

        Scene scene = new Scene(tabPane);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Area Calculator");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(image);
        primaryStage.show();
    }
}
