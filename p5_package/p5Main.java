package p5_package;

public class p5Main
{

    public static void main( String[] args )
    {
        StackClass array = new StackClass();
        array.push( 1 );
        array.push( 5 );
        array.push( 10 );
        array.push( 15 );
        array.push( 20 );
        array.pop();
        array.displayStack();
        System.out.println( "Value=" + array.peek() );

    }

}
