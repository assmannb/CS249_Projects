package p5_package;

/**
 * StackClass uses ArrayClass as data for its operations
 * 
 * @author Benjamin Assmann
 * @version 0.1
 */
public class StackClass
{
    private static final int TOP_INDEX = 0;
    private ArrayClass stackArray;

    /**
     * Default constructor
     */
    public StackClass()
    {
        stackArray = new IteratorClass();
    }

    /**
     * Initialization constructor
     * 
     * @param initialCapacity- integer value indicating initial capacity for
     *                         object
     */
    public StackClass( int initialCapacity )
    {
        stackArray = new IteratorClass( initialCapacity );
    }

    /**
     * Copy constructor for object
     * 
     * @param copied - StackClass object to be duplicated
     */
    public StackClass( StackClass copied )
    {
        stackArray = copied.stackArray;
    }

    /**
     * Clears stack
     */
    public void clear()
    {
        stackArray.clear();
    }

    /**
     * Returns true if stack is empty, false otherwise
     * 
     * @return Boolean result representing specification
     */
    public boolean isEmpty()
    {
        return stackArray.isEmpty();
    }

    /**
     * Returns true if stack is full, false otherwise
     * 
     * @return Boolean result representing specification
     */
    public boolean isFull()
    {
        return stackArray.isFull();
    }

    /**
     * Returns value at top of stack without removing it
     * 
     * @return integer value returned if stack not empty, FAILED_ACCESS
     *         otherwise
     */
    public int peek()
    {
        return ( ( IteratorClass ) stackArray ).accessItemAt( TOP_INDEX );
    }

    /**
     * Returns value at top of stack upon removing it
     * 
     * @return integer value returned if stack not empty, FAILED_ACCESS
     *         otherwise
     */
    public int pop()
    {
        return ( ( IteratorClass ) stackArray ).removeItemAt( TOP_INDEX );
    }

    /**
     * Places new value at the top of the stack
     * 
     * @param newValue - integer value to be pushed on to stack
     * @return Boolean result of operation success
     */
    public boolean push( int newValue )
    {
        return ( ( IteratorClass ) stackArray ).insertItemAt( TOP_INDEX,
                newValue );
    }

    /**
     * Resizes stack - must resize to capacity larger than current
     * 
     * @param newCapacity- integer value indicating capacity to which to be
     *                     resized
     * @return Boolean result of operation success
     */
    public boolean resizeStack( int newCapacity )
    {
        return stackArray.resize( newCapacity );
    }

    /**
     * Displays comma-delimited list showing data from bottom of stack to top,
     * from left to right
     * 
     */
    public void displayStack()
    {
        int index;
        System.out.print( "Bottom of Stack -|" );
        for( index = stackArray.getCurrentSize()
                - 1; index >= TOP_INDEX; index-- )
        {
            System.out.print( stackArray.accessItemAt( index ) );
            System.out.print( "," );
        }
        System.out.println( "<- Top of Stack" );
    }

}
