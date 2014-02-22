package challenger.cs_puzzle;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Tests the Wall down method.
 *
 *  @author Amin Davoodi (amind1)
 *  @author Estelle Susanto (estel94)
 *  @author Sung Lee (satou)
 *  @version Dec 7, 2013
 */
public class WallDownTest
    extends TestCase
{

    // ----------------------------------------------------------
    /**
     * Tests if the wall moves with the avatar
     */
    public void testMoveWithAvatar()
    {
        WallDown wall = new WallDown(1, 1, 2, 2);
        wall.moveWithAvatar(4);
        assertEquals(1, wall.bottom(), .01);
    }
}
