import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* This function reads a d file and displays
* the length of the largest run in the string.
*
*
* @author Titwech Wal
* @version 1.0
* @since   2023-05-20
*/

public final class LargestRun {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private LargestRun() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(String[] args) {

        // Pass path to file as parameter.
        final File character = new File("Characters.txt");

        // Display on the marks spreadsheet
        final File longestRun = new File("longestRun.txt");

        // Declare lists.
        final List<String> listOfChar =
            new ArrayList<String>();

        // Declare variable.
        String charList;

        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(longestRun);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(character);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                charList = sc.nextLine();
                // Adding each string to list.
                listOfChar.add(charList);
            }

            // Convert from list to array.
            final String[] str = listOfChar.toArray(new String[0]);

            // Call function.
            // Loops to find the max run for all lines.
            for (String elements : listOfChar) {
                final int maxLength = maxRun(elements);

                // Displays result to console
                System.out.println("The max run of " + elements
                        + " is " + maxLength);
                // Displays result to output file
                write.println("The max run of " + elements
                        + " is " + maxLength);
            }

            // Closes scanner & writer.
            write.close();
            sc.close();
        } catch (IOException error) {
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
     * This function returns the length of
     * the largest run in the string.
     *
     *
     * @param str passed
     * @return longRun
     */

    public static int maxRun(String str) {

        // Check if the input string is empty
        if (str.isEmpty()) {
            System.out.println("The line is empty");
        }

        // Variables; everything starts at 1.
        int longRun = 1;
        int currentRun = 1;

        // Loop through the string and check for runs
        for (int counter = 1; counter < str.length(); counter++) {
            // If the current character is the same as
            // the previous one add to current run.
            if (str.charAt(counter) == str.charAt(counter - 1)) {
                currentRun++;
                if (currentRun > longRun) {
                    longRun = currentRun;
                }
            } else {
                currentRun = 1;
            }
        }

        return longRun;
    }
}
