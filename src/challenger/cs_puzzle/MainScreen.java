package challenger.cs_puzzle;

import sofia.graphics.Shape;
import android.widget.Button;
import android.widget.TextView;
import sofia.app.ShapeScreen;

/**
 * The view for the game. All visual representations and interactions are
 * handled in this class.
 *
 * @author Amin Davoodi (amind1)
 * @author Estelle Susanto (estel94)
 * @author Sung Lee (satou)
 * @version Dec 7, 2013
 */
public class MainScreen
    extends ShapeScreen
{

    private TextView       endGame;
    private Puzzle         puzzle;
    private float          dy;
    private Avatar         avatar;
    private float          avaY;
    private static boolean insideAvatar;
    private static float   distanceTravelled;
    private float          dx;
    private float          avaX;
    private Button         nextLevel;
    private Button         reset;
    private Button         exit;
    private TextView       rules;


    /**
     * Initializes the screen and displays the avatar.
     */
    public void initialize()
    {
        puzzle = new Puzzle();
        puzzle.levelZero(this);
        dy = 0;
        avaY = 0;
        dx = 0;
        avaX = 0;
        avatar = Puzzle.getAvatar();
        setInsideAvatar(false);
        nextLevel.setVisibility(0);
        reset.setVisibility(8);
        exit.setVisibility(8);
        rules.setVisibility(0);
        rules.setText("Drag your avatar to the goal location."
            + " If the avatar touches a wall, your level will be reset."
            + " Use the teleportation pads to"
            + " move around the map.  Good Luck!");
    }


    /**
     * When finger is placed on screen, check if it is placed inside the avatar
     * or not.
     *
     * @param x
     *            coordinate of placement
     * @param y
     *            coordinate of placement
     */
    public void onTouchDown(float x, float y)
    {
        avaY = y;
        avaX = x;
        if (avatar != null)
        {
            if (avatar.contains(x, y))
            {
                setInsideAvatar(true);
            }
            else
            {
                setInsideAvatar(false);
            }
        }
    }


    /**
     * Checks if the avatar is at the goal or not.
     *
     * @return true if the avatar is at the goal
     */
    public boolean atGoal()
    {
        return (avatar.intersects(puzzle.getGoalLocation()));
    }


    /**
     * what happens when the user drags on the screen
     *
     * @param x
     *            the x coordinate that's touched
     * @param y
     *            the y coordinate that's touched
     */
    public void onTouchMove(float x, float y)
    {
        if (getInsideAvatar())
        {
            drag(x, y);
        }

    }


    /**
     * drags the object across the screen to get to the goal
     *
     * @param x
     *            the x coordinate moved
     * @param y
     *            the y coordinate moved
     */
    public void drag(float x, float y)
    {
        // Checks if the avatar is at the goal
        // if it is, remove the avatar,
        // set the "Congrats" text
        // and then place the "Next Level" button on the screen
        // IF AND ONLY IF it is not the last level of the game.
        if (atGoal())
        {
            avatar.remove();
            endGame.setText("Congratulations!  You Won!");
            if (Puzzle.getLevel() < 4)
            {
                nextLevel.setVisibility(0);
            }
            else
            {
                exit.setVisibility(0);
                reset.setVisibility(0);
            }
        }

        // when the avatar is anywhere else but the goal
        // calculate the distance in both the x and y direction
        // that the avatar moved (used to calculate the distance
        // that the walls should move).

        else if (x < getWidth() && x >= 0 && y < getHeight() && y >= 0)
        {
            dy = y - avaY;
            dx = x - avaX;

            // calculates the distance travelled as the avatar moves.
            setDistanceTravelled(getDistanceTravelled()
                + (Math.abs(dy) + Math.abs(dx)));

            // if pressed inside the avatar,
            if (getInsideAvatar())
            {
                avatar.setPosition(x, y);
                // constantly checks if the avatar is
                // colliding with teleportation pads or walls
                padCollision();
                wallCollision();
            }
        }
        avaY = y;
        avaX = x;
    }


    /**
     * This method resets the level at the end of every level.
     *
     * @param x
     *            the level number from 1 to 3
     */
    public void resetLevel(int x)
    {
        setInsideAvatar(false);
        Puzzle.getList().clear();
        this.clear();
        if (x == 1)
        {
            puzzle.levelZero(this);
        }
        else if (x == 2)
        {
            puzzle.levelOne(this);
        }
        else if (x == 3)
        {
            puzzle.levelTwo(this);
        }
        else if (x == 4)
        {
            puzzle.levelThree(this);
        }
        avatar = Puzzle.getAvatar();
    }


    /**
     * This method check if there is a pad collision with the avatar: aka, the
     * avatar is inside of the teleportation pad.
     */
    public void padCollision()
    {
        for (Shape shape : Puzzle.getList())
        {
            if (shape instanceof TeleportationPad)
            {
                TeleportationPad pad1 = (TeleportationPad)shape;
                for (Shape shape2 : Puzzle.getList())
                {
                    if (shape2 instanceof TeleportationPad
                        && !shape2.equals(pad1))
                    {
                        TeleportationPad pad2 = (TeleportationPad)shape2;

                        // connects both pad1 to pad2 and
                        // pad2 to pad1,
                        // which means that you can re-enter pad2
                        // and teleport back to pad1 if needed.
                        pad2.connect(pad1);
                        pad1.connect(pad2);
                        return;
                    }
                }
            }
        }
    }


    /**
     * This method checks if the avatar runs into a wall. if so, reset the leve.
     */
    public void wallCollision()
    {
        for (Shape shape : Puzzle.getList())
        {
            if (shape instanceof Wall)
            {
                Wall wall = (Wall)shape;
                if (avatar.intersects(wall))
                {
                    resetLevel(Puzzle.getLevel());
                }
                wall.moveWithAvatar(dy);
            }
        }
    }


    /**
     * When the "next level" button is clicked at the end of a level, reset the
     * next leve (load the next level) hides nextLevel button,. hides the rules.
     * hides the endGame "Congrats" text.
     */
    public void nextLevelClicked()
    {
        resetLevel(Puzzle.getLevel() + 1);
        nextLevel.setVisibility(8);
        rules.setVisibility(8);
        endGame.setText("");
    }


    /**
     * When the reset button is clicked at the end of the game it resets the
     * entire game (by resetting/loading the first level) Hides the buttons.
     */
    public void resetClicked()
    {
        resetLevel(2);
        nextLevel.setVisibility(8);
        endGame.setVisibility(8);
        reset.setVisibility(8);
        exit.setVisibility(8);
    }


    /**
     * When the exit button is clicked at the end of the entire game, exit the
     * entire system.
     */
    public void exitClicked()
    {
        System.exit(0);
    }


    /**
     * getter to check whether the person clicked inside the avatar or not.
     *
     * @return true if the avatar is clicked.
     */
    public static boolean getInsideAvatar()
    {
        return insideAvatar;
    }


    /**
     * setter for insideAvatar.
     *
     * @param insideAvatar
     *            true if location is inside, false if otherwise.
     */
    public static void setInsideAvatar(boolean insideAvatar)
    {
        MainScreen.insideAvatar = insideAvatar;
    }


    /**
     * getter for the distance traveled.
     *
     * @return distanceTravelled that calculated the distance traveled.
     */
    public static float getDistanceTravelled()
    {
        return distanceTravelled;
    }


    /**
     * Setter for the distance traveled.
     *
     * @param distanceTravelled
     *            takes in a float for the distance traveled.
     */
    public static void setDistanceTravelled(float distanceTravelled)
    {
        MainScreen.distanceTravelled = distanceTravelled;
    }
}
