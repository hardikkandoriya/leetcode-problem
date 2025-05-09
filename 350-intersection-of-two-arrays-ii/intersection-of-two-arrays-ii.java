import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // Sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // Use ArrayList to store intersection
        ArrayList<Integer> result = new ArrayList<>();
        
       
        int i = 0; 
        int j = 0; 
        
        
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
               
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
              
                i++;
            } else {
               
                j++;
            }
        }
        
        
        int[] intersection = new int[result.size()];
        for (int k = 0; k < result.size(); k++) {
            intersection[k] = result.get(k);
        }
        
        return intersection;
    }
}