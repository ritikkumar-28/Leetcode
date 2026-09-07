class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            maxEndingHere = Math.max(num, maxEndingHere + num);
            minEndingHere = Math.min(num, minEndingHere + num);
            
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
            minSoFar = Math.min(minSoFar, minEndingHere);
        }
        
        return Math.max(Math.abs(maxSoFar), Math.abs(minSoFar));
    }
}