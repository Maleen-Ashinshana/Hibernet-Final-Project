package lk.ijse.hostel.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.service.ServiceFactory;
import lk.ijse.hostel.service.ServiceTypes;
import lk.ijse.hostel.service.custome.RoomService;

import java.sql.SQLException;

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

    /*public void btnAddOnAction(ActionEvent actionEvent) {
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
    }*/

    /*public void btnDeleteOnAction(ActionEvent actionEvent) {
        Alert alert=new Alert(Alert.AlertType.WARNING,"are you sure to delete the Room", ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> result=alert.showAndWait();
        if (result.isPresent()&&result.get()==ButtonType.YES){
            try {
                roomService.delete(txtRoomId.getText());
                new Alert(Alert.AlertType.INFORMATION,"Deleted").show();
            }catch (NotFoundException e){
                new Alert(Alert.AlertType.WARNING,"No").show();
            }
        }
    }*/

   /* public void btnUpdateOnAction(ActionEvent actionEvent) {
      RoomDTO roomDTO=new RoomDTO(txtRoomId.getText(),txtType.getText(),txtKeyMoney.getText(),Integer.parseInt(txtQty.getText()));
      try {
          roomService.updateRoom(roomDTO);
          new Alert(Alert.AlertType.INFORMATION,"Updated0").show();
      }catch (NotFoundException e){
          new Alert(Alert.AlertType.ERROR,e.getMessage());
      }
    }*/

    public void btnSearchOnAction(ActionEvent actionEvent) {

    }

    public void txtIdOnAction(ActionEvent actionEvent) {
              RoomDTO roomDTO=roomService.search(txtRoomId.getText());
              if (roomDTO!=null){
                  fillData(roomDTO);
              }
    }
    private void fillData(RoomDTO roomDTO){
        txtRoomId.setText(roomDTO.getRoom_type_id());
        txtType.setText(roomDTO.getType());
        txtKeyMoney.setText(roomDTO.getKey_money());
        txtQty.setText(String.valueOf(roomDTO.getQty()));
    }
}
