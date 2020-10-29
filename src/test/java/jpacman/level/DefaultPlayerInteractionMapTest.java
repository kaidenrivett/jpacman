package jpacman.level;

import jpacman.points.DefaultPointCalculator;

public class DefaultPlayerInteractionMapTest extends CollisionTest {

    public DefaultPlayerInteractionMapTest(){
        setCmap(new DefaultPlayerInteractionMap(new DefaultPointCalculator()));
    }

}
