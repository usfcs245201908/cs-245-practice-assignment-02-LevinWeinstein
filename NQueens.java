/**
 * Author : Levin Weinstein
 * Class  : CS 245
 * Date   : Friday, August 30, 2019
 * Purpose: This class is designed to provide a solution to the NQueens Problem.
 *          The class is not a standalong program, but meant to be used by other classes,
 *          and is tested through the "Practice02Test" class.
 */

class NQueens {
    private int boardSize;
    private int[][] board;

    NQueens(int size) {
        board = new int[size][size];
        boardSize = size;
    }

    /**
     *
     * @param row : Int => the row of the desired queen placement
     * @param col : Int => the column of the desired queen placement
     *
     * @return Boolean : whether or not there are already Queens
     *                   place which would conflict with a Queen
     *                   placed at board[row][col]
     */
    private boolean noCollisions(int row, int col) {

        for (int i = col, j = 0; i >= 0; i--, j++) {
            // horizontal
            if (board[row][i] != 0)
                return false;
            // diagonal up
            if (row + j < boardSize && board[row + j][i] != 0)
                return false;
            // diagonal down
            if (row - j >= 0 && board[row - j][i] != 0)
                return false;
            // since we know only place one queen per row,
            // we do not need to test for vertical collisions
        }
        return true;
    }

    /**
     * @return whether or not is is possible to place #{boardSize}
     *         queens on #{board}.
     *
     * @throws Exception : If a non-positive board size is set.
     */
    public boolean placeNQueens() throws Exception {
        if (boardSize < 1)
            throw new Exception("Board Size must be a positive number");
        return placeColumn(0);
    }


    /**
     * Inner method of placeNQueens, which allows for a "col" parameter.
     */
    private boolean placeColumn(int col) {

        if (col >= boardSize)
            return true;

        for (int i = 0; i < boardSize; i++) {
            if (noCollisions(i, col)) {
                board[i][col] = 1;
                if (placeColumn(col+ 1))
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    /* private static void print2dArray(int [][] n){
        for (int i = 0; i < n.length; i++){
            for (int j = 0; j < n[0].length; j++){
                System.out.format("[%d]", n[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        NQueens n = new NQueens(8);

        System.out.println(n.placeNQueens());
    } */
}