package matrixmath;

import java.awt.*;
import java.util.Scanner;

/**
 * Created by simon on 20.03.17.
 */
public class UserInput {
    private static final Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static double[][] getMatrix(int rows, int columns) {
        double[][] matrix = new double[rows][columns];
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                printMatrix(matrix, x, y);
                matrix[x][y] = getDouble("Value at [" + x + ", " + y + "] : ");
            }
        }
        return matrix;
    }

    public static Dimension getMatrixSize() {
        return new Dimension(getInteger("Matrix rows: "), getInteger("Matrix columns: "));
    }

    public static int getInteger(String query) {
        int result = 0;
        boolean success = false;
        do {
            try {
                System.out.print(query);
                result = Integer.parseInt(scanner.nextLine());
                success = true;
            } catch (NumberFormatException ignored) {
                System.out.println("Please enter a valid integer!");
            }
        } while (!success);
        return result;
    }

    public static double getDouble(String query) {
        double result = 0;
        boolean success = false;
        do {
            try {
                System.out.print(query);
                result = Double.parseDouble(scanner.nextLine());
                success = true;
            } catch (NumberFormatException ignored) {
                System.out.println("Please enter a valid double!");
            }
        } while (!success);
        return result;
    }

    public static void printMatrix(double[][] matrix) {
        printMatrix(matrix, matrix.length, matrix[0].length);
    }

    public static void printMatrix(double[][] matrix, int untilX, int untilY) {
        for (int x = 0; x < untilX; x++) {
            for (int y = 0; y < untilY; y++) {
                System.out.print("[");
                System.out.print(matrix[x][y]);
                System.out.print("] ");
            }
            System.out.println();
        }
    }
}
