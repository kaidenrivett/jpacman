package jpacman.level;

import jpacman.PacmanConfigurationException;
import jpacman.board.*;
import jpacman.game.Game;
import jpacman.game.GameFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;


public class MapParserUnitTest {

    private MapParser mapParser;
    private LevelFactory levelFactory;
    private BoardFactory boardFactory;
    private GameFactory gameFactory;

    @BeforeEach
    void setUp() {
        // mocked two objects
        levelFactory = mock(LevelFactory.class);
        boardFactory = mock(BoardFactory.class);
        gameFactory = mock(GameFactory.class);
        // create a mapparser that uses the mock objects
        mapParser = new MapParser(levelFactory, boardFactory);
    }

    // Exercise 1
    @Test
    void parseMapParser() {
        // using a space
        mapParser.parseMap(Collections.singletonList(" "));
        // verify if mapparser asked to create ground, if yes, this verification will pass
        verify(boardFactory).createGround();
        // verify if create level was found
        verify(levelFactory).createLevel(any(),anyList(),anyList());

        // try player and pellet, it gets interesting.
    }

    @Test
    void parsePellet() {
        Square square = mock(Square.class);
        when(boardFactory.createGround()).thenReturn(square);

        Pellet pellet = mock(Pellet.class);
        when(levelFactory.createPellet()).thenReturn(pellet);

        mapParser.parseMap(Collections.singletonList("."));

        verify(boardFactory).createGround();
        verify(levelFactory).createPellet();

        verify(pellet).occupy(square);
        verify(levelFactory).createLevel(any(), anyList(), anyList());
    }



    // Exercise 2 Bad Weather Tests
    @Test
    void fileDNE() {
        assertThatThrownBy(() -> mapParser.parseMap("File name does not exist")).isInstanceOf(PacmanConfigurationException.class);
    }

    @Test
    void noGhosts() {
        levelFactory = mock(LevelFactory.class);
        doThrow(NullPointerException.class).when(levelFactory).createGhost();
    }

    @Test
    void noGround() {
        boardFactory = mock(BoardFactory.class);
        doThrow(NullPointerException.class).when(boardFactory).createGround();
    }

}
