package matrixmath.calculations;

import matrixmath.UserInput;

import java.awt.*;

/**
 * @author rhbvkleef
 *         Created on 3/20/17
 */
public class DeterminantOperation implements IMathOperation {
    @Override
    public String getName() {
        return "Determinant";
    }

    @Override
    public String getDescription() {
        return "This math operation calculates the determinant of an n*n matrix.";
    }

    @Override
    public void execute() {
        Dimension size = UserInput.getMatrixSize();
        double[][] matrix = UserInput.getMatrix(size.height, size.width);

        System.out.printf("The determinant of the provided matrix is: %2.2f\n", determinant(matrix));
    }

    private static double determinant(double[][] matrix) throws IllegalArgumentException {
        if (matrix.length < 1) {
            throw new IllegalArgumentException("Cannot calculate the determinant of a matrix without elements");
        } else if (matrix.length != matrix[0].length) {
            throw new IllegalArgumentException("Can only calculate the determinant of a square matrix");
        } else if (matrix.length == 1) {
            return matrix[0][0];
        } else if (matrix.length == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }

        double det = 0;
        boolean sub = false;
        for (int i = 0; i < matrix.length; i++) {
            double[][] newMatrix = delRowCols(matrix, i, 0);
            double localDeterminant = matrix[i][0] * determinant(newMatrix);

            det += sub ? -localDeterminant : localDeterminant;
            sub = !sub;
        }

        return det;
    }

    private static double[][] delRowCols(double[][] matrix, int x, @SuppressWarnings("SameParameterValue") int y) {
        double[][] newMatrix = new double[matrix.length - 1][matrix.length - 1];

        for (int xc = 0; xc < matrix.length; xc++) {
            for (int yc = 0; yc < matrix[xc].length; yc++) {
                if (xc != x && yc != y) {
                    newMatrix[xc > x ? xc - 1 : xc][yc > y ? yc - 1 : yc] = matrix[xc][yc];
                }
            }
        }

        return newMatrix;
    }
}
