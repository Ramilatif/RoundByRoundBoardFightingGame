import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        Board board = new Board(5);
        int boardSize = board.getBoardSize();

        Gamemode gamemode = null;
        Character player1 = null;
        Character player2 = null;
        Case player1Case = null;
        Case player2Case = null;
        int reboot = 1;

        while (reboot == 1) {

            player1 = gamemode.choiceClasse(board, "Joueur 1", player1, player1Case, true, boardSize / 2, 0);

            player2 = gamemode.choiceClasse(board, "Joueur 2", player2, player2Case, false, boardSize / 2, boardSize - 1);

            while (player1.getHp() > 0 && player2.getHp() > 0) {

                board.visualization(player1, player2);
                player1.walkingDirection(board, gamemode, player1, player1.getWalkingDistance(), "player1");
                board.visualization(player1, player2);
                player2.walkingDirection(board, gamemode, player2, player2.getWalkingDistance(), "player2");
                board.visualization(player1, player2);
                player1.fight(player2, board, gamemode, "player1");
                if (player2.getHp() > 0) {
                    player2.fight(player1, board, gamemode, "player2");
                }
            }

            if (player2.getHp() > 0) {
                System.out.println("Le joueur 1 a gagné la partie.");
            } else System.out.print("Le joueur 2 a gagné la partie.");
            board.visualization(player1, player2);
            System.out.println("Souhaitez-vous en refaire une?\n 1: Relancer    0: Quitter");
            Scanner choiceReboot = new Scanner(System.in);
            reboot = choiceReboot.nextInt();
            if (reboot != 1 && reboot != 0) {
                System.out.println("Reponse invalide.");
                reboot = choiceReboot.nextInt();
            }
        }
    }
}
