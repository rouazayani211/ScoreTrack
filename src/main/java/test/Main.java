package test;


import entities.Evenement;
import entities.Terrain;

import services.ServiceEvenement;
import services.ServiceTerrain;
import utils.MyDB;
import java.sql.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
       /* MyDB db1 = MyDB.getInstance();
        MyDB db2 = MyDB.getInstance();

        System.out.println(db1.hashCode());
        System.out.println(db2.hashCode());*/

        Terrain t = new Terrain(1,"beranbeau","madrid",300);
        Evenement ev = new Evenement(1,"copa del rey",new Date(2024-1900,4,7),20);

        ServiceTerrain services = new ServiceTerrain();
        ServiceEvenement service = new ServiceEvenement();
        /**   // ajouter les terrains


        try {
            services.ajouter(t);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        //Affichage Terrain

        try {
            System.out.println(services.afficher());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


         // modification terrain
        try {
            services.modifier(t);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }**/

         /**   //suppression terrain

        try {
            services.supprimer(t);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 **/


        /**      // ajouter les evenements

        try {
            service.ajouter(ev);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


        //Affichage evenement

        try {
            System.out.println(service.afficher());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


            // modification evenement
        try {
            service.modifier(ev);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 **/
               //suppression evenement

        try {
            service.supprimer(ev);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
