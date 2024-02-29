package Controller;

import entities.Utilisateur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import service.ServiceUtilisateur;
import utils.Session;

import java.io.IOException;
import java.sql.SQLException;

public class Login {
    @FXML
    private Label lbEmail;
    @FXML
    private ImageView loginimage;

    @FXML
    private TextField Email;

    @FXML
    private TextField mdp;

    private ServiceUtilisateur serviceUtilisateur = new ServiceUtilisateur();

    @FXML
    void LoginBT(ActionEvent event) {
        String email = Email.getText();
        String password = mdp.getText();

        try {
            Utilisateur user = serviceUtilisateur.login(email, password);
            if (user != null) {
                Session.getInstance().setUser(user);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/AfficherUtilisateurController.fxml"));
                try {
                    Parent root = loader.load();
                    lbEmail.getScene().setRoot(root);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                showAlert("Login Failed", "Invalid credentials. Please check your email and password.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
    @FXML
    void creeCompte(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/AjouterUtilisateurContoller.fxml"));
        try {
            Parent root = loader.load();
            lbEmail.getScene().setRoot(root);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void OnForget(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ForgetPassword.fxml"));
        try {
            Parent root = loader.load();
            lbEmail.getScene().setRoot(root);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

