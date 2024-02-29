package Controller;

import entities.Utilisateur;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import service.ServiceUtilisateur;
import utils.Session;

import java.io.IOException;
import java.sql.SQLException;

public class AfficherUtilisateurController {
    @FXML
    private ListView<Utilisateur> labelfromdb;

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField dateNaissField;
    @FXML
    private TextField emailField;
    @FXML
    public TextField roleField;
    @FXML
    public TextField mdpField;

    ServiceUtilisateur SU = new ServiceUtilisateur();

    public void initialize() {
        try {
            labelfromdb.setItems(FXCollections.observableArrayList(SU.Afficher()));
            labelfromdb.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            labelfromdb.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    updateFields(newValue);
                }
            });
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private void updateFields(Utilisateur utilisateur) {
        nomField.setText(utilisateur.getNom());
        prenomField.setText(utilisateur.getPrenom());
        dateNaissField.setText(utilisateur.getDate_naiss());
        emailField.setText(utilisateur.getEmail());
        roleField.setText(utilisateur.getRole());
        mdpField.setText(utilisateur.getMdp());
    }

    @FXML
    void AfficherDB(ActionEvent event) {
        try {
            labelfromdb.setItems(FXCollections.observableArrayList(SU.Afficher()));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void SupprimerUtilisateur(ActionEvent event) {
        Utilisateur selectedUtilisateur = labelfromdb.getSelectionModel().getSelectedItem();
        if (selectedUtilisateur != null) {
            int id = selectedUtilisateur.getId();

            try {
                SU.Supprimer(new Utilisateur(id));
                AfficherDB(event);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Aucun élément sélectionné.");
        }
    }

    public void OnLogout(ActionEvent actionEvent) {
        Session.getInstance().logout();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
        try {
            Parent root = loader.load();
            labelfromdb.getScene().setRoot(root);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void UpdateUtilisateur(ActionEvent event) {
        Utilisateur selectedUtilisateur = labelfromdb.getSelectionModel().getSelectedItem();
        if (selectedUtilisateur != null) {
            try {
                int id = selectedUtilisateur.getId();
                Utilisateur updatedUtilisateur = getUpdatedUtilisateur(selectedUtilisateur);
                updatedUtilisateur.setId(id);
                SU.Modifier(updatedUtilisateur);
                AfficherDB(event);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Aucun élément sélectionné");
        }
    }
    private Utilisateur getUpdatedUtilisateur(Utilisateur utilisateur) {
        String updatedNom = nomField.getText().trim();
        String updatedPrenom = prenomField.getText().trim();
        String updatedDateNaiss = dateNaissField.getText().trim();
        String updatedEmail = emailField.getText().trim();
        String updatedRole = roleField.getText().trim();
        String updatedMdp = mdpField.getText().trim();

        if (!updatedNom.isEmpty()) {
            utilisateur.setNom(updatedNom);
        }
        if (!updatedPrenom.isEmpty()) {
            utilisateur.setPrenom(updatedPrenom);
        }
        if (!updatedDateNaiss.isEmpty()) {
            utilisateur.setDate_naiss(updatedDateNaiss);
        }
        if (!updatedEmail.isEmpty() && updatedEmail.contains("@")) {
            utilisateur.setEmail(updatedEmail);
        } else {
            System.out.println("email non valide ");
        }
        if (!updatedRole.isEmpty()) {
            utilisateur.setRole(updatedRole);
        }
        if (!updatedMdp.isEmpty()) {
            utilisateur.setMdp(updatedMdp);
        }
        return utilisateur;
    }
}
