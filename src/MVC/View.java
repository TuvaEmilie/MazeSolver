package MVC;

import MazeComponent.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * View class represents the graphical user interface for displaying mazes and solutions.
 * It provides methods for rendering maze components on the screen and in the console.
 */
public class View {
    JFrame frame;
    JPanel frameGrid;
    JPanel frameBorder;
    int rows;
    int columns;

    JLabel[][] grid;
    JList mazeList;
    String selectedMaze;

    public View(Integer rows, Integer columns, String mazeName) {
        // Constructs a new View instance with the specified inventory of the maze, like number of columns and rows.
        this.rows = rows;
        this.columns = columns;
        frame = new JFrame(); // creating instance of JFrame
        frameGrid = new JPanel(); // creating instance of JFrame
        frameBorder = new JPanel();
        grid = new JLabel[rows][columns];
        String[] mazeFiles = {"maze001", "maze002", "maze003"};
        mazeList = new JList(mazeFiles);
        selectedMaze = mazeName;
    }
    public void drawMaze(char[][] mazeText, ArrayList<Position> solution, Maze maze){
        //Draws the maze of the GUI.

        //remove all components in panel.
        frameGrid.removeAll();
        // refresh the panel.
        frameGrid.updateUI();

        // Create JLabel for each component of the maze, and add to the frame for the GUI
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                JLabel gridComponent = getJLabel(mazeText, i, j, solution, maze);
                frameGrid.add(gridComponent);
                grid[i][j] = gridComponent;
            }
        }

        frameBorder.add(mazeList);
        frameBorder.setLayout(new FlowLayout(FlowLayout.CENTER));

        frameGrid.setLayout(new GridLayout(rows, columns));
        frame.setLayout(new GridLayout());
        frame.add(frameGrid);
        frame.pack();
        frame.setVisible(true);
    }

    private static JLabel getJLabel(char[][] mazeText, int i, int j, ArrayList<Position> solution, Maze maze) {
        // Creates the JLabels representing the symbols of the maze in the GUI
        JLabel gridComponent = new JLabel();
        gridComponent.setMinimumSize(new Dimension(20,20));
        gridComponent.setPreferredSize(new Dimension(20,20));
        gridComponent.setMaximumSize(new Dimension(20,20));
        if(mazeText[i][j] == '#'){
            gridComponent.setBackground(Color.PINK);
        } else if (mazeText[i][j] == 'S') {
            gridComponent.setBackground(Color.GREEN);
        }
        else if (mazeText[i][j] == 'E') {
            gridComponent.setBackground(Color.BLUE);
        }
        else if (mazeText[i][j] == ' ' || mazeText[i][j] == '.'){
            if (solution.contains(maze.getComponent(i,j).getPosition())){
                gridComponent.setBackground(Color.BLACK);
            } else {
                gridComponent.setBackground(Color.LIGHT_GRAY);
            }
        }
        gridComponent.setOpaque(true);
        return gridComponent;
    }

    public void drawTextMaze(char[][] mazeText, ArrayList<Position> solution, Maze maze){
        //Shows the maze in text-form
        String[][] terminalMaze = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(mazeText[i][j] == '#'){
                    terminalMaze[i][j] = "\u001B[30m" + '█';
                } else if (mazeText[i][j] == 'S') {
                    terminalMaze[i][j] = "\u001B[32m" + '█';
                }
                else if (mazeText[i][j] == 'E') {
                    terminalMaze[i][j] = "\u001B[33m" + '█';
                }
                else if (mazeText[i][j] == ' ' || mazeText[i][j] == '.'){
                    if (solution.contains(maze.getComponent(i,j).getPosition())){
                        terminalMaze[i][j] = "\u001B[34m" + '█';
                    } else {
                        terminalMaze[i][j] = "\u001B[37m" + '█';
                    }
                }
            }
        }
        // Prints to terminal
        for (String[] row : terminalMaze){
            for (String column : row){
                System.out.print(column);
            }
            System.out.print("\n");
        }
    }
}
