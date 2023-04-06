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
    @Override
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
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        //transaction.begin();
        try{
            session.saveOrUpdate(entity);
            transaction.commit();
            return true;
        }catch (Exception e){

            System.out.println(e);;
            transaction.rollback();
            return false;
        }
    }

    @Override
    public boolean delete(String id) throws NotFoundException {
        return false;
    }

    @Override
    public StudentEntity search(String s) throws ConstraintViolationException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        //transaction.begin();
        try{

            StudentEntity student = session.find(StudentEntity.class, s);
            transaction.commit();
            return new StudentEntity(s, student.getStudentName(), student.getAddress(),student.getContact_number(),student.getDate_of_birth(),student.getGender());
        }catch (Exception e){
            System.out.println(e);;
            transaction.rollback();
            return null;
        }

    }


    @Override
    public ArrayList<StudentEntity> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

/*    @Override
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

        try {
            session.delete(id,new StudentEntity());
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
        Session session=FactoryConfiguration.getInstance().getSession();
         Transaction transaction= session.beginTransaction();

        List<StudentEntity> resul=null;
         try {
             String hql="select st from StudentEntity st ";
             Query query=session.createQuery(hql);

             resul=query.list();
         }catch (Exception e){
             e.printStackTrace();
         }finally {
             session.close();
         }
        return resul;
        *//*List<StudentEntity> resul=query.list();

        for (StudentEntity student:resul) {
            student.getAddress();
            System.out.println(student.getStudentId()+"");
        }*//*

        *//*return resul;*//*
        *//*try {
           *//**//*String hql="From StudentEntity ";
           Query query=session.createQuery(hql);
           List<StudentEntity> resul=query.list();*//**//*

            for (StudentEntity student:resul) {
                System.out.println(student.getStudentId()+"");
            }
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return null;*//*
    }


    @Override
    public long count() {
        return 0;
    }*/

    @Override
    public boolean existByPk(String pk) {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        try {
            StudentEntity studentEntity=session.find(StudentEntity.class,pk);
            ResultSet resultSet= (ResultSet) studentEntity;
            transaction.commit();
            return resultSet.next();
            //return new StudentEntity(pk,studentEntity.getStudentName(),studentEntity.getAddress(),studentEntity.getContact_number(),studentEntity.getDate_of_birth(),studentEntity.getGender());
        }catch (Exception e){
            e.printStackTrace();
            //transaction.rollback();
            return false;
        }

    }

    @Override
    public List<String> loadStudentIds() throws SQLException, ClassNotFoundException {
        Session session=FactoryConfiguration.getInstance().getSession();
        List<String> list=new ArrayList<>();
        NativeQuery hql= session.createSQLQuery("SELECT  * from Student");
        System.out.println(hql);
        hql.addEntity(StudentEntity.class);
        List<StudentEntity> studentEntityList=hql.list();
        /*String id;*/
        for (StudentEntity student:studentEntityList) {
            System.out.println(student.getStudentId());
            list.add(student.getStudentId());
            System.out.println(student.getStudentId());

        }
        return list;
    }
}
