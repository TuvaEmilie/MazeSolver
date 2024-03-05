/*package MazeComponent;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeComponentTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCoordinates() {
    }

    @Test
    void getPosition() {
    }

    @Test
    void getSymbol() {
    }

    @Test
    void isTraversable() {
    }

    @Test
    void isTraversed() {
    }

    @Test
    void setTraversed() {
    }

    @Test
    void getTraversed() {
    }
}*/

package MazeComponent;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MazeComponentTest {
    private MazeComponent mazeComponent;

    @BeforeEach
    void setUp() {
        mazeComponent = new MazeComponent(2, 3);
    }

    @Test
    void getCoordinates() {
        int[] coordinates = mazeComponent.getCoordinates();
        assertArrayEquals(new int[]{2, 3}, coordinates);
    }

    @Test
    void getPosition() {
        Position position = mazeComponent.getPosition();
        assertEquals(2, position.getRow());
        assertEquals(3, position.getColumn());
    }

    @Test
    void getSymbol() {
        assertEquals('\u0000', mazeComponent.getSymbol());
    }

    @Test
    void isTraversable() {
        assertTrue(mazeComponent.isTraversable());

        mazeComponent.traversable = false;
        assertFalse(mazeComponent.isTraversable());
    }

    @Test
    void isTraversed() {
        assertFalse(mazeComponent.isTraversed());

        mazeComponent.traversed = true;
        assertTrue(mazeComponent.isTraversed());
    }

    @Test
    void setTraversed() {
        assertFalse(mazeComponent.isTraversed());

        mazeComponent.setTraversed(true);
        assertTrue(mazeComponent.isTraversed());

        mazeComponent.setTraversed(false);
        assertFalse(mazeComponent.isTraversed());
    }

    @Test
    void getTraversed() {
        assertFalse(mazeComponent.getTraversed());

        mazeComponent.setTraversed(true);
        assertTrue(mazeComponent.getTraversed());

        mazeComponent.setTraversed(false);
        assertFalse(mazeComponent.getTraversed());
    }
}
