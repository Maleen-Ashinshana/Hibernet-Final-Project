package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hostel.dao.custom.impl.StudentDAOIMPL;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.ServiceTypes;
import lk.ijse.hostel.service.custome.StudentService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.exception.NotFoundException;
import lk.ijse.hostel.tm.StudentTM;
import lk.ijse.hostel.util.Navigation;
import lk.ijse.hostel.util.Routs;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.regex.Pattern;

public class DashboardFormController {
    public AnchorPane mainPane;
    public AnchorPane subPane;
    @FXML
    private AnchorPane stdPaneNumber1;
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
    public StudentDAOIMPL studentDAOIMPL;
    private ObservableList<StudentDTO> obList= FXCollections.observableArrayList();


    public void initialize() throws SQLException, ClassNotFoundException {
      pattern();
      studentView();
      //loadAllStudent();
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
    @FXML
    void btnstdOnAction(ActionEvent event) throws IOException {
        mainPane.getChildren().clear();
        Navigation.navigation(Routs.STUDENT,mainPane);

    }
    @FXML
    void btnRVAOOnACtion(ActionEvent event) throws IOException {
        stdPaneNumber1.getChildren().clear();
        Navigation.navigation(Routs.RESERVATION,stdPaneNumber1);

    }
    @FXML
    void btnRmOnAction(ActionEvent event) throws IOException {
          stdPaneNumber1.getChildren().clear();
          Navigation.navigation(Routs.ROOM,stdPaneNumber1);
    }

   /* public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
         mainPane.getChildren().clear();
         Navigation.navigation(Routs.STUDENT,mainPane);
    }*/

    /*public void btnRoomOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/lk/ijse/hostel/view/roomForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }*/

   /* public void btnReservationOnAction(ActionEvent actionEvent) throws IOException {
        subPane.getChildren().clear();
        Navigation.navigation(Routs.RESERVATION,subPane);

    }*/

    public void txtStudentIdOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO=studentService.search(txtStudentId.getText());
        if (studentDTO!=null){
            fillData(studentDTO);
        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        Alert alert=new Alert(Alert.AlertType.WARNING,"are you sure to delete the Student",ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> result=alert.showAndWait();
        if (result.isPresent()&&result.get()==ButtonType.YES){
            try {
                studentService.delete(txtStudentId.getText());
                new Alert(Alert.AlertType.INFORMATION,"Student deleted").show();
                tblStudent.getItems().removeAll(tblStudent.getSelectionModel().getSelectedItem());
                txtStudentId.clear();
                txtStudentName.clear();
                txtAddress.clear();
                txtContactNumber.clear();
                txtDOB.clear();
                txtGender.clear();

            }catch (NotFoundException e){
                new Alert(Alert.AlertType.WARNING,"No").show();
            }
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        StudentDTO studentDTO=new StudentDTO(txtStudentId.getText(),txtStudentName.getText(),txtAddress.getText(),Integer.parseInt(txtContactNumber.getText()),txtDOB.getText(),txtGender.getText());
        try {
            studentService.updateStudent(studentDTO);
            new Alert(Alert.AlertType.INFORMATION,"Update").show();
        }catch (NotFoundException e){
            new Alert(Alert.AlertType.ERROR,e.getMessage());
        }
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
    }
    public void btnSearchOnAction(ActionEvent actionEvent) {
        txtStudentIdOnAction(actionEvent);

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

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("/lk/ijse/hostel/view/loginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        Stage widow= (Stage) mainPane.getScene().getWindow();
        widow.close();
        stage.show();
    }
    /*private void loadAllStudent(){
        ArrayList<StudentDTO> studentDTOS=null;
        studentDTOS= (ArrayList<StudentDTO>) studentService.findAll();
        for (StudentDTO dto:studentDTOS) {
            StudentDTO  studentDTO=new StudentDTO(dto.getStudentId(), dto.getStudentName(), dto.getAddress(), dto.getContact_number(), dto.getDate_of_birth(),dto.getGender());
            obList.add(studentDTO);

            tblStudent.setItems(obList);
        }
    }*/
}
