package lk.ijse.hostel.service.custome.impl;

import lk.ijse.hostel.dao.custom.ReservationDAO;
import lk.ijse.hostel.dao.util.DAOFactory;
import lk.ijse.hostel.dao.util.DaoTypes;
import lk.ijse.hostel.service.SuperSevice;
import lk.ijse.hostel.service.util.Convertor;

public class ReservationServiceIMPL implements SuperSevice {

    private final ReservationDAO reservationDAO;
    private final Convertor convertor;
    public ReservationServiceIMPL(){
        reservationDAO= (ReservationDAO) DAOFactory.getInstance().getDAO(DaoTypes.RESEVATION);
        convertor=new Convertor();
    }

}
