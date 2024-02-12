package test;


import entities.Reservation;
import entities.Ticket;
import services.ServiceReservation;
import services.ServiceTicket;
import utils.MyDB;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        MyDB db1 = MyDB.getInstance();

        System.out.println(db1.hashCode());

        Ticket t1 = new Ticket(1,1,11,15);
        Ticket t2 = new Ticket(2,2,303,40);

        Reservation r1= new Reservation(1,"15/2/2002");
        Reservation r2= new Reservation(3,"19/4/2021");

        ServiceTicket services = new ServiceTicket();
        ServiceReservation serviceReservation = new ServiceReservation();
        // ajouter les Ticket

       /*  try{
            services.ajouter(t1);
            services.ajouter(t2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } */

        // ajouter les RESERVATION
        try{
            serviceReservation.ajouter(r1);
            serviceReservation.ajouter(r2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        //supprimer TICKET

        /*try {
            services.supprimer(t1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/

        //supprimer RESERVATION

        /*try {
            serviceReservation.supprimer(r1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/
        // AFFICHER TICKETS

        try {
            System.out.println(services.afficher());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // AFFICHER RESERVATION

        try {
            System.out.println(serviceReservation.afficher());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

          // modification Ticket
       /* try {
            services.modifier(t2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/
        // modification  reservation
       /* try {
            serviceReservation.modifier(r2);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/


    }
}
