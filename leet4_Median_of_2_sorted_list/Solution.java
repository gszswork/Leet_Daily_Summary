package leet4_Median_of_2_sorted_list;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int mid = (length1 + length2) /2;
        double medianIndex = ((double)(length1 + length2))/2;
        if (mid == medianIndex) {
        	int idx1 = 0, idx2 = 0;
        	for (int i=0; i< medianIndex;i++) {
        		if(nums1[idx1] < nums2[idx2]) {
        			idx1 ++;
        		}
        		else { 
        			idx2 ++;
        		}
        	}
        	return nums1[idx1] < nums2[idx2]? nums2[idx2]:nums1[idx1];
        	
        }else {
        	int idx1 = 0, idx2 = 0;
        	for (int i=0; i< mid;i++) {
        		if(nums1[idx1] < nums2[idx2]) {
        			idx1 ++;
        		}
        		else { 
        			idx2 ++;
        		}
        	}
        	int next = nums1[idx1+1] < nums2[idx2+1]? nums1[idx1+1]:nums2[idx2+1];
        	return ((nums1[idx1] < nums2[idx2]? nums2[idx2]:nums1[idx1]) + next)/2;
        }
        
    }
    public static void main(String args[]) {
    	double ptl = (double)5/2;
    	System.out.println(ptl);
    }
}
