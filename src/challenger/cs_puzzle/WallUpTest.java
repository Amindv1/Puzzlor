package challenger.cs_puzzle;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests the Wall moving up class.
 *
 *  @author Amin Davoodi (amind1)
 *  @author Estelle Susanto (estel94)
 *  @author Sung Lee (satou)
 *  @version Dec 7, 2013
 */
public class WallUpTest extends TestCase
{
    // ----------------------------------------------------------
    /**
     * Tests if the wall moves with the avatar
     */
    public void testMoveWithAvatar()
    {
        WallUp wall = new WallUp(1, 1, 2, 2);
        wall.moveWithAvatar(4);
        assertEquals(3, wall.bottom(), .01);
    }
}
