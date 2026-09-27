package array;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayDSAPractice {
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 1, 9, 3};
        
        System.out.println("--- DSA Array Practice ---");
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        // 1. Reverse
        reverseArray(arr);
        System.out.println("Reversed Array: " + Arrays.toString(arr));
        
        // 2. Min/Max
        System.out.println("Max Element: " + findMax(arr));
        System.out.println("Min Element: " + findMin(arr));
        
        // 3. Binary Search
        int[] sortedArr = {1, 2, 3, 4, 5, 6, 7};
        int target = 5;
        System.out.println("Binary Search Index of " + target + ": " + binarySearch(sortedArr, target));
        
        // 4. Two Sum
        int[] nums = {2, 7, 11, 15};
        int sumTarget = 9;
        System.out.println("Two Sum Optimal for sum " + sumTarget + ": " + Arrays.toString(twoSumOptimal(nums, sumTarget)));
        
        // 5. Rotate Array
        int[] rotateArr = {1, 2, 3, 4, 5};
        rotateRight(rotateArr, 2);
        System.out.println("Rotated Right by 2: " + Arrays.toString(rotateArr));
    }
    
    /**
     * 1. Reverse Array (Two Pointer Approach)
     * Time Complexity: O(N) | Space Complexity: O(1)
     */
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    
    /**
     * 2. Find Maximum Element
     * Time Complexity: O(N)
     */
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }
        return max;
    }
    
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min) min = num;
        }
        return min;
    }
    
    /**
     * 3. Binary Search (Array must be sorted)
     * Time Complexity: O(log N)
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents integer overflow
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1; // Target is in right half
            else right = mid - 1; // Target is in left half
        }
        return -1; // Not found
    }
    
    /**
     * 4. Two Sum (Optimal using HashMap)
     * Time Complexity: O(N) | Space Complexity: O(N)
     * Returns the indices of the two numbers that add up to the target.
     */
    public static int[] twoSumOptimal(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
    
    /**
     * 5. Rotate Array to the Right by K steps
     * Time Complexity: O(N) | Space Complexity: O(1)
     */
    public static void rotateRight(int[] nums, int k) {
        k = k % nums.length;
        reverseSubArray(nums, 0, nums.length - 1); // Reverse whole array
        reverseSubArray(nums, 0, k - 1);           // Reverse first k elements
        reverseSubArray(nums, k, nums.length - 1); // Reverse remaining elements
    }
    
    // Helper method for array rotation
    private static void reverseSubArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
