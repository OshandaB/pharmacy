package lk.ijse.pharmacy.model;

import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderModel {
    public static int getTotalSales() throws SQLException, ClassNotFoundException {
        String sql="SELECT count(orderID) FROM orders WHERE date =curdate()";
        ResultSet resultSet= CrudUtil.crudUtil(sql);
        int count=0;
        while (resultSet.next()){
            count=resultSet.getInt(1);
        }
        return count;
    }
}
