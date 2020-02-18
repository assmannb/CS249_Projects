package PracticeCode;

//Java program to find approximation of an ordinary 
//differential equation using euler method 
import java.io.IOException;

class Euler
{
    // Consider a differential equation
    // dy/dx=(x + y + xy)
    float func( float x, float y )
    {
        return( 2 - 4 * x - 2 * y );
    }

    // Function for Euler formula
    void euler( float x0, float y, float h, float x )
    {
        float temp = -0;

        // Iterating till the point at which we
        // need approximation
        while( x0 < x )
        {
            temp = y;
            y = y + h * func( x0, y );
            x0 = x0 + h;
        }

        // Printing approximation
        System.out.println( "Approximate solution at x = " + x + " is " + y );
    }

    // Driver program
    public static void main( String args[] ) throws IOException
    {
        Euler obj = new Euler();
        // Initial Values
        float x0 = 1;
        float y0 = -3;
        float h = 0.25f;

        // Value of x at which we need approximation
        float x = -2.75f;

        obj.euler( x0, y0, h, x );
    }
}