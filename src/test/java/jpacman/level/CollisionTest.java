package jpacman.level;

import jpacman.npc.Ghost;
import jpacman.points.DefaultPointCalculator;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


abstract class  CollisionTest {

    private Player player = mock(Player.class);
    private Ghost ghost = mock(Ghost.class);
    private Pellet pellet = mock(Pellet.class);

    private CollisionMap cmap;

    void setCmap(CollisionMap cmap) {
        this.cmap = cmap;
    }


    @Test
    public void PlayerGhostCollision() {
        cmap.collide(player,ghost);
        // this is a redundant test case below
        // when(player.isAlive()).thenReturn(false)
        verify(player).setAlive(false);
        verifyZeroInteractions(ghost);
    }

//    @Test
//    public void PelletCase() {
//
//    }

}

/*
Collider            Player/Pacman                               Player                              Ghost
Collidee            Ghost                                       Pellet                              Player
Consequence         Game ends/lost; nothing happens to ghost    eat + points + pellet disappear
*/