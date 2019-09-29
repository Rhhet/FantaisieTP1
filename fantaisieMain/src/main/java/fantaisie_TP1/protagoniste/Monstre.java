package fantaisie_TP1.protagoniste;


import java.util.Iterator;
import java.util.Random;
import fantaisie_TP1.attaque.pouvoirs.Pouvoir;


public class Monstre<T extends Pouvoir> extends EtreVivant {
    
    private T[] attaques;
    private ZoneDeCombat zoneDeCombat;
    private Domaine domaine;
    private GestionAttaque gstAtt;

    // constructor
    @SafeVarargs
    public Monstre(String nom, int forceDeVie, ZoneDeCombat zdc, 
                   Domaine dom, T ... attaques) {
        super(nom, forceDeVie);
        this.zoneDeCombat = zdc;
        this.domaine = dom;
        this.attaques = attaques;
    }


    /* classe interne */

    private class GestionAttaque implements Iterator<T> {

        private T[] attaquesPossibles = attaques;
        private int nbAttaquesPossibles = attaques.length;

        /* avec constructeur :
        public GestionAttaque() {
            attaquesPossibles = attaques;
            nbAttaquesPossibles = attaques.length;
        } */

        public boolean hasNext() {
            for (T x : attaquesPossibles) {
                while (!x.isOperationnel()) {
                    x = attaquesPossibles[nbAttaquesPossibles - 1];
                    nbAttaquesPossibles--;
                }
            }
            return (nbAttaquesPossibles != 0);
        }

        public T next() {
            Random rand = new Random();
            int index = rand.nextInt(nbAttaquesPossibles);
            return attaquesPossibles[index];
        }
    }


    /* getters */

    public ZoneDeCombat getZDC() {
        return zoneDeCombat;
    }

    public Domaine getDomaine() {
        return domaine;
    }


    public void entreEnCombat() {
        for (T x : attaques) {
            x.regenererPouvoir();
        }
        gstAtt = new GestionAttaque();
    }

    // suppose l'utilisation de entreEnCombat() avant pour instancier GestionAttaque
    public T attaque() {
        return (gstAtt.hasNext()) ? gstAtt.next() 
                                  : null;
    }


    //meth donnant les attaques du monstre
    public T[] getAttaques() {
        return attaques;
    }

    //return contents of this.attaques in a String
    private String allAttaques() {
        String str = "";
        for (T x : attaques) {
            str += x.getNom() + " [Deg: " + x.getPointDeDegat() 
                   + ", Utilisable: " + x.isOperationnel() + " ("
                   + x.getNbUtilPV() + ")],\n"; 
        }
        return str.substring(0, str.length() - 2);
    }

    
    /*  *** Other version ***
     (format moins lisible mais utilise toString() de Feu inherited de ForceDeCombat)

    private String allAttaques2() {
        String str = "";
        for (T x : attaques) {
            str += x.getNom() + " [" + x.toString() + "],\n"; 
        }
        return str.substring(0, str.length() - 2);
    } */
    
    @Override
    public String toString() {

        return "--Monstre: " + getNom() + "--" +
               "\nType: " + getClass().getName() + 
               "\nPV: " + getForceDeVie() +
               "\nDomaine: " + getDomaine() +
               "\nZone de Combat: " + getZDC() +
               "\nAttaques: " + allAttaques();
    }
}