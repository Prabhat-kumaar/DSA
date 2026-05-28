import java.util.*;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        TreeMap<Integer, ArrayList<Integer>> mp = new TreeMap<>();
        ArrayList<Integer> ansList = new ArrayList<>();

        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {

                int sum = i + j;

                mp.putIfAbsent(sum, new ArrayList<>());
                mp.get(sum).add(mat[i][j]);
            }
        }

  
        for (Map.Entry<Integer, ArrayList<Integer>> entry : mp.entrySet()) {

            int key = entry.getKey();
            ArrayList<Integer> temp = entry.getValue();

          
            if (key % 2 == 0) {
                Collections.reverse(temp);
            }

            for (int ele : temp) {
                ansList.add(ele);
            }
        }

        
        int[] ans = new int[ansList.size()];

        for (int i = 0; i < ansList.size(); i++) {
            ans[i] = ansList.get(i);
        }

        return ans;
    }
}