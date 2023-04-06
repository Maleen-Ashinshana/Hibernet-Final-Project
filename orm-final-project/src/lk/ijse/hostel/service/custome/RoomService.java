package lk.ijse.hostel.service.custome;

import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.SuperSevice;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.exception.NotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomService extends SuperSevice {
/*    public RoomDTO saveRoom(RoomDTO roomDTO)throws DuplicateException;
    public RoomDTO search(String id) throws NotFoundException;
    public void delete(String id) throws NotFoundException;
    public RoomDTO updateRoom(RoomDTO roomDTO)throws NotFoundException;
    public List<RoomDTO> findAll()throws SQLException,ClassNotFoundException ;*/

    public RoomDTO search(String id) throws NotFoundException;
    boolean addStudent(RoomDTO roomDTO)throws DuplicateException;
    boolean updateStudent(RoomDTO roomDTO) throws NotFoundException;
    boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;
    ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException;
}
