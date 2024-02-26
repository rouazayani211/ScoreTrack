package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;
import entities.Terrain;
import javafx.stage.Stage;
import services.ServiceTerrain;
public class modifierTerrain {

    @FXML
    private TextField capacitet;

    @FXML
    private TextField idt;

    @FXML
    private TextField localisationt;

    @FXML
    private Button modifier_button_eq;

    @FXML
    private TextField nomt;

    @FXML
    void modifierreq(ActionEvent event) {
        // Get the values from the UI components
        //  int id = Integer.parseInt(IdTextField.getText());
        int id=Integer.parseInt(idt.getText());
        String nom=nomt.getText();
        String localisation=localisationt.getText();
        int capacite=Integer.parseInt(capacitet.getText());

        // Create a new Debt object with the retrieved values
        Terrain terrain = new Terrain(id,nom,localisation,capacite);
        // Update the Debt object in the database
        ServiceTerrain ST = new ServiceTerrain();
        try {
            ST.modifier(terrain);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("terrain mise à jour avec succès!!");
            alert.show();
            // Close the ModifierDebt window
            Stage stage = (Stage) nomt.getScene().getWindow();
            stage.close();
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }
    public void setterrain(Terrain terrain) {
        idt.setText(String.valueOf(terrain.getId_terrain()));
        nomt.setText(String.valueOf(terrain.getNom()));
        localisationt.setText(String.valueOf(terrain.getLocalisation()));
        capacitet.setText(String.valueOf(terrain.getCapacite()));
    }

    @FXML
    void initialize() {
    }

}
