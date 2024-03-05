package MazeComponent;
/**
 * Similar to the EndPoint class, StartPoint class represents the StartPoint in the provided maze.
 * * It is specified by "S".
 */

public class StartPoint extends MazeComponent{
    public StartPoint(int row, int col) {
        super(row, col);
        symbol = 'S';
    }
}
