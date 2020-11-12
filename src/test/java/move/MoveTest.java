package move;

import jpacman.Launcher;
import jpacman.board.Direction;
import jpacman.board.Unit;
import jpacman.game.Game;
import jpacman.level.MapParser;
import jpacman.level.Pellet;
import jpacman.level.Player;
import jpacman.npc.ghost.Navigation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoveTest {
    private Game game;
    private Launcher launcher;
    private MapParser mapParser;
    private Player player;


    @BeforeEach
    public void setup() {
        launcher = new Launcher();
        launcher.launch();
        game = launcher.getGame();
        game.start();
    }

    @AfterEach
    void teardown() {
        launcher.dispose();
    }

    // Exercise 2

    // S2.1
    @Test
    void playerConsumes() {
        player = game.getPlayers().get(0);
        game.move(player, Direction.EAST);
        // the pellet value is 10
        assertEquals(10, player.getScore());
        // check if the pellet has disappeared
        // this is one way to verify if the pellet has disappeared
        Unit pellet = Navigation.findUnit(Pellet.class, player.getSquare());
        assertEquals(null, pellet);

    }

    // S2.2
    @Test
    void playerOnEmptySquare() {
        // get pacman to move right and then move back to the empty square he previously started on
        player = game.getPlayers().get(0);
        game.move(player, Direction.EAST);
        // get score from moving onto the pellet
        int score1 = player.getScore();
        game.move(player, Direction.WEST);
        // get score again from moving onto empty square, int score value should not have changed
        int score2 = player.getScore();
        assertTrue(score1 == score2);

    }

    // S2.3
    @Test
    void playerMoveFails() {
        player = game.getPlayers().get(0);
        game.move(player, Direction.NORTH);
//        assertThat()
    }

    // Exercise 4
    // write a helper method to parse the map we have created
    @Test
    void customMapTest() throws InterruptedException{
        launcher.dispose(); // get rid of original map, its way too big
        launcher = new Launcher();
        launcher.withMapFile("/singlePellet.txt");
        launcher.launch();
        game = launcher.getGame();
        player = game.getPlayers().get(0);
        Thread.sleep(1000);
    }
}
