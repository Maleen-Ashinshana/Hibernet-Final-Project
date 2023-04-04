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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO) throws NotFoundException {
        this.studentDAO.update(this.convertor.toStudent(studentDTO));
        return studentDTO;
    }

    @Override
    public void delete(String code) throws NotFoundException {
         this.studentDAO.delete(code);

    }

    @Override
    public StudentDTO search(String id) throws NotFoundException{
       StudentEntity se=studentDAO.search(id);
       return new StudentDTO(se.getStudentId(),se.getStudentName(),se.getAddress(),se.getContact_number(),se.getDate_of_birth(),se.getGender());
    }

    @Override
    public List<StudentDTO> findAll() {
        //return studentDAO.findAll().stream().map(studentEntity -> convertor.fromStudent(studentEntity)).collect(Collectors.toList());
        /*ArrayList<StudentDTO> studentDTOS=new ArrayList<>();
        ArrayList<StudentEntity> entities= (ArrayList<StudentEntity>) studentDAO.findAll();
        for (StudentEntity studentEntity:entities) {
            studentDTOS.add(new StudentDTO(studentEntity.getStudentId(),studentEntity.getStudentName(),studentEntity.getStudentName(),studentEntity.getContact_number(),studentEntity.getDate_of_birth(),studentEntity.getGender()));
        }
        return studentDTOS;*/
        ArrayList<StudentDTO> dtos=new ArrayList<>();
        ArrayList<StudentEntity>studentEntities= (ArrayList<StudentEntity>) studentDAO.findAll();
        for (StudentEntity entity:studentEntities) {
            dtos.add(new StudentDTO(entity.getStudentId(), entity.getStudentName(), entity.getAddress(), entity.getContact_number(), entity.getDate_of_birth(), entity.getGender()));
        }
        return dtos;
    }

    @Override
    public List<String> loadStudentIds() throws SQLException, ClassNotFoundException {
        return studentDAO.loadStudentIds();
    }
}
