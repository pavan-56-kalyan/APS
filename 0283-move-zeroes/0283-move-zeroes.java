class Solution {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        
        // Step 1: Move all non-zero elements forward
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        // Step 2: Fill the remaining positions with zeros
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }
}