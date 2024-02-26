package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import entities.Evenement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import services.ServiceEvenement;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
public class ShowEvent1 {

    @FXML
    private FlowPane event1Container;

    @FXML
    private AnchorPane eventPage1;
    private ServiceEvenement serviceEvenement = new ServiceEvenement();

    public void initialize() throws SQLException
    {
        List<Evenement>evenements=serviceEvenement.afficher();
        displayEvenement(evenements);
    }
    private void displayEvenement(List<Evenement> evenements)
    {
        for (Evenement evenement: evenements)
        {
        VBox card=createEventCard(evenement);
        event1Container.getChildren().add(card);
        }
    }
    public VBox createEventCard(Evenement evenement)
    {
        VBox card=new VBox();
        card.getStyleClass().add("evenement-card");
        Label idLabel= new Label("id_evenement : "+evenement.getId_event());
        Label nameLabel=new Label("Nom : "+evenement.getNom());
        Label dateLabel=new Label("Date :"+evenement.getDate());
        Label prixLabel=new Label("Prix : "+evenement.getPrix());
        card.getChildren().addAll(idLabel,nameLabel,dateLabel,prixLabel);
        card.setOnMouseClicked(event -> openEventDetailsPage(evenement));
        card.setCursor(Cursor.HAND);
        return card;

    }
public void openEventDetailsPage(Evenement evenement)
{
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("/ShowEventDetails1.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        ShowEventDetails1 controller = fxmlLoader.getController();
        controller.displayEventDetails(evenement);
        stage.setTitle("evenement Details");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    @FXML
    void EventPage(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("/ShowTerrain1.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) event1Container.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Evenement");
        stage.show();
    }

    @FXML
    void OnAjouter(ActionEvent event)throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("/AjouterEvent.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) event1Container.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Ajouter Evenement");
        stage.show();

    }

    @FXML
    void OnRefresh(ActionEvent event)throws SQLException {
        List<Evenement> products = serviceEvenement.afficher();
        event1Container.getChildren().clear();
        displayEvenement(products);

    }

    @FXML
    void modifierload(ActionEvent event) {
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/modifieEvent.fxml"));
        try{
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.showAndWait();
        }catch (IOException e){throw new RuntimeException(e);}
    }

}
