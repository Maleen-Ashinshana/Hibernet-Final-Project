package lk.ijse.hostel.service.custome.impl;

import lk.ijse.hostel.dao.custom.StudentDAO;
import lk.ijse.hostel.dao.util.DAOFactory;
import lk.ijse.hostel.dao.util.DaoTypes;
import lk.ijse.hostel.dto.StudentDTO;
import lk.ijse.hostel.entity.StudentEntity;
import lk.ijse.hostel.service.custome.StudentService;
import lk.ijse.hostel.service.exception.DuplicateException;
import lk.ijse.hostel.service.exception.NotFoundException;
import lk.ijse.hostel.service.util.Convertor;

import java.util.List;
import java.util.Optional;

public class StudentServiceIMPL implements StudentService {
    private final StudentDAO studentDAO;
    private final Convertor convertor;
    public StudentServiceIMPL(){
        studentDAO= (StudentDAO) DAOFactory.getInstance().getDAO(DaoTypes.STUDENT);
        convertor=new Convertor();
    }
    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) throws DuplicateException {

        studentDAO.save(convertor.toStudent(studentDTO));
        return studentDTO;
    }

/*    @Override
    public boolean saveStudent(StudentDTO studentDTO) throws DuplicateException {
        return studentDAO.save(new StudentEntity(studentDTO.getStudentId(),studentDTO.getStudentName(),studentDTO.getAddress(),studentDTO.getContact_number(),studentDTO.getDate_of_birth(),studentDTO.getGender()));
    }*/

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(String code) throws NotFoundException {

    }

    @Override
    public StudentDTO search(String id) throws NotFoundException{
        /*Optional<StudentEntity>studentEntity= Optional.ofNullable(studentDAO.search(id));
        return convertor.fromStudent();*/
       StudentEntity se=studentDAO.search(id);
       return new StudentDTO(se.getStudentId(),se.getStudentName(),se.getAddress(),se.getContact_number(),se.getDate_of_birth(),se.getGender());
    }

    @Override
    public List<StudentDTO> findAll() {
        return null;
    }
}
