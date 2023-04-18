package lk.ijse.pharmacy.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import lk.ijse.pharmacy.util.Navigation;

import java.io.IOException;

public class LoginUserController {

    public JFXTextField txtUser;
    public JFXTextField txtPassword;


    public void loginOnAction(ActionEvent actionEvent) {
        try {
            Navigation.switchNavigation("Dashboard.fxml",actionEvent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}