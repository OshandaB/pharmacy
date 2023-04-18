package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.pharmacy.dto.Employee;
import lk.ijse.pharmacy.model.EmployeeModel;
import lk.ijse.pharmacy.tm.EmployeeTm;
import lk.ijse.pharmacy.util.AlertController;

public class EmployeeFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private TableColumn<?, ?> colEmpId;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colLane;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colStreet;

    @FXML
    private TableView<EmployeeTm> tblEmployee;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtEmployeeId;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLane;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtSearchId;

    @FXML
    private TextField txtStreet;

    private Employee employee;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        employee.setEmpId(txtEmployeeId.getText());
        employee.setFirstName(txtFirstName.getText());
        employee.setLastName(txtLastName.getText());
        employee.setStreet(txtStreet.getText());
        employee.setCity(txtCity.getText());
        employee.setLane(txtLane.getText());
        employee.setContact(txtContact.getText());

        try {
            boolean isSaved = EmployeeModel.save(employee);

            if(isSaved){
                setCellValueFactory();
                getAll();
                clearTxtField();
                AlertController.confirmmessage("Employee added successfuly");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        employee.setEmpId(txtEmployeeId.getText());
        employee.setFirstName(txtFirstName.getText());
        employee.setLastName(txtLastName.getText());
        employee.setStreet(txtStreet.getText());
        employee.setCity(txtCity.getText());
        employee.setLane(txtLane.getText());
        employee.setContact(txtContact.getText());

        try {
            boolean isUpdated = EmployeeModel.update(employee);
            if(isUpdated) {
                setCellValueFactory();
                getAll();
                clearTxtField();
                AlertController.confirmmessage("Employee updated successfuly");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void imgSearchIconOnMouseClickedAction(MouseEvent event) {

    }

    @FXML
    void tableOnMouseClickedAction(MouseEvent event) {

    }

    @FXML
    void txtSearchIdOnAction(ActionEvent event) {
    }

    @FXML
    void initialize() {
        employee = new Employee();

        setCellValueFactory();
        getAll();
    }

    private void setCellValueFactory() {
        colEmpId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colStreet.setCellValueFactory(new PropertyValueFactory<>("street"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colLane.setCellValueFactory(new PropertyValueFactory<>("lane"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
    }

    private void getAll() {
        ObservableList<EmployeeTm> obList = FXCollections.observableArrayList();
        try{
            List<Employee> allData = EmployeeModel.getAll();

            for(Employee employee : allData){
                obList.add(new EmployeeTm(
                        employee.getEmpId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getStreet(),
                        employee.getCity(),
                        employee.getLane(),
                        employee.getContact()
                ));
            }
            tblEmployee.setItems(obList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void clearTxtField() {
//        txtEmployeeId.setText("");
//        txtFirstName.setText("");
//        txtLastName.setText("");
//        txtStreet.setText("");
//        txtCity.setText("");
//        txtLane.setText("");
//        txtContact.setText("");
    }
}
