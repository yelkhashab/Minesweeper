import java.util.Scanner;
import java.io.IOException;
import java.util.InputMismatchException;
import java.lang.Math;

public class Game {
    MineSweeperGUI gui;
    Difficulty diff;

    int gridWidth;
    int gridHeight;
    int numStones;

    int[][] stones;
    boolean[][] flags;
    boolean[][] revealed;

    int buttonX;
    int buttonY;

    public Game(Difficulty diff){
        this.diff = diff;
        this.gridWidth = diff.getWidth();
        this.gridHeight = diff.getHeight();
        this.numStones = diff.getStones();
        init();
        placeStones();
    }
    // Returns number of stones in adjacent 3x3 grid
    int adjacentStones(int x, int y) {
        if (x <  0 || y < 0 || x > gridWidth || y > gridHeight) {
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

        // if all adjacent cells are clear, recursively check all adjacent cells
        for(int i = -1; i < 1; i++) {
            for (int j = -1; j < 1; j++) {
                check(x + i, y + j);
            }
        }
    }

    //places a marker indicating suspected stone location
    void flag(int x, int y) {
        flags[x][y] = !flags[x][y];
    }

    //initialize and clear the arrays
    void init(){

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
            int x = (int)Math.floor(Math.random()*(gridWidth));
            int y = (int)Math.floor(Math.random()*(gridHeight));

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

    void mousePressed(int x, int y) {
        //Check for game loss
        if (stones[x][y]!=0) {
            return;
        } else {//If game not lost, reveal starting from that square
            check(x, y);
        }
    }

    //restart game
    void restart() {
        clearStones();
        init();
        placeStones();
        new Game(this.diff);
    }

}
