import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;

public class Game {
    int gridWidth;
    int gridHight;
    int numMines;

    int[][] mines;
    boolean[][] flags;
    boolean[][] revealed;

    int adjacentCells(int x, int y) {
        if (x < 0 || y < 0 || x > gridWidth || y > gridHight) {
            return 0;
        }

        int total = 0;

        for (int i = -1; i < 1; i++){
            for (int j = -1; j < 1; j++){
                total += mines[x + i][y + j];
            }
        }
        return total;
    }

    void check(int x, int y) {
        if(revealed[x][y])
            return;

        revealed[x][y]=true;

        if(adjacentCells(x,y)!=0)
            return;

        check(x-1,y-1);
        check(x-1,y+1);
        check(x+1,y-1);
        check(x+1,y+1);
        check(x-1,y);
        check(x+1,y);
        check(x,y-1);
        check(x,y+1);
    }

    public static void main(String args[]) {

    }

}
