import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;

        if (totalLength % 2 == 1) { // If the total length is odd, the median is the single middle element.
            // We need to find the (totalLength / 2 + 1)-th smallest element.
            return (double)getKthElement(nums1, 0, nums2, 0, totalLength / 2 + 1);
        } else { // If the total length is even, the median is the average of the two middle elements.
            // We need to find the (totalLength / 2)-th and (totalLength / 2 + 1)-th smallest elements.
            int median1 = getKthElement(nums1, 0, nums2, 0, totalLength / 2);
            int median2 = getKthElement(nums1, 0, nums2, 0, totalLength / 2 + 1);
            return (double)(median1 + median2) / 2.0;
        }
    }

    /**
     * Helper function to find the k-th smallest element in the merged array of two sorted arrays.
     *
     * @param nums1 The first sorted array.
     * @param idx1 The current starting index in nums1 for the search.
     * @param nums2 The second sorted array.
     * @param idx2 The current starting index in nums2 for the search.
     * @param k The rank of the element we are looking for (1-based).
     * @return The k-th smallest element.
     */
    private int getKthElement(int[] nums1, int idx1, int[] nums2, int idx2, int k) {
        // Base case 1: If nums1 is exhausted, the k-th element must be in nums2.
        if (idx1 == nums1.length) {
            return nums2[idx2 + k - 1];
        }
        // Base case 2: If nums2 is exhausted, the k-th element must be in nums1.
        if (idx2 == nums2.length) {
            return nums1[idx1 + k - 1];
        }

        // Base case 3: If k is 1, we just need the minimum of the current starting elements.
        if (k == 1) {
            return Math.min(nums1[idx1], nums2[idx2]);
        }

        // Calculate potential pivot indices for comparison.
        // We look at the (k/2)-th element from the current start of each array.
        // If (idx + k/2 - 1) goes beyond array bounds, treat its value as infinity.
        int pivot1_idx = idx1 + k / 2 - 1;
        int pivot2_idx = idx2 + k / 2 - 1;

        int val1 = (pivot1_idx < nums1.length) ? nums1[pivot1_idx] : Integer.MAX_VALUE;
        int val2 = (pivot2_idx < nums2.length) ? nums2[pivot2_idx] : Integer.MAX_VALUE;

        // If val1 is smaller than val2, it means that all elements from nums1[idx1] to nums1[pivot1_idx]
        // (which are k/2 elements) are definitely among the smaller elements and cannot be the k-th element
        // we are looking for (if k is sufficiently large).
        // So, we can safely discard these k/2 elements from nums1 and
        // continue searching for the (k - k/2)-th element in the remaining parts.
        if (val1 < val2) {
            return getKthElement(nums1, pivot1_idx + 1, nums2, idx2, k - k / 2);
        } else { // If val2 is smaller than or equal to val1, discard k/2 elements from nums2.
            return getKthElement(nums1, idx1, nums2, pivot2_idx + 1, k - k / 2);
        }
    }
}