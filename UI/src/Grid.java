import javax.swing.*;

public class Grid {

    public int width;
    public int height;
    private JButton[][] grid;
    private boolean[][] isMine;
    private int[][] numberOfMines;

//    public Grid(int width, int height) {
//        grid = new JButton[height][width];
//    }

    public Grid(int width, int height, int numberOfMines) {
        this.width = width;
        this.height = height;
        grid = new JButton[height][width];

//           for (JButton[] row : grid) {
//               for (JButton col : row){
//                   col.setVisible(true);
//               }
//            }
    }

    public JButton[][] getGrid(){
        return grid;
    }
}
