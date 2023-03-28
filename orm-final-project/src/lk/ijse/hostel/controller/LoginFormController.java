package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.util.Navigation;
import lk.ijse.hostel.util.Routs;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane pane;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;

    public void btnLoginOnAction(ActionEvent actionEvent) {

    }

    public void btnCreateOnAction(ActionEvent actionEvent) throws IOException {
      pane.getChildren().clear();
        Navigation.navigation(Routs.USER,pane);
    }
}
