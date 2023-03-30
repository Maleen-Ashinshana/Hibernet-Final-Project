package lk.ijse.hostel.dao.util;

import lk.ijse.hostel.dao.exception.ConstraintViolationException;
import lk.ijse.hostel.entity.SuperEntity;

import java.io.Serializable;

public interface S<T extends SuperEntity,ID extends Serializable> extends SuperDAO {
     T add(T entity) throws ConstraintViolationException;
}
