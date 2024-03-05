package MazeComponent;
/**
 * The Wall class represents a wall component within a maze grid.
 * It is specified by "#".
 */

public class Wall extends MazeComponent{
    public Wall(int row, int col){
        super(row,col);
        symbol = '#';
        traversable = false;
    }
}
