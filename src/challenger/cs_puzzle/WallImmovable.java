package challenger.cs_puzzle;

import sofia.graphics.Color;

/**
 * This creates the immovable wall onto the screen. And also moves it according
 * to the avatar movement.
 *
 * @author Amin Davoodi (amind1)
 * @author Estelle Susanto (estel94)
 * @author Sung Lee (satou)
 * @version Dec 7, 2013
 */
public class WallImmovable
    extends Wall
{
    /**
     * Create a new Wall object.
     *
     * @param left
     *            takes in the left coordinate
     * @param top
     *            takes in the top coordinate
     * @param right
     *            takes in the right coordinate
     * @param bottom
     *            takes in the bottom coordinate
     */
    public WallImmovable(
        final float left,
        final float top,
        final float right,
        final float bottom)
    {
        super(left, top, right, bottom);
        setFillColor(Color.greenYellow);
    }


    /**
     * This method does nothing because this wall is "immovable".
     * @param y  this parameter does nothing
     */
    @Override
    public void moveWithAvatar(float y)
    {
        // This Method Does nothing
    }

}
