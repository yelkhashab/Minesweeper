import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grid {

    public int width;
    public int height;
    private JButton[][] grid;
    private boolean[][] isMine;
    private int[][] numberOfMines;

//    public Grid(int width, int height) {
//        grid = new JButton[height][width];
//    }

    public Grid(Difficulty diff) {
        this.width = diff.gridWidth;
        this.height = diff.gridHeight;
        grid = new JButton[height][width];
    }

    public JButton[][] getGrid(){
        return grid;
    }
}
