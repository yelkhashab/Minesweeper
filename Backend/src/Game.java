import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;
import java.lang.Math;

public class Game {
    int gridWidth;
    int gridHeight;
    int numStones;

    int[][] stones;
    boolean[][] flags;
    boolean[][] revealed;

    // Returns number of stones in adjacent 3x3 grid
    int adjacentStones(int x, int y) {
        if (x < 0 || y < 0 || x > gridWidth || y > gridHeight) {
            return 0;
        }
        int total = 0;

        for (int i = -1; i < 1; i++){
            for (int j = -1; j < 1; j++){
                total += stones[x + i][y + j];
            }
        }
        return total;
    }

    //check if cell is clear and displays number of stones in adjacent cells
    void check(int x, int y) {
        if(revealed[x][y])
            return;

        revealed[x][y] = true;

        if(adjacentStones(x,y) != 0)
            return;

        // if all adjacent cells are clear, recusively check all adjacent cells
        for(int i = -1; i < 1; i++) {
            for (int j = -1; j < 1; j++) {
                check(x + i, y + j);
            }
        }

        /*
        check(x-1,y-1);
        check(x-1,y+1);
        check(x+1,y-1);
        check(x+1,y+1);
        check(x-1,y);
        check(x+1,y);
        check(x,y-1);
        check(x,y+1);
         */
    }

    //places a marker indicating suspected stone location
    void flag(int x, int y) {
        flags[x][y] = !flags[x][y];
    }

    void init(){
        //initialize and clear the arrays
        stones = new int[gridWidth][gridHeight];
        flags = new boolean[gridWidth][gridHeight];
        revealed = new boolean[gridWidth][gridHeight];
        for(int x = 0; x < gridWidth; x++){
            for(int y = 0; y < gridHeight; y++){
                stones[x][y] = 0;
                flags[x][y] = false;
                revealed[x][y] = false;
            }
        }
    }

    //randomly assigns stones to the grid
    void placeStones(){
        int placed = 0;
        while (placed < numStones){
            int x = (int)Math.floor(Math.random()*(gridWidth+1));
            int y = (int)Math.floor(Math.random()*(gridHeight+1));

            if (stones[x][y] == 1){
                continue;
            }
            stones[x][y] = 1;
            placed++;
        }
    }

    //clears stones from grid
    void clearStones(){
        for(int x = 0; x < gridWidth; x++) {
            for (int y = 0; y < gridHeight; y++) {
                stones[x][y] = 0;
            }
        }
    }

    void restart(){
        new Game();
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Which board size do you want to select: \nSmall \nMedium \nLarge");
        String diff = scan.nextLine();

        Game game = new Game();
        Difficulty size = new Difficulty(diff);
        game.gridWidth = size.getWidth();
        game.gridHeight = size.getHeight();
        game.numStones = size.getStones();
    }

}
