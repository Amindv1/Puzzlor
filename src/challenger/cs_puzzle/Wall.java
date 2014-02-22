package challenger.cs_puzzle;

import sofia.graphics.Color;

/**
 *  This creates the wall that moves right onto the screen.
 *  And also moves it according to the avatar movement.
 *
 *  @author Amin Davoodi (amind1)
 *  @author Estelle Susanto (estel94)
 *  @author Sung Lee (satou)
 *  @version Dec 7, 2013
 */
public class Wall
    extends Location
{

    /**
     * Create a new Wall object.
     *
     * @param left takes in the left coordinate
     * @param top takes in the top coordinate
     * @param right takes in the right coordinate
     * @param bottom takes in the bottom coordinate
     */
    public Wall(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        setFillColor(Color.green);
    }


    /**
     * moves the wall the distance in the y direction that
     * the avatar moved in.
     *
     * @param y distance in the y that the avatar moved
     */
    public void moveWithAvatar(float y)
    {
        this.moveBy(-(y / 4), 0);
        updateLocation(this.left() - (y - 4), this.top(), this.right()
            - (y / 4), this.bottom());
    }

}
