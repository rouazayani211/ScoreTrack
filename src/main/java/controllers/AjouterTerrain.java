package controllers;

import entities.Terrain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.ServiceTerrain;
import javafx.scene.Scene;
import java.io.IOException;
import java.sql.SQLException;
import javafx.stage.Stage;
public class AjouterTerrain {

    @FXML
    private Button ajouter_button_ev;

    @FXML
    private TextField capacitet;

    @FXML
    private TextField idt;

    @FXML
    private TextField localisationt;

    @FXML
    private TextField nomt;
    private final ServiceTerrain ST=new ServiceTerrain();
    @FXML
    void afficherbtn(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ShowTerrain1.fxml"));
        try {
            Parent root = loader.load();

            nomt.getScene().setRoot(root);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    void ajoutereq(ActionEvent event) {
        try {
            ST.ajouter(new Terrain(Integer.parseInt(idt.getText()), nomt.getText(), localisationt.getText(), Integer.parseInt(capacitet.getText())));
        }catch (SQLException e){throw new RuntimeException(e);}
    }

}
