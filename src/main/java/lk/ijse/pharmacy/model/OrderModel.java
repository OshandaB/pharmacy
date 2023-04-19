package lk.ijse.pharmacy.model;

import javafx.scene.chart.XYChart;
import lk.ijse.pharmacy.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<String> LoadOrderIds() throws SQLException, ClassNotFoundException {

        String sql = "SELECT orderID FROM orders";
        List<String> allItemData = new ArrayList<>();

        ResultSet resultSet = CrudUtil.crudUtil(sql);
        while (resultSet.next()) {
            allItemData.add(resultSet.getString(1));


        }
        return allItemData;
    }

//    public static XYChart.Series lineChartData() throws SQLException, ClassNotFoundException {
//        String sql="SELECT MONTHNAME(date),sum(orderPayment) from orders group by MONTHNAME(date)";
//        ResultSet resultSet=CrudUtil.crudUtil(sql);
//        XYChart.Series series=new XYChart.Series();
//        while (resultSet.next()){
//            series.getData().add(new XYChart.Data(resultSet.getString(1),resultSet.getInt(2)));
//        }
//        return series;
//
//    }
}
