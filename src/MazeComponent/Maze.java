package MazeComponent;
/**
 * Maze class represents a grid-based layout for the maze composed of MazeComponent objects.
 * It provides methods for adding and retrieving components in the maze.
 */
public class Maze {
    MazeComponent[][] inventory;

    public Maze(Integer rows, Integer columns){
        inventory = new MazeComponent[rows][columns];
    }

    public void addComponent(Integer row, Integer column, MazeComponent component) {
        inventory[row][column] = component;
    }
    public MazeComponent getComponent(Integer row, Integer column){
        return inventory[row][column];
    }

    public MazeComponent[][] getInventory(){
        return inventory;
    }
}
