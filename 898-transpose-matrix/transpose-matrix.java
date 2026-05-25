class Solution {
    public int[][] transpose(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];  // fix 1

        for (int i = 0; i < rows; i++) {       // fix 2
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];   // fix 3
            }
        }

        return result;
    }
}