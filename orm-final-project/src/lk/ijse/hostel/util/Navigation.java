package lk.ijse.hostel.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;

    public static void navigation(Routs routs, AnchorPane pane) throws IOException {
        Navigation.pane=pane;
        Navigation.pane.getChildren().clear();
        Stage window=(Stage) Navigation.pane.getScene().getWindow();

        switch (routs){
            case USER:
                window.setTitle("Create Account");
                iniUI("createAccountForm.fxml");
                break;
            case LOGIN:
                window.setTitle("Login Form");
                iniUI("loginForm.fxml");
                break;
            case ROOM:
                window.setTitle("Room Form");
                iniUI("roomForm.fxml");
                break;
            case STUDENT:
                window.setTitle("Dash Board Form");
                iniUI("dashboardForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR,"UI Not Found!..");
        }
    }
    private static void iniUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class.getResource("/lk/ijse/hostel/view/" +location)));
    }
}
