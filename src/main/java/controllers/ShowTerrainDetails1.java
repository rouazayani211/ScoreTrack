package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import entities.Terrain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.ServiceTerrain;

import java.sql.SQLException;
import java.io.IOException;
public class ShowTerrainDetails1 {

    @FXML
    private Label capaciteLabel;

    @FXML
    private Label idLabel;

    @FXML
    private Label localisationLabel;

    @FXML
    private Label nomLabel;
    private ServiceTerrain service=new ServiceTerrain();
    private Terrain terrains;
    public void displayTerrainDetails(Terrain terrain)
    {
        terrains=terrain;
        idLabel.setText("Id :"+terrains.getId_terrain());
        nomLabel.setText("nom :"+terrains.getNom());
        localisationLabel.setText("localisation :"+terrains.getLocalisation());
        capaciteLabel.setText("capacite :"+terrains.getCapacite());

    }
    @FXML
    void handleDelete(ActionEvent actionEvent)throws SQLException {
        service.supprimer(terrains);
        Stage stage = (Stage) idLabel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handleEdit(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("/modifierTerrain.fxml"));
            Parent root = fxmlLoader.load();
            modifierTerrain modifierJoueurController = fxmlLoader.getController();
            modifierJoueurController.setterrain(terrains);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Edit terrain");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
