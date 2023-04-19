package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.dto.PlaceOrder;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class OrderModel {
    public static String getNextOrderId() throws SQLException, ClassNotFoundException {
        String sql = "SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1";

        ResultSet resultSet = CrudUtil.crudUtil(sql);

        if (resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    private static String splitOrderId(String currentId) {
        if (currentId != null) {
            String[] strings = currentId.split("ORD-");
            int id = Integer.parseInt(strings[1]);
            ++id;
            String digit = String.format("%03d", id);
            return "ORD-" + digit;
        }
        return "ORD-001";
    }

    public static boolean placeOrder(String orderid, String custid, String ordpay, String empid, List<PlaceOrder> placeOrderList) throws SQLException, ClassNotFoundException {
        Connection con = null;
        try {
            con = DBConnection.getInstance().getConnection();
            con.setAutoCommit(false);

            boolean isSaved = save(orderid, custid, LocalDate.now(), ordpay, empid);
            if (isSaved) {
                boolean isUpdated = ItemModel.updateQty(placeOrderList);
                if (isUpdated) {
                    boolean isOrdered = OrderDetailModel.save(orderid, placeOrderList);
                    if (isOrdered) {
                                con.commit();
                                return true;
                        }
                }
            }
            return false;
        } catch (SQLException er) {
            System.out.println(er);
            con.rollback();
            return false;
        } finally {
            System.out.println("finally");
            con.setAutoCommit(true);
        }
    }

    private static boolean save(String orderid, String custid, LocalDate now, String ordpay, String empid) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO orders(orderID,custID,empID,date,orderPayment) VALUES(?,?,?,?,?)";

        return CrudUtil.crudUtil(
                sql,
                orderid,
                custid,
                empid,
                now,
                ordpay
        );
    }
}
