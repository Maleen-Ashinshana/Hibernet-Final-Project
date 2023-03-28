package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.util.Navigation;
import lk.ijse.hostel.util.Routs;

import java.io.IOException;

public class CreateAccountFormController {
    public AnchorPane pane;
    public JFXPasswordField txtPassword;
    public JFXTextField txtUserName;
    public JFXTextField txtEmail;

    public void btnCreateOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routs.LOGIN,pane);
        
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routs.LOGIN,pane);
    }
}
