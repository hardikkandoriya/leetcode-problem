import java.util.*;

public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n - k + 1]; 
        int windowSum = 0;

        for (int i = 0; i < n; i++) {
            windowSum += nums[i];
            if (i >= k) windowSum -= nums[i - k];
            if (i >= k - 1) sum[i - k + 1] = windowSum;
        }

        int[] left = new int[sum.length];
        int bestLeft = 0;
        for (int i = 0; i < sum.length; i++) {
            if (sum[i] > sum[bestLeft]) bestLeft = i;
            left[i] = bestLeft;
        }

        
        int[] right = new int[sum.length];
        int bestRight = sum.length - 1;
        for (int i = sum.length - 1; i >= 0; i--) {
            if (sum[i] >= sum[bestRight]) bestRight = i; 
            right[i] = bestRight;
        }

        
        int maxSum = 0;
        int[] result = new int[3];
        for (int j = k; j < sum.length - k; j++) {
            int i = left[j - k];      
            int l = right[j + k];      
            int total = sum[i] + sum[j] + sum[l];
            if (total > maxSum) {
                maxSum = total;
                result[0] = i;
                result[1] = j;
                result[2] = l;
            }
        }

        return result;
    }
}
