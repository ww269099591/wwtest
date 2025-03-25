package algorithm;

class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] maxLengthList = new int[nums.length];
        int[] minValueList = new int[nums.length];
        maxLengthList[nums.length - 1] = 1;
        minValueList[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int maxLength = 1;
            int minValue = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (minValueList[j] >nums[i]) {
                    maxLength = Math.max(maxLength, maxLengthList[j] + 1);
                }
            }
            maxLengthList[i] = maxLength;
            minValueList[i] = minValue;
        }
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength,maxLengthList[i]);
        }
        return maxLength;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLIS(new int[]{0,1,0,3,2,3});
    }


}