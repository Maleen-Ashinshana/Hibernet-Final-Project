package lk.ijse.hostel.dao.custom.impl;

import lk.ijse.hostel.dao.custom.RoomDAO;
import lk.ijse.hostel.dao.exception.ConstraintViolationException;
import lk.ijse.hostel.entity.RoomEntity;
import lk.ijse.hostel.service.exception.NotFoundException;
import lk.ijse.hostel.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomDAOIMPL implements RoomDAO {
    @Override
    public RoomEntity save(RoomEntity entity) throws ConstraintViolationException {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();

            return entity;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return entity;
        }
        /*return entity;*/
    }

    @Override
    public RoomEntity update(RoomEntity entity) throws ConstraintViolationException {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        try {
            session.update(entity);
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
            session.delete(id,new RoomEntity());
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }

    }

    @Override
    public RoomEntity search(String pk) throws ConstraintViolationException {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction= session.beginTransaction();
        try {
            RoomEntity roomEntity=session.find(RoomEntity.class,pk);
            transaction.commit();
            return new RoomEntity(pk,roomEntity.getType(),roomEntity.getKey_money(),roomEntity.getQty());
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return null;
        }

    }

/*    @Override
    public RoomEntity search(RoomEntity entity) throws ConstraintViolationException {
        return null;
    }*/

    @Override
    public List<RoomEntity> findAll() {
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
