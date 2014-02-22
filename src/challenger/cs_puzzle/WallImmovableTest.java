package challenger.cs_puzzle;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  tests all methods in the WallImmovable class
 *
 *  @author Amin Davoodi (amind1)
 *  @author Estelle Susanto (estel94)
 *  @author Sung Lee (satou)
 *  @version Dec 7, 2013
 */
public class WallImmovableTest extends TestCase
{

    // ----------------------------------------------------------
    /**
     * Tests if the wall moves with the avatar.
     * Which in this case, it doesnt.
     */
    public void testMoveWithAvatar()
    {
        WallImmovable wall = new WallImmovable(1, 1, 2, 2);
        wall.moveWithAvatar(4);
        assertEquals(2, wall.bottom(), .01);
    }
}
