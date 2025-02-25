public class Solution {
    public static int maxIndex(int[] row, int start, int end) {
        // Returns the index of the maximum entry between start and end
        int maxEntry = row[start];
        int maxIndex = start;

        for (int i = start + 1; i <= end; i++) {
            if (row[i] > maxEntry) {
                maxEntry = row[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int matrixMaxValue(int[][] matrix) {
        // Returns the maximum value in the matrix

        int maxEntry = matrix[0][0];

        int lastMaxColumn = 0;

        for (int i = 0; i < matrix.length; i++) {
            int maxInRow = maxIndex(matrix[i], lastMaxColumn, matrix[i].length - 1);
            lastMaxColumn = maxInRow;
            maxEntry = Math.max(maxEntry, matrix[i][maxInRow]);
        }
        return maxEntry;
    }

    public static int blockMaxValue(int[][] matrix, int startRow, int startCol, int
            endRow, int endCol) {
        // Returns the maximum entry in the matrix between columns startCol, endCol inclusive and between rows startRow,
        // endRow inclusive
        int maxEntry = matrix[startRow][startCol];
        int lastMaxColumn = startCol;

        for (int i = startRow; i <= endRow; i++) {
            int maxInRow = maxIndex(matrix[i], lastMaxColumn, endCol);
            lastMaxColumn = maxInRow;
            maxEntry = Math.max(maxEntry, matrix[i][maxInRow]);
        }
        return maxEntry;
    }
}

