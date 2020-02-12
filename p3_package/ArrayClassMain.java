package p3_package;

public class ArrayClassMain
{

    public static void main( String[] args )
    {
        ArrayClass array = new ArrayClass();
        array.loadUniqueRandoms( 10, 1, 100 );
        array.runQuickSort();
        array.dump();
        System.out.println();
        array.runMergeSort();
        array.dump();
        System.out.println();
        array.runShellSort();
        array.dump();

    }

}
