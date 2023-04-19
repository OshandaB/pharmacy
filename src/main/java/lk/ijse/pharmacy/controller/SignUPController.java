package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import lk.ijse.pharmacy.dto.User;
import lk.ijse.pharmacy.model.UserModel;
import lk.ijse.pharmacy.util.AlertController;
import lk.ijse.pharmacy.util.Navigation;

public class SignUPController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink AlreadyHaveAnAccountHyperLink;

    @FXML
    private TextField confirmPassword;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField passwordTxt;

    @FXML
    private JFXButton signUPBtn;

    @FXML
    private TextField userNameTxt;

    @FXML
    void hyperLinkOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("LoginUser.fxml",event);

    }

    @FXML
    void signBtnOnAction(ActionEvent event) {
         if(emailTxt.getText().isEmpty()|userNameTxt.getText().isEmpty()|passwordTxt.getText().isEmpty()|
                confirmPassword.getText().isEmpty()){
            AlertController.errormessage("please fill all empty fields before signup for a account");

        }else{
             String username = userNameTxt.getText();
             String password = passwordTxt.getText();
             String email = emailTxt.getText();

             User user = new User(username, password, email);

             if (passwordTxt.getText().equals(confirmPassword.getText())) {
                 boolean isSaved = false;
                 try {
                     isSaved = UserModel.save(user);
                     if (isSaved) {
                         System.out.println("saved");
                         signUPBtn.getScene().getWindow().hide();
                         emailTxt.setText("");
                         userNameTxt.setText("");
                         passwordTxt.setText("");
                         confirmPassword.setText("");

                     }
                 } catch (Exception throwables) {
                     throwables.printStackTrace();
                 }


             }

        }
    }

    @FXML
    void initialize() {


    }

}
