package services;

import entities.Reservation;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceReservation  implements IService<Reservation>   {

    private Connection connection;

    public ServiceReservation(){
        connection= MyDB.getInstance().getConnection();
    }
    public void ajouter(Reservation reservation) throws SQLException {
        String req ="insert into reserevation (idUser,date)"+
                "values('"+reservation.getIdUser()+"',"+reservation.getDate()+")";
        Statement ste= connection.createStatement();

        ste.executeUpdate(req);
    }

    public void supprimer(Reservation reservation) throws SQLException {

        String req = " delete from reserevation where idReservation=?";
        PreparedStatement pre = connection.prepareStatement(req);
        pre.setInt(1,reservation.getIdReservation());
        pre.executeUpdate();

    }

    public List<Reservation> afficher() throws SQLException {

        String req = "select * from reserevation";
        Statement ste = connection.createStatement();
        ResultSet res = ste.executeQuery(req);
        List<Reservation> list =new ArrayList<>();
        while (res.next()){
            Reservation p = new Reservation();
            p.setIdReservation(res.getInt(1));
            p.setIdUser(res.getInt(2));
            p.setDate(res.getString(3));

            list.add(p);
        }
        return list;
    }

    public void modifier(Reservation reservation) throws SQLException {
        String req = "update reserevation set idUser=? , date=?  where idReservation=?";
        PreparedStatement pre = connection.prepareStatement(req);
        pre.setInt(1,reservation.getIdUser());
        pre.setString(2,reservation.getDate());
        pre.setInt(3,reservation.getIdReservation());

        pre.executeUpdate();

    }

}
