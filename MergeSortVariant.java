/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.



Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
 */

public class MergeSortVariant {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = n, j = 0, k = 0, totalLen = m + n - 1, iterator = m - 1;

        while (iterator >= 0 && iterator < iterator + n) {
            nums1[totalLen] = nums1[iterator];
            nums1[iterator] = 0;
            totalLen--;
            iterator--;
        }
        while (i < m + n && k < m + n && j < n) {
            if (nums1[i] < nums2[j]) {
                nums1[k] = nums1[i];
                i++;
                k++;
            } else if (nums2[j] <= nums1[i]) {
                nums1[k] = nums2[j];
                k++;
                j++;
            }
        }
        while (k < m + n && j < n) {
            nums1[k] = nums2[j];
            k++;
            j++;
        }

    }

    public static void main(String[] args) {
        MergeSortVariant obj = new MergeSortVariant();
        int[] nums1 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int[] nums2 = {1, 2, 2};
        obj.merge(nums1, 6, nums2, 3);
        for (int i : nums1) {
            System.out.print(i + " ");
        }
    }
}
