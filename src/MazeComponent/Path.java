package MazeComponent;
/**
 * The Path class represents a path component within a maze grid which inherits from MazeComponent class.
 * * It is specified by " ".
 */
public class Path extends MazeComponent{
    boolean traversed;

    public Path(int row, int col) {
        super(row, col);
        symbol = ' ';
    }

}
