package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.dto.Customer;
import lk.ijse.pharmacy.tm.CustomerTm;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {
    public static boolean add(Customer customer) throws SQLException, ClassNotFoundException {
        return CrudUtil.crudUtil("INSERT INTO Customer VALUES (?,?,?,?,?,?,?)",
                customer.getCustID(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getStreet(),
                customer.getCity(),
                customer.getLane(),
                customer.getContact()
        );
    }

    public static ArrayList<String> getAllId() throws SQLException, ClassNotFoundException {
        ArrayList<String>list=new ArrayList<>();
        ResultSet set= CrudUtil.crudUtil("SELECT  custID From Customer ORDER BY LENGTH(custID),custID");
        while (set.next()){
            list.add(set.getString(1));
        }
        return list;
    }

    public static ArrayList<CustomerTm> getAllICustomer() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerTm>list=new ArrayList<>();
        ResultSet rst= CrudUtil.crudUtil("SELECT  * From Customer;");
        while (rst.next()){
            list.add(
                    new CustomerTm(
                            rst.getString(1),
                            rst.getString(2),
                            rst.getString(3),
                            rst.getString(4),
                            rst.getString(5)
                    ));
        }
        return list;
    }
}
