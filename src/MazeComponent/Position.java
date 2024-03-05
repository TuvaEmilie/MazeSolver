package MazeComponent;
/**
 * The Position class represents a specific position within the grid.
 * It stores the information of row and column coordinates of the position.
 *
 */
public class Position {
    int row;
    int column;

    public Position(Integer row, Integer column){
        this.row = row;
        this.column = column;
    }

    public int getRow(){
        return row;
    }
    public int getColumn(){
        return column;
    }
}
