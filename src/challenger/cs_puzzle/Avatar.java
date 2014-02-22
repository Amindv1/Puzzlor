package challenger.cs_puzzle;

import sofia.graphics.Color;
import sofia.graphics.OvalShape;

/**
 *  This class creates the avatar of an OvalShape.
 *
 *  @author Amin Davoodi (amind1)
 *  @author Estelle Susanto (estel94)
 *  @author Sung Lee (satou)
 *  @version Dec 7, 2013
 */
public class Avatar
    extends OvalShape
{
    /**
     * Create a new Avatar object.
     * @param xCoord of the x location.
     * @param yCoord of the y location.
     */
    public Avatar(float xCoord, float yCoord)
    {
        super(xCoord, yCoord, 8);
        setFillColor(Color.blue);
    }
}
