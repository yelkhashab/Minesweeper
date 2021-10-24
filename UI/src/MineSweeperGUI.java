import javax.swing.*;

public class MineSweeperGUI {
    private Grid grid;
    private JButton restartGameButton;
    private JPanel panel1;
    public Difficulty difficulty;

    private void setRestartGameButton(){
    }
    public void createGrid(){
        grid = new Grid(difficulty.getWidth(), difficulty.getHeight());
    }
}
