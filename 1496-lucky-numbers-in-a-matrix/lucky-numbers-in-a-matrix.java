import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int n = matrix.length; // Fixed typo 'ength'
        int m = matrix[0].length;

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int minV = matrix[i][0];
            int colIndx = 0;
            
            
            for (int j = 0; j < m; j++) { 
                if (matrix[i][j] < minV) {
                    minV = matrix[i][j];
                    colIndx = j; 
                }
            }
            
            boolean isMax = true;
            for (int k = 0; k < n; k++) {
                if (matrix[k][colIndx] > minV) { 

                    isMax = false;
                    break; 
                }
            }
            
           
            if (isMax) {
                ans.add(minV);
            }
        }
        
        return ans; 
    }
}