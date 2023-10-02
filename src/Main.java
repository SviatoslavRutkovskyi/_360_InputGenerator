import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Scanner sc = new Scanner(System.in);
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

            generateBoard(rows, col, percentage);
        } else {
            System.out.println("# 0f boards: ");
            int boardNum = sc.nextInt();
            for (int i = 0; i < boardNum; i++) {
                int rows = (int) (Math.random() * 100);
                int col = (int) (Math.random() * 100);
                double percentage = Math.random() * 100;
                generateBoard(rows, col, percentage);
            }
        }


    }
    private static void generateBoard(int theRows, int theCol, double thePercentage){
        char[][] minefield = new char[theRows][theCol];


        for (int i = 0; i < theRows; i++) {
            for (int j = 0; j < theCol; j++) {
                if (thePercentage > Math.random() * 100) {
                    minefield[i][j] = '*';
                } else {
                    minefield[i][j] = '.';
                }
            }

        }
        System.out.println(theRows + " " + theCol);
        for (char[] chars : minefield) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();

        }
    }
}