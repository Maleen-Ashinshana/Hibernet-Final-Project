package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.ServiceTypes;
import lk.ijse.hostel.service.custome.StudentService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.tm.StudentTM;
import lk.ijse.hostel.util.Navigation;
import lk.ijse.hostel.util.Routs;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

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
    public JFXTextField txtGender;

    private Pattern idPattern;
    private Pattern NamePattern;
    private Pattern addressPattern;
    private Pattern contPattern;
    private Pattern dobPattern;
    private Pattern genderPattern;
    public StudentService studentService;


    public void initialize() throws SQLException, ClassNotFoundException {
      pattern();
      studentView();
      this.studentService= (StudentService) ServiceFactory.getInstance().getService(ServiceTypes.STUDENT);
    }
    public void pattern(){
        idPattern=Pattern.compile("[S][0][0-9]{1,}");
        NamePattern=Pattern.compile("^[A-Za-z0-9]{4,}$");
        addressPattern=Pattern.compile("^[A-Za-z0-9]{1,}$");
        contPattern=Pattern.compile("^(076|074|073|075|078|072|091)([0-9]{7})$");
        dobPattern=Pattern.compile("[0-9]{1,}");
        genderPattern=Pattern.compile("^[A-Za-z]{1,}$");
    }

    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
         mainPane.getChildren().clear();
         Navigation.navigation(Routs.STUDENT,mainPane);
    }

    public void btnRoomOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/lk/ijse/hostel/view/roomForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void btnReservationOnAction(ActionEvent actionEvent) throws IOException {
        subPane.getChildren().clear();
        Navigation.navigation(Routs.RESERVATION,subPane);

    }

    public void txtStudentIdOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO=studentService.search(txtStudentId.getText());
        if (studentDTO!=null){
            fillData(studentDTO);
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        boolean isIdMatched=idPattern.matcher(txtStudentId.getText()).matches();
        boolean isNameMatched=NamePattern.matcher(txtStudentName.getText()).matches();
        boolean isAddressMatched=addressPattern.matcher(txtAddress.getText()).matches();
        boolean isContMatched=contPattern.matcher(txtContactNumber.getText()).matches();
        //boolean isDOBdMatched=dobPattern.matcher(txtDOB.getText()).matches();
        boolean isGenderMatched=genderPattern.matcher(txtGender.getText()).matches();

/*        if (isIdMatched){
            if (isNameMatched){
                if (isAddressMatched){
                    if (isContMatched){
*//*                        if (isDOBdMatched){*//*
                            if (isGenderMatched){


                            }else {
                                txtGender.setFocusColor(Paint.valueOf("red"));
                                txtGender.requestFocus();
                            }
                        *//*}
                        else {
                            txtDOB.setFocusColor(Paint.valueOf("red"));
                            txtDOB.requestFocus();
                        }*//*
                    }else {
                        txtContactNumber.setFocusColor(Paint.valueOf("red"));
                        txtContactNumber.requestFocus();
                    }
                }else {
                    txtAddress.setFocusColor(Paint.valueOf("red"));
                    txtAddress.requestFocus();
                }
            }else {
                txtStudentName.setFocusColor(Paint.valueOf("red"));
                txtStudentName.requestFocus();
            }
        }else {
            txtStudentId.setFocusColor(Paint.valueOf("red"));
            txtStudentId.requestFocus();
        }*/
        StudentDTO studentDTO=new StudentDTO(txtStudentId.getText(),txtStudentName.getText(),txtAddress.getText(),Integer.parseInt(txtContactNumber.getText()),txtDOB.getText(),txtGender.getText());
        try {
            System.out.println(studentDTO);
            if (studentService.saveStudent(studentDTO)==null){
                new Alert(Alert.AlertType.ERROR,"Failed").show();
                return;
            }
            new Alert(Alert.AlertType.CONFIRMATION,"Student Added  Successful").show();
            tblStudent.getItems().add(new StudentTM(studentDTO.getStudentId(),studentDTO.getStudentName(),studentDTO.getAddress(),studentDTO.getContact_number(),studentDTO.getDate_of_birth(),studentDTO.getGender()));
            txtStudentId.clear();
            txtStudentName.clear();
            txtAddress.clear();
            txtContactNumber.clear();
            txtDOB.clear();
            txtGender.clear();
        }catch (DuplicateException e){
            new Alert(Alert.AlertType.ERROR,"Student Already Added").show();
            txtStudentId.selectAll();
            txtStudentId.requestFocus();
        }
/*        StudentDTO studentDTO=new StudentDTO(txtStudentId.getText(),txtStudentName.getText(),txtAddress.getText(),Integer.parseInt(txtContactNumber.getText()),txtDOB.getText(),txtGender.getText());
        ObservableList<StudentDTO> dtos=tblStudent.getItems();


        boolean isAdded=studentService.saveStudent(studentDTO);
        if (isAdded){
            new Alert(Alert.AlertType.CONFIRMATION,"Added").show();
        }else {
            new Alert(Alert.AlertType.ERROR,"No");
        }*/

        /*Alert alert = new Alert(Alert.AlertType.CONFIRMATION);*/

        /*alert.setTitle("Add Customer");
        alert.setContentText("Are you sure you want to add customer " + txtStudentId.getText() + " ?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.equals(null))*/

    }


    public void btnSearchOnAction(ActionEvent actionEvent) {

    }
    private void studentView() {
        colId.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("StudentName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact_number"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("date_of_birth"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

    }
    private void fillData(StudentDTO studentDTO){
        txtStudentId.setText(studentDTO.getStudentId());
        txtStudentName.setText(studentDTO.getStudentName());
        txtAddress.setText(studentDTO.getAddress());
        txtContactNumber.setText(String.valueOf(studentDTO.getContact_number()));
        txtDOB.setText(studentDTO.getDate_of_birth());
        txtGender.setText(studentDTO.getGender());
    }
   /* public void list(){
        List<StudentTM>studentTMList=studentService.
    }*/
}
