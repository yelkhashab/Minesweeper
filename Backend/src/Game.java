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
        int total = 0;

        for (int i = -1; i < 1; i++){
            for (int j = -1; j < 1; j++){
                total += mines[x + i][y + j];
            }
        }
        return total;
    }

    public static void main(String args[]) {

    }

}
