package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import lk.ijse.pharmacy.model.CustomerModel;
import lk.ijse.pharmacy.tm.CustomerTm;
import lk.ijse.pharmacy.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerFormController {
    private static CustomerFormController controller;
    public Pane pane;
    public Label txtBox2;
    public JFXButton btnUpdate;
    public TextField txtSearch;
    public ImageView imgSearch;
    public Label txtBox1;
    public JFXButton btnAdd;
    public TableView tblCustomer;
    public TableColumn colCusId;
    public TableColumn colFName;
    public TableColumn colLName;
    public TableColumn colCity;
    public TableColumn colDelete;
    public TableColumn colView;
    public TableColumn colContact;

    public void visibleFalse(){
        txtBox2.setVisible(false);
        btnUpdate.setVisible(false);
        txtSearch.setVisible(false);
        imgSearch.setVisible(false);
        txtBox1.setVisible(false);
        btnAdd.setVisible(false);
    }

    public void visibleTrue(){
        txtBox2.setVisible(true);
        btnUpdate.setVisible(true);
        txtSearch.setVisible(true);
        imgSearch.setVisible(true);
        txtBox1.setVisible(true);
        btnAdd.setVisible(true);
    }

    public void initialize(){
        colCusId.setCellValueFactory(new PropertyValueFactory<>("custID"));
        colFName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("custID"));
        colLName.setCellValueFactory(new PropertyValueFactory<>("custID"));
        
        LoadAllCustpmer();

    }

    private void LoadAllCustpmer() {
        try {
            tblCustomer.getItems().clear();
            ArrayList<CustomerTm> allICustomer = CustomerModel.getAllICustomer();
            for (CustomerTm tm: allICustomer) {
                tblCustomer.getItems().add(
                        new CustomerTm(
                                tm.getCustID(),
                                tm.getFirstName(),
                                tm.getLastName(),
                                tm.getCity(),
                                tm.getContact()
                        )
                );
            }
            
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public CustomerFormController() {
        controller = this;
    }

    public static CustomerFormController getInstance() {
        return controller;
    }

    public void CustomerAddOnAction(ActionEvent actionEvent) {
        visibleFalse();
        Navigation.onTheTopNavigation(pane, "CustomerAddForm.fxml");
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {

        visibleFalse();
        Navigation.onTheTopNavigation(pane, "CustomerUpdateForm.fxml");
       /* try {
            Navigation.popupNavigation("CustomerUpdateForm.fxml");
        } catch (IOException e) {


        }*/
    }


    public void searchOnAction(ActionEvent actionEvent) {
    }
}
