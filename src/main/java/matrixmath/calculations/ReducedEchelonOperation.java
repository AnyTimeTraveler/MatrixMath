package matrixmath.calculations;

import matrixmath.UserInput;

import java.awt.*;

/**
 * @author rhbvkleef
 *         Created on 3/20/17
 */
public class ReducedEchelonOperation implements IMathOperation {

    @Override
    public String getName() {
        return "Reduced Echelon";
    }

    @Override
    public String getDescription() {
        return "This operation turns the passed matrix into the reduced echelon form";
    }

    @SuppressWarnings("UnnecessaryLabelOnBreakStatement")
    @Override
    public void execute() {
        Dimension matrixSize = UserInput.getMatrixSize();
        double[][] matrix = UserInput.getMatrix(matrixSize.width, matrixSize.height);

        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        boolean[] visitedRows = new boolean[matrix[0].length];
        for (int i = 0; i < visitedRows.length; i++) visitedRows[i] = false;

        while (!allTrue(visitedRows)) {

            // Choose row with maximum pivot
            int maxIdx = matrix.length;
            int maxLine = -1;
            for (int y = 0; y < matrix[0].length; y++) {
                if (visitedRows[y]) continue;

                inner: for (int x = 0; x < matrix.length; x++) {
                    if (matrix[x][y] != 0 && x < maxIdx) {
                        maxIdx = x;
                        maxLine = y;
                        break inner;
                    }
                }
            }

            visitedRows[maxLine] = true;
            if (maxLine == -1) continue;

            // Reduce own row
            double divider = matrix[maxIdx][maxLine];
            for (int x = maxIdx; x < matrix.length; x++) {
                matrix[x][maxLine] /= divider;
            }

            // Subtract from all unvisited rows
            for (int y = 0; y < matrix[0].length; y++) {
                if (visitedRows[y]) continue;

                double pElem = matrix[maxIdx][y];
                for (int x = maxIdx; x < matrix[0].length; x++) {
                    matrix[x][y] -= pElem * matrix[x][maxLine];
                }
            }
        }
        
        UserInput.printMatrix(matrix);
    }

    private static boolean allTrue(boolean[] bools) {
        for (boolean bool : bools) {
            if (!bool) return false;
        }
        return true;
    }
}
