package challenger.cs_puzzle;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This class tests all the methods in the puzzle class.
 *
 *  @author Amin Davoodi (amind1)
 *  @author Estelle Susanto (estel94)
 *  @author Sung Lee (satou)
 *  @version Dec 7, 2013
 */
public class PuzzleTest
    extends TestCase
{
    /**
     * Tests the levelZero method
     */
    public void testLevelZero()
    {
        Puzzle puzzle = new Puzzle();
        MainScreen screen = new MainScreen();
        puzzle.levelZero(screen);
        assertEquals(Puzzle.getLevel(), 1);
    }

}
