package jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.common.collect.ImmutableList;
import jpacman.sprite.Sprite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.util.*;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;
    private Square square;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
        square = new BasicSquare();
    }


    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        assertThat(unit.hasSquare()).isEqualTo(false);
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
//        Unit class has a getSquare method that returns the square a unit is on
//        look for getOccupants() in the square class

        // get the unit to occupy a square
        unit.occupy(square);

        // check that the square the unit was on was the target
        assertThat(unit.getSquare()).isEqualTo(square);

        // check that the unit had the square as an occupant
        assertThat(square.getOccupants()).isEqualTo(ImmutableList.copyOf(square.getOccupants()));

    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        // asking the same unit to occupy the same square twice
        unit.occupy(square);
        unit.occupy(square);

        assertThat(unit.getSquare()).isEqualTo(square);

        assertThat(square.getOccupants()).isEqualTo(ImmutableList.copyOf(square.getOccupants()));

    }
}
