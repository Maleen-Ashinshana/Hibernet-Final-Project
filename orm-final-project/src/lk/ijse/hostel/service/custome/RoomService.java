package lk.ijse.hostel.service.custome;

import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.service.SuperSevice;
import lk.ijse.hostel.service.exception.DuplicateException;

public interface RoomService extends SuperSevice {
    public RoomDTO saveRoom(RoomDTO roomDTO)throws DuplicateException;
}
