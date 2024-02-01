package Backtracking;

public class NQueens {
    //count total no. of ways in which we can solve N-Queens problem.
    static int count=0;
    public static boolean isSafe(char board[][], int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // diagonal up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void nQueen(char board[][], int row) {
        // base case
        if (row == board.length) {
            printBoard(board);
            count++;
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q';
                // func call
                nQueen(board, row + 1);
                // backtracking
                board[row][j] = 'x';
            }

        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("-----Chess board--------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    //checks if problem can be solved & print only 1 solution to NQueen problem
    public static boolean nQ(char board[][], int row){
        if(row==board.length){
            count++;
            return true;
        }
        for(int j=0;j<board.length;j++){
            if(isSafe(board, row, j)){
                board[row][j]='Q';
                if(nQ(board, row+1)){
                    return true;
                }
                board[row][j]='X';
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        int n = 4;
        char board[][] = new char[n][n];
        // initialize
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }
        // System.out.println(isSafe(board, n, n));
        // nQueen(board, 0);
        // printBoard(board);
        // System.out.println("total ways: ="+count);

        if(nQ(board, 0)){
            System.out.println("Solution is possible");
            printBoard(board);
        }else{
            System.out.println("Solution is not possible");
        }
    }
}
