package MazeComponent;
/**
 * The EndPoint class represents the endpoint in the provided maze.
 * * It is specified by "E".
 */
public class EndPoint extends MazeComponent{
    boolean traversable;
    public EndPoint(int row, int col) {
        super(row, col);
        this.symbol = 'E';
    }
}
