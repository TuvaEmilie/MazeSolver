package IO;

import Exceptions.MazeMalformedException;
import Exceptions.MazeSizeMissmatchException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileLoaderTest {
    @Test
    void loadValidMaze() throws MazeSizeMissmatchException, MazeMalformedException {
        FileLoader loader = new FileLoader();
        try {
            char[][] mazeText = loader.load("src/test/resources/validMaze.txt");
            assertNotNull(mazeText);
        } catch (Exception e) {
            fail("Exception should not be thrown for a valid maze.");
        }
    }

    @Test
    void loadInvalidMaze() {
        FileLoader loader = new FileLoader();
        assertThrows(MazeMalformedException.class, () -> {
            char[][] mazeText = loader.load("src/MazeTextFiles/maze001Malformed.txt");
        });
    }

    @Test
    void getInventory() throws MazeSizeMissmatchException, MazeMalformedException {
        FileLoader loader = new FileLoader();
        try {
            char[][] mazeText = loader.load("src/MazeTextFiles/maze001.txt");
            assertNotNull(loader.getInventory());
        } catch (Exception e) {
            fail("Exception should not be thrown when getting inventory.");
        }
    }

    @Test
    void singlePointValid() throws MazeSizeMissmatchException, MazeMalformedException {
        FileLoader loader = new FileLoader();
        try {
            char[][] mazeText = loader.load("src/MazeTextFiles/maze001.txt");
            assertDoesNotThrow(loader::singlePoint);
        } catch (Exception e) {
            fail("Exception should not be thrown for a valid maze.");
        }
    }

    @Test
    void singlePointInvalid() {
        FileLoader loader = new FileLoader();
        assertThrows(MazeMalformedException.class, () -> {
            char[][] mazeText = loader.load("src/MazeTextFiles/maze001Malformed.txt");
            loader.singlePoint();
        });
    }
}
