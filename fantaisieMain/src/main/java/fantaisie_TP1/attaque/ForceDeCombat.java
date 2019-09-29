package fantaisie_TP1.attaque;

public abstract class ForceDeCombat {

    private int pointDeDegat;
    private String nom;
    protected boolean operationnel; //ou private...
    /* NOTE: il aurait peut être été plus judicieux d'initialiser
    operationnel à true de base et éviter quelques lignes de code dans
    les constructeurs des sous classes */


    //constructor
    public ForceDeCombat(int pointDeDegat, String nom) {
        this.pointDeDegat = pointDeDegat;
        this.nom = nom;
    }
    
    public int getPointDeDegat() {
        return pointDeDegat;
    }

    public String getNom() {
        return nom;
    }

    public boolean isOperationnel() {
        return operationnel;
    }

    /* à n'utiliser que si operationnel est déclaré private */
    @Deprecated
    protected void setOperationnel(boolean operationnel) {
        this.operationnel = operationnel;
    }

    //return all attributes
    @Override
    public String toString() {
        return "Nom: " + getNom() + 
               "\nPts deg: " + getPointDeDegat() + 
               "\nOperationnel: " + isOperationnel();
    }

    public int utiliser() {
        return isOperationnel() ? getPointDeDegat() : 0;
    }
}