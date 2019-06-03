package wwtest;

public class Solution {

        //柱子接雨水
        public static int trap(int[] height) {
            if (height == null || height.length <= 2) {
                return 0;
            }
            //查找最高值和最高值的索引
            int max = height[0];
            int maxIndex = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] > max) {
                    max = height[i];
                    maxIndex = i;
                }
            }

            int water = 0;
            //寻找左边最高值
            int leftMax = height[0];
            for (int i = 0; i < maxIndex; i++) {
                if (height[i] > leftMax) {
                    leftMax = height[i];
                } else {
                    water += leftMax - height[i];
                }
            }

            int rightMax = height[height.length - 1];
            for (int i = height.length - 1; i > maxIndex; i--) {
                if (height[i] > rightMax) {
                    rightMax = height[i];
                } else {
                    water += rightMax - height[i];
                }
            }
           
            return water;
        }
    
}
