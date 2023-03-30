package lk.ijse.hostel.dao.util;

import lk.ijse.hostel.dao.exception.ConstraintViolationException;
import lk.ijse.hostel.entity.SuperEntity;
import lk.ijse.hostel.service.exception.NotFoundException;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T extends SuperEntity,ID extends Serializable> extends  SuperDAO {
/*    public boolean save(T  entity) throws ConstraintViolationException;
    public boolean update(T entity)throws ConstraintViolationException;
     public boolean delete(String id) throws NotFoundException;
     public T search(T entity) throws ConstraintViolationException;
     public ArrayList<T> getAll()throws SQLException,ClassNotFoundException;*/
}
