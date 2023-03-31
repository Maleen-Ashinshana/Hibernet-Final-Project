package lk.ijse.hostel.service.custome.impl;

import lk.ijse.hostel.dao.custom.UserDAO;
import lk.ijse.hostel.dao.util.DAOFactory;
import lk.ijse.hostel.dao.util.DaoTypes;
import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.entity.UserEntity;
import lk.ijse.hostel.service.custome.UserService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.util.Convertor;


public class UserServiceIMPL implements UserService {
    private final UserDAO userDAO;
    private final Convertor convertor;
    public UserServiceIMPL(){
        userDAO= (UserDAO) DAOFactory.getInstance().getDAO(DaoTypes.USER);
        convertor=new Convertor();
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) throws DuplicateException {
        userDAO.add(convertor.toUser(userDTO));
        return userDTO;
    }

/*    @Override
    public boolean saveUser(UserDTO userDTO) throws SQLException, ClassNotFoundException {

        return userDAO.add(new UserEntity(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), userDTO.getPassword()));
    }*/
}
