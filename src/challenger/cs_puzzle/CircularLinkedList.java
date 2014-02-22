package challenger.cs_puzzle;



import java.util.Iterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 * A circular, doubly-linked list.
 *
 * @param <E>
 *            the type of element stored in the list
 *
 *  @author Amin Davoodi (amind1)
 *  @author Estelle Susanto (estel94)
 *  @author Sung Lee (satou)
 *  @version Dec 7, 2013
 */
public class CircularLinkedList<E> implements Iterable<E>
{
    // ~ Fields ................................................................

    private Node<E> current;
    private int     size;


    // ----------------------------------------------------------
    /**
     * Create a new CircularLinkedList object.
     */
    public CircularLinkedList()
    {
        current = null;
        size = 0;
    }


    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * moves the current location to the next node, if the list is empty nothing
     * happens. If you are at the end of the list it moves to the first item in
     * the list
     */
    public void next()
    {
        if (size != 0)
        {
            current = current.next();
        }
    }


    // ----------------------------------------------------------
    /**
     * moves the current location to the previous node, if the list is empty
     * nothing happens. If you are at the begining of the list it moves to the
     * last item in the list
     */
    public void previous()
    {
        if (size != 0)
        {
            current = current.previous();
        }

    }


    /**
     * returns the data at the current location, throws an exception if the node
     * is null.
     *
     * @return the data of the current node
     */
    public E getCurrent()
    {
        if (size != 0)
        {
            return current.data();
        }
        else
        {
            throw new NoSuchElementException("The list is empty");
        }
    }


    // ----------------------------------------------------------
    /**
     * returns the size of the list
     *
     * @return returns the number of elements
     */
    public int size()
    {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * adds an item right before the current item and sets the current item
     * equal to the item added.
     *
     * @param item
     *            the data being added to the list
     */
    public void add(E item)
    {

        Node<E> node = new Node<E>(item);
        // if it is the first item in the list, it sets the current item to the
        // new item
        if (size == 0)
        {
            current = node;
            current.join(current);
            size++;
            return;
        }

        Node<E> previous = current.previous();
        previous.split();
        node.join(current);
        previous.join(node);
        current = node;

        size++;
    }


    /**
     * removes the current node and sets the node before it to the new current
     * node. If the list is empty it throws an exception.
     *
     * @return returns the data of the node removed.
     */
    public E removeCurrent()
    {
        if (size == 0)
        {
            throw new NoSuchElementException(
                "The list is empty, there is nothing to remove.");
        }

        Node<E> previous = current.previous();
        Node<E> next = current.next();
        Node<E> oldCurrent = current;
        current.split();
        previous.split();
        previous.join(next);
        current = next;

        size--;
        return oldCurrent.data();
    }


    /**
     * Removes all the elements from the list.
     */
    public void clear()
    {
        current = null;
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * returns a string representation of the circular linked list.
     *
     * @return the elements in the list
     */
    public String toString()
    {

        String str = "[";
        Iterator<E> iterate = iterator();
        if (size == 0)
        {
            return "[]";
        }
        while (iterate.hasNext())
        {
            str += (iterate.next() + ", ");
        }
        return str.substring(0, str.length() - 2) + "]";
    }


    // ----------------------------------------------------------
    /**
     * creates a new iterator
     * @return returns a new iterator
     */
    public Iterator<E> iterator()
    {
        return new CircularLinkedListIterator();
    }


    // ~ Inner classes .........................................................

    // ----------------------------------------------------------
    /**
     * makes an iterator for this class
     *
     * @author Amin Davoodi amind1
     * @version Nov 7, 2013
     */
    private class CircularLinkedListIterator
        implements Iterator<E>
    {
        // ~ Fields ............................................................

        private int     count       = size;
        private Node<E> currentNode = current;


        // ~ Constructors ......................................................

        /**
         * if there is another element in the list it will move to that element
         *
         * @return returns true or false if there is a next
         */
        public boolean hasNext()
        {
            return (count > 0);
        }


        /**
         * moves to the next item in the iterator
         *
         * @return returns the next element in the list
         */
        public E next()
        {
            if (hasNext())
            {
                E item = currentNode.data();
                currentNode = currentNode.next();
                count--;
                return item;
            }
            else
            {
                throw new NoSuchElementException("There isnt another element");

            }
        }


        /**
         * this method is unsupported
         */
        public void remove()
        {
            throw new UnsupportedOperationException(
                "remove() is not supported.");
        }
    }
}
