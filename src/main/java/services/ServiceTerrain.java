package services;


import entities.Terrain;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceTerrain implements IService<Terrain> {
    private Connection connection;

    public ServiceTerrain(){
        connection= MyDB.getInstance().getConnection();
    }
    @Override
    public void ajouter(Terrain terrain) throws SQLException {
        String req ="insert into terrain (nom,localisation,capacite)"+
                "values('"+terrain.getNom()+"','"+terrain.getLocalisation()+"',"+terrain.getCapacite()+")";
        Statement ste= connection.createStatement();

        ste.executeUpdate(req);
    }

    @Override
    public void modifier(Terrain terrain) throws SQLException {
        String req = "update terrain set nom=? , localisation=? , capacite=? where id_terrain=?";
        PreparedStatement pre = connection.prepareStatement(req);
        pre.setString(1,terrain.getNom());
        pre.setString(2,terrain.getLocalisation());
        pre.setInt(3,terrain.getCapacite());
        pre.setInt(4,terrain.getId_terrain());

        pre.executeUpdate();

    }

    @Override
    public void supprimer(Terrain terrain) throws SQLException {

        String req = " delete from terrain where id_terrain=?";
        PreparedStatement pre = connection.prepareStatement(req);
        pre.setInt(1,terrain.getId_terrain());
        pre.executeUpdate();

    }

    @Override
    public List<Terrain> afficher() throws SQLException {

        String req = "select * from terrain";
        Statement ste = connection.createStatement();
        ResultSet res = ste.executeQuery(req);
        List<Terrain> list =new ArrayList<>();
        while (res.next()){
            Terrain t = new Terrain();
            t.setId_terrain(res.getInt(1));
            t.setNom(res.getString("nom"));
            t.setLocalisation(res.getString("localisation"));
            t.setCapacite(res.getInt(4));

            list.add(t);
        }
        return list;
    }
}
