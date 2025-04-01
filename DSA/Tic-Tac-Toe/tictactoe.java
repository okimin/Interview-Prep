import java.util.*;

class TicTacToe {
    int [] rows;
    int [] columns;
    int diagonal;
    int antidiagonal;

    public TicTacToe(int board){
        rows = new int[board];
        columns = new int[board];
        diagonal = 0;
        antidiagonal = 0; 
    }
    
    public int move(int row,int column, int player){
        int score = 1;
        if(player == 2){
            score = -1;
        }
        rows[row] += score;
        columns[column] += score;
        
        if((row - column) == 0)
            diagonal+=score;
        else if((column -(-row))== 2)
            antidiagonal+=score;
        
        if(isWinner())
            return player;

        return 0;
    }

    private boolean isWinner(){
        for(int row : rows){
            if(row == 3 || row == -3)
                return true;
        }

        for(int column: columns){
            if(column ==3 || column == -3){
                return true;
            }
        }

        if(diagonal == 3 || diagonal == -3 || antidiagonal == 3 || antidiagonal == -3)
            return true;

        return false;
    }
}
