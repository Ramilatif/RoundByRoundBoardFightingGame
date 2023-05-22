

public class Mage extends Character {

    public Mage(Case currentposition, boolean numplayer) {

        super(5, 4, 7, 15, currentposition, numplayer);

    }
    @Override
    public void vizusalisationObject(){
        if (getNumeroPlayer() == true)
            System.out.print("Mage 1 |");
        else if (getNumeroPlayer() == false) System.out.print("Mage 2 |");
    }
}
