package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import entities.Evenement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.ServiceEvenement;

import java.sql.SQLException;
import java.io.IOException;
public class ShowEventDetails1 {

    @FXML
    private Label idLabel;

    @FXML
    private Label nomLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label prixLabel;

private ServiceEvenement service= new ServiceEvenement();
private Evenement evenements;
public void displayEventDetails(Evenement evenement)
{
evenements=evenement;
idLabel.setText("ID : "+evenements.getId_event());
nomLabel.setText("Nom : "+evenements.getNom());
dateLabel.setText("Date :"+evenements.getDate());
prixLabel.setText(("Prix : "+evenements.getPrix()));
}
    @FXML
    void handleDelete(ActionEvent actionEvent) throws SQLException {
        service.supprimer(evenements);
        Stage stage = (Stage) nomLabel.getScene().getWindow();
        stage.close();
    }

    @FXML
    void handleEdit(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainFX.class.getResource("/modifieEvent.fxml"));
            Parent root = fxmlLoader.load();
            modifieEvent ModifieEvent = fxmlLoader.getController();
           ModifieEvent.setevent(evenements);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Edit event");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
