package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;
import entities.Evenement;
import javafx.stage.Stage;
import services.ServiceEvenement;
public class modifieEvent {

    @FXML
    private DatePicker dateev;

    @FXML
    private TextField idev;

    @FXML
    private Button modifier_button_eq;

    @FXML
    private TextField nomev;

    @FXML
    private TextField prixev;

    @FXML
    void modifierreq(ActionEvent event) {
        int id=Integer.parseInt(idev.getText());
        String nom=nomev.getText();
        Date date=Date.valueOf(dateev.getValue());
        Float prix=Float.parseFloat(prixev.getText());
        Evenement evenement = new Evenement(id,nom,date,prix);
        ServiceEvenement SE = new ServiceEvenement();
        try {
            SE.modifier(evenement);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("evenement mise à jour avec succès!!");
            alert.show();
            // Close the ModifierDebt window
            Stage stage = (Stage) nomev.getScene().getWindow();
            stage.close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
public void setevent(Evenement evenement) {
idev.setText(String.valueOf(evenement.getId_event()));
nomev.setText(String.valueOf(evenement.getNom()));
dateev.setValue(evenement.getDate().toLocalDate());
prixev.setText(String.valueOf(evenement.getPrix()));
}
    @FXML
    void initialize() {
    }


}
