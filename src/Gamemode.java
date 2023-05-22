import java.util.Scanner;

public class Gamemode {


    public static int dialogueChoiseClass(Character player, String playerName) {
        Scanner choice1 = new Scanner(System.in);
        System.out.print(" " + playerName + " choississez votre classe:\n 1: Mage\n 2: Guerrier\n");
        int answerClass = choice1.nextInt();
        while (answerClass != 1 && answerClass != 2) {
            answerClass = choice1.nextInt();
        }
        return answerClass;
    }

    public static int DialogueWalkingDirection(String action, String player) {
        Scanner answerPlacement = new Scanner(System.in);
        System.out.println(player +":Ou voulez-vous vous " + action + "? \n 1:Haut \n 2:Bas \n 3:Droite \n 4:Gauche");
        int answerP = answerPlacement.nextInt();
        while (answerP != 1 && answerP != 2 && answerP != 3 && answerP != 4) {
            answerP = answerPlacement.nextInt();
        }
        return answerP;
    }

    public static int dialogueWalkingDirectionBIS(String action, Character character, int choiceAction) {
        Scanner answerDistance = new Scanner(System.in);
        System.out.println("De combien de case voulez-vous vous " + action + "?");
        int answerD = answerDistance.nextInt();
        while (answerD > choiceAction) {
            System.out.println("Votre classe n'a pas assez de stats de deplacement pour agir de la sorte");
            System.out.println("De combien de case voulez-vous vous deplacer?");
            answerD = answerDistance.nextInt();
        }
        return answerD;

    }

    public static Case choiceCase(Board board, Character persona, String action, String player, Case currentPosition, int choiceAction) {
        int answerP = DialogueWalkingDirection(action, player);
        int answerD = dialogueWalkingDirectionBIS(action, persona, choiceAction);
        Case futurCase = null;
        if (answerP == 1) {
            futurCase = board.getCaseFromPosition(currentPosition.getX() - answerD, currentPosition.getY());
        } else if (answerP == 2) {
            futurCase = board.getCaseFromPosition(currentPosition.getX() + answerD, currentPosition.getY());
        } else if (answerP == 3) {
            futurCase = board.getCaseFromPosition(currentPosition.getX(), currentPosition.getY() + answerD);
        } else futurCase = board.getCaseFromPosition(currentPosition.getX(), currentPosition.getY() - answerD);
        return futurCase;
    }

    public static Character choiceClasse(Board board, String playerName, Character player, Case playerCase, Boolean numplayer, int playerPlacementX, int playerPlacementY) {

        playerCase = board.getCaseFromPosition(playerPlacementX, playerPlacementY);

        if (dialogueChoiseClass(player, playerName) == 1) {
            player = new Mage(playerCase, numplayer);


            System.out.print(" Vous avez choisi la classe Mage\n");
        } else {
            player = new Warrior(playerCase, numplayer);

            System.out.print(" Vous avez choisi la classe Guerrier\n");

        }

        playerCase.setPersona(player);
        return player;
    }
}