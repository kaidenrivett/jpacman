package jpacman.level;

import jpacman.board.Square;
import jpacman.game.Game;
import jpacman.npc.Ghost;
import jpacman.points.DefaultPointCalculator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;


abstract class  CollisionTest {

    // create mocks
    private Player player = mock(Player.class);
    private Ghost ghost = mock(Ghost.class);
    private Pellet pellet = mock(Pellet.class);
    private Square square = mock(Square.class);
    private Game game = mock(Game.class);

    private CollisionMap cmap;

    void setCmap(CollisionMap cmap) {
        this.cmap = cmap;
    }


    @Test
    void PlayerGhostCollision() {
        cmap.collide(player,ghost);
        verify(player).setAlive(false);
        verifyZeroInteractions(ghost);
        assertThat(game.isInProgress()).isFalse();
    }

    @Test
    void PlayerPelletCollision() {
        cmap.collide(player, pellet);
        // verify that the player did indeed collide with a pellet and that its score increased by one pellet value (10)
        verify(player).addPoints(0);
        verify(pellet).leaveSquare();
        // check that the pellet has disappeared
    }

    @Test
    void GhostCollidesWithGhost() {
        game.start();
        cmap.collide(ghost, ghost);
        // nothing should happen, game should still be running
        verify(game, never()).isInProgress();
    }

    @Test
    void GhostCollidesWithPellet() {
        // in this case also nothing should happen at all
        cmap.collide(ghost, pellet);
        // because the ghost collided with the pellet, the points should not increase
        verify(player, never()).addPoints(0);
    }

    @Test
    void GhostCollidesWithPlayer() {
        cmap.collide(ghost, player);
        verify(player).setAlive(false);
        // player has died and game is over
        assertThat(game.isInProgress()).isFalse();
    }
}

/*
Collider            Player/Pacman                               Player                              Ghost                  Ghost               Ghost
Collidee            Ghost                                       Pellet                              Player/Pacman          Ghost               Pellet
Consequence         Game ends/lost; nothing happens to ghost    eat + points + pellet disappear     Game ends              Nothing happens     Pellet is not visible
*/