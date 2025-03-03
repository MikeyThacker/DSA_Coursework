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
        return blockMaxValue(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    public static int blockMaxValue(int[][] matrix, int startRow, int startCol, int
            endRow, int endCol) {
        // Returns the maximum entry in the matrix between columns startCol, endCol inclusive and between rows startRow,
        // endRow inclusive

        // Check for base case
        if (startRow == endRow) {
            return matrix[startRow][maxIndex(matrix[startRow], startCol, endCol)];
        }

        // Get the largest element in middle row
        int middleRow = startRow + (endRow - startRow) / 2;
        int maxEntryIndex = maxIndex(matrix[middleRow], startCol, endCol);
        int maxEntry = matrix[middleRow][maxEntryIndex];


        int topHalfMax = matrix[startRow][startCol];
        int bottomHalfMax = matrix[startRow][startCol];

        // Get the largest element in all rows above and below following rule 2
        if (middleRow > startRow) {
            topHalfMax = blockMaxValue(matrix, startRow, startCol, middleRow - 1, maxEntryIndex);
        }
        if (middleRow < endRow) {
            bottomHalfMax = blockMaxValue(matrix, middleRow + 1, maxEntryIndex, endRow, endCol);
        }


        return Math.max(maxEntry, Math.max(topHalfMax, bottomHalfMax));
    }
}
