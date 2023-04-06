package lk.ijse.hostel.service.custome.impl;

import lk.ijse.hostel.dao.custom.RoomDAO;
import lk.ijse.hostel.dao.util.DAOFactory;
import lk.ijse.hostel.dao.util.DaoTypes;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.custome.RoomService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.exception.NotFoundException;
import lk.ijse.hostel.service.util.Convertor;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomServiceIMPL implements RoomService {
    private final RoomDAO roomDAO;
    private final Convertor convertor;
    public RoomServiceIMPL() {
        roomDAO = (RoomDAO) DAOFactory.getInstance().getDAO(DaoTypes.ROOM);
        convertor = new Convertor();
    }

    @Override
    public RoomDTO search(String id) throws NotFoundException {
        return null;
    }

    @Override
    public boolean addStudent(RoomDTO roomDTO) throws DuplicateException {
        return false;
    }

    @Override
    public boolean updateStudent(RoomDTO roomDTO) throws NotFoundException {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException {
        return null;
    }
/*    }
    @Override
    public RoomDTO saveRoom(RoomDTO roomDTO) throws DuplicateException {
        roomDAO.save(convertor.toRoom(roomDTO));
        return roomDTO;
    }

    @Override
    public RoomDTO search(String id) throws NotFoundException {
        RoomEntity se=roomDAO.search(id);
        return new RoomDTO(se.getRoom_type_id(),se.getType(),se.getKey_money(),se.getQty());
    }

    @Override
    public void delete(String id) throws NotFoundException {
        roomDAO.delete(id);
    }

    @Override
    public RoomDTO updateRoom(RoomDTO roomDTO) throws NotFoundException {
        this.roomDAO.update(this.convertor.toRoom(roomDTO));
        return roomDTO;
    }

    @Override
    public List<RoomDTO> findAll() {
        return null;
    }*/
}
