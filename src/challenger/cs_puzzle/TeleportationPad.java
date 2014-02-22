package challenger.cs_puzzle;

import sofia.graphics.Color;

// -------------------------------------------------------------------------
/**
 *  This method creates the teleportation pads for the game.
 *  When the avatar enters one teleportation pad, it
 *  teleports the avatar to the location of the other teleportation pad.
 *  It works vice versa.
 *
 *  @author Amin Davoodi (amind1)
 *  @author Estelle Susanto (estel94)
 *  @author Sung Lee (satou)
 *  @version Dec 7, 2013
 */
public class TeleportationPad
    extends Location
{

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
    public TeleportationPad(float left, float top, float right, float bottom)
    {
        super(left, top, right, bottom);
        this.setFillColor(Color.purple);
    }


    /**
     * Connects the two pads.
     *
     * @param pad of type Teleportation connects the two pads.
     */
    public void connect(TeleportationPad pad)
    {
        if (this.intersects(Puzzle.getAvatar()) && pad != null
            && MainScreen.getDistanceTravelled() > 35)
        {
            Puzzle.getAvatar().setPosition(pad.getX(), pad.getY());
            MainScreen.setInsideAvatar(false);
            MainScreen.setDistanceTravelled(0);
        }
    }


    /**
     * this method checks to see if the object passed to it is another
     * teleportation-pad that has the same coordinates and is indeed in the same
     * location
     *
     * @param obj
     *            the object to compare to
     * @return returns true if they have the same top, right, left & bottom
     *         coordinates
     */
    public boolean equals(Object obj)
    {
        if (obj instanceof TeleportationPad)
        {
            TeleportationPad pad = (TeleportationPad)obj;
            return (pad.right() == this.right() && pad.left() == this.left()
                && pad.top() == this.top() && pad.bottom() == this.bottom());
        }
        else
        {
            return false;
        }
    }

}
