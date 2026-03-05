class Solution {
    public int[] replaceElements(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            int maxRight = arr[i + 1];

            for (int j=i+1; j<arr.length; j++) {

                if (arr[j] > maxRight) {
                    maxRight = arr[j];
                }
            }

            arr[i] = maxRight;
        }

        arr[arr.length - 1] = -1;
        return arr;
        
    }
}