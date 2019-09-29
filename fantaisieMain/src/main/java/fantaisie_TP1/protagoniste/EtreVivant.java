package fantaisie_TP1.protagoniste;



public abstract class EtreVivant {

    private String nom;
    private int forceDeVie;


    // constructor
    public EtreVivant(String nom, int forceDeVie) {
        this.nom = nom;
        this.forceDeVie = forceDeVie;
    }

    /* getters */

    public String getNom() {
        return nom;
    }

    public int getForceDeVie() {
        return forceDeVie;
    }

    @Override
    public String toString() {
        return "--Etre vivant: " + getNom() + "--" +
               "\nPV: " + forceDeVie;
    }
}