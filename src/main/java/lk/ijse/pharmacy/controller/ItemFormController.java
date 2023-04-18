package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.pharmacy.dto.Item;
import lk.ijse.pharmacy.model.ItemModel;
import lk.ijse.pharmacy.tm.ItemTM;

import java.sql.SQLException;

public class ItemFormController {

    @FXML
    private TableView<ItemTM> mainCOMItem;

    @FXML
    private TableColumn<?, ?> tblMedId;

    @FXML
    private TableColumn<?, ?> tblMedNmae;

    @FXML
    private TableColumn<?, ?> tbltype;

    @FXML
    private TableColumn<?, ?> tblQuantityOnHands;

    @FXML
    private TableColumn<?, ?> tblmfgDate;

    @FXML
    private TableColumn<?, ?> tblexpDate;

    @FXML
    private JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtItemMedName;

    @FXML
    private JFXTextField txtItemType;

    @FXML
    private JFXTextField txtItemDate;

    @FXML
    private JFXTextField txtItemQOH;

    @FXML
    private JFXTextField txtItemmfgDate;

    @FXML
    private TextField txtsearchItem;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {


        String ItemCode = txtItemCode.getText();

                try {
                    boolean isDeleted = ItemModel.delete(ItemCode);
                    if (isDeleted) {
                        new Alert(Alert.AlertType.CONFIRMATION,"Customer deleted!").show();

                        onActionGetAllItem();
                    }
                } catch (SQLException e) {
                    new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
                }

            }
    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String ItemCode = txtItemCode.getText();
        String ItemMedName = txtItemMedName.getText();
        String ItemType = txtItemType.getText();
        String ItemQOH = txtItemQOH.getText();
        String ItemDate = txtItemDate.getText();
        String ItemmfgDate = txtItemmfgDate.getText();

        Item itemAll = new Item(ItemCode, ItemMedName, ItemType,ItemDate,ItemQOH,ItemmfgDate);

        try {
            boolean isUpdated = ItemModel.update(itemAll);
           // AlertController.animationMesseageCorect("CONFIRMATION","Item updated!");
            new Alert(Alert.AlertType.CONFIRMATION,"Customer updated!").show();
            onActionGetAllItem();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
           // AlertController.animationMesseagewrong("Error","something went wrong!");
        }

    }

    @FXML
    void buttonSaveOnACT(ActionEvent event) {
        String ItemCode = txtItemCode.getText();
        String ItemMedName = txtItemMedName.getText();
        String ItemType = txtItemType.getText();
        String ItemQOH = txtItemQOH.getText();
        String ItemDate = txtItemDate.getText();
        String ItemmfgDate = txtItemmfgDate.getText();

        Item itemAll = new Item(ItemCode, ItemMedName, ItemType,ItemDate,ItemQOH,ItemmfgDate);

        try {
//            boolean isSaved = ItemModel.save(code, description, unitPrice, qtyOnHand);
            boolean isSaved = ItemModel.save(itemAll);
            if (isSaved) {

                new Alert(Alert.AlertType.CONFIRMATION,"Customer Added!").show();
                onActionGetAllItem();
                System.out.println("dsfgdfg");
            }
        } catch (SQLException e) {
            System.out.println(e);
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
           // AlertController.animationMesseagewrong("Error","something went wrong!");

        }

    }

    @FXML
    void itemIdOnAction(ActionEvent event) {

    }

    @FXML
    void itemOnMouse(MouseEvent event) {
        TablePosition pos=mainCOMItem.getSelectionModel().getSelectedCells().get(0);
        int row=pos.getRow();

        ObservableList<TableColumn<ItemTM,?>> columns=mainCOMItem.getColumns();

        txtItemCode.setText(columns.get(0).getCellData(row).toString());
        txtItemMedName.setText(columns.get(1).getCellData(row).toString());
        txtItemType.setText(columns.get(2).getCellData(row).toString());
        txtItemQOH.setText(columns.get(3).getCellData(row).toString());
        txtItemmfgDate.setText(columns.get(4).getCellData(row).toString());
        txtItemDate.setText(columns.get(5).getCellData(row).toString());


    }

    @FXML
    void searchItemOnKey(KeyEvent event) {

    }
    @FXML
    void initialize() {
        onActionGetAllItem();
        setCellValuefactory();

    }

    void onActionGetAllItem() {
        try {
            ObservableList<ItemTM> supList = ItemModel.getAll();
            mainCOMItem.setItems(supList);


        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "something went wrong!").show();
            //AlertController.animationMesseagewrong("Error","something went wrong!");
        }

    }

    void setCellValuefactory(){
        tblMedId.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        tblMedNmae.setCellValueFactory(new PropertyValueFactory<>("ItemMedName"));
        tbltype.setCellValueFactory(new PropertyValueFactory<>("ItemType"));
        tblQuantityOnHands.setCellValueFactory(new PropertyValueFactory<>("ItemQOH"));
        tblmfgDate.setCellValueFactory(new PropertyValueFactory<>("ItemmfgDate"));
        tblexpDate.setCellValueFactory(new PropertyValueFactory<>("ItemDate"));

    }

}
