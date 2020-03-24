package p7_package;

import java.io.FileReader;
import java.io.IOException;

/**
 * Provides workbench for testing Generic_BST_Class
 * 
 * @author MichaelL
 *
 */
public class BST_ClassMain
{
    private final static int END_OF_FILE_MARKER = -1;

    // used for acquiring data via several methods
    private static FileReader fileIn;

    /**
     * main method for driving multiple tests on Generic BST Class
     * 
     * @param args command-line string input arguments
     */
    public static void main( String[] args )
    {
        Generic_BST_Class<StudentClass> gSC;
        String fileName = "in_5_Tabbed.txt";
        StudentClass temp;

        // title
        System.out.println( "\nGeneric_BST_Class Data Testing Program\n" );

        // access data from file
        // test initialization constructor, appendItem, resize
        System.out.println( "Data Retrieval from file - Begin" );
        gSC = getData( fileName );
        System.out.println( "Data Retrieval from file - End" );
        System.out.print( "\nData Display - " );
        gSC.displayInOrder();

        // test for addition of redundant data
        // ---> Insert code here
        // ---> Display code here
        gSC.displayInOrder();

        // test for removal of data
        gSC.clearTree();
        System.out.print( "\nData Display after clearing tree - " );
        gSC.displayInOrder();

        gSC = getData( fileName );
        System.out.print( "\nData Display after reload - " );
        gSC.displayInOrder();

        // test for removal from left node
        // ---> Remove code here
        System.out.print( "\nData Display after removal from left node: " + temp
                + " - " );
        gSC.displayInOrder();

        // test for removal from right node
        // ---> Insert code here
        // ---> Remove code here
        gSC.displayInOrder();

        // test for removal from node having no children
        // ---> Remove code here
        System.out.print(
                "\nData Display after removal from node having no children: "
                        + temp + " - " );
        gSC.displayInOrder();

        // test for removal from node having two children
        // ---> Remove code here
        System.out.print(
                "\nData Display after removal from node having two children: "
                        + temp + " - " );
        gSC.displayInOrder();

        // test for removal from node having two children
        // ---> Remove code here
        System.out.print(
                "\nData Display after attempt to remove value not in tree: >"
                        + temp + "< - " );
        gSC.displayInOrder();

        System.out.println( "\n --- End of Program--- " );
    }

    /**
     * Local method uploads data character by character, parses characters, and
     * loads into StudentClass type data
     * <p>
     * Exception: If there is a file failure such as file not found, method will
     * return null
     * 
     * @param fileName name of file in local directory required for upload
     * 
     * @return returns Generic_BST_Class object holding StudentClass data
     */
    public static Generic_BST_Class<StudentClass> getData( String fileName )
    {
        int value;

        StudentClass studentClassObject;
        Generic_BST_Class<StudentClass> bstClassObject = new Generic_BST_Class<StudentClass>();
        String nameStr, idStr, gpaStr;
        int idVal;
        char genderVal;
        double gpaVal;
        boolean failedAccess = false;

        // FileReader
        fileIn = null;

        try
        {
            fileIn = new FileReader( fileName );

            // read prime, name
            value = fileIn.read();

            while( value != END_OF_FILE_MARKER && !failedAccess )
            {
                // reset input strings
                nameStr = "";
                idStr = "";
                gpaStr = "";

                // get name
                while( value != ';' )
                {
                    nameStr += ( char ) value;

                    value = fileIn.read();
                }

                // skip spaces up to integer value characters
                value = getNextCharInt( "0123456789" );

                // get id
                while( value >= '0' && value <= '9' )
                {
                    idStr += ( char ) value;

                    value = fileIn.read();
                }

                // translate id
                idVal = Integer.parseInt( idStr );

                // skip spaces up to Mm or Ff
                value = getNextCharInt( "MFmf" );

                // load gender
                genderVal = ( char ) value;

                // skip empty spaces up to double value characters
                value = getNextCharInt( "0123456789." );

                // get gpa
                while( ( value >= '0' && value <= '9' ) || value == '.' )
                {
                    gpaStr += ( char ) value;

                    value = fileIn.read();
                }

                // translate gpa
                gpaVal = Double.parseDouble( gpaStr );

                // load data into StudentClass object
                studentClassObject = new StudentClass( nameStr, idVal,
                        genderVal, gpaVal );

                // load StudentClass object into BST
                bstClassObject.insert( studentClassObject );

                // skip end of line, etc., up to next letter
                // (name on next line)
                value = getNextCharInt(
                        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ" );

            } // end data collection loop

            if( fileIn != null )
            {
                fileIn.close();
            }
        }

        catch( IOException ioe )
        {
            failedAccess = true;
        }

        if( failedAccess )
        {
            bstClassObject = null;
        }

        return bstClassObject;
    }

    /**
     * Local method for getting next desired character from the file stream
     * 
     * @param rangeString set of desired characters
     * 
     * @return integer character for use in input process
     */
    private static int getNextCharInt( String rangeString )
    {
        int nextCharInt = 0;

        try
        {
            nextCharInt = fileIn.read();

            while( nextCharInt != END_OF_FILE_MARKER
                    && !isInString( ( char ) nextCharInt, rangeString ) )
            {
                nextCharInt = fileIn.read();
            }
        }

        catch( IOException ioe )
        {
            System.out.println( "INPUT ERROR: Failure to capture character" );
        }

        // if( )

        return nextCharInt;
    }

    /**
     * Local method that searches for character in a given string
     * 
     * @param testChar   search character
     * 
     * @param testString string containing list of acceptable characters
     * 
     * @return true if character found in string; false otherwise
     */
    private static boolean isInString( char testChar, String testString )
    {
        int index;

        for( index = 0; index < testString.length(); index++ )
        {
            if( testString.charAt( index ) == testChar )
            {
                return true;
            }
        }

        return false;
    }
}
