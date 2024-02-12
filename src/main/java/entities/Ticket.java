package entities;

public class Ticket {
    int idTicket , idReservation, numPLace;
    float prix;

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNumPLace() {
        return numPLace;
    }

    public void setNumPLace(int numPLace) {
        this.numPLace = numPLace;
    }

    @Override
    public String toString() {
        return "Ticket{"+ "idTicket=" + idTicket +
                ", idReservation=" +idReservation +
                ", numPlace=" + numPLace +
                ",Prix=" + prix + "}";

    }
    public Ticket()  {

    }

    public Ticket(int idTicket , int idReservation , int numPLace , float prix) {
        this.idTicket=idTicket;
        this.idReservation=idReservation;
        this.numPLace=numPLace;
        this.prix=prix;

    }

    public Ticket( int idReservation , int numPLace , float prix) {
        this.idReservation=idReservation;
        this.numPLace=numPLace;
        this.prix=prix;

    }
}
