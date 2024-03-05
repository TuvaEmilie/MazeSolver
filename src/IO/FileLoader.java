package IO;

import MazeComponent.*;
import Exceptions.MazeMalformedException;
import Exceptions.MazeSizeMissmatchException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * FileLoader reads the provided maze.txt file, loads it into an array and creates the appropriate objects for solving
 * and displaying the maze.
 */

public class FileLoader implements FileInterface {
    Maze inventory;
    char[][] mazeArray;

    public char[][] load(String filename) throws MazeMalformedException, MazeSizeMissmatchException, IllegalArgumentException, FileNotFoundException {
        /**
         * FileLoader loads maze data from one of the MazeTextFiles.
         *
         * @param filename The name of the file to load the maze data from.
         * @return A 2D array representing the loaded maze.
         * @throws MazeMalformedException   If the loaded maze is malformed.
         * @throws MazeSizeMissmatchException If the maze dimensions are wrong.
         * @throws IllegalArgumentException  If an invalid argument is passed.
         * @throws FileNotFoundException    If the file is not found.
         */
        FileReader reader = new FileReader(filename);
        BufferedReader buffReader = new BufferedReader(reader);

        try {
            String dimensions = buffReader.readLine();
            int rows = Integer.parseInt(dimensions.split(" ")[0]);
            int columns = Integer.parseInt(dimensions.split(" ")[1]);
            if (columns % 2 == 0 && rows % 2 == 0){
                throw new MazeSizeMissmatchException();
            }
            mazeArray = new char[rows][columns];
            inventory = new Maze(rows, columns);
            String mazeLine = buffReader.readLine();
            // looping through each row in the maze
            for (int i = 0; i < rows; i++) {
                // looping through each column in the maze
                char[] line = mazeLine.toCharArray();
                for (int j = 0; j < columns; j++) {
                    // if any character of the maze is wrong, then the maze is malformed
                    if(line[j] != '#' && line[j] != 'S' && line[j] != 'E' && line[j] != ' '){
                        throw new MazeMalformedException();
                    }
                    if(line[j] == '#'){
                        inventory.addComponent(i, j, new Wall(i, j));
                    } else if (line[j] == 'S') {
                        inventory.addComponent(i, j, new StartPoint(i, j));
                    }
                    else if (line[j] == 'E') {
                        inventory.addComponent(i, j, new EndPoint(i,j));
                    }
                    else if (line[j] == ' ' || line[j] == '.'){
                        inventory.addComponent(i, j, new Path(i, j));
                    }
                    mazeArray[i][j] = line[j];
                }
                mazeLine = buffReader.readLine();
            }
            buffReader.close();
            // check that there is a start and an end, otherwise the maze is malformed
            singlePoint();
            return mazeArray;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (MazeMalformedException | MazeSizeMissmatchException e) {
            throw e;
        }
    }
    public Maze getInventory(){
        // Returns the instance of Maze that contains all objects created in the fileLoader representing the maze
        return inventory;
    }
    public void singlePoint() throws MazeMalformedException {
        // Checks if there is one start point and one end point in the loaded maze and throws
        // MazeMalformedException if there is no single start point or no single end point.
        boolean singleStart = false;
        boolean singleEnd = false;
        for (char[] a: mazeArray) {
            for (char c: a) {
                if (c == 'S'){
                    singleStart = !singleStart;
                }
                else if(c == 'E'){
                    singleEnd = !singleEnd;
                }
            }
        }
        if (!(singleStart && singleEnd)){
            throw new MazeMalformedException();
        }
    }

}
