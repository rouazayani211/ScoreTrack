package services;

import entities.Ticket;
import utils.MyDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ServiceTicket implements IService<Ticket>  {

    private Connection connection;

    public ServiceTicket(){
        connection= MyDB.getInstance().getConnection();
    }

    @Override
    public void ajouter(Ticket ticket) throws SQLException {
        String req ="insert into ticket (idReservation,numPlace,prix)"+
                "values('"+ticket.getIdReservation()+"','"+ticket.getNumPLace()+"',"+ticket.getPrix()+")";
        Statement ste= connection.createStatement();

        ste.executeUpdate(req);
    }

    @Override
    public void modifier(Ticket ticket) throws SQLException {
        String req = "update ticket set idReservation=? , numPlace=? , prix=? where idTicket=?";
        PreparedStatement pre = connection.prepareStatement(req);
        pre.setInt(1,ticket.getIdTicket());
        pre.setInt(2,ticket.getNumPLace());
        pre.setFloat(3,ticket.getPrix());
        pre.setInt(4,ticket.getIdTicket());

        pre.executeUpdate();

    }

    @Override
    public void supprimer(Ticket ticket) throws SQLException {
        String req = " delete from ticket where idTicket=?";
        PreparedStatement pre = connection.prepareStatement(req);
        pre.setInt(1,ticket.getIdTicket());
        pre.executeUpdate();

    }

    @Override
    public List<Ticket> afficher() throws SQLException {
        String req = "select * from ticket";
        Statement ste = connection.createStatement();
        ResultSet res = ste.executeQuery(req);
        List<Ticket> list =new ArrayList<>();
        while (res.next()){
            Ticket p = new Ticket();
            p.setIdTicket(res.getInt(1));
            p.setIdReservation(res.getInt(2));
            p.setNumPLace(res.getInt(3));
            p.setPrix(res.getInt(4));

            list.add(p);
        }
        return list;
    }
}
