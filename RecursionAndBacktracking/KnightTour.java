package leetCode.RecursionAndBacktracking;

public class KnightTour {
    

    static void placeKnights(int [][] board,int row,int coll,int moveNumber){



            if(row<0 || coll<0 || row>=board.length || coll>=board.length || board[row][coll]!=0){
                return;
            }
            if (moveNumber==board.length*board.length){
                board[row][coll]=moveNumber;
                printBoard(board);
                board[row][coll]=0;
                return;
               
            }

        board[row][coll]=moveNumber;
        placeKnights(board, row-2, coll-1, moveNumber+1);
        placeKnights(board, row-2, coll+1, moveNumber+1);
        placeKnights(board, row-1, coll-2, moveNumber+1);
        placeKnights(board, row-1, coll+2, moveNumber+1);
        placeKnights(board, row+2, coll-1, moveNumber+1);
        placeKnights(board, row+2, coll+1, moveNumber+1);
        placeKnights(board, row+1, coll-2, moveNumber+1);
        placeKnights(board, row+1, coll+2, moveNumber+1);
        board[row][coll]=0;
        




    }

   static void printBoard(int [][] board){

        for(int i=0;i<board.length;i++){

            for(int j=0;j<board.length;j++){

                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        int n=8;
        int [][] board=new int[n][n];
        
        for(int i=0;i<board.length;i++){

            for(int j=0;j<board.length;j++){

                board[i][j]=0;
            }
        }

        placeKnights(board,0,0,1);
      printBoard(board);
    }
}
