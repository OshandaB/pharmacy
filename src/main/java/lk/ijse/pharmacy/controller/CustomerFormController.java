package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.pharmacy.dto.Customer;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.tm.CustomerTm;
import lk.ijse.pharmacy.util.AlertController;
import lk.ijse.pharmacy.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class CustomerFormController {
    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colCusId;

    @FXML
    private TableColumn<?, ?> colFName;

    @FXML
    private TableColumn<?, ?> colLName;

    @FXML
    private TableColumn<?, ?> colLane;

    @FXML
    private TableColumn<?, ?> colStreet;

    @FXML
    private ImageView imgSearch;

    @FXML
    private TableView<?> tblCustomer;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtSearch;

    @FXML
    private TextField txtStreet;

    @FXML
    private TextField txtLane;

//    public void visibleFalse(){
//        txtBox2.setVisible(false);
//        btnUpdate.setVisible(false);
//        txtSearch.setVisible(false);
//        imgSearch.setVisible(false);
//        txtBox1.setVisible(false);
//        btnAdd.setVisible(false);
//    }
//
//    public void visibleTrue(){
//        txtBox2.setVisible(true);
//        btnUpdate.setVisible(true);
//        txtSearch.setVisible(true);
//        imgSearch.setVisible(true);
//        txtBox1.setVisible(true);
//        btnAdd.setVisible(true);
//    }

    public void initialize(){
        //LoadAllCustpmer();

    }

//    private void LoadAllCustpmer() {
//        try {
//            tblCustomer.getItems().clear();
//            ArrayList<CustomerTm> allICustomer = CustomerModel.getAllICustomer();
//            for (CustomerTm tm: allICustomer) {
//                tblCustomer.getItems().add(
//                        new CustomerTm(
//                                tm.getCustID(),
//                                tm.getFirstName(),
//                                tm.getLastName(),
//                                tm.getCity(),
//                                tm.getContact()
//                        )
//                );
//            }
//
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        }
//    }

    public void CustomerAddOnAction(ActionEvent actionEvent) throws ClassNotFoundException {
        //visibleFalse();
        //Navigation.onTheTopNavigation(pane, "CustomerAddForm.fxml");
        String id = txtId.getText();
        String fname = txtFirstName.getText();
        String lname = txtLastName.getText();
        String street = txtStreet.getText();
        String city = txtCity.getText();
        String lane = txtLane.getText();
        String contact = txtContact.getText();

        Customer customer = new Customer(id, fname, lname, street, city, lane, contact);

        try {
            boolean isSaved = CustomerModel.add(customer);
            if (isSaved) {
                AlertController.confirmmessage("Customer Added Successfully");
                txtId.setText("");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtStreet.setText("");
                txtCity.setText("");
                txtLane.setText("");
                txtContact.setText("");

                //getAll();
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "Duplicate Customer ID").show();
        } catch (SQLException e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
        }
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
        //visibleFalse();
        //Navigation.onTheTopNavigation(pane, "CustomerUpdateForm.fxml");
        String id = txtId.getText();
        String fname = txtFirstName.getText();
        String lname = txtLastName.getText();
        String street = txtStreet.getText();
        String city = txtCity.getText();
        String lane = txtLane.getText();
        String contact = txtContact.getText();

        try {
            Customer customer = new Customer(id, fname, lname,street,city,lane,contact);
            boolean isUpdated = CustomerModel.update(customer);
            if (isUpdated) {
                AlertController.confirmmessage("Customer Details Updated");
                txtId.setText("");
                txtFirstName.setText("");
                txtLastName.setText("");
                txtStreet.setText("");
                txtCity.setText("");
                txtLane.setText("");
                txtContact.setText("");

                //getAll();
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(e);
            AlertController.errormessage(e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
            AlertController.errormessage("something went wrong!");
        }
    }


    public void searchOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws ClassNotFoundException {
        String id = txtId.getText();

        boolean result = AlertController.okconfirmmessage("Are you sure you want to remove this customer?");
        if (result == true) {
            try {
                boolean isDeleted = CustomerModel.delete(id);
                if (isDeleted) {
                    AlertController.confirmmessage("Customer Deleted Successfully");
                    txtId.setText("");
                    txtFirstName.setText("");
                    txtLastName.setText("");
                    txtStreet.setText("");
                    txtCity.setText("");
                    txtLane.setText("");
                    txtContact.setText("");

                    //getAll();
                }
            } catch (SQLException e) {
                System.out.println(e);
                AlertController.errormessage("something went wrong!");
            }
        }
    }
}
