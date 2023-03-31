package lk.ijse.hostel.dao.util;


import lk.ijse.hostel.dao.custom.impl.RoomDAOIMPL;
import lk.ijse.hostel.dao.custom.impl.StudentDAOIMPL;
import lk.ijse.hostel.dao.custom.impl.UserDAOIMPL;

import java.sql.Connection;

public class DAOFactory {
    private static DAOFactory daoFactory;

    public DAOFactory() {
    }
    public static DAOFactory getInstance(){
        return  daoFactory==null?(daoFactory=new DAOFactory()):daoFactory;
    }

   public  SuperDAO getDAO(DaoTypes daoTypes){
        switch (daoTypes){
            case USER:
                return new UserDAOIMPL();
            case STUDENT:
                return new StudentDAOIMPL();
            case ROOM:
                return new RoomDAOIMPL();
            default:
                return null;
        }
   }
}
