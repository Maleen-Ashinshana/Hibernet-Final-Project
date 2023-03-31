package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.ServiceTypes;
import lk.ijse.hostel.service.custome.RoomService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.tm.RoomTM;

import java.sql.SQLException;
import java.util.regex.Pattern;

public class roomFormController {
    public AnchorPane pane;
    public TableView table;
    public TableColumn tblRoomId;
    public TableColumn colRoomType;
    public TableColumn tblKeyMoney;
    public TableColumn colQty;
    public JFXTextField txtRoomId;
    public JFXTextField txtType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtQty;
    public RoomService roomService;


    public void initialize()throws SQLException,ClassNotFoundException{
        roomView();
        this.roomService= (RoomService) ServiceFactory.getInstance().getService(ServiceTypes.ROOM);
    }
    private void roomView(){
        tblRoomId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colRoomType.setCellValueFactory(new PropertyValueFactory<>("type"));
        tblKeyMoney.setCellValueFactory(new PropertyValueFactory<>("key_money"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
    }

    public void btnAddOnAction(ActionEvent actionEvent) {
        RoomDTO roomDTO=new RoomDTO(txtRoomId.getText(),txtType.getText(),txtKeyMoney.getText(),Integer.parseInt(txtQty.getText()));
        try {
            if(roomService.saveRoom(roomDTO)==null){
                new Alert(Alert.AlertType.ERROR,"Fail To Save").show();
                return;
            }
            new Alert(Alert.AlertType.CONFIRMATION,"Success to Save").show();
            table.getItems().add(new RoomTM(roomDTO.getRoom_type_id(),roomDTO.getType(),roomDTO.getKey_money(), roomDTO.getQty()));
            txtRoomId.clear();
            txtType.clear();
            txtKeyMoney.clear();
            txtQty.clear();
        }catch (DuplicateException e){
            new Alert(Alert.AlertType.ERROR,"Room Already Exists").show();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }

    public void btnSearchOnAction(ActionEvent actionEvent) {

    }

    public void txtIdOnAction(ActionEvent actionEvent) {

    }
}
