import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Board board = new Board(5);
        int boardSize = board.getBoardSize();
        int a = Gamemode.choise1Class();
        Character character = new Character();
        Gamemode gamemode = new Gamemode();
        Character player1 = null;
        Character player2 = null;
        Case player1Case = null;
        Case player2Case = null;
        int reboot = 1;
        while (reboot == 1) {

            if (a == 1) {

                player1Case = board.getCaseFromPosition(boardSize / 2, 0);

                player1 = new Mage(player1Case, true);
                player1Case.setPersona(player1);

                System.out.print(" Vous avez choisi la classe Mage\n");
            } else {
                player1Case = board.getCaseFromPosition(boardSize / 2, 0);

                player1 = new Warrior(player1Case, true);
                player1Case.setPersona(player1);

                System.out.print(" Vous avez choisi la classe Guerrier\n");


            }

            int b = Gamemode.choise2Class();
            if (b == 1) {

                player2Case = board.getCaseFromPosition((boardSize / 2), boardSize - 1);

                player2 = new Mage(player2Case, false);
                player2Case.setPersona(player2);

                System.out.print(" Vous avez choisi la classe Mage\n");
            } else {
                player2Case = board.getCaseFromPosition((boardSize / 2), boardSize - 1);

                player2 = new Warrior(player2Case, false);
                player2Case.setPersona(player2);

                System.out.print(" Vous avez choisi la classe Guerrier\n");


            }


            while (player1.getHp() > 0 && player2.getHp() > 0) {

                    board.visualization(player1, player2);
                    player1.walkingDirection(board, gamemode, player1, player1.getWalkingDistance());
                    board.visualization(player1, player2);
                    player2.walkingDirection(board, gamemode, player2, player2.getWalkingDistance());
                    board.visualization(player1, player2);
                    player1.fight(player2, board, gamemode);
                if (player2.getHp() > 0) {
                    player2.fight(player1, board, gamemode);}
            }

            if (player1.getHp() > 0) {
                System.out.println("Le joueur 1 a gagné la partie.");
            } else System.out.println("Le joueur 2 a gagné la partie.");

            System.out.println("\nSouhaitez-vous en refaire une?\n 1: Relancer    0: Quitter");
            Scanner choiceReboot = new Scanner(System.in);
            reboot = choiceReboot.nextInt();
            if (reboot != 1 && reboot != 0) {
                System.out.println("Reponse invalide.");
                reboot = choiceReboot.nextInt();
            }
        }
    }
}
