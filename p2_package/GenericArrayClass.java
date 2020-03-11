package p2_package;

/**
 * Description: Class wrapper for a Java array of generic data (classes), with
 * additional management operations
 * 
 * @author Benjamin Assmann
 * @version 1.0
 */
public class GenericArrayClass<GenericData extends Comparable<GenericData>>
{
    private int arrayCapacity;
    private int arraySize;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] localArray;

    /**
     * Default constructor, initializes array to default capacity (10)
     **/
    GenericArrayClass()
    {
        localArray = new Object[ DEFAULT_CAPACITY ];
        arrayCapacity = DEFAULT_CAPACITY;
        arraySize = 0;
    }

    /**
     * Initializing constructor, initializes array to specified capacity
     * 
     * @param capacity - integer maximum capacity specification for the array
     */
    GenericArrayClass( int capacity )
    {
        arrayCapacity = capacity;
        localArray = new Object[ capacity ];
        arraySize = 0;
    }

    /**
     * Accesses item in array at specified index if index within array size
     * bounds
     * 
     * @param accessIndex - index of requested element value
     * @return accessed value if successful, null if not
     */
    @SuppressWarnings( "unchecked" )
    public GenericData accessItemAt( int accessIndex )
    {
        GenericData accessItem;
        if( accessIndex < arraySize )
        {
            accessItem = ( GenericData ) localArray[ accessIndex ];
            return accessItem;
        }
        return null;
    }

    /**
     * Appends item to end of array, if array is not full, e.g., no more values
     * can be added
     * 
     * @param newValue - value to be appended to array
     * @return Boolean success if appended, or failure if array was full
     */
    public boolean appendItem( GenericData newValue )
    {
        if( !isFull() )
        {
            localArray[ arraySize ] = newValue;
            arraySize++ ;
            return true;
        }
        return false;
    }

    /**
     * Clears array of all valid values by setting array size to zero, values
     * remain in array but are not accessible
     */
    public void clear()
    {
        arraySize = 0;
    }

    /**
     * Description: Gets current capacity of array
     * <p>
     * Note: capacity of array indicates number of values the array can hold
     * 
     * @return capacity of array
     */
    public int getCurrentCapacity()
    {
        return arrayCapacity;
    }

    /**
     * Description: Gets current size of array
     * <p>
     * Note: size of array indicates number of valid or viable values in the
     * array
     * 
     * @return size of array
     */
    public int getCurrentSize()
    {
        return arraySize;
    }

    /**
     * Description: Inserts item to array at specified index if array is not
     * full, e.g., no more values can be added
     * <p>
     * Note: Value is inserted at given index, all data from that index to the
     * end of the array is shifted up by one
     * 
     * @param insertIndex - index of element into which value is to be inserted
     * @param newValue    - value to be inserted into array
     * @return Boolean success if inserted, or failure if array was full
     */
    public boolean insertItemAt( int insertIndex, GenericData newValue )
    {
        int index;
        if( !isFull() )
        {
            for( index = arraySize; index > insertIndex; index-- )
            {
                localArray[ index ] = localArray[ index - 1 ];
            }
            localArray[ insertIndex ] = newValue;
            arraySize++ ;
            return true;
        }

        return false;
    }

    /**
     * Tests for size of array equal to zero, no valid values stored in array
     * 
     * @return Boolean result of test for empty
     */
    public boolean isEmpty()
    {
        return arraySize == 0;
    }

    /**
     * Tests for size of array equal to capacity, no more values can be added
     * 
     * @return Boolean result of test for full
     */
    public boolean isFull()
    {
        return arraySize >= arrayCapacity;
    }

    /**
     * Description: Removes item from array at specified index if index within
     * array size bounds
     * <p>
     * Note: Each data item from the element immediately above the remove index
     * to the end of the array is moved down by one element
     * 
     * @param removeIndex - index of element value to be removed
     * @return removed value if successful, null if not
     */
    @SuppressWarnings( "unchecked" )
    public GenericData removeItemAt( int removeIndex )
    {
        int index;
        if( removeIndex >= 0 )
        {
            GenericData index_element = ( GenericData ) localArray[ removeIndex
                    + 1 ];
            for( index = removeIndex; index < arraySize - 1; index++ )
            {
                localArray[ index ] = localArray[ index + 1 ];
            }
            arraySize-- ;
            return index_element;
        }
        return null;
    }

    /**
     * Description: Resets array capacity, copies current size and current size
     * number of elements
     * <p>
     * Exception: Method will not resize capacity below current array size,
     * returns false if this is attempted, true otherwise
     * 
     * @param newCapacity - new capacity to be set; must be larger than current
     *                    capacity
     * @return Boolean condition of resize success or failure
     */
    public boolean resize( int newCapacity )
    {
        int index;
        if( newCapacity >= arraySize )
        {
            arrayCapacity = newCapacity;
            Object copiedArray[] = new Object[ arrayCapacity ];
            for( index = 0; index < arraySize; index++ )
            {
                copiedArray[ index ] = localArray[ index ];
            }
            localArray = copiedArray;
            return true;
        }
        return false;
    }

    /**
     * Description: Sorts elements using the bubble sort algorithm
     * <p>
     * Note: The data is sorted using the compareTo method of the given data
     * set; the compareTo method decides the key and the order resulting
     */
    @SuppressWarnings( "unchecked" )
    public void runBubbleSort()
    {
        int index;
        int moveIndex;
        GenericData swapObject1, swapObject2;
        for( index = 0; index < arraySize; index++ )
        {
            for( moveIndex = 0; moveIndex < arraySize - 1; moveIndex++ )
            {
                swapObject1 = ( GenericData ) localArray[ moveIndex ];
                swapObject2 = ( GenericData ) localArray[ index ];
                if( swapObject1.compareTo( swapObject2 ) > 0 )
                {
                    swapElements( index, moveIndex );
                }
            }
        }

    }

    /**
     * Description: Sorts elements using the insertion sort algorithm
     * <p>
     * Note: The data is sorted using the compareTo method of the given data
     * set; the compareTo method decides the key and the order resulting
     */
    @SuppressWarnings( "unchecked" )
    public void runInsertionSort()
    {
        int innerIndex, outerIndex;
        GenericData innerIndexData, outerIndexData;
        for( outerIndex = 1; outerIndex < arraySize; outerIndex++ )
        {
            outerIndexData = ( GenericData ) localArray[ outerIndex ];
            innerIndex = outerIndex;
            innerIndexData = ( GenericData ) localArray[ innerIndex - 1 ];
            while( ( innerIndex > 0 )
                    && ( outerIndexData.compareTo( innerIndexData ) < 0 ) )
            {
                localArray[ innerIndex ] = localArray[ innerIndex - 1 ];
                innerIndex-- ;
            }
            localArray[ innerIndex ] = outerIndexData;
        }
    }

    /**
     * Description: Sorts elements using the selection sort algorithm
     * <p>
     * Note: The data is sorted using the compareTo method of the given data
     * set; the compareTo method decides the key and the order resulting
     */
    @SuppressWarnings( "unchecked" )
    public void runSelectionSort()
    {
        int index;
        int innerIndex;
        GenericData innerIndexData, minValueIndexData;
        int lastIndexCheck = arraySize - 1;
        for( index = 0; index < lastIndexCheck; index++ )
        {
            int minValIndex = index;
            for( innerIndex = index
                    + 1; innerIndex < lastIndexCheck; innerIndex++ )
            {
                innerIndexData = ( GenericData ) localArray[ innerIndex ];
                minValueIndexData = ( GenericData ) localArray[ minValIndex ];
                if( innerIndexData.compareTo( minValueIndexData ) < 0 )
                {
                    minValIndex = innerIndex;
                }
            }
            swapElements( minValIndex, index );
        }
    }

    /**
     * Swaps one element in the local array at a given index with another
     * element in the array at the other given element
     * 
     * @param oneIndex   - index of one of two elements to be swapped
     * @param otherIndex - index of second of two elements to be swapped
     */
    private void swapElements( int oneIndex, int otherIndex )
    {
        Object temp = localArray[ oneIndex ];

        localArray[ oneIndex ] = localArray[ otherIndex ];

        localArray[ otherIndex ] = temp;

    }

}
