package test;

import entities.Commande;
import entities.Produit;
import services.ServiceCommande;
import services.ServiceProduit;

import java.sql.SQLException;

public class main {
    public static void main (String[] args){
        /*MyDB db1 =  MyDB.getInstance();
        MyDB db2 =  MyDB.getInstance();


        System.out.println(db1.hashCode());
        System.out.println(db2.hashCode());*/
        Produit p1 = new Produit("roua",55,"azertyu",4);
        Produit p2 = new Produit("YOSSRAooo",56,"dfghjkl",5);
        Commande c1=new Commande(1,"dfhjdfj",6,"ff","fhf");

        ServiceProduit service=new ServiceProduit();
        ServiceCommande comm=new ServiceCommande();
        // ajouter les personnes
        try {
            service.ajouter(p1);
            service.ajouter(p2);
            comm.ajouter(c1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }


    }
}

