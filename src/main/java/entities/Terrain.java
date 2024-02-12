package entities;

public class Terrain {

   private int id_terrain;
   private String nom;
   private String localisation;
   private int capacite;

    public int getId_terrain() {
        return id_terrain;
    }

    public void setId_terrain(int id) {
        this.id_terrain = id_terrain;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @Override
    public String toString() {
        return "Terrain{" +
                "id_terrain=" + id_terrain +
                ", nom='" + nom + '\'' +
                ", localisation='" + localisation + '\'' +
                ", capacite='" + capacite + '\'' +
                '}';
    }

    public Terrain() {
    }

    public Terrain(int id_terrain, String nom, String localisation, int capacite) {
        this.id_terrain = id_terrain;
        this.nom = nom;
        this.localisation = localisation;
        this.capacite = capacite;
    }

    public Terrain(String nom, String localisation, int capacite) {
        this.nom = nom;
        this.localisation = localisation;
        this.capacite = capacite;
    }
}

