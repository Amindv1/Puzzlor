package challenger.cs_puzzle;


import java.util.NoSuchElementException;
import java.util.Iterator;

// -------------------------------------------------------------------------
/**
 * Example unit tests for the CircularLinkedList class.
 *
 *  @author Amin Davoodi (amind1)
 *  @author Estelle Susanto (estel94)
 *  @author Sung Lee (satou)
 *  @version Dec 7, 2013
 */
public class CircularLinkedListTests
    extends student.TestCase
{
    // ~ Fields ................................................................

    private CircularLinkedList<String> list;


    // ~ Public methods ........................................................

    /**
     * Creates a brand new, empty CircularLinkedList for each test method.
     */
    public void setUp()
    {
        list = new CircularLinkedList<String>();
    }


    /**
     * tests the next method
     */
    public void testNext()
    {
        list.next();

        list.add("hi");
        list.next();
        assertEquals(list.getCurrent(), "hi");
        list.add("bye");
        list.next();
        assertEquals(list.getCurrent(), "hi");
        list.next();
        assertEquals(list.getCurrent(), "bye");

    }


    /**
     * tests previous method
     */
    public void testPrevious()
    {
        list.previous();

        list.add("hi");
        list.add("bye");
        list.add("yo");
        list.add("hey");
        list.previous();
        assertEquals(list.getCurrent(), "hi");
        list.previous();
        assertEquals(list.getCurrent(), "bye");
        list.previous();
        assertEquals(list.getCurrent(), "yo");
        list.previous();
        assertEquals(list.getCurrent(), "hey");
    }


    /**
     * tests getCurrent method
     */
    public void testGetCurrent()
    {
        Exception thrown = null;
        try
        {
            list.getCurrent();
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof NoSuchElementException);
        assertEquals("The list is empty", thrown.getMessage());

        list.add("hi");
        assertEquals(list.getCurrent(), "hi");
    }


    /**
     * tests the size method
     */
    public void testSize()
    {
        assertEquals(list.size(), 0);
        list.add("y");
        assertEquals(list.size(), 1);
    }


    /**
     * tests add method
     */
    public void testAdd()
    {
        list.add("hi");
        assertEquals(list.size(), 1);
        assertNotNull(list.getCurrent());

        list.add("gg");
        list.removeCurrent();

        assertEquals(list.getCurrent(), "hi");

    }


    /**
     * tests removeCurrent method
     */
    public void testRemoveCurrent()
    {
        list.add("hello");
        list.add("hi");
        list.add("bye");
        assertEquals(list.size(), 3);

        assertEquals(list.removeCurrent(), "bye");
        assertEquals(list.getCurrent(), "hi");
        assertEquals(list.size(), 2);

        assertEquals(list.removeCurrent(), "hi");
        assertEquals(list.getCurrent(), "hello");
        assertEquals(list.size(), 1);

        list.removeCurrent();
        assertEquals(list.size(), 0);

        Exception thrown = null;
        try
        {
            list.removeCurrent();
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof NoSuchElementException);
        assertEquals(
            "The list is empty, there is nothing to remove.",
            thrown.getMessage());

    }


    /**
     * tests clear method
     */
    public void testClear()
    {
        list.add("");
        list.add("");
        list.clear();
        assertEquals(list.size(), 0);
    }


    /**
     * tests toString method
     */
    public void testToString()
    {
        assertEquals(list.toString(), "[]");

        list.add("hi");
        list.add("hello");

        assertEquals(list.toString(), "[hello, hi]");

        Exception thrown = null;
        try
        {
            list.iterator().remove();
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof UnsupportedOperationException);
        assertEquals("remove() is not supported.", thrown.getMessage());


    }


    /**
     * tests the iterators next method
     */
    public void testIteratorNext()
    {
        list.add("yo");
        Iterator<String> iter = list.iterator();
        iter.next();

        Exception thrown = null;
        try
        {
            iter.next();
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertTrue(thrown instanceof NoSuchElementException);
        assertEquals("There isnt another element", thrown.getMessage());

        for (String str : list) {
            assertNotNull(str);
        }

    }
}
