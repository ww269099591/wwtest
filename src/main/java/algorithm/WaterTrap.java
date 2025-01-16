package algorithm;

/**
 * https://leetcode.cn/problems/trapping-rain-water/
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，
 * 计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class WaterTrap {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int count = 0;
        int leftMaxHeight = height[left];
        int rightMaxHeight = height[right];


        while (right > left) {
            int minMaxHeight = Math.min(leftMaxHeight,rightMaxHeight );
            int rightHeight = height[right];
            int leftHeight = height[left];
            if (leftHeight < rightHeight) {
                if (height[left + 1] < minMaxHeight) {
                    count = count + minMaxHeight - height[left + 1];
                } else {
                    leftMaxHeight = height[left + 1];
                }
                left++;
            } else {
                if (height[right - 1] < minMaxHeight) {
                    count = count + minMaxHeight - height[right - 1];
                } else {
                    rightMaxHeight = height[right - 1];
                }
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        WaterTrap waterTrap = new WaterTrap();
        System.out.println(waterTrap.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }


}
