package MVC;

import Exceptions.MazeMalformedException;
import Exceptions.MazeSizeMissmatchException;
import IO.FileLoader;
import MazeComponent.Maze;
import MazeComponent.Position;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;


import javax.swing.*;

/**
 * Controller class manages the interaction between the model and the view.
 * The maze-solving application loads maze data and controls the solving process,
 */
public class Controller {
    Model model;
    View view;

    public Controller(String mazeInput, String displayInput) throws InterruptedException, MazeMalformedException, FileNotFoundException, MazeSizeMissmatchException {
        // Makes a controller that initializes the application, maze solving and visualization. Aditionally throws error messages.
        FileLoader loader = new FileLoader();
        char[][] mazeText;
        Maze maze;
        // check which maze to load based on user input
        if (mazeInput.toLowerCase(Locale.ROOT).contains("maze001")){
            mazeText = loader.load("src/MazeTextFiles/maze001.txt");
        } else if (mazeInput.toLowerCase(Locale.ROOT).contains("maze002")){
            mazeText = loader.load("src/MazeTextFiles/maze002.txt");
        } else if (mazeInput.toLowerCase(Locale.ROOT).contains("maze003")) {
            mazeText = loader.load("src/MazeTextFiles/maze003.txt");
        } else {
            System.out.println("Maze could not be found.");
            return;
        }
        maze = loader.getInventory();

        model = new Model(mazeText, maze);
        view = new View(mazeText.length, mazeText[0].length, mazeInput);

        // if model.solve() returns an empty solution, then the maze is unsolvable and therefore malformed
        ArrayList<Position> result = model.solve();
        if (result.isEmpty()){
            throw new MazeMalformedException();
        }

        // call to the method which draws the maze representation - either gui or text
        draw(mazeText, maze, result, displayInput);

    }
    public void draw(char[][] mazeText, Maze maze, ArrayList<Position> result, String displayInput) throws InterruptedException {
        ArrayList<Position> incrementingResult = new ArrayList<>();
        // incrementally adds the solution to a list, and redraws the maze each time to incrementally solve the maze
        for (Position position : result){
            incrementingResult.add(position);
            // make the thread sleep 1s in order to see the solution incrementally update
            Thread.sleep(1000);
            // visualizes the maze (GUI) and the solution according to the display mode.
            if (displayInput.toLowerCase(Locale.ROOT).contains("gui")){
                view.drawMaze(mazeText, incrementingResult, maze);
            }
            // visualizes the maze (TEXT) and the solution according to the display mode.
            else if (displayInput.toLowerCase(Locale.ROOT).contains("text")) {
                view.drawTextMaze(mazeText, incrementingResult, maze);
            }
        }
    }
}
