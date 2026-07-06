class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxAns = 0;
        long windowSum = 0;
        HashSet<Integer> set = new HashSet<>();
        
        int left = 0;
        for (int right = 0; right < n; right++) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                windowSum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            windowSum += nums[right];
            if (right - left + 1 > k) {
                set.remove(nums[left]);
                windowSum -= nums[left];
                left++;
            }
            if (right - left + 1 == k) {
                maxAns = Math.max(maxAns, windowSum);
            }
        }
        
        return maxAns;
    }
}