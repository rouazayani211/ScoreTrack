package service;

import entities.Utilisateur;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceUtilisateur implements IService<Utilisateur>{
    private Connection connection;
    public ServiceUtilisateur(){
        connection= MyDB.getInstance().getConnection();
    }

    @Override
    public void Ajouter(Utilisateur utilisateur) throws SQLException {
        String req = "insert into utilisateur (nom, prenom, date_naiss, email,mdp, role)" +
                " VALUES (?, ?, ?, ?, ?,?)";

        try (PreparedStatement pre = connection.prepareStatement(req)) {
            pre.setString(1, utilisateur.getNom());
            pre.setString(2, utilisateur.getPrenom());
            pre.setString(3, String.valueOf(utilisateur.getDate_naiss()));
            pre.setString(4, utilisateur.getEmail());
            pre.setString(5, utilisateur.getMdp());
            pre.setString(6, "admin");

            pre.executeUpdate();
        }


    }
    public void changePassword(String email, String newPassword) throws SQLException {
        if (doesEmailExist(email)) {
            String req = "UPDATE utilisateur SET mdp = ? WHERE email = ?";
            try (PreparedStatement pre = connection.prepareStatement(req)) {
                pre.setString(1, newPassword);
                pre.setString(2, email);

                pre.executeUpdate();
            }
        } else {
            // Handle the case where the email does not exist
            throw new SQLException("Email not found.");
        }
    }

    @Override
    public void Modifier(Utilisateur utilisateur) throws SQLException {
        String req="update utilisateur set nom =?,prenom=?,date_naiss=?,email=?,mdp=? ,role=? where id=?";
        System.out.println(utilisateur);
        PreparedStatement pre =connection.prepareStatement(req);
        pre.setString(1,utilisateur.getPrenom());
        pre.setString(2,utilisateur.getPrenom());
        pre.setString(3,utilisateur.getDate_naiss().toString());
        pre.setString(4,utilisateur.getEmail());
        pre.setString(5,utilisateur.getMdp());
        pre.setString(6,"admin");
        pre.setInt(7,utilisateur.getId());
        pre.executeUpdate();
    }

    @Override
    public void Supprimer(Utilisateur utilisateur) throws SQLException {
        String req="delete from utilisateur where id=?";
        PreparedStatement pre = connection.prepareStatement(req);
        pre.setInt(1,utilisateur.getId());
        pre.executeUpdate();

    }

    @Override
    public List<Utilisateur> Afficher() throws SQLException {
        String req="select * from utilisateur";
        Statement ste= connection.createStatement();
        ResultSet res= ste.executeQuery(req);
        List<Utilisateur> list =new ArrayList<>();
        while (res.next()){
            Utilisateur u = new Utilisateur();
            u.setId(res.getInt(1));
            u.setNom(res.getString(2));
            u.setPrenom(res.getString(3));
            u.setDate_naiss(res.getString("date_naiss"));
            u.setEmail(res.getString("email"));
            u.setMdp(res.getString("mdp"));
            u.setRole(res.getString("role"));
            list.add(u);
        }
        return list;
    }

    public boolean doesEmailExist(String email) throws SQLException {
        String req = "SELECT * FROM utilisateur WHERE email=?";
        try (PreparedStatement pre = connection.prepareStatement(req)) {
            pre.setString(1, email);

            ResultSet res = pre.executeQuery();
            return res.next();
        }
    }
    public Utilisateur login(String email, String mdp) throws SQLException {
        String req = "SELECT * FROM utilisateur WHERE email=? AND mdp=?";
        try (PreparedStatement pre = connection.prepareStatement(req)) {
            pre.setString(1, email);
            pre.setString(2, mdp);

            ResultSet res = pre.executeQuery();
            if (res.next()) {
                Utilisateur user = new Utilisateur();
                user.setId(res.getInt(1));
                user.setNom(res.getString(2));
                user.setPrenom(res.getString(3));
                user.setDate_naiss(res.getString(4));
                user.setEmail(res.getString(5));
                user.setMdp(res.getString(6));
                user.setRole(res.getString(7));
                return user;
            }
        }
        return null;
    }


}
