package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.dto.PlaceOrder;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailModel {

    public static boolean save(String orderid, List<PlaceOrder> placeOrderList) throws SQLException, ClassNotFoundException {
        for(PlaceOrder placeOrder : placeOrderList) {
            if(!save(orderid, placeOrder)) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(String orderid, PlaceOrder placeOrder) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO orderdetail(medID,orderID,qty)" +
                "VALUES(?, ?, ?)";

        return CrudUtil.crudUtil(
                sql,
                placeOrder.getOrdereditemcode(),
                orderid,
                placeOrder.getOrdereditemqty()
        );
    }
}
