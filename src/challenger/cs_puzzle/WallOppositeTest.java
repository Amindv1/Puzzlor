package challenger.cs_puzzle;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Tests the Wall going left (WallOpposite class)
 *
 *  @author Amin Davoodi (amind1)
 *  @author Estelle Susanto (estel94)
 *  @author Sung Lee (satou)
 *  @version Dec 7, 2013
 */
public class WallOppositeTest extends TestCase
{

    // ----------------------------------------------------------
    /**
     * Tests if the wall moves with the avatar
     */
    public void testMoveWithAvatar()
    {
        WallOpposite wall = new WallOpposite(1, 1, 2, 2);
        wall.moveWithAvatar(4);
        assertEquals(2, wall.bottom(), .01);
    }
}