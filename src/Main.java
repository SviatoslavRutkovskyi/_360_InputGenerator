/**
 * Authors: Sviatoslav Rutkovskyi, Minh Vu, Andrew Holmes.
 * Date: 10/10/2023
 * TCSS 360
 */

import java.util.Scanner;

public class Main {
    /**
     * Percentage multiplier for Math.random().
     */
    private static final int PERCENTAGE = 100;

    /**
     * Main method that prompts user and
     * creates test code for Minesweeper Class.
     *
     * @param theArgs passed in argument
     */
    public static void main(final String[] theArgs) {
        System.out.println("Hello world!");

        Scanner sc = new Scanner(System.in);
        String arrayCheckS;
        boolean arrayCheck;
        do {
            System.out.println("Make parameters into 2D Array? yes/no");
            arrayCheckS = sc.nextLine();

        } while (!arrayCheckS.equals("no") && !arrayCheckS.equals("yes"));
        arrayCheck = arrayCheckS.equals("yes");
        String rand;
        do {
            System.out.println("Randomise parameters? yes/no");
            rand = sc.nextLine();

        } while (!rand.equals("no") && !rand.equals("yes"));

        if (rand.equals("no")) {
            System.out.println("Rows: ");
            int rows = sc.nextInt();
            System.out.println("Columns: ");
            int col = sc.nextInt();
            System.out.println("Mine Percentage: ");
            double percentage = sc.nextInt();

            generateBoard(rows, col, percentage, arrayCheck);
        } else {
            System.out.println("# 0f boards: ");
            int boardNum = sc.nextInt();
            for (int i = 0; i < boardNum; i++) {
                int rows = (int) (Math.random() * PERCENTAGE);
                int col = (int) (Math.random() * PERCENTAGE);
                double percentage = Math.random() * PERCENTAGE;
                generateBoard(rows, col, percentage, arrayCheck);
                System.out.println();
            }
        }


    }

    private static void generateBoard(final int theRows, final int theCol,
                                      final double thePercentage,
                                      final boolean theArrayCheck) {
        char[][] minefield = new char[theRows][theCol];

        for (int i = 0; i < theRows; i++) {
            for (int j = 0; j < theCol; j++) {
                if (thePercentage > Math.random() * PERCENTAGE) {
                    minefield[i][j] = '*';
                } else {
                    minefield[i][j] = '.';
                }
            }

        }
        System.out.println(theRows + " " + theCol);
        if (theArrayCheck) {
            for (char[] chars : minefield) {
                System.out.print("{");
                for (char aChar : chars) {
                    System.out.print("'" + aChar + "',");
                }
                System.out.print("},\n");
            }
            System.out.println();

        } else {
            for (char[] chars : minefield) {
                for (char aChar : chars) {
                    System.out.print(aChar);
                }
                System.out.println();

            }
        }
    }
}
