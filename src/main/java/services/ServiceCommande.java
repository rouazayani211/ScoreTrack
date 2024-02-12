package services;

import entities.Commande;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceCommande implements  IService<Commande>{
    private Connection connection;
    public ServiceCommande() {
        connection = MyDB.getInstance().getConnection();
    }
    @Override
    public void ajouter(Commande commande) throws SQLException {
        String req = "INSERT INTO commande (id_produit, date_commande, montant_total, mode_paiement, adresse_livraison) " +
                "VALUES ('" + commande.getId_produit() + "', '" + commande.getDate_commande() + "', '" + commande.getMontant_total() + "', '" + commande.getMode_paiement() + "', '" + commande.getAdresse_livraison() + "')";

        Statement ste = connection.createStatement();
        ste.executeUpdate(req);
    }

    @Override
    public void modifier(Commande commande) throws SQLException {
        String req = "update commande set id_produit=?  ,date_commande=?,montant_total=? ,mode_paiement=?,adresse_livraison=? where id_commande=? ";
        PreparedStatement pre = connection.prepareStatement(req);
        pre.setInt(1, commande.getId_produit());
        pre.setString(2, commande.getDate_commande());
        pre.setInt(3, commande.getMontant_total());
        pre.setString(4, commande.getMode_paiement());
        pre.setString(5, commande.getAdresse_livraison());
        pre.setInt(6, commande.getId_commande());
        pre.executeUpdate();

    }

    @Override
    public void supprimer(Commande commande) throws SQLException {
        String req="delete from commande where id_commande=?";
        PreparedStatement pre = connection.prepareStatement(req);
        pre.setInt(1, commande.getId_commande());
        pre.executeUpdate();

    }

    @Override
    public List<Commande> afficher() throws SQLException {
        String req = "select * from commande";
        Statement ste = connection.createStatement();
        ResultSet res = ste.executeQuery(req);
        List<Commande> list = new ArrayList<>();
        while (res.next()) {
            Commande c = new Commande();
            c.setId_commande(res.getInt(1));
            c.setId_produit(res.getInt(2));
            c.setDate_commande(res.getString("date_commande"));
            c.setMontant_total(res.getInt(4));
            c.setMode_paiement(res.getString("mode_paiement"));
            c.setAdresse_livraison(res.getString("adresse_livraison"));
            list.add(c);
        }
        return null;
    }


}




