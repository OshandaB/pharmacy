package lk.ijse.pharmacy.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import lk.ijse.pharmacy.util.Navigation;

public class DashboardFormController {


    public Pane pane;

    public void btnCustomerOnAction(ActionEvent actionEvent) {
        Navigation.onTheTopNavigation(pane, "Customer.fxml");
    }

    public void btnEmployeeOnAction(ActionEvent actionEvent) {
        Navigation.onTheTopNavigation(pane, "Employee.fxml");

    }

    public void btnSupplierOnAction(ActionEvent actionEvent) {
        Navigation.onTheTopNavigation(pane, "Supplier.fxml");

    }

    public void btnOrderOnAction(ActionEvent actionEvent) {
        Navigation.onTheTopNavigation(pane, "Order.fxml");

    }

    public void btnItemOnAction(ActionEvent actionEvent) {
        Navigation.onTheTopNavigation(pane, "Item.fxml");
    }

    public void btnBillFormOnAction(ActionEvent actionEvent) {
        Navigation.onTheTopNavigation(pane, "Bill.fxml");
    }

//    public void btnHomeOnaction(ActionEvent actionEvent) {
//        Navigation.onTheTopNavigation(pane, "Dashboard.fxml");
//
//    }

    @FXML
    void btnHomeOnAction(ActionEvent event) {
        Navigation.onTheTopNavigation(pane, "Dashboard1.fxml");
    }

    public void EmployeeAddOnAction(ActionEvent actionEvent) {
    }
}






