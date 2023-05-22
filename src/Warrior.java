public class Warrior extends Character {
    public Warrior(Case currentposition, boolean numplayer) {

        super(10, 10, 10, 10, currentposition, numplayer);
    }

    @Override
    public void vizusalisationObject() {
        if (getNumeroPlayer() == true)
            System.out.print(" War 1 |");
        else if (getNumeroPlayer() == false) System.out.print(" War 2 |");
    }
}
