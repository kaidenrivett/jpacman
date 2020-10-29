package jpacman.game;

import jpacman.board.BoardFactory;
import jpacman.board.Square;
import jpacman.game.GameFactory;
import jpacman.level.*;
import jpacman.npc.Ghost;
import jpacman.points.PointCalculator;
import jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class GameStartUnitTest {
    private Game game;
    private MapParser mapParser;
    private LevelFactory levelFactory;
    private BoardFactory boardFactory;
    private SinglePlayerGame spg;
    private Player pacman;

    Player player;
    Level level;
    PointCalculator pointCalculator;

    @BeforeEach
    void setUp() {
        PacManSprites sprites = new PacManSprites();
        PlayerFactory playerFactory = new PlayerFactory(sprites);
//        spg = new SinglePlayerGame(player, level, pointCalculator);
        spg = mock(SinglePlayerGame.class);
        game =  mock(Game.class);
        levelFactory = mock(LevelFactory.class);
        boardFactory = mock(BoardFactory.class);
        // create a mapparser that uses the mock objects
        mapParser = new MapParser(levelFactory, boardFactory);
        pacman = playerFactory.createPacMan();
    }

    @Test
    void SinglePlayerGame() {
        level.registerPlayer(pacman);
        game.getPlayers();
        mapParser.parseMap(Collections.singletonList(" "));
        mapParser.parseMap(Collections.singletonList(" "));
        verify(boardFactory).createGround();
        verify(spg).getPlayers();

    }



}
