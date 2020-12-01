package tictactoe;

import java.util.Scanner;

public class TicTacToe {

    static void board(char[] ch) {
        System.out.println("+----+----+----+");
        System.out.println("| " + ch[0] + "  | " + ch[1] + "  | " + ch[2] + "  |");
        System.out.println("+----+----+----+");
        System.out.println("| " + ch[3] + "  | " + ch[4] + "  | " + ch[5] + "  |");
        System.out.println("+----+----+----+");
        System.out.println("| " + ch[6] + "  | " + ch[7] + "  | " + ch[8] + "  |");
        System.out.println("+----+----+----+");
    }

    static boolean checkForWinner(char[] ch) {
        if (ch[0] == ch[1] && ch[1] == ch[2]) {
            System.out.println("We have a winner!");
            return true;
        } else if (ch[0] == ch[3] && ch[3] == ch[6]) {
            System.out.println("We have a winner!");
            return true;
        } else if (ch[0] == ch[4] && ch[4] == ch[8]) {
            System.out.println("We have a winner!");
            return true;
        } else if (ch[1] == ch[4] && ch[4] == ch[7]) {
            System.out.println("We have a winner!");
            return true;
        } else if (ch[2] == ch[5] && ch[5] == ch[8]) {
            System.out.println("We have a winner!");
            return true;
        } else if (ch[3] == ch[4] && ch[4] == ch[5]) {
            System.out.println("We have a winner!");
            return true;
        } else if (ch[6] == ch[4] && ch[4] == ch[2]) {
            System.out.println("We have a winner!");
            return true;
        } else if (ch[6] == ch[7] && ch[7] == ch[8]) {
            System.out.println("We have a winner!");
            return true;
        }

        return false;
    }

    static char changeTurns(char currentPlayer) {
        char playersOneTurn = 'X';
        char playersTwoTurn = 'O';
        if (currentPlayer == 'X') {
            return playersTwoTurn;
        } else if (currentPlayer == 'O') {
            return playersOneTurn;
        }
        return 'e';
    }

    static void updateBoard(char[] ch, int numPressed, char whoseTurnIs) {

        ch[numPressed] = whoseTurnIs;

        System.out.println("+----+----+----+");
        System.out.println("| " + ch[0] + "  | " + ch[1] + "  | " + ch[2] + "  |");
        System.out.println("+----+----+----+");
        System.out.println("| " + ch[3] + "  | " + ch[4] + "  | " + ch[5] + "  |");
        System.out.println("+----+----+----+");
        System.out.println("| " + ch[6] + "  | " + ch[7] + "  | " + ch[8] + "  |");
        System.out.println("+----+----+----+");
    }

    static char[] initializeTheMatrix() {
        final int REDIX = 10;
        char[] matrix = new char[9];

        for (int i = 0; i <= matrix.length - 1; i++) {
            matrix[i] = Character.forDigit(i, REDIX);
        }
        return matrix;
    }

    public static void main(String[] args) {

        //crearte the matrix outside main
        char[] choice = initializeTheMatrix();

        board(choice);

        boolean winner = false;

        //temporary of the turn of each player every time
        char turnEachTimeTemp = 'O';

        while (!winner) {

            boolean outcome = checkForWinner(choice);
            if (outcome)
               break;

            System.out.println("press a number for your choice");
            Scanner input = new Scanner(System.in);
            int numPressed = input.nextInt();

            //call for change turns and give current turn
            char whoseTurnIs = changeTurns(turnEachTimeTemp);
            //save player played turn 
            turnEachTimeTemp = whoseTurnIs;

            updateBoard(choice, numPressed, whoseTurnIs);

        }
    }

}
