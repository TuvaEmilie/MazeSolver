package Exceptions;
/**
 * This exception is thrown when a maze is malformed.
 * Malformed mazes include mazes that have the wrong characters, e.g using "*" as walls instead of "#"
 */
public class MazeMalformedException extends Throwable {
    public MazeMalformedException() {
        System.out.println("Maze is malformed");
    }
}
