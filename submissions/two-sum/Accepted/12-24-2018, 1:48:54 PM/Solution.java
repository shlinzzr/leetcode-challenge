// https://leetcode.com/problems/two-sum

//Approach 1: Brute Force Time/Space : O(n^2)/O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

//Approach 2: Two-pass Hash Table
// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//     Map<Integer, Integer> map = new HashMap<>();
//     for (int i = 0; i < nums.length; i++) {
//         int complement = target - nums[i];
//         if (map.containsKey(complement)) {
//             return new int[] { map.get(complement), i };
//         }
//         map.put(nums[i], i);
//     }
//     throw new IllegalArgumentException("No two sum solution");
//     }
// }