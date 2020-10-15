package jpacman.npc.ghost;
import jpacman.board.BoardFactory;
import jpacman.board.Direction;
import jpacman.level.Level;
import jpacman.level.LevelFactory;
import jpacman.level.Player;
import jpacman.level.PlayerFactory;
import jpacman.points.DefaultPointCalculator;
import jpacman.points.PointCalculator;
import jpacman.sprite.PacManSprites;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InkyTest {
    private GhostMapParser ghostMapParser;
    private Player pacman;

    @BeforeEach
    void setup() {
        PacManSprites sprites = new PacManSprites();
        GhostFactory ghostFactory = new GhostFactory(sprites);

        PointCalculator pointCalculator = new DefaultPointCalculator();
        LevelFactory levelFactory = new LevelFactory(sprites, ghostFactory, pointCalculator);

        BoardFactory boardFactory = new BoardFactory(sprites);
        ghostMapParser = new GhostMapParser(levelFactory, boardFactory, ghostFactory);

        PlayerFactory playerFactory = new PlayerFactory(sprites);
        pacman = playerFactory.createPacMan();
    }

    // Exercise 1

    /* But if Inky is in front of Pac-Man when
     * Blinky is far behind him, Inky tends to want to move away from Pac-Man
     * (in reality, to a point very far ahead of Pac-Man) */
    @Test
    void InkyFollowingBlinky() {
        List<String> map = Lists.newArrayList(
                "########",
                "#P   BI#",
                "########"
        );
        Level level = ghostMapParser.parseMap(map);
        Inky inky = Navigation.findUnitInBoard(Inky.class, level.getBoard());
        level.registerPlayer(pacman);

        // pacman is west of Inky and Blinky
        pacman.setDirection(Direction.WEST);
        // assert that inky will follow in the direction of Blinky if it is behind
        assertThat(inky.nextAiMove()).contains((Direction.WEST));
    }

    @Test
    void InkyInFrontBlinkyBehind() {
        List<String> map = Lists.newArrayList(
                "############",
                "#B   P    I#",
                "############"
        );
        Level level = ghostMapParser.parseMap(map);
        Inky inky = Navigation.findUnitInBoard(Inky.class, level.getBoard());

        level.registerPlayer(pacman);

        // pacman is east of Inky
        pacman.setDirection(Direction.EAST);
        // inky is in front of pacman and blinky is behind pacman, therefore
        // we should assert that inky will try to move in the opposite direction of pacman
        assertThat(inky.nextAiMove()).contains((Direction.WEST));

    }
}

