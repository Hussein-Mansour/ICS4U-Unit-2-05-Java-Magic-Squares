/*
* This program prints out
* the Magic Sqaures.
*
* @author  Nicholas B. & Mr. Coxall & Hsen
* @version 1.0
* @since   2020-01-01
* @since   2021-12-10
*/

/**
* This is the standard "Magic Squares" program.
*/

final class MagicSquares {

    /** The middle left index. */
    public static final int THREE = 3;
    /** The center index. */
    public static final int FOUR = 4;
    /** The middle right index. */
    public static final int FIVE = 5;
    /** The lower left index. */
    public static final int SIX = 6;
    /** The lower center index. */
    public static final int SEVEN = 7;
    /** The lower right index. */
    public static final int EIGHT = 8;
    /** The maximum number for magicNumbers. */
    public static final int NINE = 9;
    /** The maximum number for magicNumbers. */
    public static final int MAGICNUM = 15;
    /** Size of magic square array. */
    public static final int ARRAY_SIZE = 9;
    /** Middle left index of 3x3 1D Array. */
    public static final int MIDDLE_LEFT = 3;
    /** Middle centre index of 3x3 1D Array. */
    public static final int MIDDLE_CENTRE = 4;
    /** Middle right index of 3x3 1D Array. */
    public static final int MIDDLE_RIGHT = 5;
    /** Bottom left index of 3x3 1D Array. */
    public static final int BOTTOM_LEFT = 6;
    /** Bottom centre index of 3x3 1D Array. */
    public static final int BOTTOM_CENTRE = 7;
    /** Bottom right index of 3x3 1D Array. */
    public static final int BOTTOM_RIGHT = 8;
    /** SPACE.  */
    public static final String SPACE = "\n";
    /** String. */
    public static final String STR = "*****";
    /** Empty String. */
    public static final String ESTR = " ";

    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private MagicSquares() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Method.
    *
    * @param square array.
    * @param presenceArray array.
    * @param currentSquare integer.
    */
    public static void genSquare(final int[] square, int[] presenceArray,
                                 final int currentSquare) {
        for (int index = 0; index < square.length; index++) {
            if (presenceArray[index] == 0) {
                square[currentSquare] = index + 1;
                presenceArray[index] = 1;
                if (currentSquare < square.length - 1) {
                    genSquare(square, presenceArray, currentSquare + 1);
                } else if (isMagic(square)) {
                    printMagicSquare(square);
                }
                presenceArray[index] = 0;
            }
        }
    }

    /**
    * Method.
    *
    * @param preSquare Array.
    * @return row1.
    */
    public static boolean isMagic(final int[] preSquare) {
        // returns true or false for whether or not array is a magic square
        final int row1 = preSquare[0] + preSquare[1] + preSquare[2];
        final int row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
        final int row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];
        final int col1 = preSquare[0] + preSquare[THREE] + preSquare[SIX];
        final int col2 = preSquare[1] + preSquare[FOUR] + preSquare[SEVEN];
        final int col3 = preSquare[2] + preSquare[FIVE] + preSquare[EIGHT];
        final int diag1 = preSquare[0] + preSquare[FOUR] + preSquare[EIGHT];
        final int diag2 = preSquare[2] + preSquare[FOUR] + preSquare[SIX];

        return row1 == MAGICNUM && row2 == MAGICNUM && row3 == MAGICNUM
               && col1 == MAGICNUM && col2 == MAGICNUM
               && col3 == MAGICNUM && diag1 == MAGICNUM && diag2 == MAGICNUM;
    }

    /**
    * Method.
    *
    * @param outputSquare Array.
    */
    public static void printMagicSquare(final int[] outputSquare) {
        // prints inputted array in a magic square format
        System.out.println(SPACE + STR);
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + ESTR);
            } else {
                System.out.print(outputSquare[count] + ESTR);
            }
        }
        System.out.println(SPACE + STR);
    }

    /**
    * Starting the main Method.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        // main stub, get user input here
        final int[] magicSquare = {1, 2, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
        final int[] extraArray = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(SPACE);
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare(magicSquare, extraArray, 0);
        System.out.println(SPACE + "Done.");
    }
}
