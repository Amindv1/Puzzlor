package challenger.cs_puzzle;

import sofia.graphics.ShapeView;
import android.graphics.PointF;
import android.widget.Button;
import android.widget.TextView;

/**
 * This class tests all the methods in the MainScreenTest class
 *
 * @author Amin Davoodi (amind1)
 * @author Estelle Susanto (estel94)
 * @author Sung Lee (satou)
 * @version Dec 7, 2013
 */
public class MainScreenTest
    extends student.AndroidTestCase<MainScreen>
{
    private TextView  endGame;
    private Button    nextLevel;
    private Button    exit;
    private TextView  rules;
    private ShapeView shapeView;


    /**
     * Create a new MainScreenTest object.
     */
    public MainScreenTest()
    {
        super(MainScreen.class);
    }


    /**
     * tests if everything works correctly when you start the game
     */
    public void testStart()
    {
        assertEquals(0, nextLevel.getVisibility());
        assertEquals(
            "Drag your avatar to the goal location. If the"
                + " avatar touches a wall, your level will be reset. Use the"
                + " teleportation pads to move around the map.  Good Luck!",
            rules.getText());
    }


    /**
     * tests if everything works correctly when the nextlevel button is clicked
     */
    public void testNextLevel()
    {
        // tests if the avatar is at the starting position to see if nextLevel
        // worked
        click(nextLevel);
        assertEquals(new PointF(216, 632), Puzzle.getAvatar().getPosition());
        assertEquals(8, rules.getVisibility());
        assertEquals(8, exit.getVisibility());
        assertEquals(8, nextLevel.getVisibility());
        Puzzle.getAvatar().setPosition(0, 0);
        touchDown(shapeView, Puzzle.getAvatar().getX(), Puzzle.getAvatar()
            .getY());
        touchMove(5, 5);
        touchUp();
        assertEquals(5, Puzzle.getAvatar().getX(), 0.1);
        assertEquals(5, Puzzle.getAvatar().getY(), 0.1);
    }


    /**
     * This method tests the end game text.
     */
    public void testEndGame()
    {
        assertEquals(endGame.getText(), "");
    }


    /**
     * tests if nextLevel works correctly
     */
    public void testLevel()
    {
        click(nextLevel);
        assertEquals(Puzzle.getLevel(), 2);

        // tests reset level
        this.getScreen().resetLevel(4);
        assertEquals(Puzzle.getAvatar().getX(), 20, 0.1);

        this.getScreen().resetLevel(3);
        assertEquals(Puzzle.getAvatar().getY(), Puzzle.getScreenheight(), 0.1);

        this.getScreen().resetLevel(2);
        assertEquals(Puzzle.getAvatar().getY(), Puzzle.getScreenheight(), 0.1);
    }


    /**
     * tests the movement of the avatar
     */
    public void testMovement()
    {
        getScreen().resetLevel(2);
        touchDown(shapeView, Puzzle.getAvatar().getX(), Puzzle.getAvatar()
            .getY());
        touchMove(Puzzle.getScreenwidth() / 2, 0);
        touchUp();
        assertEquals(Puzzle.getAvatar().getY(), 632, 0.1);
    }


    /**
     * tests if avatar is at the goal location
     */
    public void testGoal()
    {
        this.getScreen().resetLevel(3);
        assertFalse(getScreen().atGoal());
        Puzzle.getAvatar().setPosition(Puzzle.getScreenwidth() / 2, 0);
        assertTrue(getScreen().atGoal());
    }
}
