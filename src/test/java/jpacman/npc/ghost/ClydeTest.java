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

public class ClydeTest {

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

    // make it so clyde is further than 8 spaces away, therefore so we can test
    // if clyde is trying to go to pacmans exact location
    @Test
    void ClydeWhenHesNotSoShy() {

        List<String> map = Lists.newArrayList(
                "##########",
                "#P      C#",
                "##########"
        );
        Level level = ghostMapParser.parseMap(map);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());

        level.registerPlayer(pacman);
        pacman.setDirection(Direction.EAST);

        assertThat(clyde.nextAiMove()).contains(Direction.EAST);
    }
    // create a scenario where clyde is within 8 spaces of pacman, therefore so
    // we can test if clyde will try to get away from pacman
    @Test
    void ShyClyde() {

        // make it so clyde is close to pacman is now trying to get away from pacman
        List<String> map = Lists.newArrayList(
                "########",
                "#P    C#",
                "########"
        );
        Level level = ghostMapParser.parseMap(map);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        level.registerPlayer(pacman);
        pacman.setDirection(Direction.WEST);

        assertThat(clyde.nextAiMove()).contains((Direction.EAST));

    }
    // creating the scenario that clyde is very close to pacman, therefore so we can test
    // if clyde will still try to get away from pacman.
    @Test
    void ClydeOutOfHisComfortZone() {

        List<String> map = Lists.newArrayList(
                "####",
                "#PC#",
                "####"
        );

        Level level = ghostMapParser.parseMap(map);
        Clyde clyde = Navigation.findUnitInBoard(Clyde.class, level.getBoard());
        level.registerPlayer(pacman);
        pacman.setDirection(Direction.WEST);
        // although clyde is directly next to pacman, he is still trying to get away
        assertThat(clyde.nextAiMove()).contains((Direction.EAST));
    }

}