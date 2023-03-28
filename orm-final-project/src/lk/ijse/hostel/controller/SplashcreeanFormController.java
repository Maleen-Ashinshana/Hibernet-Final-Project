package lk.ijse.hostel.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class SplashcreeanFormController {
    public Label lblLoading;
    public Rectangle recContainer;
    public Rectangle recLoading;
    public AnchorPane pane;

    public void initialize(){
        Timeline timeline=new Timeline();
        KeyFrame keyFrame1= new KeyFrame(Duration.millis(500), actionEvent ->{
            lblLoading.setText("Welcome To Hostel Management System...");
            recLoading.setWidth(recContainer.getWidth()*0.3);
        });
        KeyFrame keyFrame2= new KeyFrame(Duration.millis(1000), actionEvent ->{
            lblLoading.setText("Welcome To Hostel Management System...");
            recLoading.setWidth(recContainer.getWidth()*0.5);
        });
        KeyFrame keyFrame3= new KeyFrame(Duration.millis(1500), actionEvent ->{
            lblLoading.setText("Welcome To Hostel Management System...");
            recLoading.setWidth(recContainer.getWidth()*0.6);
        });KeyFrame keyFrame4= new KeyFrame(Duration.millis(2000), actionEvent ->{
            lblLoading.setText("Welcome To Hostel Management System...");
            recLoading.setWidth(recContainer.getWidth()*0.8);
        });
        KeyFrame keyFrame5= new KeyFrame(Duration.millis(2500), actionEvent ->{
            lblLoading.setText("Welcome To Hostel Management System...");
            recLoading.setWidth(recContainer.getWidth());
        });
        KeyFrame keyFrame6=new KeyFrame(Duration.millis(3000),actionEvent-> {
            try {
                URL resource = getClass().getResource("/lk/ijse/hostel/view/loginForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Scene scene = new Scene(load);
                Stage stage = new Stage();
                stage.setScene(scene);
                Stage widow= (Stage) pane.getScene().getWindow();
                widow.close();
                stage.show();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        });
        timeline.getKeyFrames().addAll(keyFrame1,keyFrame2,keyFrame3,keyFrame4,keyFrame5,keyFrame6);
        timeline.playFromStart();

        }
}
