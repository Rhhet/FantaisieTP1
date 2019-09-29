package fantaisie_TP1.attaque.pouvoirs.sharpSpells;


public class Morsure extends Tranchant {

    public Morsure(int pointDeDegat) {
        super(pointDeDegat, "Morsure", -1);    //nbUtilisationPouvoirInitial = -1 means 
    }                                          // infinite nb of utilisations

    //override utiliser(): Morsure utilisable un nb infini de fois...
    @Override
    public int utiliser() {
		if (isOperationnel())
			return getPointDeDegat();
		else
			return 0;
	}
}