package lk.ijse.hostel.dao.custom;

import lk.ijse.hostel.dao.util.CrudDAO;
import lk.ijse.hostel.entity.StudentEntity;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO extends CrudDAO<StudentEntity,String> {
    List<String> loadStudentIds()throws SQLException, ClassNotFoundException;
}
