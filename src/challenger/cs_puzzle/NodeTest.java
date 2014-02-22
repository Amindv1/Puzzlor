package challenger.cs_puzzle;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests for the Node class.
 *
 *  @author Amin Davoodi (amind1)
 *  @author Estelle Susanto (estel94)
 *  @author Sung Lee (satou)
 *  @version Dec 7, 2013
 */
public class NodeTest
    extends TestCase
{
    // ~ Fields ................................................................

    private Node<String> node1;
    private Node<String> node2;
    private Node<String> node3;


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Create some new nodes for each test method.
     */
    public void setUp()
    {
        node1 = new Node<String>("node1");
        node2 = new Node<String>("node2");
        node3 = new Node<String>("node3");
    }


    // ----------------------------------------------------------
    /**
     * Tests the join method
     */
    public void testJoin()
    {
        setUp();
        node2.join(node3);
        assertEquals(node2, node3.previous());
        assertEquals(node3, node2.next());

        setUp();
        node2.join(node3);
        Exception thrown = null;
        Exception thrown2 = null;
        try
        {
            node1.join(node3);
        }
        catch (Exception e)
        {
            thrown = e;
        }
        try
        {
            node2.join(node1);
        }
        catch (Exception e)
        {
            thrown2 = e;
        }
        assertTrue(thrown instanceof IllegalStateException);
        assertEquals(
            "A node is already preceding the one passed to this method.",
            thrown.getMessage());
        assertTrue(thrown2 instanceof IllegalStateException);
        assertEquals(
            "A node is already following this one.",
            thrown2.getMessage());
        setUp();
        node1.join(null);
        assertEquals(node1.next(), null);
    }


    // ----------------------------------------------------------
    /**
     * Tests the split method
     */
    public void testSplit()
    {
        setUp();
        node1.join(node2);
        node2.join(node3);
        node2.split();
        assertEquals(null, node2.next());
        node2.split();
        assertEquals(null, node2.next());
    }


    // ----------------------------------------------------------
    /**
     * Tests the setData method
     */
    public void testSetData()
    {
        node1.setData("Not node 1");
        assertEquals("Not node 1", node1.data());
    }
}
