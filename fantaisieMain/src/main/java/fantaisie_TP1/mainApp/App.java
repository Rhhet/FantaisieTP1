package fantaisie_TP1.mainApp;

import fantaisie_TP1.attaque.pouvoirs.fireSpells.*;
import fantaisie_TP1.attaque.pouvoirs.iceSpells.Glace;
import fantaisie_TP1.attaque.pouvoirs.iceSpells.PicsDeGlace;
import fantaisie_TP1.attaque.pouvoirs.iceSpells.Tornade;
import fantaisie_TP1.attaque.pouvoirs.sharpSpells.Morsure;
import fantaisie_TP1.attaque.armes.*;
import fantaisie_TP1.protagoniste.Domaine;
import fantaisie_TP1.protagoniste.Monstre;
import fantaisie_TP1.protagoniste.ZoneDeCombat;

public class App {

    public static void main(String[] args) {
        /* partie 1 - 2 tests */

        Arc bow = new Arc(0);
        Morsure bite = new Morsure(85);

        System.out.println(bow.toString());
        System.out.println();
        System.out.println(bite.toString());
        System.out.println();

        /* partie 3  */

        var bdf1 = new BouleDeFeu(1000);
        var bdf2 = new BouleDeFeu(100_000);
        var dragon = new Monstre<Feu>("Ebonhorn", 125_050, ZoneDeCombat.aerien, 
                                        Domaine.feu, bdf1, bdf2);

        System.out.println(dragon.toString());   
        System.out.println();
       
        
        var lava = new Lave(100);
        var lightning = new Eclair(100);
        var bdf = new BouleDeFeu(900);
        //bdf.regenererPouvoir();
        var dragotenebre = new Monstre<Feu>("Twilight Drake", 200, ZoneDeCombat.aerien,
                                            Domaine.feu, lava, lightning, bdf);

        System.out.println(dragotenebre.toString());  
        System.out.println();
             
        Feu att1 = dragotenebre.getAttaques()[0];    

        int degTot = 0;
        while (att1.getNbUtilPV() > 80) {
            att1.utiliser();
            degTot += att1.getPointDeDegat();
        }

        //lava utilisé 20 fois
        System.out.println(dragotenebre.toString());       
        System.out.println(dragotenebre.getNom() + " a fait " + degTot + " degats.");
        System.err.println("\n\n\n");


        /* partie 4  */

        var pdg = new PicsDeGlace(20);
        var tor = new Tornade(12);

        var monster = new Monstre<Glace>("test", 1500, ZoneDeCombat.terrestre, 
                                                        Domaine.glace, pdg, tor);

        System.out.println(monster + "\n");       
        monster.entreEnCombat();
        System.out.println(monster.attaque());
    }
}
