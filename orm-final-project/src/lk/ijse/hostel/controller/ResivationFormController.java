package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.ServiceTypes;
import lk.ijse.hostel.service.custome.ReservationService;
import lk.ijse.hostel.service.custome.RoomService;
import lk.ijse.hostel.service.custome.StudentService;

import java.sql.SQLException;

public class ResivationFormController {
    public AnchorPane pane;
    public Label lblAllRooms;
    public Label lblCurrenRooms;
    public JFXComboBox cmbTypes;
    public Label lblQty;
    public JFXTextField txtResId;
    public JFXTextField txtDate;
    public JFXComboBox cmbStudentId;
    public JFXTextField txtStatus;
    public JFXComboBox cmbRoomTypeId;
    public TableView tblView;
    public TableColumn colResId;
    public TableColumn colDate;
    public TableColumn colStudentId;
    public TableColumn colRoomId;
    public TableColumn colStatus;
     private StudentService studentService;
     private RoomService roomService;
     private ReservationService reservationService;


    public void initialize() throws SQLException, ClassNotFoundException {
   loadStudentId();
   this.studentService= (StudentService) ServiceFactory.getInstance().getService(ServiceTypes.STUDENT);
   this.roomService= (RoomService) ServiceFactory.getInstance().getService(ServiceTypes.ROOM);
   //this.reservationService= (ReservationService) ServiceFactory.getInstance().getService(ServiceTypes.RESEVATION);


    }

    public void btnRegisterOnAction(ActionEvent actionEvent) {

    }

    public void btnDeletOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }

    public void btnSearchOnAction(ActionEvent actionEvent) {


    }

    public void txtRes_IdOnAction(ActionEvent actionEvent) {

    }
    private void loadStudentId(){

        /*try {
            ObservableList<String> observableList= FXCollections.observableArrayList();
            List<String> stringList=studentService.loadStudentIds();

            for (String ids:stringList) {
                observableList.add(ids);
            }
            cmbStudentId.setItems(observableList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/
    }

}
