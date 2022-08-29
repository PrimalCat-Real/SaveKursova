/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package deumworld;

import animatefx.animation.FadeIn;
import deumworld.controllers.SceneController;
import deumworld.models.Configs;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author PrimalCat
 */
public class Main extends Application {

    public static ResourceBundle getBundle() {
        return bundle;
    }

    public static URL getRoot_main() {
        return root_main;
    }

    public static Stage getStage() {
        return stage;
    }


    private static ResourceBundle bundle;
    private static URL root_main;
    private static Stage stage;
    private static SceneController screenController;
    private static Configs configs;

    public static Configs getConfigs() {
        return configs;
    }

    public static SceneController getScreenController() {
        return screenController;
    }
    public static final String iconsPath = String.valueOf(Main.class.getResource("images/icons/"));

    public static String getIconsPath() {
        return iconsPath;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        bundle = ResourceBundle.getBundle("deumworld/lang/login");
        root_main = getClass().getResource("Dashboard.fxml");
        stage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"),bundle);
        Scene scene = new Scene(root);
        screenController = new SceneController(stage);
        new FadeIn(root).play();
        
        screenController.setScene(scene);
        configs = new Configs();
        configs.main();


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
