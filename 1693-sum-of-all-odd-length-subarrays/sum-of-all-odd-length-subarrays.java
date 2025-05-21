public class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int total = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int leftCount = i + 1;
            int rightCount = n - i;

            int totalSubarrays = leftCount * rightCount;

            
            int oddSubarrays = (totalSubarrays + 1) / 2;

            total += arr[i] * oddSubarrays;
        }

        return total;
    }
}
