package lk.ijse.pharmacy.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.pharmacy.db.DBConnection;
import lk.ijse.pharmacy.dto.Item;
import lk.ijse.pharmacy.tm.ItemTM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemModel {
    public static boolean save(Item itmAdd) throws SQLException {  //data baes ekata dana set eka
        String sql = "INSERT INTO medicine(medID, medName, type, mfgDate , expDate, qtyOnHand) " +
                "VALUES(?, ?, ?, ? ,? ,?)";
        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, itmAdd.getItemCode());
            pstm.setString(2, itmAdd.getItemMedName());
            pstm.setString(3, itmAdd.getItemType());
            pstm.setString(4, itmAdd.getItemDate());
            pstm.setString(5, itmAdd.getItemmfgDate());
            pstm.setString(6, itmAdd.getItemQOH());


            return pstm.executeUpdate() > 0;
        }
    }
    public static boolean delete(String id) throws SQLException {

        String sql = "DELETE FROM medicine WHERE medID = ?";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, id);
            return pstm.executeUpdate() > 0;
        }
    }
    public static ObservableList<ItemTM> getAll() throws SQLException {
        String sql = "SELECT * FROM medicine";

        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            ResultSet resultSet = pstm.executeQuery();

            ObservableList<ItemTM> dataList = FXCollections.observableArrayList();

            while (resultSet.next()) {
                dataList.add(new ItemTM(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)

                ));
            }
            return dataList;
        }
    }
    public static boolean update(Item supAdd) throws SQLException {

        String sql = "UPDATE medicine SET medName = ?, type = ?, mfgDate = ?, expDate = ?, qtyOnHand = ? WHERE medID = ?";


        try (PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql)) {

            pstm.setString(1, supAdd.getItemMedName());
            pstm.setString(2, supAdd.getItemType());
            pstm.setString(3, supAdd.getItemDate());
            pstm.setString(4, supAdd.getItemmfgDate());
            pstm.setString(5, supAdd.getItemQOH());
            pstm.setString(6, supAdd.getItemCode());

            return pstm.executeUpdate() > 0;
        }
    }


}
