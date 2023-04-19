package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class OrderFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addicon;

    @FXML
    private Label balancelbl;

    @FXML
    private JFXButton btnAddCart;

    @FXML
    private JFXButton btnPlaceOrder;

    @FXML
    private ComboBox<?> cmbcustid;

    @FXML
    private ComboBox<?> cmbitemcode;

    @FXML
    private TableColumn<?, ?> colaction;

    @FXML
    private TableColumn<?, ?> colcategory;

    @FXML
    private TableColumn<?, ?> colitemcode;

    @FXML
    private TableColumn<?, ?> colitemname;

    @FXML
    private TableColumn<?, ?> colquantity;

    @FXML
    private TableColumn<?, ?> colquantity_unitprice;

    @FXML
    private TableColumn<?, ?> colunitprice;

    @FXML
    private Label lblchangingcategory;

    @FXML
    private Label lblchangingcusname;

    @FXML
    private Label lblchangingitmname;

    @FXML
    private Label lblchangingqtyonhands;

    @FXML
    private Label lblchangingunitprice;

    @FXML
    private Label lblcustomername;

    @FXML
    private Label lblitemcategory;

    @FXML
    private Label lblitemname;

    @FXML
    private Label lblitemqtyonhand;

    @FXML
    private Label lblitmunitprice;

    @FXML
    private Label lblmoreneeded;

    @FXML
    private Label lblorderdate;

    @FXML
    private Label lblorderid;

    @FXML
    private Label lbltotalpay;

    @FXML
    private TextField orderqty;

    @FXML
    private RadioButton radiodelivery;

    @FXML
    private ImageView seeorderdet;

    @FXML
    private TableView<?> tblplaceOrder;

    @FXML
    private TextField txtpaidamount;

    @FXML
    void addiconOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void btnDeleteMousePressed(MouseEvent event) {

    }

    @FXML
    void btnaddcartOnAction(ActionEvent event) {

    }

    @FXML
    void btnplaceorderOnAction(ActionEvent event) {

    }

    @FXML
    void cmbcustidOnAction(ActionEvent event) {

    }

    @FXML
    void cmbitemcodeOnAction(ActionEvent event) {

    }

    @FXML
    void radiodeliveryOnAction(ActionEvent event) {

    }

    @FXML
    void seeorderdetOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void tblOnMouseClicked(MouseEvent event) {

    }

    @FXML
    void txtpaidamountKeyTyped(KeyEvent event) {

    }

    @FXML
    void initialize() {
        assert addicon != null : "fx:id=\"addicon\" was not injected: check your FXML file 'Order.fxml'.";
        assert balancelbl != null : "fx:id=\"balancelbl\" was not injected: check your FXML file 'Order.fxml'.";
        assert btnAddCart != null : "fx:id=\"btnAddCart\" was not injected: check your FXML file 'Order.fxml'.";
        assert btnPlaceOrder != null : "fx:id=\"btnPlaceOrder\" was not injected: check your FXML file 'Order.fxml'.";
        assert cmbcustid != null : "fx:id=\"cmbcustid\" was not injected: check your FXML file 'Order.fxml'.";
        assert cmbitemcode != null : "fx:id=\"cmbitemcode\" was not injected: check your FXML file 'Order.fxml'.";
        assert colaction != null : "fx:id=\"colaction\" was not injected: check your FXML file 'Order.fxml'.";
        assert colcategory != null : "fx:id=\"colcategory\" was not injected: check your FXML file 'Order.fxml'.";
        assert colitemcode != null : "fx:id=\"colitemcode\" was not injected: check your FXML file 'Order.fxml'.";
        assert colitemname != null : "fx:id=\"colitemname\" was not injected: check your FXML file 'Order.fxml'.";
        assert colquantity != null : "fx:id=\"colquantity\" was not injected: check your FXML file 'Order.fxml'.";
        assert colquantity_unitprice != null : "fx:id=\"colquantity_unitprice\" was not injected: check your FXML file 'Order.fxml'.";
        assert colunitprice != null : "fx:id=\"colunitprice\" was not injected: check your FXML file 'Order.fxml'.";
        assert lblchangingcategory != null : "fx:id=\"lblchangingcategory\" was not injected: check your FXML file 'Order.fxml'.";
        assert lblchangingcusname != null : "fx:id=\"lblchangingcusname\" was not injected: check your FXML file 'Order.fxml'.";
        assert lblchangingitmname != null : "fx:id=\"lblchangingitmname\" was not injected: check your FXML file 'Order.fxml'.";
        assert lblchangingqtyonhands != null : "fx:id=\"lblchangingqtyonhands\" was not injected: check your FXML file 'Order.fxml'.";
        assert lblchangingunitprice != null : "fx:id=\"lblchangingunitprice\" was not injected: check your FXML file 'Order.fxml'.";
        assert lblcustomername != null : "fx:id=\"lblcustomername\" was not injected: check your FXML file 'Order.fxml'.";
        assert lblitemcategory != null : "fx:id=\"lblitemcategory\" was not injected: check your FXML file 'Order.fxml'.";
        assert lblitemname != null : "fx:id=\"lblitemname\" was not injected: check your FXML file 'Order.fxml'.";
        assert lblitemqtyonhand != null : "fx:id=\"lblitemqtyonhand\" was not injected: check your FXML file 'Order.fxml'.";
        assert lblitmunitprice != null : "fx:id=\"lblitmunitprice\" was not injected: check your FXML file 'Order.fxml'.";
        assert lblmoreneeded != null : "fx:id=\"lblmoreneeded\" was not injected: check your FXML file 'Order.fxml'.";
        assert lblorderdate != null : "fx:id=\"lblorderdate\" was not injected: check your FXML file 'Order.fxml'.";
        assert lblorderid != null : "fx:id=\"lblorderid\" was not injected: check your FXML file 'Order.fxml'.";
        assert lbltotalpay != null : "fx:id=\"lbltotalpay\" was not injected: check your FXML file 'Order.fxml'.";
        assert orderqty != null : "fx:id=\"orderqty\" was not injected: check your FXML file 'Order.fxml'.";
        assert radiodelivery != null : "fx:id=\"radiodelivery\" was not injected: check your FXML file 'Order.fxml'.";
        assert seeorderdet != null : "fx:id=\"seeorderdet\" was not injected: check your FXML file 'Order.fxml'.";
        assert tblplaceOrder != null : "fx:id=\"tblplaceOrder\" was not injected: check your FXML file 'Order.fxml'.";
        assert txtpaidamount != null : "fx:id=\"txtpaidamount\" was not injected: check your FXML file 'Order.fxml'.";

    }

}
