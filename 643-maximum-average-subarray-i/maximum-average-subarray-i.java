class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        if(k>n){
            throw new IllegalArgumentException("k should not " +"be greater than array length.");
        }

        double avg=0;

        int windowSum=0;
        for(int i=0;i<k;i++){
            windowSum +=nums[i];
        }
        double maxSum=windowSum;

        for(int i=k;i<n;i++){
            windowSum += nums[i] - nums[i-k];
            maxSum=Math.max(maxSum,windowSum);
        }
        
        avg=maxSum/k;
        return avg;
        
  }
        
}
