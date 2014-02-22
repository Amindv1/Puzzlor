package challenger.cs_puzzle;

import sofia.graphics.Color;
import sofia.app.ShapeScreen;
import sofia.graphics.Shape;

/**
 * // -------------------------------------------------------------------------
 * /** The main puzzle in which the view is designed over. The levels are
 * created in this class and the locations of the objects are all placed in this
 * class.
 *
 * @author Amin Davoodi (amind1)
 * @author Estelle Susanto (estel94)
 * @author Sung Lee (satou)
 * @version Dec 7, 2013
 */
public class Puzzle
{
    private Location                        goalLocation;
    private static final int                SCREENWIDTH  = 432;
    private static final int                SCREENHEIGHT = 632;
    private static CircularLinkedList<Shape> list;
    private static Avatar                   avatar;
    private static int                      level;


    /**
     * creates a new puzzle.
     */
    public Puzzle()
    {
        setList(new CircularLinkedList<Shape>());
        setLevel(0);
    }


    /**
     * creates the first level of the game
     *
     * @param screen
     *            takes in the screen to be drawn on.
     */

    public void levelZero(ShapeScreen screen)
    {
        setLevel(1);
    }


    // ----------------------------------------------------------
    /**
     * This method designs level 1 of the game.
     *
     * @param screen
     *            that the level is made on is passed in
     */
    public void levelOne(ShapeScreen screen)
    {
        goalLocation =
            new Location(
                getScreenwidth() / 2 - 30,
                0,
                getScreenwidth() / 2 + 30,
                20);
        goalLocation.setFillColor(Color.red);
        setAvatar(new Avatar(getScreenwidth() / 2, getScreenheight()));
        getList().add(getAvatar());
        Wall wall1 =
            new Wall(
                0,
                getScreenheight() / 2,
                (float)(.75 * getScreenwidth()),
                getScreenheight() - 250);
        WallOpposite wall2 =
            new WallOpposite(
                getScreenwidth() / 2,
                getScreenheight() / 4,
                getScreenwidth(),
                getScreenheight() - 400);
        getList().add(wall2);
        getList().add(wall1);
        getList().add(goalLocation);

        spawnLevel(screen);
        setLevel(2);
    }


    /**
     * This method designs level 2 of the game.
     *
     * @param screen
     *            that the level is made on is passed in
     */
    public void levelTwo(ShapeScreen screen)
    {
        getList().clear();
        goalLocation =
            new Location(
                getScreenwidth() / 2 - 30,
                0,
                getScreenwidth() / 2 + 30,
                20);
        goalLocation.setFillColor(Color.red);
        getList().add(goalLocation);
        setAvatar(new Avatar(getScreenwidth() / 2, getScreenheight()));
        getList().add(getAvatar());
        TeleportationPad pad =
            new TeleportationPad(
                getScreenwidth() - 15,
                getScreenheight() - 15,
                getScreenwidth(),
                getScreenheight());
        TeleportationPad pad2 = new TeleportationPad(0, 0, 15, 15);
        getList().add(pad);
        getList().add(pad2);
        getList().add(
            new WallImmovable(
                0,
                getScreenheight() / 2,
                getScreenwidth(),
                getScreenheight() / 2 + 30));
        spawnLevel(screen);
        setLevel(3);
    }


    /**
     * This method designs level 3 of the game.
     *
     * @param screen
     *            that the level is made on is passed in
     */
    public void levelThree(ShapeScreen screen)
    {
        getList().clear();
        goalLocation = new Location(20, 0, 60, 20);
        goalLocation.setFillColor(Color.red);
        getList().add(goalLocation);
        setAvatar(new Avatar(20, getScreenheight() - 20));
        getList().add(getAvatar());
        getList().add(
            new WallImmovable(
                getScreenwidth() - 50,
                getScreenheight() - 50,
                getScreenwidth(),
                getScreenheight()));
        getList().add(
            new Wall(
                10,
                getScreenheight() - 70,
                getScreenwidth() - 70,
                getScreenheight() - 50));
        getList().add(
            new WallDown(
                100,
                getScreenheight() / 2,
                120,
                getScreenheight() - 120));
        getList().add(
            new WallUp(
                0,
                getScreenheight() / 2 - 30,
                120,
                getScreenheight() / 2));
        getList().add(
            new TeleportationPad(
                getScreenwidth() - 20,
                0,
                getScreenwidth(),
                20));
        getList().add(
            new TeleportationPad(
                getScreenwidth() - 20,
                getScreenheight() / 2 - 20,
                getScreenwidth(),
                getScreenheight() / 2));
        getList().add(
            new WallOpposite(
                getScreenwidth() / 2,
                getScreenheight() / 2 - 20,
                getScreenwidth(),
                getScreenheight() / 2));
        getList().add(
            new WallImmovable(
                getScreenwidth() - 45,
                getScreenheight() / 2 - 50,
                getScreenwidth() - 25,
                getScreenheight() / 2));
        getList().add(new WallImmovable(0, 30, getScreenwidth(), 50));
        setLevel(4);
        spawnLevel(screen);
    }


    /**
     * sets the game goal Location
     *
     * @param goalLoc
     *            takes in the location of the goal.
     */
    public void setGoalLoc(Location goalLoc)
    {

        goalLocation = goalLoc;
    }


    /**
     * gets the starting location
     *
     * @return avatar : the start location of avatar
     */
    public static Avatar getAvatar()
    {
        return avatar;
    }


    /**
     * gets the goal location
     *
     * @return goalLocation : the goal location
     */
    public Location getGoalLocation()
    {
        return goalLocation;
    }


    /**
     * Loads the level.
     *
     * @param screen
     *            : takes in the screen that the levels are drawn on.
     */
    public void spawnLevel(ShapeScreen screen)
    {
        for (Shape shape : getList())
        {
            screen.add(shape);
        }
    }


    /**
     * Getter for the level of the game.
     *
     * @return level of the game.
     */
    public static int getLevel()
    {
        return level;
    }


    /**
     * Getter for the list of type Shape.
     *
     * @return list of the CircularLinkedList.
     */
    public static CircularLinkedList<Shape> getList()
    {
        return list;
    }

    /**
     * Setter for the avatar.
     *
     * @param avatar
     *            of type Avatar is passed in.
     */
    public void setAvatar(Avatar avatar)
    {
        Puzzle.avatar = avatar;
    }


    /**
     * getter for the screenwidth.
     *
     * @return SCREENWIDTH of the screen.
     */
    public static int getScreenwidth()
    {
        return SCREENWIDTH;
    }


    /**
     * getter for the screenheight;
     *
     * @return SCREENHEIGHT of the screen.
     */
    public static int getScreenheight()
    {
        return SCREENHEIGHT;
    }


    // ----------------------------------------------------------
    /**
     * sets the current level
     *
     * @param level
     *            the level to be set to
     */
    public static void setLevel(int level)
    {
        Puzzle.level = level;
    }



    /**
     * Setter for the list of type shape.
     *
     * @param list
     *            takes in the list of CircularLinkedList<Shape>
     */
    public static void setList(CircularLinkedList<Shape> list)
    {
        Puzzle.list = list;
    }

}
