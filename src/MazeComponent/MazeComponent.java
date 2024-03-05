package MazeComponent;
/**
 * The MazeComponent class represents a component for the maze-grid.
 * It contains information about the position, symbol, and traversal status of the component.
 */

public class MazeComponent {
    Position position;
    char symbol;
    boolean traversable;
    boolean traversed;

    public MazeComponent(int row, int col){
        position = new Position(row, col);
        traversed = false;
        traversable = true;
    }
    public int[] getCoordinates() {
        return new int[]{position.getRow(),position.getColumn()};
    }

    public Position getPosition(){
        return position;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isTraversable(){
        return traversable;
    }

    public boolean isTraversed(){
        return traversed;
    }

    public void setTraversed(boolean traversed){
        this.traversed = traversed;
    }

    public boolean getTraversed(){
        return traversed;
    }
}
