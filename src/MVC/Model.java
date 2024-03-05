package MVC;

import MazeComponent.Maze;
import MazeComponent.MazeComponent;
import MazeComponent.Position;

import java.util.ArrayList;


/**
 * The Model class represents the logic.
 * It contains methods for solving mazes and managing data.
 */
public class Model {
    char[][] mazeText;
    Maze maze;
    int rows;
    int columns;
    //MazeComponent currentPosition;
    ArrayList<Position> allPaths;

    public Model(char[][] mazeText, Maze maze){
        //Constructs an object, Model, with the provided maze text and components.
        this.mazeText = mazeText;
        this.maze = maze;
        rows = mazeText.length;
        columns = mazeText[0].length;
        //currentPosition = this.maze.getInventory()[0][0];
        allPaths = new ArrayList<>();
    }

    public ArrayList<Position> solve(){
        //Solves the maze and provides a list with a possible solution for the maze.
        // If there is no solution, the list is empty and the unsolvable maze is handled in Controller
        if (exploreMaze(findStart(),allPaths)){
            return allPaths;
        } else {
            return new ArrayList<>();
        }
    }

    // Programmatic maze solver using recursion
    public boolean exploreMaze(MazeComponent position, ArrayList<Position> traversedPath) {
        //Explores the maze from a current position
        if (traversedPath == null) {
            traversedPath = new ArrayList<>();
        }
        if (position == null) {
            position = findStart();
        }
        // Add current position to traversedPath
        traversedPath.add(position.getPosition());

        if (position.equals(findEnd())) {
            return true; // This path leads to the end
        }

        if (!position.isTraversable() || position.isTraversed()) {
            traversedPath.remove(position.getPosition());
            return false; // This path is invalid
        }

        position.setTraversed(true);
        MazeComponent[] neighbors = getNeighbors(position);

        for (MazeComponent neighbor : neighbors) {
            //neighbor = positions that are valid; up/down/sideways.
            if (exploreMaze(neighbor, traversedPath)) {
                return true; // If any neighbor leads to the end, return true
            }
        }

        traversedPath.remove(position.getPosition()); // Backtrack
        return false; // This path doesn't lead to the end
    }

    public MazeComponent[] getNeighbors(MazeComponent position){
        //Retrieves neighboring maze components of a given position.
        ArrayList<MazeComponent> allNeighbors = new ArrayList<>();
        allNeighbors.add(maze.getInventory()[position.getPosition().getRow()-1][position.getPosition().getColumn()]);
        allNeighbors.add(maze.getInventory()[position.getPosition().getRow()][position.getPosition().getColumn()-1]);
        allNeighbors.add(maze.getInventory()[position.getPosition().getRow()][position.getPosition().getColumn()+1]);
        allNeighbors.add(maze.getInventory()[position.getPosition().getRow()+1][position.getPosition().getColumn()]);
        return removeOldNeighbors(allNeighbors);
    }

    public MazeComponent[] removeOldNeighbors(ArrayList<MazeComponent> neighbors){
        //Removes neighbors that have been crossed from a list with neighbors.
        neighbors.removeIf(component -> component.isTraversed());
        return neighbors.toArray(new MazeComponent[0]);
    }

    public MazeComponent findStart(){
        //Finds the starting point of the components
        MazeComponent start = null;
        for (MazeComponent[] totalMaze : maze.getInventory()){
            for (MazeComponent component : totalMaze){
                if (component.getSymbol() == 'S'){
                    start = component;
                }
            }
        }
        return start;
    }

    public MazeComponent findEnd(){
        //Finds ending point of the maze components.
        MazeComponent start = null;
        for (MazeComponent[] totalMaze : maze.getInventory()){
            for (MazeComponent component : totalMaze){
                if (component.getSymbol() == 'E'){
                    start = component;
                }
            }
        }
        return start;
    }

}