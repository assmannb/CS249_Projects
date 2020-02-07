package p1_package;

/**
 * Class wrapper for a Java array, with additional management operations
 * 
 * @author Benjamin Assmann
 * @version 1.1
 */
public class ArrayClass
    {
        private static final int DEFAULT_CAPACITY = 10;
        public static final int FAILED_ACCESS = -999999;
        private int[] localArray;
        private int arraySize;
        private int arrayCapacity;

        /**
         * Default constructor, initializes array to default capacity {10}
         */
        ArrayClass()
            {
                arrayCapacity = DEFAULT_CAPACITY;
                arraySize = 0;
                localArray = new int[arrayCapacity];
            }

        /**
         * Initializing constructor, initializes array to specified capacity
         * 
         * @param capacity - integer maximum capacity specification for the array
         */
        public ArrayClass(int capacity)
            {
                arraySize = 0;
                if (capacity < 0)
                    {
                        arrayCapacity = DEFAULT_CAPACITY;
                    }

                else
                    {
                        arrayCapacity = capacity;
                    }
                localArray = new int[arrayCapacity];
            }

        /**
         * Initializing constructor, initializes array to specified capacity, size to
         * specified value, then fills all elements with specified size value
         * 
         * @param capacity  - maximum capacity specification for the array
         * @param size      - sets the number of items to be filled in array, and sets
         *                  the size of the ArrayClass object
         * @param fillValue - value to be placed in all elements of initialized array up
         *                  to the size
         */
        public ArrayClass(int capacity, int size, int fillValue)
            {
                int index;
                if (capacity < 0)
                    {
                        capacity = DEFAULT_CAPACITY;
                    }
                if (size > capacity)
                    {
                        size = capacity;
                    }
                localArray = new int[capacity];
                arrayCapacity = capacity;
                arraySize = 0;
                for (index = 0; index < size; index++)
                    {
                        localArray[index] = fillValue;
                        arraySize++;
                    }
            }

        /**
         * Copy constructor, initializes array to size and capacity of copied array,
         * then copies only the elements up to the given size
         * 
         * @param copied - ArrayClass object to be copied
         */
        ArrayClass(ArrayClass copied)
            {
                int index;

                this.arraySize = copied.arraySize;
                this.arrayCapacity = copied.arrayCapacity;
                localArray = new int[arrayCapacity];

                for (index = 0; index < arraySize; index++)
                    {
                        localArray[index] = copied.localArray[index];
                    }
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
         * Tests for size of array equal to zero, no valid values stored in array
         * 
         * @return Boolean result of test for empty
         */
        public boolean isEmpty()
            {
                return arraySize == 0;
            }

        /**
         * Appends item to end of array, if array is not full, e.g., no more values can
         * be added
         * 
         * @param newValue - value to be appended to array
         * @return Boolean success if appended, or failure if array was full
         */
        public boolean appendItem(int newValue)
            {
                if (!isFull())
                    {
                        localArray[arraySize] = newValue;
                        arraySize++;
                        return true;
                    }
                return false;
            }

        /**
         * Description: Inserts item to array at specified index if array is not full,
         * e.g., no more values can be added
         * <p>
         * Note: Value is inserted at given index, all data from that index to the end
         * of the array is shifted up by one
         * <p>
         * Note: Value can be inserted after the last valid element but not at any index
         * past that point
         * 
         * @param insertIndex - index of element into which value is to be inserted
         * @param newValue    - value to be inserted into array
         * @return Boolean success if inserted, or failure if array was full
         */
        public boolean insertItemAt(int insertIndex, int newValue)
            {
                int index;
                if (!isFull())
                    {
                        for (index = arraySize; index > insertIndex; index--)
                            {
                                localArray[index] = localArray[index - 1];
                            }
                        localArray[insertIndex] = newValue;
                        arraySize++;
                        return true;
                    }

                return false;
            }

        /**
         * Accesses item in array at specified index if index within array size bounds
         * 
         * @param accessIndex - index of requested element value
         * @return accessed value if successful, FAILED_ACCESS (-999999) if not
         */
        public int accessItemAt(int accessIndex)
            {
                int accessItem;
                if (accessIndex < arraySize)
                    {
                        accessItem = localArray[accessIndex];
                        return accessItem;
                    }
                return FAILED_ACCESS;
            }

        /**
         * Description: Removes item from array at specified index if index within array
         * size bounds
         * <p>
         * Note: Each data item from the element immediately above the remove index to
         * the end of the array is moved down by one element
         * 
         * @param removeIndex - index of element value to be removed
         * @return removed value if successful, FAILED_ACCESS (-999999) if not
         */
        public int removeItemAt(int removeIndex)
            {
                int index;
                if (removeIndex < arraySize)
                    {
                        int index_element = localArray[removeIndex];
                        for (index = removeIndex; index < arraySize; index++)
                            {
                                localArray[index] = localArray[index + 1];
                            }
                        arraySize--;
                        return index_element;
                    }
                return FAILED_ACCESS;
            }

        /**
         * Description: Resets array capacity, copies current size and current size
         * number of elements
         * <p>
         * Exception: Method will not resize capacity below current array size, returns
         * false if this is attempted, true otherwise
         * 
         * @param newCapacity - new capacity to be set; must be larger than current
         *                    capacity
         * @return Boolean condition of resize success or failure
         */
        public boolean resize(int newCapacity)
            {
                int index;
                if (newCapacity >= arraySize)
                    {
                        arrayCapacity = newCapacity;
                        int copiedArray[] = new int[arrayCapacity];
                        for (index = 0; index < arraySize; index++)
                            {
                                copiedArray[index] = localArray[index];
                            }
                        localArray = copiedArray;
                        return true;
                    }
                return false;
            }

        /**
         * Description: Gets current size of array
         * <p>
         * Note: size of array indicates number of valid or viable values in the array
         * 
         * @return size of array
         */
        public int getCurrentSize()
            {
                return arraySize;
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
         * Clears array of all valid values by setting array size to zero, values remain
         * in array but are not accessible
         */
        public void clear()
            {
                arraySize = 0;
            }
    }
