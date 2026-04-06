class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000000L;
        long high = 10000000000L;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(nums1, nums2, mid) < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private long count(int[] nums1, int[] nums2, long mid) {
        long count = 0;

        for (int a : nums1) {
            if (a > 0) {
                int left = 0, right = nums2.length - 1;
                int pos = -1;

                while (left <= right) {
                    int m = (left + right) / 2;
                    if ((long)a * nums2[m] <= mid) {
                        pos = m;
                        left = m + 1;
                    } else {
                        right = m - 1;
                    }
                }
                count += (pos + 1);
            }

            else if (a < 0) {
                int left = 0, right = nums2.length - 1;
                int pos = nums2.length;

                while (left <= right) {
                    int m = (left + right) / 2;
                    if ((long)a * nums2[m] <= mid) {
                        pos = m;
                        right = m - 1;
                    } else {
                        left = m + 1;
                    }
                }
                count += (nums2.length - pos);
            }

            else { // a == 0
                if (mid >= 0) {
                    count += nums2.length;
                }
            }
        }

        return count;
    }
}