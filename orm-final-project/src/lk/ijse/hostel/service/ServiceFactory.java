package lk.ijse.hostel.service;


import lk.ijse.hostel.service.custome.impl.UserServiceIMPL;

import java.sql.SQLException;

public class ServiceFactory {
    private  static ServiceFactory serviceFactory;

    public ServiceFactory() {
    }
    public  static  ServiceFactory getInstance(){
        return serviceFactory==null?(serviceFactory=new ServiceFactory()):serviceFactory;

    }
    public   SuperSevice getService(ServiceTypes serviceTypes) throws SQLException, ClassNotFoundException {
        switch (serviceTypes){
            case USER:
                return new UserServiceIMPL();
//            case ITEM :
//                return (T) new ItemServiceIMPL();
//            case EMPLOYE:
//                return (T) new EmployeServiceIMPL();
////            case CASHIER:
////                return (T) new CashierServiceIMPL();
//            case ORDER:
//                return (T) new OrderServiceIMPL();
//            case STOKE:
//                return (T) new StokeServiceIMPL();
////            case MANAGER:
////                return (T) new ManagerServiceIMPL();
//            case PAYMENT:
//                return (T) new PaymentServiceIMPL();
//            case SUPPLOYER:
//                return (T) new SupployerServiceIMPL();
//            case STOKEITEMS:
//                return (T) new StokeItemServiceIMPL();
//            case ORDERDETAILS:
//                return (T) new OrderDetailsServiceIMPL();
//            case STOKEDETAILS:
//                return (T) new StokeDetailsServiceIMPL();
//            case CUSTOMER:
//                return (T) new CustomerServiceIMPL();
//            case SYSTEMUSERS:
//                return (T) new SystemServiceIMPL();
            default:
                return null;
        }
    }
}
