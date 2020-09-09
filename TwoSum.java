/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:

2 <= nums.length <= 105
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/

class Solution {
    private int[] binarySearch(int[] array, int currentIndex, int low, int high, int target) {
        while(low <= high) {
            int mid = low + (high- low) /2;
            int[] toReturn = new int[2];
            
            if(array[currentIndex] + array[mid] == target) {
                toReturn[0] = currentIndex;
                toReturn[1] = mid;
                return toReturn;
            } else if (array[currentIndex] + array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
    public int[] twoSum(int[] nums, int target) {
        int[] toReturn;
        toReturn = new int[2];
        for(int i = 0; i < nums.length-1; i++) {
            toReturn = binarySearch(nums, i, i+1, nums.length-1, target);
            if(toReturn != null) return toReturn;
        }
        return null;
    }
}