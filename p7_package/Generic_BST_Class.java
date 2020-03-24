package p7_package;

/**
 * Binary Search Tree (BST) class for managing generic data
 * <p>
 * Note: Data used must have implemented Comparable interface
 * 
 * @author Benjamin Assmann
 *
 * @param <GenericData>
 */
public class Generic_BST_Class<GenericData>
{
    private class BST_Node
    {
        BST_Node leftChildRef;
        private GenericData nodeData;
        BST_Node rightChildRef;

        public BST_Node( GenericData inData )
        {
            leftChildRef = null;
            rightChildRef = null;
            nodeData = inData;
        }

        public BST_Node( BST_Node copied )
        {
            leftChildRef = copied.leftChildRef;
            rightChildRef = copied.rightChildRef;
            nodeData = copied.nodeData;
        }
    }

    private BST_Node BST_Root;
    private GenericData removed;

    Generic_BST_Class()
    {
        BST_Root = null;
    }

    public void clearTree()
    {
        BST_Root = null;
    }

    public void displayInOrder()
    {

    }

    private void displayInOrderHelper( Generic_BST_Class.BST_Node localRoot )
    {

    }

    public void displayPostOrder()
    {

    }

    private void displayPostOrderHelper( BST_Node localRoot )
    {

    }

    public void displayPreOrder()
    {

    }

    private void displayPreOrderHelper( BST_Node localRoot )
    {

    }

    public void insert( GenericData inData )
    {
        insertHelper( BST_Root, inData );
    }

    private BST_Node insertHelper( BST_Node localRoot, GenericData inData )
    {
        if( localRoot == null )
        {
            localRoot = new BST_Node( inData );
        }
        if( compare )
        {

        }
        if( StudentClass.compareTo() )
        {

        }
        return localRoot;
    }

    public boolean isEmpty()
    {
        return BST_Root == null;
    }

    private BST_Node removeFromMax( BST_Node maxParent, BST_Node maxLoc )
    {

    }

    public GenericData removeItem( GenericData inData )
    {

    }

    private BST_Node removeItemHelper( BST_Node localRoot, GenericData outData )
    {

    }

    public GenericData search( GenericData searchData )
    {
        return searchHelper( BST_Root, searchData );
    }

    private GenericData searchHelper( BST_Node localRoot,
            GenericData searchData )
    {

    }
}
