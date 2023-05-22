import java.util.Scanner;

abstract public class Character implements Vizualisation {

    int hp;
    int walkingDistance;
    int force;
    int attackDistance;

    boolean numplayer;
    Case currentPosition;

    protected Character(int hp, int walkingDistance, int force, int attackDistance, Case currentPosition, boolean numplayer) {
        this.hp = hp;
        this.walkingDistance = walkingDistance;
        this.force = force;
        this.attackDistance = attackDistance;
        this.currentPosition = currentPosition;
        this.numplayer = numplayer;
    }

    public int getWalkingDistance() {
        return this.walkingDistance;
    }

    public int getHp() {
        return this.hp;
    }

    public int getForce() {
        return this.force;
    }

    public Case getCurrentPosition() {
        return this.currentPosition;
    }

    public boolean getNumeroPlayer() {
        return numplayer;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setCurrentPosition(Case playerCase) {
        this.currentPosition = playerCase;
    }

    public void walkingDirection(Board board, Gamemode gamemode, Character persona, int travelling) {
        boolean reboot = true;


        while (reboot == true) {
            try {
                Case futurCase = gamemode.choiceCase(board, persona, "deplacer", currentPosition, travelling);


                this.currentPosition.setPersona(null);
                this.setCurrentPosition(futurCase);
                if (futurCase.getPersona() == null) {
                    currentPosition.setPersona(persona);
                    reboot = false;
                } else System.out.println("Il y a deja un joueur sur cette case");


            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Le personnage sort du plateau... \n");

            }
        }
    }

    public void damageReceived(Character playerReceived) {
        int hpDamage = playerReceived.getHp();
        playerReceived.setHp(hpDamage - this.getForce());

    }

    public void fight(Character playerReceived, Board board, Gamemode gamemode) {
        boolean reboot = true;

        while (reboot == true) {
            try {
                Case fightCase = gamemode.choiceCase(board, this, "attaquer", currentPosition, getForce());

                if (fightCase.getPersona() == null) {
                    System.out.println("L'attaque n'a touché aucun joueur");
                } else damageReceived(playerReceived);
                reboot = false;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Le personnage attaque en dehors du plateau \n");

            }
        }
    }


}






