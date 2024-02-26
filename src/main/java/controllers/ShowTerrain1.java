package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

import entities.Terrain;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ServiceTerrain;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
public class ShowTerrain1 {

    @FXML
    private FlowPane terrain1Container;

    @FXML
    private AnchorPane terrainPage1;
    private ServiceTerrain serviceTerrain=new ServiceTerrain();

    public void initialize()throws SQLException
    {
        List<Terrain>terrains=serviceTerrain.afficher();
        displayTerrains(terrains);
    }
    private void displayTerrains(List<Terrain> terrains)
    {
        for(Terrain terrain: terrains)
        {
            VBox card=createTerrainCard(terrain);
            terrain1Container.getChildren().add(card);
        }
    }
    public VBox createTerrainCard(Terrain terrain)
    {
        VBox card=new VBox();
        card.getStyleClass().add("terrain-card");
        Label idLabel=new Label("id_terrain :"+terrain.getId_terrain());
        Label nameLabel=new Label("Nom :"+terrain.getNom());
        Label localisationLabel=new Label("localisation :"+terrain.getLocalisation());
        Label capaciteLabel=new Label("capacite :"+terrain.getCapacite());
        card.getChildren().addAll(idLabel,nameLabel, localisationLabel, capaciteLabel);
        card.setOnMouseClicked(event -> openTerrainDetailsPage(terrain));
        card.setCursor(Cursor.HAND);
        return card;
    }
    private void openTerrainDetailsPage(Terrain terrain)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("/ShowTerrainDetails1.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            ShowTerrainDetails1 controller = fxmlLoader.getController();
            controller.displayTerrainDetails(terrain);
            stage.setTitle("Terrain Details");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void OnAjouter(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("/AjouterTerrain.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) terrain1Container.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Ajouter Terrain");
        stage.show();

    }

    @FXML
    void OnRefresh(ActionEvent actionEvent) throws SQLException {
        List<Terrain> products = serviceTerrain.afficher();
        terrain1Container.getChildren().clear();
        displayTerrains(products);
    }

    @FXML
    void TerrainPage(ActionEvent actionEvent)throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("/ShowEvent1.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) terrain1Container.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Terrain");
        stage.show();

    }

    @FXML
    void modifierload(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/modifierTerrain.fxml"));
        try{
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.showAndWait();
        }catch (IOException e){throw new RuntimeException(e);}
    }
    }


