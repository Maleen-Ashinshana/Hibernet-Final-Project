package lk.ijse.hostel.service.custome;

import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.service.SuperSevice;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.exception.NotFoundException;

import java.util.List;

public interface StudentService extends SuperSevice {
   /* boolean saveStudent(StudentDTO studentDTO)throws DuplicateException;*/

    public StudentDTO saveStudent(StudentDTO studentDTO)throws DuplicateException;
    public StudentDTO updateStudent(StudentDTO studentDTO)throws NotFoundException;
    public void delete(String code)throws NotFoundException;
    public  StudentDTO search(String id) throws  NotFoundException;
    public List<StudentDTO> findAll();
}
