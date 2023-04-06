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

public class StudentServiceIMPL implements StudentService {
    private final StudentDAO studentDAO;
    private final Convertor convertor;
    public StudentServiceIMPL(){
        studentDAO= (StudentDAO) DAOFactory.getInstance().getDAO(DaoTypes.STUDENT);
        convertor=new Convertor();
    }

    @Override
    public StudentDTO search(String id) throws NotFoundException {
        StudentEntity search=studentDAO.search(id);
        return new StudentDTO(search.getStudentId(),search.getStudentName(),search.getAddress(),search.getContact_number(),search.getDate_of_birth(),search.getGender());
    }

    @Override
    public boolean addStudent(StudentDTO studentDTO) throws DuplicateException {
        return studentDAO.save(new StudentEntity(studentDTO.getStudentId(),studentDTO.getStudentName(),studentDTO.getAddress(),studentDTO.getContact_number(),studentDTO.getDate_of_birth(),studentDTO.getGender()));
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws NotFoundException {
        return false;
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() throws SQLException, ClassNotFoundException {
        return null;
    }
/*    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) throws DuplicateException {
        if (studentDAO.existByPk(studentDTO.getStudentId())) throw new DuplicateException("Student Already saved");
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
        *//*ArrayList<StudentDTO> studentDTOS=new ArrayList<>();
        ArrayList<StudentEntity> entities= (ArrayList<StudentEntity>) studentDAO.findAll();
        for (StudentEntity studentEntity:entities) {
            studentDTOS.add(new StudentDTO(studentEntity.getStudentId(),studentEntity.getStudentName(),studentEntity.getStudentName(),studentEntity.getContact_number(),studentEntity.getDate_of_birth(),studentEntity.getGender()));
        }
        return studentDTOS;*//*
*//*        ArrayList<StudentDTO> dtos=new ArrayList<>();
        ArrayList<StudentEntity>studentEntities= (ArrayList<StudentEntity>) studentDAO.findAll();
        for (StudentEntity entity:studentEntities) {
            dtos.add(new StudentDTO(entity.getStudentId(), entity.getStudentName(), entity.getAddress(), entity.getContact_number(), entity.getDate_of_birth(), entity.getGender()));
        }
        return dto*//*;
        *//*List<StudentDTO> rs=studentDAO.findAll();
        for (StudentEntity student:rs) {
            System.out.println(student.toString());
        }
        return rs;*//*
        return studentDAO.findAll().stream().map(StudentEntity->convertor.fromStudent(StudentEntity)).collect(Collectors.toList());
    }

    @Override
    public List<String> loadStudentIds() throws SQLException, ClassNotFoundException {
        return null;
        *//*return studentDAO.loadStudentIds()*//*
    }*/
}
