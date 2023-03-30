package lk.ijse.hostel.service.custome;

import lk.ijse.hostel.dto.UserDTO;
import lk.ijse.hostel.service.SuperSevice;
import lk.ijse.hostel.service.exception.DuplicateException;

import java.sql.SQLException;

public interface UserService extends SuperSevice {
/*    public boolean saveUser(UserDTO userDTO)throws SQLException,ClassNotFoundException;*/
      public UserDTO saveUser(UserDTO userDTO)throws DuplicateException;
}
