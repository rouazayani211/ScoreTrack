package entities;
import java.sql.Date;
public class Evenement {
    private int id_event;
    private String nom;
    private Date date;
    private float prix;

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Evenement{" +
                "id_event=" + id_event +
                ", nom='" + nom + '\'' +
                ", date=" + date +
                ", prix=" + prix +
                '}';
    }

    public Evenement() {
    }

    public Evenement(int id_event, String nom, Date date, float prix) {
        this.id_event = id_event;
        this.nom = nom;
        this.date = date;
        this.prix = prix;
    }

    public Evenement(String nom, Date date, float prix) {
        this.nom = nom;
        this.date = date;
        this.prix = prix;
    }
}
