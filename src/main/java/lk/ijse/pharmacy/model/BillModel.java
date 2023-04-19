package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.dto.Bill;
import lk.ijse.pharmacy.dto.Customer;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.SQLException;

public class BillModel {

    public static boolean addBill(Bill bill) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO bill(billID,orderID,totalAmt,custPay,discount,orderDate)" +
                "VALUES (?,?,?,?,?,?)";

        return CrudUtil.crudUtil(
                sql,
                bill.getBillID(),
                bill.getOrderID(),
                bill.getTotalAmt(),
                bill.getCustPay(),
                bill.getDiscount(),
                bill.getOrderDate()
        );
    }

    public static boolean updateBill(Bill bill) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE bill SET orderID=?,totalAmt=?,custPay=?,discount=?,orderDate=? WHERE billID=?";

        return CrudUtil.crudUtil(
                sql,
                bill.getOrderID(),
                bill.getTotalAmt(),
                bill.getCustPay(),
                bill.getDiscount(),
                bill.getOrderDate(),
                bill.getBillID()
        );
    }

    public static boolean deleteBill(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM bill WHERE billID=?";
        return CrudUtil.crudUtil(
                sql,
                id);
    }

}
