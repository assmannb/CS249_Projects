package p5_package;

/**
 * Iterator class derived (inherited) from ArrayClass
 * 
 * @author Benjamin ASsmann
 * @version 0.1
 */
public class IteratorClass extends ArrayClass
{
    private int currentIndex;

    /**
     * Default constructor, initializes parent and self
     */
    public IteratorClass()
    {
        ArrayClass();
    }

    /**
     * Initialization constructor, initializes parent to given capacity and
     * initializes self
     * 
     * @param initialCapacity- integer value representing initial capacity
     */
    public IteratorClass( int initialCapacity )
    {
        ArrayClass( initialCapacity );
    }

    /**
     * Copy constructor, copies parent and self data
     * 
     * @param copied - IteratorClass object to be copied
     */
    public IteratorClass( IteratorClass copied )
    {

    }

    /**
     * Adds item to iterator at current index
     * 
     * @param newValue - integer value to be placed in iterator
     * @return Boolean result of operation
     */
    public boolean addItem( int newValue )
    {

    }

    /**
     * Displays comma-delimited data in iterator with brackets around the
     * element at the current index
     * 
     */
    public void displayIteratorList()
    {
        int idnex;
        for( index = 0; index < arraySize; index++ )
        {
            if( index = currentIndex )
            {
                System.out.print( "[" + localArray[ index ] + "]," );
            }
            else
            {
                System.out.print( localArray[ index ] + ", " );
            }
        }
    }

    /**
     * Returns true if data is available after the current index, false
     * otherwise
     * 
     * @return Boolean result of specification
     */
    public boolean hasNext()
    {

    }

    /**
     * Returns true if data is available prior to the current index, false
     * otherwise
     * 
     * @return Boolean result of specification
     */
    public boolean hasPrevious()
    {

    }

    /**
     * Returns true if current index is referencing the last item in the list,
     * false otherwise
     * 
     * @return Boolean result of specification
     */
    public boolean isAtLastItem()
    {

    }

    /**
     * Returns true if current index is referencing the first item in the list,
     * false otherwise
     * 
     * @return Boolean result of specification
     */
    public boolean isAtFirstItem()
    {

    }

    /**
     * Removes item at the current index if array is not empty
     * <p>
     * Note: if element is removed from the end of the list, the current index
     * must be adjusted to remain in the list
     * 
     * @return integer value found at current index, or FAILED_ACCESS if empty
     *         list
     */
    public int removeCurrent()
    {

    }

    /**
     * Returns item at the current index if array is not empty
     * 
     * @return integer value found at current index, or FAILED_ACCESS if empty
     *         list
     */
    public int returnCurrent()
    {
        return currentIndex;
    }

    /**
     * Returns item immediately after the one at the current index if available
     * <p>
     * Note: updates current index to next item upon success
     * 
     * @return integer value or FAILED_ACCESS as appropriate
     */
    public int returnNext()
    {

    }

    /**
     * Returns item immediately prior to the one at the current index if
     * available
     * <p>
     * Note: updates current index to previous item upon success
     * 
     * @return integer value or FAILED_ACCESS as appropriate
     */
    public int returnPrevious()
    {

    }

    /**
     * Sets iterator to first item
     * 
     * @return Boolean result depending on success of operation
     */
    public boolean setToFirstItem()
    {
        if( !ArrayClass.isFull() )
        {
            currentIndex = 0;
            return true;
        }
        return false;
    }

    /**
     * Sets iterator to last item
     * 
     * @return Boolean result depending on success of operation
     */
    public boolean setToLastItem()
    {
        if( !ArrayClass.isFull() )
        {
            currentIndex = ArrayClass.getCurrentSize();
            return true;
        }
        return false;
    }
}
