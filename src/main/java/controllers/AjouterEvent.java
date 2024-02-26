package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import entities.Evenement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import services.ServiceEvenement;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class AjouterEvent {

    @FXML
    private DatePicker dateev;

    @FXML
    private TextField idev;

    @FXML
    private TextField nomev;

    @FXML
    private TextField prixev;
private final ServiceEvenement SE=new ServiceEvenement();
    @FXML
    void afficherbtn(ActionEvent event) {
        FXMLLoader loader= new FXMLLoader(getClass().getResource("/ShowEvent1.fxml"));
        try{
            Parent root=loader.load();

            nomev.getScene().setRoot(root);

        }catch (IOException e){System.out.println(e.getMessage());}

    }


    @FXML
    void ajoutereq(ActionEvent event) {
        try {
            SE.ajouter(new Evenement(Integer.parseInt(idev.getText()),nomev.getText(), Date.valueOf(dateev.getValue()), Float.parseFloat(prixev.getText())));

        }catch (SQLException e){throw new RuntimeException(e);}
    }
    }


