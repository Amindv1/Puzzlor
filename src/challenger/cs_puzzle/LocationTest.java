package challenger.cs_puzzle;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * This is the location tester class. It tests the location class.
 *
 *  @author Amin Davoodi (amind1)
 *  @author Estelle Susanto (estel94)
 *  @author Sung Lee (satou)
 *  @version Dec 7, 2013
 */
public class LocationTest
    extends TestCase
{
    private Location location;


    /**
     * This is the set up method for the Location Test class.
     */
    public void setUp()
    {
        location = new Location(1, 2, 3, 4);
    }


    // ----------------------------------------------------------
    /**
     * Tests the updateLocation() method.
     * updates the location then checks if each side
     * is at the correct corresponding location.
     */
    public void testUpdateLocation()
    {
        location.updateLocation(2, 1, 1, 1);
        assertEquals(location.right(), 1, 0.1);
        assertEquals(location.left(), 2, 0.1);
        assertEquals(location.top(), 1, 0.1);
        assertEquals(location.bottom(), 1, 0.1);
    }


    /**
     * Tests getting the left of the object.
     */
    public void testLeft()
    {
        assertEquals(1.0, location.left(), 0.01);
    }


    /**
     * Tests getting the top of the object.
     */
    public void testTop()
    {

        assertEquals(2.0, location.top(), 0.01);
    }


    /**
     * Tests getting the right of the object.
     */
    public void testRight()
    {
        assertEquals(3.0, location.right(), 0.01);
    }


    /**
     * Tests getting the bottom of the object.
     */
    public void testBottom()
    {
        assertEquals(4.0, location.bottom(), 0.01);
    }

}
