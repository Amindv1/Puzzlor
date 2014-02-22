package challenger.cs_puzzle;

import sofia.graphics.RectangleShape;

/**
 * The walls of the maze. These are added in the Puzzle class. Each wall
 * will have properties that will be implemented in this class eg: you can not
 * move through walls
 *
 * @author Amin Davoodi (amind1)
 * @author Estelle Susanto (estel94)
 * @author Sung Lee (satou)
 * @version Dec 7, 2013
 */
public class Location
    extends RectangleShape
{
    private float left;
    private float top;
    private float right;
    private float bottom;


    /**
     * Create a new Wall object.
     *
     * @param left
     *            the top-left coordinate of the shape
     * @param top
     *            the top-right coordinate of the shape
     * @param right
     *            the bottom-right coordinate of the shape
     * @param bottom
     *            the bottom left coordinate of the shape
     */
    public Location(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        this.bottom = bottom;
        this.right = right;
        this.left = left;
        this.top = top;
    }


    /**
     * updates the location of the wall
     *
     * @param lef
     *            the left position of the wall
     * @param to
     *            the top position of the wall
     * @param rig
     *            the right position of the wall
     * @param bot
     *            the bottom position of the wall
     */
    public void updateLocation(float lef, float to, float rig, float bot)
    {
        left = lef;
        top = to;
        right = rig;
        bottom = bot;
    }


    /**
     * gets the top coordinate of this object
     *
     * @return returns the top coordinate
     */
    public float top()
    {
        return top;
    }


    /**
     * gets the right coordinate of this object
     *
     * @return returns the right coordinate
     */
    public float right()
    {
        return right;
    }


    /**
     * gets the left coordinate of this object
     *
     * @return returns the left coordinate
     */

    public float left()
    {
        return left;
    }


    /**
     * gets the bottom coordinate of this object
     *
     * @return returns the bottom coordinate
     */
    public float bottom()
    {
        return bottom;
    }

}
