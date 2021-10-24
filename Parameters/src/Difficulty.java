public class Difficulty {

    public int len;
    public int width;
    public int stones;

    public Difficulty(String diff){
        if(diff.compareToIgnoreCase("Small") == 0){
            len = 9;
            width = 9;
            stones = 10;
        }
        else if(diff.compareToIgnoreCase("Meduim") == 0){
            len = 16;
            width = 16;
            stones = 40;
        }
        else{
            len = 16;
            width = 30;
            stones = 99;
        }
    }

    public int getLen(){
        return len;
    }

    public int getWidth(){
        return width;
    }

    public int getStones(){
        return stones;
    }
}