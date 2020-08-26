package Hash_Problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class L18_Sum4 {
	 void quick_sort(int s[], int l, int r)
	    {
	        if (l < r)
	        {
	            //Swap(s[l], s[(l + r) / 2]); 
	            int i = l, j = r, x = s[l];
	            while (i < j)
	            {
	                while(i < j && s[j] >= x) 
	                    j--;  
	                if(i < j) 
	                    s[i++] = s[j];
	                
	                while(i < j && s[i] < x) 
	                    i++;  
	                if(i < j) 
	                    s[j--] = s[i];
	            }
	            s[i] = x;
	            quick_sort(s, l, i - 1); 
	            quick_sort(s, i + 1, r);
	        }
	    }
	    
 public List<List<Integer>> fourSum(int[] nums) {
     
     quick_sort(nums, 0, nums.length-1);
     int length = nums.length;
     HashSet<List<Integer>> hashRes = new HashSet<>();
     for (int i=0;i<length; i++) {
    	for(int m=0; m<i; m++) {
	     	HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
	     	for(int j=0; j<m; j++) {
	     		int com = 0 - nums[i] - nums[j] - nums[m];
	     		
	     		if(hash.containsKey(com)) {
	     			//System.out.println("i: "+ nums[i]+" j: "+nums[j] +" com:"+com);
	     			List<Integer> inner = new ArrayList<Integer>();
	     			inner.add(nums[i]);
	     			inner.add(nums[j]);
	     			inner.add(com);
	     			hashRes.add(inner);
	     		}
	     		hash.put(nums[j], j);
	     	}
    	}
     }
     List<List<Integer>> res = new ArrayList<>(hashRes);

     return res;
 }
}
