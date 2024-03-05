package Exceptions;
/**
 * This exception is thrown when the maze dimensions are even; a wall or a path cannot be double.
 */
public class MazeSizeMissmatchException extends Throwable {
    public MazeSizeMissmatchException() {
        System.out.println("Maze dimensions cannot be even numbers");
    }
}
