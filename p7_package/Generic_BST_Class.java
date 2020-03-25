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
public class Generic_BST_Class<GenericData extends Comparable<GenericData>>
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
            leftChildRef = null;
            rightChildRef = null;
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
        displayInOrderHelper( BST_Root );
    }

    private void displayInOrderHelper( BST_Node localRoot )
    {
        System.out.println( "Data Display - Tree Display - Inorder:" );
        if( localRoot.rightChildRef != null )
        {
            displayInOrderHelper( localRoot.rightChildRef );
        }
        if( localRoot.leftChildRef != null )
        {
            displayInOrderHelper( localRoot.leftChildRef );
        }
        System.out.println( localRoot.nodeData.toString() );
    }

    public void displayPostOrder()
    {
        displayPostOrderHelper( BST_Root );
    }

    private void displayPostOrderHelper( BST_Node localRoot )
    {
        System.out.println( "Data Display - Tree Display - Postorder:" );
        System.out.println( localRoot.nodeData.toString() );
        if( localRoot.rightChildRef != null )
        {
            displayPostOrderHelper( localRoot.rightChildRef );
        }
        if( localRoot.leftChildRef != null )
        {
            displayPostOrderHelper( localRoot.leftChildRef );
        }
    }

    public void displayPreOrder()
    {
        displayPreOrderHelper( BST_Root );
    }

    private void displayPreOrderHelper( BST_Node localRoot )
    {
        System.out.println( "Data Display - Tree Display - Preorder:" );
        if( localRoot.rightChildRef != null )
        {
            displayPreOrderHelper( localRoot.rightChildRef );
        }
        if( localRoot.leftChildRef != null )
        {
            displayPreOrderHelper( localRoot.leftChildRef );
        }
        System.out.println( localRoot.nodeData.toString() );
    }

    public void insert( GenericData inData )
    {
        BST_Root = insertHelper( BST_Root, inData );
    }

    private BST_Node insertHelper( BST_Node localRoot, GenericData inData )
    {
        if( localRoot == null )
        {
            localRoot = new BST_Node( inData );
        }
        else if( localRoot.nodeData.compareTo( inData ) > 0 )
        {
            localRoot.leftChildRef = insertHelper( localRoot.leftChildRef,
                    inData );
        }
        else if( localRoot.nodeData.compareTo( inData ) < 0 )
        {
            localRoot.rightChildRef = insertHelper( localRoot.rightChildRef,
                    inData );
        }
        return localRoot;
    }

    public boolean isEmpty()
    {
        return BST_Root == null;
    }

    private BST_Node removeFromMax( BST_Node maxParent, BST_Node maxLoc )
    {
        BST_Node maxTempNode;
        if( maxLoc.rightChildRef != null )
        {
            return removeFromMax( maxLoc, maxLoc.rightChildRef );
        }
        maxTempNode = maxLoc;
        maxParent.rightChildRef = maxLoc.leftChildRef;
        return maxTempNode;
    }

    public GenericData removeItem( GenericData inData )
    {
        BST_Root = removeItemHelper( BST_Root, inData );
        return removed;
    }

    private BST_Node removeItemHelper( BST_Node localRoot, GenericData outData )
    {
        if( localRoot.leftChildRef == null )
        {
            removed = localRoot.nodeData;
            return localRoot.rightChildRef;
        }
        if( localRoot.rightChildRef == null )
        {
            removed = localRoot.nodeData;
            return localRoot.leftChildRef;
        }
        if( localRoot.leftChildRef.rightChildRef != null )
        {
            BST_Node temp = removeFromMax( localRoot, localRoot.leftChildRef );
            localRoot.nodeData = temp.nodeData;
        }
        else
        {
            localRoot = localRoot.leftChildRef;
            localRoot.leftChildRef = localRoot.leftChildRef.leftChildRef;
        }
        return localRoot; // fix
    }

    public GenericData search( GenericData searchData )
    {
        return searchHelper( BST_Root, searchData );
    }

    private GenericData searchHelper( BST_Node localRoot,
            GenericData searchData )
    {
        if( localRoot.nodeData.compareTo( searchData ) > 0 )
        {
            return searchHelper( localRoot.rightChildRef, searchData );
        }
        else if( localRoot.nodeData.compareTo( searchData ) < 0 )
        {
            return searchHelper( localRoot.leftChildRef, searchData );
        }
        return localRoot.nodeData;
    }
}
