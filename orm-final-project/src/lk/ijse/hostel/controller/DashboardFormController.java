package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.util.Navigation;
import lk.ijse.hostel.util.Routs;

import java.io.IOException;

public class DashboardFormController {
    public AnchorPane mainPane;
    public AnchorPane subPane;
    public TableView tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDOB;
    public TableColumn colGender;
    public JFXTextField txtStudentId;
    public JFXTextField txtStudentName;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNumber;
    public JFXTextField txtDOB;
    public JFXComboBox cmbGender;

    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
         mainPane.getChildren().clear();
         Navigation.navigation(Routs.STUDENT,mainPane);
    }

    public void btnRoomOnAction(ActionEvent actionEvent) throws IOException {
        subPane.getChildren().clear();
        Navigation.navigation(Routs.ROOM,subPane);
    }

    public void btnReservationOnAction(ActionEvent actionEvent) {

    }

    public void txtStudentIdOnAction(ActionEvent actionEvent) {

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }

    public void btnAddOnAction(ActionEvent actionEvent) {

    }

    public void btnSearchOnAction(ActionEvent actionEvent) {

    }
}
