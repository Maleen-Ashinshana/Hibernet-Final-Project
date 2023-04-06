package lk.ijse.hostel.service.custome;

import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.SuperSevice;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.exception.NotFoundException;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentService extends SuperSevice {
   /* boolean saveStudent(StudentDTO studentDTO)throws DuplicateException;*/

/*    public StudentDTO saveStudent(StudentDTO studentDTO)throws DuplicateException;
    public StudentDTO updateStudent(StudentDTO studentDTO)throws NotFoundException;
    public void delete(String code)throws NotFoundException;

    public List<StudentDTO> findAll();
    List<String> loadStudentIds()throws SQLException, ClassNotFoundException;*/

    public  StudentDTO search(String id) throws  NotFoundException;
    boolean addStudent(StudentDTO studentDTO)throws DuplicateException;
    boolean updateStudent(StudentDTO studentDTO) throws NotFoundException;
    boolean deleteStudent(String id) throws SQLException, ClassNotFoundException;
    ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException;

}
