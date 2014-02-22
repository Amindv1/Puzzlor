package challenger.cs_puzzle;

import student.TestCase;



// -------------------------------------------------------------------------
/**
 *  Test class for the Teleportation Pad.
 *
 *  @author Amin Davoodi (amind1)
 *  @author Estelle Susanto (estel94)
 *  @author Sung Lee (satou)
 *  @version Dec 7, 2013
 */
public class TeleportationPadTest extends TestCase
{
    private TeleportationPad pad1;
    private TeleportationPad pad2;
    /**
     * Set up method that defines the location
     * of the pads and the avatar.
     */
    public void setUp()
    {
        pad1 = new TeleportationPad(0, 0, 20, 20);
        pad2 = new TeleportationPad(10, 10, 40, 40);
        pad1.setPosition(0, 0);
        pad2.setPosition(100, 100);
    }

    /**
     * tests that the pads are connected.
     */
    public void testConnect()
    {
        setUp();
        Puzzle puzzle = new Puzzle();
        MainScreen.setDistanceTravelled(100);
        pad1.connect(pad2);
        assertEquals(Puzzle.getAvatar().getX(), 100, 0.1);
        assertEquals(Puzzle.getAvatar().getY(), 100, 0.1);
        assertNotNull(puzzle);

        setUp();
        MainScreen.setDistanceTravelled(0);
        pad2.connect(pad1);
        assertEquals(Puzzle.getAvatar().getX(), 100, 0.1);
        assertEquals(Puzzle.getAvatar().getY(), 100, 0.1);
    }



    /**
     * Tests if the pads are equal.
     */
    public void testEquals()
    {
        assertTrue(pad1.equals(pad1));
        assertFalse(pad1.equals(pad2));
    }
}
