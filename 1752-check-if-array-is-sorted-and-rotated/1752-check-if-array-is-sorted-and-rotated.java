class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                count++;
            }
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.check(new int[]{3, 4, 5, 1, 2})); 
        System.out.println(solution.check(new int[]{2, 1, 3, 4})); 
        System.out.println(solution.check(new int[]{1, 2, 3})); 
    }
}