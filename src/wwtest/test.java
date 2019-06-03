package wwtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class test {
	
public  static void main(String args[]) {
	      int[] nums= {1,2,3,4,6,6,6,6,};
	      int i = 0;
	      while (i < nums.length) {
	        if (nums[i] > 0 && nums[i] != i + 1 && nums[i] - 1 < nums.length && nums[i] != nums[nums[i]-1]) {
	          swap(nums, i, nums[i] - 1);
	        } else {
	          i++;
	        }
	      }

	      for (int j = 0; j < nums.length; j++) {
	        if (nums[j] != j + 1) {
	         System.out.println(j + 1);
	        }
	      }
	      System.out.println(nums.length + 1);
	    }
static void swap(int[] nums, int i, int j) {
         int temp = nums[i];
         nums[i] = nums[j];
         nums[j] = temp;
         }
	   
}


 

