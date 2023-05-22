public class Board {
    public int boardSize;
    private Case[][] casesList;

    Board(int boardSize) {
        this.boardSize = boardSize;
        initBoard();
    }

    public void initBoard() {
        casesList = new Case[boardSize][boardSize];

        for (int line = 0; line < boardSize; line++) {
            for (int column = 0; column < boardSize; column++) {
                casesList[line][column] = new Case(line, column, null);
            }
        }
    }

    public void visualization(Character player1, Character player2) {
        for (int line = 0; line < boardSize; line++) {
            for (int column = 0; column < boardSize; column++) {
                if (casesList[line][column].getPersona() == null) {
                    System.out.print("case | ");

                } else if (casesList[line][column].getPersona().getNumeroPlayer() == true) {
                    player1.vizusalisationObject();

                } else if (casesList[line][column].getPersona().getNumeroPlayer() == false) {
                    player2.vizusalisationObject();
                }
            }
            System.out.println("\n-------------------------------------------------");

        }
        System.out.println("HP du joueur 1:" + player1.getHp() + "     HP du joueur 2:" + player2.getHp());
    }

    public Case getCaseFromPosition(int line, int column) {
        return casesList[line][column];
    }

    public int getBoardSize() {
        return this.boardSize;
    }

}
