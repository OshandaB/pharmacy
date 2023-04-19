package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import lk.ijse.pharmacy.dto.Bill;
import lk.ijse.pharmacy.model.BillModel;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.model.OrderModel;
import lk.ijse.pharmacy.util.AlertController;

public class BillFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> BillIdCol;

    @FXML
    private TableColumn<?, ?> OrderIdCol;

    @FXML
    private TableColumn<?, ?> TotalAmtCol;

    @FXML
    private TableColumn<?, ?> CustPayCol;

    @FXML
    private TableColumn<?, ?> OrderDateCol;

    @FXML
    private TextField searchText;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TextField BillIdText;

    @FXML
    private TextField AmountText;

    @FXML
    private TextField PayemntText;

    @FXML
    private TextField DiscountText;

    @FXML
    private ComboBox OrderIdBox;

    @FXML
    private DatePicker OrderDateText;

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        Bill bill=new Bill();

        bill.setBillID(BillIdText.getText());
        bill.setOrderID(String.valueOf(OrderIdBox.getValue()));
        bill.setTotalAmt(Double.parseDouble(AmountText.getText()));
        bill.setCustPay(Double.parseDouble(PayemntText.getText()));
        bill.setDiscount(Double.parseDouble(DiscountText.getText()));
        bill.setOrderDate(String.valueOf(OrderDateText.getValue()));

        try {
            boolean isSave = BillModel.addBill(bill);
            if (isSave) {
                AlertController.confirmmessage("Save successFully");

            }


        } catch (Exception e) {
            System.out.println(e);
            AlertController.errormessage("Error");

        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void txtIdOnMouseClicked(MouseEvent event) {

    }

    private void LoadOrderId() throws ClassNotFoundException {

        try{
            ObservableList<String> orderIds= FXCollections.observableArrayList();
            List<String> ids = OrderModel.LoadOrderIds();

            for(String id:ids) {
                orderIds.add(id);

            }
            OrderIdBox.setItems(orderIds);

        }catch (SQLException throwables){
            AlertController.errormessage("Something went Wrong");
        }
    }

    @FXML
    void initialize() {

        try {
            LoadOrderId();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        assert BillIdCol != null : "fx:id=\"BillIdCol\" was not injected: check your FXML file 'Bill.fxml'.";
        assert OrderIdCol != null : "fx:id=\"OrderIdCol\" was not injected: check your FXML file 'Bill.fxml'.";
        assert TotalAmtCol != null : "fx:id=\"TotalAmtCol\" was not injected: check your FXML file 'Bill.fxml'.";
        assert CustPayCol != null : "fx:id=\"CustPayCol\" was not injected: check your FXML file 'Bill.fxml'.";
        assert OrderDateCol != null : "fx:id=\"OrderDateCol\" was not injected: check your FXML file 'Bill.fxml'.";
        assert searchText != null : "fx:id=\"searchText\" was not injected: check your FXML file 'Bill.fxml'.";
        assert btnUpdate != null : "fx:id=\"btnUpdate\" was not injected: check your FXML file 'Bill.fxml'.";
        assert btnAdd != null : "fx:id=\"btnAdd\" was not injected: check your FXML file 'Bill.fxml'.";
        assert btnDelete != null : "fx:id=\"btnDelete\" was not injected: check your FXML file 'Bill.fxml'.";
        assert BillIdText != null : "fx:id=\"BillIdText\" was not injected: check your FXML file 'Bill.fxml'.";
        assert AmountText != null : "fx:id=\"AmountText\" was not injected: check your FXML file 'Bill.fxml'.";
        assert PayemntText != null : "fx:id=\"PayemntText\" was not injected: check your FXML file 'Bill.fxml'.";
        assert DiscountText != null : "fx:id=\"DiscountText\" was not injected: check your FXML file 'Bill.fxml'.";
        assert OrderIdBox != null : "fx:id=\"OrderIdBox\" was not injected: check your FXML file 'Bill.fxml'.";
        assert OrderDateText != null : "fx:id=\"OrderDateText\" was not injected: check your FXML file 'Bill.fxml'.";

    }
}
