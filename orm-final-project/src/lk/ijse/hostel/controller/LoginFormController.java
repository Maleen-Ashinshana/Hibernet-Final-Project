package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lk.ijse.hostel.entity.UserEntity;
import lk.ijse.hostel.util.FactoryConfiguration;
import lk.ijse.hostel.util.Navigation;
import lk.ijse.hostel.util.Routs;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;

public class LoginFormController {
    public AnchorPane pane;
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    private Pattern txtUserNamePatten;
    private Pattern txtPasswordPatten;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        UserEntity userEntity=new UserEntity();
        String hql="SELECT U.name FROM UserEntity U";
        Query query= session.createQuery(hql);
        List<UserEntity> re=query.list();
        System.out.println(re);


/*        boolean uniq=true;
        String pass="password";

        if (uniq){
            if (pass.equals(txtPassword.getText())){
                Stage widow= (Stage) pane.getScene().getWindow();
                widow.close();
                URL resource = getClass().getResource("/lk/ijse/hostel/view/dashboardForm.fxml");
                Parent load = FXMLLoader.load(resource);
                Scene scene = new Scene(load);
                Stage stage = new Stage();
                stage.setScene(scene);
//                Stage widow= (Stage) pane.getScene().getWindow();
//                widow.close();
                stage.show();
            }else {
                new Alert(Alert.AlertType.CONFIRMATION,"password is incorect").show();
            }
        }else{
            new Alert(Alert.AlertType.WARNING,"Please Enter The User Name And Password").show();
        }
        boolean isUserNameMatched=txtUserNamePatten.matcher(txtUserName.getText()).matches();
        boolean isPasswordMatched=txtPasswordPatten.matcher(txtPassword.getText()).matches();
        if (isUserNameMatched){
            if (isPasswordMatched) {
                System.out.println("Loging Success");
            }else{
                txtPassword.setFocusColor(Paint.valueOf("Red"));
                txtPassword.requestFocus();
            }
        }else{
            txtUserName.setFocusColor(Paint.valueOf("Red"));
            txtUserName.requestFocus();
        }*/
        URL resource = getClass().getResource("/lk/ijse/hostel/view/dashboardForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
//                Stage widow= (Stage) pane.getScene().getWindow();
//                widow.close();
        stage.show();



    }

    public void btnCreateOnAction(ActionEvent actionEvent) throws IOException {
      pane.getChildren().clear();
        Navigation.navigation(Routs.USER,pane);
    }
}
