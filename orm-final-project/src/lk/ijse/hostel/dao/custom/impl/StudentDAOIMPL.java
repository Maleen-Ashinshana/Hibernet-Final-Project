package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.StudentDAO;
import lk.ijse.hostel.dao.exception.ConstraintViolationException;
import lk.ijse.hostel.entity.StudentEntity;
import lk.ijse.hostel.entity.SuperEntity;
import lk.ijse.hostel.service.exception.NotFoundException;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOIMPL implements StudentDAO {
/*    @Override
    public boolean save(StudentEntity entity) throws ConstraintViolationException {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }

    }

    @Override
    public boolean update(StudentEntity entity) throws ConstraintViolationException {
        return false;
    }

    @Override
    public boolean delete(String id) throws NotFoundException {
        return false;
    }

    @Override
    public StudentEntity search(StudentEntity entity) throws ConstraintViolationException {
        return null;
    }

    @Override
    public ArrayList<StudentEntity> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }*/

    @Override
    public StudentEntity save(StudentEntity entity) throws ConstraintViolationException {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
            return entity;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return entity;
    }

    @Override
    public StudentEntity update(StudentEntity entity) throws ConstraintViolationException {
        return null;
    }

    @Override
    public void delete(String id) throws NotFoundException {

    }

    @Override
    public StudentEntity search(String pk) throws ConstraintViolationException {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        try {
            StudentEntity studentEntity=session.find(StudentEntity.class,pk);
            transaction.commit();
            return new StudentEntity(pk,studentEntity.getStudentName(),studentEntity.getAddress(),studentEntity.getContact_number(),studentEntity.getDate_of_birth(),studentEntity.getGender());
        }catch (Exception e){
            transaction.rollback();
            return null;
        }


    }

/*    @Override
    public StudentEntity search(StudentEntity entity) throws ConstraintViolationException {

        return null;
    }*/

    @Override
    public List<StudentEntity> findAll() {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        ArrayList<StudentEntity>entities=new ArrayList<>();
        /*String hql=*/
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existByPk(String pk) {
        return false;
    }
}
