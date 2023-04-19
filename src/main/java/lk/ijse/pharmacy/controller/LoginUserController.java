package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import lk.ijse.pharmacy.dto.User;
import lk.ijse.pharmacy.model.UserModel;
import lk.ijse.pharmacy.util.AlertController;
import lk.ijse.pharmacy.util.Navigation;

public class LoginUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Hyperlink dontHaveAnAccountHyperLink;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private TextField passwordTxt;

    @FXML
    private TextField userNameTxt;

    String username;
    String password;
    String userr;

    @FXML
    void hyperLinkOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("signUpForm.fxml",event);

    }

    @FXML
    void loginOnAction(ActionEvent event) {
        username = userNameTxt.getText();
        password = null;
        try {
            User user = UserModel.SearchById(username);
            password = user.getPassword();
            userr = user.getUsername();
        } catch (Exception e) {
        }
        if (passwordTxt.getText().equals(password) ) {
            AlertController.animationMesseage("/img/tick.gif", "Login",
                    "Login succesfull !!");
            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event1 -> {
                loginBtn.getScene().getWindow().hide();

                try {
                    Navigation.switchNavigation("Dashboard.fxml",event);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }));
            timeline.play();
        }else if (userNameTxt.getText().isEmpty() && passwordTxt.getText().isEmpty()) {
            AlertController.errormessage("Username field and Password field can't be empty");
            passwordTxt.setStyle("-fx-border-color: red; -fx-border-width: 3 3 3 3;");
            userNameTxt.setStyle("-fx-border-color: red; -fx-border-width: 3 3 3 3;");


        }else if (!userNameTxt.getText().equals(userr) && !passwordTxt.getText().equals(password)) {
            AlertController.errormessage("Username or password is incorrect.please check your details again!!");
            userNameTxt.setStyle("-fx-border-color: #dfa47e; -fx-border-width: 3 3 3 3;");
            passwordTxt.setStyle("-fx-border-color: red; -fx-border-width: 3 3 3 3;");


        }

    }

    @FXML
    void initialize() {

    }

}
