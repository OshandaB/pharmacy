package lk.ijse.pharmacy.controller;

import javafx.event.ActionEvent;
import lk.ijse.pharmacy.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;

public class ReportsFormController {



    public void btnOnCustomerDetaiils(ActionEvent event) {
        InputStream resource = this.getClass().getResourceAsStream("/reports/custome.jrxml");



        {
            try {
                JasperReport jasperReport = JasperCompileManager.compileReport(resource);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
                JasperViewer.viewReport(jasperPrint, false);
            } catch (JRException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
