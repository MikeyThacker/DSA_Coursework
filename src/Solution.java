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
        // O(m) as requires to search all numbers in row from start to end
    }

    public static int matrixMaxValue(int[][] matrix) {
        // Returns the maximum value in the matrix
        return blockMaxValue(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
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

