public class Difficulty {

    public int gridHeight;
    public int gridWidth;
    public int numStones;

    public Difficulty(String diff){
        if(diff.compareToIgnoreCase("Small") == 0){
            gridHeight = 9;
            gridWidth = 9;
            numStones = 10;
        }
        else if(diff.compareToIgnoreCase("Medium") == 0){
            gridHeight = 16;
            gridWidth = 16;
            numStones = 40;
        }
        else{
            gridHeight = 16;
            gridWidth = 30;
            numStones = 99;
        }
    }

    public int getHeight(){
        return gridHeight;
    }

    public int getWidth(){
        return gridWidth;
    }

    public int getStones(){
        return numStones;
    }
}