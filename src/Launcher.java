import Exceptions.MazeMalformedException;
import Exceptions.MazeSizeMissmatchException;
import MVC.Controller;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Launcher class is used to set the code in motion
 * It asks the user to enter a maze in the terminal, and if they want to see it through gui or text.
 */

public class Launcher {
    public static void main(String[] args) throws FileNotFoundException, MazeSizeMissmatchException, MazeMalformedException, InterruptedException {

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter maze001, maze002, or maze003:");
        String mazeInput = scanner.nextLine();  // Read user input
        System.out.println("Enter gui or text:");  // Ask for user input
        String displayInput = scanner.nextLine();  // Read user input

        Controller controller = new Controller(mazeInput, displayInput);
    }

}