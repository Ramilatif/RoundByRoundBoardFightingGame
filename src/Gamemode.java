import java.util.Scanner;

public class Gamemode {


    public static int choise1Class() {
        Scanner choice1 = new Scanner(System.in);
        System.out.print(" Player 1 choississez votre classe:\n 1: Mage\n 2: Guerrier\n");
        int a = choice1.nextInt();
        Character player1 = null;
        while (a != 1 && a != 2) {
            a = choice1.nextInt();
        }
        return a;
    }

    public static int choise2Class() {
        Scanner choice1 = new Scanner(System.in);
        System.out.print(" Player 2 choississez votre classe:\n 1: Mage\n 2: Guerrier\n");
        int b = choice1.nextInt();
        Character player2 = null;
        while (b != 1 && b != 2) {
            b = choice1.nextInt();
        }
        return b;
    }

    public static int DialogueWalkingDirection(String action) {
        Scanner answerPlacement = new Scanner(System.in);
        System.out.println("Ou voulez-vous vous " + action + "? \n 1:Haut \n 2:Bas \n 3:Droite \n 4:Gauche");
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

    public static Case choiceCase(Board board, Character persona, String action, Case currentPosition, int choiceAction) {
        int answerP = DialogueWalkingDirection(action);
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
}