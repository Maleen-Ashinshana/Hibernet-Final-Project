package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.StudentDAO;
import lk.ijse.hostel.dao.exception.ConstraintViolationException;
import lk.ijse.hostel.entity.StudentEntity;
import lk.ijse.hostel.service.exception.NotFoundException;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.sql.ResultSet;
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
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        try {
            session.saveOrUpdate(entity);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return entity;
    }

    @Override
    public void delete(String id) throws NotFoundException {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        StudentEntity studentEntity=new StudentEntity();
        try {
            session.delete(studentEntity);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();

        }
        return;
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
            e.printStackTrace();
            transaction.rollback();
            return null;
        }


    }

    @Override
    public List<StudentEntity> findAll() {
        /*Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        ArrayList<StudentEntity> studentEntities = new ArrayList<>();

        String hql="FROM StudentEntity";
        Query query=session.createQuery(hql);
        List<StudentEntity> result=query.list();

        for (StudentEntity student:result) {
            System.out.println(student.getStudentId()+""+student.getStudentName()+""+student.getAddress()+""+student.getContact_number()+""+student.getDate_of_birth()+""+student.getGender());

        }
        return getStudentList((ResultSet) studentEntities);*/

        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        ArrayList<StudentEntity> entities=new ArrayList<>();
        NativeQuery hql= session.createSQLQuery("select * from studentEntity");
        hql.addEntity(StudentEntity.class);
        List<StudentEntity> entityList=hql.list();

        for (StudentEntity student:entityList) {
            entities.add(student);
        }
return entities;
    }
    private List<StudentEntity> getStudentList(ResultSet resultSet){
        try {
            List<StudentEntity> studentEntityList=new ArrayList<>();
            while (resultSet.next()){
                StudentEntity studentEntity=new StudentEntity(resultSet.getString("studentId"),resultSet.getString("StudentName"),resultSet.getString("address"),resultSet.getInt("contact_number"),resultSet.getString("date_of_birth"),resultSet.getString("gender"));
                studentEntityList.add(studentEntity);
            }
            return studentEntityList;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public boolean existByPk(String pk) {
/*        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.getTransaction();
        try {
            //StudentEntity studentEntity=session.find(StudentEntity.class,pk);
            StudentEntity studentEntity=session.
        }*/
        return false;
    }
}
