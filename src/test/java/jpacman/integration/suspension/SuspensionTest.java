package jpacman.integration.suspension;

import jpacman.Launcher;
import jpacman.game.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// lots of hints are in the launcher smoke test class

public class SuspensionTest {
    private Game game;
    private Launcher launcher;

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

    // Exercise 1

    // scenario S4.1
    @Test
    public void suspendRunningGame() {
        assertThat(game.isInProgress());
        game.stop();
        assertFalse(game.isInProgress());
    }

    // scenario S4.2
    @Test
    public void resumeSuspendedGame() {
        game.stop();
        assertFalse(game.isInProgress());
        game.start();
        assertTrue(game.isInProgress());
    }
}
