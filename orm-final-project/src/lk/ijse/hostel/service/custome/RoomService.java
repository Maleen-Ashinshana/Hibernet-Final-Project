package lk.ijse.hostel.service.custome;

import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.service.SuperSevice;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.exception.NotFoundException;

import java.util.List;

public interface RoomService extends SuperSevice {
    public RoomDTO saveRoom(RoomDTO roomDTO)throws DuplicateException;
    public RoomDTO search(String id) throws NotFoundException;
    public void delete(String id) throws NotFoundException;
    public RoomDTO updateRoom(RoomDTO roomDTO)throws NotFoundException;
    public List<RoomDTO> findAll();
}
