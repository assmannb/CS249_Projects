package p6_package;

/**
 * Base linked list class that emulates an array with bounds checking and
 * management for storing boxes
 * 
 * @author Benjamin Assmann
 * @version 1.0
 */
public class LinkedListClass
{
    private BoxClass headRef;

    /**
     * Default constructor
     */
    public LinkedListClass()
    {
        headRef = new BoxClass();
    }

    /**
     * Initializing constructor, fills all elements with specified size value up
     * to given size; overwrites any data already in list
     * 
     * @param size      - sets the number of items to be filled in linked list
     * @param fillValue - value to be placed in all elements of initialized
     *                  linked list up to the size
     */
    public LinkedListClass( int size, BoxClass fillValue )
    {
        int index;
        BoxClass workingRef = headRef;
        BoxClass tempBox;
        for( index = 0; index < size; index++ )
        {
            tempBox = new BoxClass( fillValue );
            workingRef.nextRef = tempBox;
            workingRef = workingRef.nextRef;
        }
    }

    /**
     * Copy constructor, initializes linked list to the size of copied linked
     * list, then copies only the elements up to the given size
     * 
     * @param copied - LinkedListClass object to be copied
     */
    public LinkedListClass( LinkedListClass copied )
    {
        headRef = copied.headRef;
    }

    /**
     * Accesses item in linked list at specified index if index within linked
     * list bounds
     * 
     * @param accessIndex - index of requested element value
     * @return accessed value if successful, null if not
     */
    public BoxClass accessItemAt( int accessIndex )
    {
        int index;
        if( accessIndex < 0 || accessIndex > getCurrentSize() )
        {
            return null;
        }
        BoxClass tempBox = headRef.nextRef;
        for( index = 1; index < accessIndex; index++ )
        {
            tempBox = tempBox.nextRef;
        }
        return tempBox;
    }

    /**
     * Appends item to end of linked list, if linked list is not full, e.g., no
     * more values can be added
     * 
     * @param newValue - BoxClass object to be appended to linked list
     */
    public void appendItem( BoxClass newValue )
    {
        BoxClass lastBox = findLastItemRef();
        lastBox.nextRef = newValue;
    }

    /**
     * Clears linked list of all valid values by setting linked list size to
     * zero, values remain in linked list but are not accessible
     */
    public void clear()
    {
        headRef = null;
    }

    /**
     * Simple linked list dump for testing purposes
     */
    public void dump()
    {

    }

    /**
     * Finds reference to last node in linked list
     * 
     * @return BoxClass reference to last item
     */
    private BoxClass findLastItemRef()
    {
        BoxClass tempBox = headRef;
        while( tempBox.nextRef != null )
        {
            return tempBox.nextRef;
        }
        return tempBox;
    }

    /**
     * Description: Gets current size of linked list
     * <p>
     * Note: size of linked list indicates number of valid or viable values in
     * the linked list
     * 
     * @return size of linked list
     */
    public int getCurrentSize()
    {
        return getCurrentSizeHelper( this.headRef );
    }

    /**
     * Recursive helper method finds length of linked list
     * 
     * @param workingRef- BoxClass reference used for recursion
     * @return integer value with size of linked list at a given point in the
     *         recursion
     */
    public int getCurrentSizeHelper( BoxClass workingRef )
    {
        int size = 1;
        if( workingRef != null )
        {
            return getCurrentSizeHelper( workingRef.nextRef ) + 1;
        }
        return size;
    }

    /**
     * Description: Inserts item into linked list at specified index
     * <p>
     * Note: Value is inserted at given index which is inserted into the linked
     * list at that point
     * <p>
     * Note: Value can be inserted after the last valid element but not at any
     * index past that point
     * 
     * @param insertIndex - index of element into which value is to be inserted
     * @param newValue    - value to be inserted into linked list
     * @return boolean success if inserted, or failure if linked list was full
     */
    public boolean insertItemAt( int insertIndex, BoxClass newValue )
    {
        if( insertIndex == 0 )
        {
            newValue.nextRef = headRef;
            headRef = newValue;
            return true;
        }
        else if( insertIndex > 0 )
        {
            BoxClass node = headRef;
            while( insertIndex-- > 0 )
            {
                node = node.nextRef;
            }
            newValue.nextRef = node.nextRef;
            node.nextRef = newValue;
            return true;
        }
        return false;
    }

    /**
     * Tests for size of linked list equal to zero, no valid values stored in
     * linked list
     * 
     * @return boolean result of test for empty
     */
    public boolean isEmpty()
    {
        return headRef == null;
    }

    /**
     * Tests for value found in object linked list; returns true if value within
     * linked list, false otherwise
     * 
     * @param testVal - value to be tested
     * @return boolean true if value is found in linked list, false otherwise
     */
    public boolean isInlinkedList( BoxClass testVal )
    {
        BoxClass tempBox = headRef;
        while( tempBox.nextRef != null )
        {
            if( tempBox == testVal )
            {
                return true;
            }
            tempBox = tempBox.nextRef;
        }
        return tempBox.nextRef == testVal;
    }

    /**
     * Description: Removes item from linked list at specified index if index
     * within linked list size bounds
     * 
     * @param removeIndex - index of element value to be removed
     * @return removed value if successful, null if not
     */
    public BoxClass removeItemAt( int removeIndex )
    {
        if( !isEmpty() )
        {
            BoxClass temp = headRef;
            if( removeIndex == 0 )
            {
                headRef = temp.nextRef;
            }
            for( int i = 0; temp != null && i < removeIndex - 1; i++ )
            {
                temp = temp.nextRef;
            }
            BoxClass next = temp.nextRef.nextRef;
            temp.nextRef = next;
            return headRef;
        }
        return null;
    }
}
