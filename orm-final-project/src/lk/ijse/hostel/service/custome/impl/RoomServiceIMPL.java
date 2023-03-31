package lk.ijse.hostel.service.custome.impl;

import lk.ijse.hostel.dao.custom.RoomDAO;
import lk.ijse.hostel.dao.util.DAOFactory;
import lk.ijse.hostel.dao.util.DaoTypes;
import lk.ijse.hostel.dto.RoomDTO;
import lk.ijse.hostel.service.custome.RoomService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.util.Convertor;

public class RoomServiceIMPL implements RoomService {
    private final RoomDAO roomDAO;
    private final Convertor convertor;
    public RoomServiceIMPL(){
        roomDAO= (RoomDAO) DAOFactory.getInstance().getDAO(DaoTypes.ROOM);
        convertor=new Convertor();
    }
/*    public RoomServiceIMPL(){
        roomDAO= (RoomDAO) DAOFactory.getInstance().getDAO(DaoTypes.ROOM);
        convertor=new Convertor();
    }*/
    @Override
    public RoomDTO saveRoom(RoomDTO roomDTO) throws DuplicateException {
        roomDAO.save(convertor.toRoom(roomDTO));
        return roomDTO;
    }
}
