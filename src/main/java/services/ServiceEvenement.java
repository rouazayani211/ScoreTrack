package services;
import entities.Evenement;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ServiceEvenement implements IService<Evenement>{
    private Connection connection;

    public ServiceEvenement(){
        connection= MyDB.getInstance().getConnection();
    }
    @Override
    public void ajouter(Evenement evenement) throws SQLException {
        String req ="insert into evenement (nom,date,prix)"+
                "values('"+evenement.getNom()+"','"+evenement.getDate()+"',"+evenement.getPrix()+")";
        Statement ste= connection.createStatement();

        ste.executeUpdate(req);
    }

    @Override
    public void modifier(Evenement evenement) throws SQLException {
        String req = "update evenement set nom=? , date=? , prix=? where id_event=?";
        PreparedStatement pre = connection.prepareStatement(req);
        pre.setString(1,evenement.getNom());
        pre.setDate(2,evenement.getDate());
        pre.setFloat(3,evenement.getPrix());
        pre.setInt(4,evenement.getId_event());

        pre.executeUpdate();

    }

    @Override
    public void supprimer(Evenement evenement) throws SQLException {

        String req = " delete from evenement where id_event=?";
        PreparedStatement pre = connection.prepareStatement(req);
        pre.setInt(1,evenement.getId_event());
        pre.executeUpdate();

    }

    @Override
    public List<Evenement> afficher() throws SQLException {

        String req = "select * from evenement";
        Statement ste = connection.createStatement();
        ResultSet res = ste.executeQuery(req);
        List<Evenement> list =new ArrayList<>();
        while (res.next()){
            Evenement ev = new Evenement();
            ev.setId_event(res.getInt(1));
            ev.setNom(res.getString("nom"));
            ev.setDate(res.getDate(3));
            ev.setPrix(res.getFloat(4));

            list.add(ev);
        }
        return list;
    }

}
