package entities;

public class Reservation {
    int idReservation , idUser;
    String date;

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", idUser=" + idUser +
                ", date='" + date + '\'' +
                '}';
    }

    public Reservation(){

    }

    public Reservation(int idReservation , int idUser , String date){

        this.idReservation=idReservation;
        this.idUser=idUser;
        this.date=date;
    }

    public Reservation( int idUser , String date){

        this.idUser=idUser;
        this.date=date;
    }
}
