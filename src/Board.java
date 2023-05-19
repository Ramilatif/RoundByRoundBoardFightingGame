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

    public void setCaseAtPosition(Case newCase, int x, int y) {
        casesList[x][y] = newCase;
    }

    public void visualization(Character player1, Character player2) {
        for (int line = 0; line < boardSize; line++) {
            for (int column = 0; column < boardSize; column++) {
                if (casesList[line][column].getPersona() == null) {
                    //casesList[line][column].visualization();
                    System.out.print("case(" + line + " " + column + ") | ");
                } else if (casesList[line][column].getPersona().getNumeroPlayer() == true) {
                    //casesList[line][column].visualization();
                    System.out.print("case(player1 ) |");
                } else if (casesList[line][column].getPersona().getNumeroPlayer() == false) {
                    System.out.print("case(player2 ) |");
                }
                //else System.out.print(casesList[line][column].getPersona().getNumeroPlayer());
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

    public void setBoardSize(int size) {

    }
}
