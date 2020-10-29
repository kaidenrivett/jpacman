package jpacman.game;

import jpacman.level.Level;
import jpacman.level.Player;
import jpacman.level.PlayerFactory;
import jpacman.points.PointCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class GameUnitTest {

    private Player player;
    private Level level;
    private SinglePlayerGame game;
    private PlayerFactory playerFactory;

    @BeforeEach
    void setUp() {
        level = mock(Level.class);
        player = mock(Player.class);
        game = new SinglePlayerGame(player, level, mock(PointCalculator.class));

    }
    // test the first if statement
    @Test
    void isInProgressBranch() {
        when(level.isInProgress()).thenReturn(true);
        game.start();
        assertThat(game.isInProgress()).isFalse();
    }
    
    
    
    
    // test the second if statement
    @Test
    void pelletsAndPlayerGreaterThanZero() {
        when(level.isAnyPlayerAlive()).thenReturn(true);
        when(level.remainingPellets()).thenReturn(42);

        game.start();

        verify(level).start();
        verify(level).addObserver(game);

        assertThat(game.isInProgress()).isTrue();
    }
    // make sure we do some in order verification first

}


