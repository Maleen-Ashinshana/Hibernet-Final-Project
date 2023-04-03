package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.ServiceTypes;
import lk.ijse.hostel.service.custome.UserService;
import lk.ijse.hostel.util.Navigation;
import lk.ijse.hostel.util.Routs;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class CreateAccountFormController {
    public AnchorPane pane;
    public JFXPasswordField txtPassword;
    public JFXTextField txtUserName;
    public JFXTextField txtEmail;
    public JFXTextField txtId;
    private Pattern idPatten;
    private Pattern namePatten;
    private Pattern emailPatten;
    private Pattern passwordPatten;
    public UserService userService;

    public void initialize() throws SQLException, ClassNotFoundException {
        this.userService= (UserService) ServiceFactory.getInstance().getService(ServiceTypes.USER);
        idPatten= Pattern.compile("^[S][0][0-9]{1,}$");
        namePatten=Pattern.compile("^[A-Za-z0-9]{4,}$");
        emailPatten=Pattern.compile("^([a-z|0-9]{3,})[@]([a-z]{2,})\\.(com|lk)$");
        passwordPatten=Pattern.compile("^[a-zA-Z0-9_]{8,}$");
    }

    public void btnCreateOnAction(ActionEvent actionEvent) throws IOException {
        boolean isIdMatched=idPatten.matcher(txtId.getText()).matches();
        boolean isNameMatched=namePatten.matcher(txtUserName.getText()).matches();
        boolean isEmailMatched=emailPatten.matcher(txtEmail.getText()).matches();
        boolean isPasswordMatched=passwordPatten.matcher(txtPassword.getText()).matches();

/*
        if (isIdMatched){
            if(isNameMatched){
                if(isEmailMatched){
                    if(isPasswordMatched){

                        UserDTO userDTO=new UserDTO(txtId.getText(),txtUserName.getText(),txtEmail.getText(),txtPassword.getText());
                        try {
                            if (userService.saveUser(userDTO)==null){
                                new Alert(Alert.AlertType.ERROR,"Fail To Register").show();
                                return;
                            }
                            new Alert(Alert.AlertType.CONFIRMATION,"Registerd").show();
                        }catch (DuplicateException e){
                            new Alert(Alert.AlertType.ERROR,"User Already Register!").show();
                            txtId.selectAll();
                            txtId.requestFocus();
                        }
                    }else {
                        txtPassword.setFocusColor(Paint.valueOf("Red"));
                        txtPassword.requestFocus();
                    }
                }else {
                    txtEmail.setFocusColor(Paint.valueOf("Red"));
                    txtEmail.requestFocus();
                }
            }else {
                txtUserName.setFocusColor(Paint.valueOf("Red"));
                txtUserName.requestFocus();
            }
        }else {
            txtId.setFocusColor(Paint.valueOf("Red"));
            txtId.requestFocus();
        }
*/


/*        try {
            boolean isAdded=userService.saveUser(userDTO);
            if (isAdded){
                new Alert(Alert.AlertType.CONFIRMATION,"Added").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"No").show();
                return;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/

/*        try {
            boolean isAdded=userService.saveUser(userDTO);
            if (isAdded){
                userService.saveUser(userDTO);
                new Alert(Alert.AlertType.CONFIRMATION,"Saved").show();

            }else {
                new Alert(Alert.AlertType.ERROR,"No").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/
        /*Navigation.navigation(Routs.LOGIN,pane);*/
        
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigation(Routs.LOGIN,pane);
    }
}
